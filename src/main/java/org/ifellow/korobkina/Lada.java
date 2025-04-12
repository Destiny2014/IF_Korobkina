package org.ifellow.korobkina;

public class Lada extends Car{

    public Lada(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
    }

    @Override
    public void printBrand() {
        System.out.println("Марка: " + getBrand());
    }

    @Override
    public String getBrand() {
        return "Lada";
    }

    public void getInfo(){
        printBrand();
        super.getInfo();
        System.out.println(" ");
    }

}
