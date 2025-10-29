package raz.razor.microgrid.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import raz.razor.microgrid.HeatTransferCoefficient;
import raz.razor.microgrid.HeatTransferManager;
import raz.razor.microgrid.Temperature;
import raz.razor.microgrid.Util;
import raz.razor.microgrid.block.ITempBlock;

public abstract class MGBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ITempBlock {

    private static final HeatTransferCoefficient HTC = new HeatTransferCoefficient(1000);

    protected Temperature temp = new Temperature(Temperature.ROOM_TEMPERATURE);

    public MGBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public Temperature tickTemp(World world, BlockPos blockPos, BlockState blockState) {
        if(!world.isClient()){
            for (var adjBlockEntity : Util.getAdjBlockEntities(world,blockPos)){
                if(adjBlockEntity instanceof MGBlockEntity blockEntity){
                    HeatTransferManager.addTransfer(this, blockEntity);
                }
            }
        }
        return this.temp;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, MGBlockEntity blockEntity) {
        blockEntity.tickTemp(world,blockPos,blockState);
    }

    public static @Nullable Temperature getTempOrNull(@NotNull BlockEntity blockEntity){
        if (blockEntity instanceof MGBlockEntity entity){
            return entity.getTemp();
        }
        return null;
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        this.temp.writeData(view);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.temp = Temperature.readData(view);
    }

    @Override
    public Temperature getTemp() {
        return temp;
    }

    @Override
    public Temperature applyHeat(float Watts) {
        this.temp.Kelvins += Watts/(this.getMass() * this.getSpecificHeatCapacity());
        return getTemp();
    }

    public HeatTransferCoefficient getHTC() {
        return HTC;
    }

    @Override
    public float getMass() {
        return 10.f;
    }

    @Override
    public float getSpecificHeatCapacity() {
        return 418.4f;
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }
}
