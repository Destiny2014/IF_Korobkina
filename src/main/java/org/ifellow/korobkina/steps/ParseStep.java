package org.ifellow.korobkina.steps;

public class ParseStep {

    public int parseString(String url) {
        String[] partUrl = url.split("/");
        return Integer.parseInt(partUrl[partUrl.length - 1]);
    }
}
