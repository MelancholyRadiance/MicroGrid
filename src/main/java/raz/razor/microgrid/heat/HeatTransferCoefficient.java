package raz.razor.microgrid.heat;

public class HeatTransferCoefficient {
    /*
        Source: https://en.wikipedia.org/wiki/Heat_transfer_coefficient
        The heat transfer coefficient has SI units in watts per square meter per kelvin (W/(m2K))
        Convective Heat Transfer Coefficients

        Source: https://www.engineeringtoolbox.com/convective-heat-transfer-d_430.html
        Convective heat transfer coefficients - hc - depends on type of media, if its gas or liquid, and flow properties such as velocity, viscosity and other flow and temperature dependent properties.

        Typical convective heat transfer coefficients for some common fluid flow applications:

        Free Convection - air, gases and dry vapors : 0.5 - 1000 (W/(m2K))

        Free Convection - water and liquids: 50 - 3000 (W/(m2K))
        Forced Convection - air, gases and dry vapors:  10 - 1000 (W/(m2K))
        Forced Convection - water and liquids:  50 - 10000 (W/(m2K))
        Forced Convection - liquid metals:  5000 - 40000 (W/(m2K))
        Boiling Water : 3.000 - 100.000 (W/(m2K))

        Condensing Water Vapor: 5.000 - 100.000 (W/(m2K))
     */

    public float W_m2K;

    public HeatTransferCoefficient(float W_m2k) {
        this.W_m2K = W_m2k;
    }
}
