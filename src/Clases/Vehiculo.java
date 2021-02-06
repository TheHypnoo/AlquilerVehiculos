package Clases;

public abstract class Vehiculo {
    String matricula;
    String tipoVehiculo;
    int dia;
    int precioBase;
    int PMAorPlazas;

    public Vehiculo(String matricula, String tipoVehiculo, int dia, int precioBase, int PMAorPlazas) {
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
        this.dia = dia;
        this.precioBase = precioBase;
        this.PMAorPlazas = PMAorPlazas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getPMAorPlazas() {
        return PMAorPlazas;
    }

    public void setPMAorPlazas(int PMAorPlazas) {
        this.PMAorPlazas = PMAorPlazas;
    }

    public abstract double calculaAlquier();
}
