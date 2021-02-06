package Clases;

public class Microbus extends Vehiculo {

    public Microbus(String matricula, String tipoVehiculo, int dia, int precioBase, int PMAorPlazas) {
        super(matricula, tipoVehiculo, dia, precioBase, PMAorPlazas);
    }

    @Override
    public double calculaAlquier() {
        return getPrecioBase() + (2 * getPMAorPlazas());
    }
}
