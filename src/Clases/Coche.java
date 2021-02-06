package Clases;

public class Coche extends Vehiculo{

    public Coche(String matricula, String tipoVehiculo, int dia, int precioBase, int PMAorPlazas) {
        super(matricula, tipoVehiculo, dia, precioBase, PMAorPlazas);
    }

    @Override
    public double calculaAlquier() {

        return (getPrecioBase() + (1.5 * getPMAorPlazas() + getDia()));
    }
}
