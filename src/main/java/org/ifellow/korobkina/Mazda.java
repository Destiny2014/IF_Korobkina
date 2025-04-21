package org.ifellow.korobkina;

public class Mazda extends Car {

    public Mazda(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
    }

    @Override
    public String getBrand() {
        return "Mazda";
    }

    @Override
    public String getCountry() {
        return "Япония";
    }
}