package com.alura.appium;

import static org.junit.Assert.assertEquals;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Clica no botão de cadastro
        MobileElement botaoCadastro = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"))
        );
        botaoCadastro.click();

        // Preenche os campos de cadastro
        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");

        campoNome.sendKeys("Waleska");
        campoSenha.sendKeys("123456");
        campoConfirmarSenha.sendKeys("7895");

        // Clica no botão para confirmar cadastro
        MobileElement botaoConfirmarCadastro = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"))
        );
        botaoConfirmarCadastro.click();

        // Valida a mensagem de erro
        MobileElement erro = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("br.com.alura.aluraesporte:id/erro_cadastro"))
        );

        assertEquals("Senhas não conferem", erro.getText());
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
        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");

        campoNome.sendKeys("Waleska");
        campoSenha.sendKeys("123456");
        campoConfirmarSenha.sendKeys("123456");

        MobileElement botaoConfirmarCadastro = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"))
        );
        botaoConfirmarCadastro.click();


        MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");


    }
}

