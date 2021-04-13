package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureCadastro {

    private AppiumDriver driver;

    @Before
    public void Before(){
        driver = AppiumDriverConfig.Instance().driver;
    }

    @Test
    public void T1_nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {

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

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();

        //When
        telaLogin = telaCadastro.Cadastrar("Marcelo", "123", "123");

        //Then (Asserting that NoSuchElements expecetion happens)
        telaLogin.BuscarElementos();
    }

    @Test
    public  void  T3_cadastrar_usuario_ja_existente() throws NoSuchElementException{

        //Given
        String usuario = "Jonas";
        String senha = "123";
        String confirmacao = "123";
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();

        //When
        telaCadastro.Cadastrar(usuario, senha, confirmacao);

        telaLogin.irParaTelaCadastro();
        telaCadastro.Cadastrar(usuario, senha, confirmacao);

        //Then
        Assert.assertEquals("Usuario já Cadastrado", telaCadastro.ObterErroMessage());
    }
}
