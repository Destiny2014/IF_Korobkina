package org.ifellow.korobkina.steps.rickmorty;

import io.qameta.allure.Step;

public class ParseStep {

    @Step("Парсинг url '{url}'")
    public int parseString(String url) {
        String[] partUrl = url.split("/");
        return Integer.parseInt(partUrl[partUrl.length - 1]);
    }
}