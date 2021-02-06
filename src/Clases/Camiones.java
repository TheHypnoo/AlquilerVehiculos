package Clases;

public class Camiones extends Vehiculo{
    public Camiones(String matricula, String tipoVehiculo, int dia, int precioBase, int PMAorPlazas) {
        super(matricula, tipoVehiculo, dia, precioBase, PMAorPlazas);
    }

    @Override
    public double calculaAlquier() {
        return (getPrecioBase() + 20) * getPMAorPlazas() + 40;
    }
}
