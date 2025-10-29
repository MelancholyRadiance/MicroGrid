package raz.razor.microgrid;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;

public class Temperature {
    private static final String KELVINS_NBT_KEY = Microgrid.MOD_ID + ":kelvins";

    public static final float ABSOLUTE_ZERO = 0;
    public static final float ROOM_TEMPERATURE = 293;

    public float Kelvins;

    public Temperature(float Kelvins) {
        this.Kelvins = clapTemp(Kelvins);
    }

    private static float clapTemp(float Kelvins){
        return Math.clamp(Kelvins,ABSOLUTE_ZERO,Float.MAX_VALUE);
    }

    public static Temperature readData(ReadView view) {
        float Kelvins = clapTemp(view.getFloat(KELVINS_NBT_KEY,0.f));
        return new Temperature(Kelvins);
    }

    public void writeData(WriteView writeView) {
        writeView.putFloat(KELVINS_NBT_KEY,clapTemp(this.Kelvins));
    }
}
