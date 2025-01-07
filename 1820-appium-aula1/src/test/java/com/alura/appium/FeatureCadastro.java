package com.alura.appium;

import static org.junit.Assert.assertEquals;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class FeatureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem()  {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        // Espera explícita
        WebDriverWait wait = new WebDriverWait(driver, 120);

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();

        telaCadastro.Cadastrar("Wa","123","456");

        assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();

        telaLogin = telaCadastro.Cadastrar("Waleska","123", "123");
        telaLogin.BuscarElementos();
    }
}

