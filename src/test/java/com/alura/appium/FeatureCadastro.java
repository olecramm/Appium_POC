package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureCadastro {
    @Test
    public void T1_nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telacadastro = telaLogin.irParaTelaCadastro();
        telacadastro.BuscarElementos();

        //When
        telacadastro.Cadastrar("Marcelo", "123", "345");

        //Then
        Assert.assertEquals("Senhas não conferem", telacadastro.ObterErroMessage());

        //Arranging the app to the next test scenario
        driver.navigate().back();
    }

    @Test
    public void T2_cadastrar_usuario_e_senha_validas() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();

        //When
        telaLogin = telaCadastro.Cadastrar("Marcelo", "123", "123");

        //Then (Asserting that NoSuchElements expecetion happens)
        telaLogin.BuscarElementos();

        driver.navigate().back();
    }

    @Test
    public  void  T3_cadastrar_usuario_ja_existente() throws NoSuchElementException{
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Jonas", "123", "123");

        telaLogin.irParaTelaCadastro();
        telaCadastro.Cadastrar("Jonas", "123", "123");

        Assert.assertEquals("Usuario já Cadastrado", telaCadastro.ObterErroMessage());
    }
}
