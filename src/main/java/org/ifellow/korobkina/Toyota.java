package org.ifellow.korobkina;

public class Toyota extends Car {

    public Toyota(int year, String transmission, String nameModel, String color, int maxSpeed, double capasityEngine) {
        super(year, transmission, nameModel, color, maxSpeed, capasityEngine);
    }

    @Override
    public String getBrand() {
        return "Toyota";
    }

    @Override
    public String getCountry() {
        return "Япония";
    }
}