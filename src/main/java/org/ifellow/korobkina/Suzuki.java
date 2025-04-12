package org.ifellow.korobkina;

public class Suzuki extends Car {

    private String typeCar;

    public Suzuki(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine, String typeCar) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
        this.typeCar = typeCar;
    }

    @Override
    public void printBrand() {
        System.out.println("Марка: " + getBrand());
    }

    @Override
    public String getBrand() {
        return "Suzuki";
    }

    public void getInfo() {
        printBrand();
        System.out.println("Тип авто:" + ' ' + this.typeCar);
        super.getInfo();
        System.out.println(" ");
    }

}
