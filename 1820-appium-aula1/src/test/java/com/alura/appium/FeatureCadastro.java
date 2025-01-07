package com.alura.appium;

import static org.junit.Assert.assertEquals;

import com.alura.appium.PageObjects.CadastroPageObject;
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
        WebDriverWait wait = new WebDriverWait(driver, 60);

        // Clica no botão de cadastro
        MobileElement botaoCadastro = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"))
        );
        botaoCadastro.click();

       CadastroPageObject telaCadastro = new CadastroPageObject(driver);
       telaCadastro.BuscarElementos();
       telaCadastro.Cadastrar("Wa","123","456");



        // Valida a mensagem de erro


        assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        // Espera explícita
        WebDriverWait wait = new WebDriverWait(driver,30);

        // Clica no botão de cadastro
        MobileElement botaoCadastro = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"))
        );
        botaoCadastro.click();

        // Preenche os campos de cadastro
        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Waleska","123", "123");




        MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");


    }
}

