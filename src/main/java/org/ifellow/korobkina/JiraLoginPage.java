package org.ifellow.korobkina;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;

import java.time.Duration;

public class JiraLoginPage {
    private final SelenideElement userLoginInput = $x("//input[@id='login-form-username']").as("Строка ввода логина");
    private final SelenideElement userPasswordInput = $x("//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement enterButton = $x("//input[@type='submit' and @value='Войти']").as("Кнопка Войти");

    @Step("Авторизация юзера с его логином '{userLogin}' и паролем")
    public void authorization(String userLogin, @Param(mode = Parameter.Mode.HIDDEN) String userPassword) {
        userLoginInput.shouldBe(visible, Duration.ofSeconds(20))
                .setValue(userLogin);
        userPasswordInput.shouldBe(visible, Duration.ofSeconds(20))
                .setValue(userPassword);
        enterButton.click();
    }
}