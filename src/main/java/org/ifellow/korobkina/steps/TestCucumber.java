package org.ifellow.korobkina.steps;

import io.cucumber.java.ru.*;

public class TestCucumber {
   /* @Когда("")
    public void print(){
        System.out.println("pu pu pu");
    }*/

    @Дано("^какое-то числовое значение '(.*)'")
    public void givenNumber(double number) {
        System.out.println(number);
    }

    @Дано("^какое-то строковое значение '(.*)'")
    public void givenString(String str) {
        System.out.println(str);
    }
}
