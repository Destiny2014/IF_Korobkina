package org.ifellow.korobkina;


import lombok.Getter;
import lombok.Setter;

public abstract class Car {
    @Getter
    private int year;
    private  String transmission;
    @Getter
    private String nameModel;
    @Setter
    @Getter
    private String color;
    @Getter
    private int maxSpeed;
    private double capacityEngine;

    public Car(int year, String transmission, String nameModel, String color, int maxSpeed, double capacityEngine){
        this.year = year;
        this.transmission = transmission;
        this.nameModel = nameModel;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.capacityEngine = capacityEngine;
    }

    public abstract void printBrand();
    public abstract String getBrand();

    public void getInfo(){
        System.out.println("Модель:" +' ' + this.nameModel);
        System.out.println("Год выпуска:" +' ' + this.year);
        System.out.println("Коробка передач:" +' ' + this.transmission);
        System.out.println("Цвет:" +' ' + this.color);
        System.out.println("Максимальная скорость:" +' ' + this.maxSpeed);
        System.out.println("Объем двигателя:" +' ' + this.capacityEngine);
        System.out.println(" ");
    }

    public void changeColor(String color) {
        this.setColor(color);
    }

}

