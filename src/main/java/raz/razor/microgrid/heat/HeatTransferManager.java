package raz.razor.microgrid.heat;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import raz.razor.microgrid.Util;
import raz.razor.microgrid.block.entity.MGBlockEntity;

import java.util.HashMap;

public class HeatTransferManager {

    private static final HashMap<HeatTransferDirection,RoHFs> transfers = new HashMap<>();
    private static double totalTransferredW = 0.0;

    public static void startTick(MinecraftServer server) {
    }

    public record HeatTransferDirection(MGBlockEntity source, MGBlockEntity dest){
        public HeatTransferDirection reverse(){
            return new HeatTransferDirection(dest,source);
        }
        void apply(RoHFs roHFs){
            source.applyHeat(roHFs.RoHFSource_W);
            dest.applyHeat(roHFs.RoHFDest_W);
        }

        public void markDirty() {
            if(source.getWorld() instanceof ServerWorld serverWorld){
                source.markDirty();
                dest.markDirty();

                // Send the update to the client
                serverWorld.updateListeners(source.getPos(), source.getCachedState(), source.getCachedState(), 0);
                serverWorld.updateListeners(dest.getPos(), dest.getCachedState(), dest.getCachedState(), 0);
            }
        }
    }

    private record RoHFs(float RoHFSource_W, float RoHFDest_W){

    }

    private static boolean isTransferPresentBetween(HeatTransferDirection heatTransferDirection){
        return transfers.containsKey(heatTransferDirection) || transfers.containsKey(heatTransferDirection.reverse());
    }

    public static void addTransfer(final MGBlockEntity source, final MGBlockEntity dest){
        float tempVariationSD = source.getTemp().Kelvins - dest.getTemp().Kelvins;
        if(Math.abs(tempVariationSD) < 0.01f){
            return;
        }

        float tempVariationDS = -tempVariationSD;

        float RoHFSource = Util.calcRoHF(source.getHTC(),tempVariationSD);
        float RoHFDest = Util.calcRoHF(dest.getHTC(),tempVariationDS);

        HeatTransferDirection transfer = new HeatTransferDirection(source,dest);
        HeatTransferManager.addTransfer(transfer,RoHFSource,RoHFDest);
    }

    private static void addTransfer(final HeatTransferDirection transfer,float RoHFSource,float RoHFDest){
        if(isTransferPresentBetween(transfer)){
            return;
        }
        transfers.put(transfer,new RoHFs(RoHFSource,RoHFDest));
    }

    private static void applyChanges() {
        totalTransferredW = 0.0;
        for(var transfer: transfers.entrySet()){
            transfer.getKey().apply(transfer.getValue());
            totalTransferredW += Math.abs(transfer.getValue().RoHFSource_W);
            //TempIO.LOGGER.info("{}K -> {}K: {}W",transfer.getKey().source.getTemp().Kelvins,transfer.getKey().dest.getTemp().Kelvins,transfer.getValue().RoHFSource_W);
            //TempIO.LOGGER.info("{}K -> {}K: {}W",transfer.getKey().dest.getTemp().Kelvins,transfer.getKey().source.getTemp().Kelvins,transfer.getValue().RoHFDest_W);
            transfer.getKey().markDirty();
        }
        //TempIO.LOGGER.info("Transfers: {}, Total: {}KW",transfers.size(),totalTransferredW/1000.);
    }

    public static void endTick(MinecraftServer server){
        for (ServerPlayerEntity serverPlayerEntity : server.getPlayerManager().getPlayerList()) {
           serverPlayerEntity.sendMessage(Text.literal(server.getTicks()+": "+ transfers.size()+" "+totalTransferredW+"W"));
        }
        HeatTransferManager.applyChanges();
        transfers.clear();
    }

}
