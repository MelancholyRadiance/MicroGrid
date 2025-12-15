package raz.razor.microgrid;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import raz.razor.microgrid.heat.HeatTransferCoefficient;

import java.util.Arrays;
import java.util.Collection;

public class Util {
    public static Collection<BlockEntity> getAdjBlockEntities(World world, BlockPos pos){
        return Arrays.stream(Direction.values())
                .map((dir) -> world.getBlockEntity(pos.offset(dir)))
                .toList();
    }

    /*
        Source: https://en.wikipedia.org/wiki/Rate_of_heat_flow
        Rate of heat flow = - (heat transfer coefficient) * (area of the body) * (variation of the temperature) / (length of the material)
            we assume:
                heat transfer coefficient is material specific, in watts per square meter per kelvin (W/(m2K))
                area = 1, for full blocks
                length = 1, for full blocks
        In Watts [J/s]
     */

    public static float calcRoHF(HeatTransferCoefficient htc, float tempVariation, float area, float lengthOfMaterial){
        return -(htc.W_m2K) * area * tempVariation / lengthOfMaterial;
    }

    public static float calcRoHF(HeatTransferCoefficient htc,float tempVariation){
        return calcRoHF(htc,tempVariation,1,1);
    }

    public static class BlackBodyColor {

        /**
         * Converts a temperature in Kelvins to a normalized RGB float array
         * using the Tanner Helland approximation.
         *
         * @param Kelvin Temperature in Kelvins (1000 to 40000 recommended)
         * @return float[3] where each component is in the range [0.0f, 1.0f]
         */
        public static float[] kelvinToRGB(float Kelvin) {
            // Adjustable temperature boundaries (in Kelvin)
            final float COLD_MAX_K = 273f;    // Freezing
            final float GRAY_START_K = 273f;
            final float GRAY_END_K = 500f;
            final float HOT_MAX_K = 5000f;    // Max simulated temperature

            Kelvin = clamp(Kelvin, 0f, HOT_MAX_K);

            float red, green, blue;

            if (Kelvin < GRAY_START_K) {
                // Deep blue to icy cyan
                float t = Kelvin / COLD_MAX_K;
                red   = lerp(0.0f, 0.2f, t);
                green = lerp(0.0f, 0.7f, t);
                blue  = lerp(1.0f, 1.0f, t);  // stays vibrant blue

            } else if (Kelvin <= GRAY_END_K) {
                // Cyan-blue to vibrant orange-red
                float t = (Kelvin - GRAY_START_K) / (GRAY_END_K - GRAY_START_K);
                float redCold = 0.2f, greenCold = 0.7f, blueCold = 1.0f;
                float redHot  = 1.0f, greenHot  = 0.3f, blueHot  = 0.0f;

                red   = lerp(redCold, redHot, t);
                green = lerp(greenCold, greenHot, t);
                blue  = lerp(blueCold, blueHot, t);

            } else {
                // Warm glow: red → yellow → white
                float t = (Kelvin - GRAY_END_K) / (HOT_MAX_K - GRAY_END_K);

                if (t < 0.3f) {
                    // Orange-red to yellow
                    red   = 1f;
                    green = lerp(0.3f, 1f, t / 0.3f);
                    blue  = 0f;
                } else if (t < 0.7f) {
                    // Yellow to warm white
                    red   = 1f;
                    green = 1f;
                    blue  = lerp(0f, 0.6f, (t - 0.3f) / 0.4f);
                } else {
                    // Warm white to white-hot
                    red   = 1f;
                    green = 1f;
                    blue  = lerp(0.6f, 1f, (t - 0.7f) / 0.3f);
                }
            }

            return new float[] {
                    clamp(red, 0f, 1f),
                    clamp(green, 0f, 1f),
                    clamp(blue, 0f, 1f)
            };
        }

        private static float lerp(float a, float b, float t) {
            return a + (b - a) * clamp(t, 0f, 1f);
        }
        // Clamp helper for doubles
        private static float clamp(float value, float min, float max) {
            return Math.max(min, Math.min(max, value));
        }

    }

}
