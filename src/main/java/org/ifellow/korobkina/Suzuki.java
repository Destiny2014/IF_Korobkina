package org.ifellow.korobkina;

public class Suzuki extends Car {

    private final String typeCar;

    public Suzuki(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine, String typeCar) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
        this.typeCar = typeCar;
    }

    @Override
    public String getBrand() {
        return "Suzuki";
    }

    @Override
    public String getCountry() {
        return "Япония";
    }

    public void getInfo() {
        System.out.println("Тип авто:" + ' ' + this.typeCar);
        super.getInfo();
        System.out.println(" ");
    }
}