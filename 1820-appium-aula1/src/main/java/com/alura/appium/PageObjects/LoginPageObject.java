package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase {

    private MobileElement botaoCadastro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);

    }

    @Override
    public void BuscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")));
        botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }


    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
