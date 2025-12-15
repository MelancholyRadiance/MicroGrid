package raz.razor.microgrid.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import raz.razor.microgrid.heat.HeatTransferCoefficient;
import raz.razor.microgrid.heat.Temperature;

public interface ITempBlock {

    Temperature getTemp(); // In Kelvins
    Temperature tickTemp(World world, BlockPos blockPos, BlockState blockState); // In Kelvins
    HeatTransferCoefficient getHTC(); // In watts per square meter per kelvin (W/(m2K))
    Temperature applyHeat(float Watts); // In Kelvins
    float getSpecificHeatCapacity(); // In joules per kelvin per kilogram, J/(kgK), water: 4184
    float getMass(); // In kg

}
