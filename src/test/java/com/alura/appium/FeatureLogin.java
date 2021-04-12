package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.ListaProdutosPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureLogin {

    @Test
    public void T1_logar_com_usuario_nao_cadastrado(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        //When
        telaLogin.Logar("UsuarioInexistente", "123");

        //Then
        Assert.assertEquals("Usuário ou senha inválidos", telaLogin.ObterMensagemErro());
    }

    @Test
    public void T2_logar_com_usuario_cadastrado(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Marcelo", "123", "123");

        //When
        telaLogin.BuscarElementos();
        ListaProdutosPageObject telaListaProdutos = telaLogin.Logar("Marcelo", "123");
        telaListaProdutos.BuscarElementos();


        //Then
        Assert.assertTrue(telaListaProdutos.ChecarBotaoProduto());

        //Arranging to the next test case
        telaListaProdutos.Deslogar();
    }

    @Test
    public void T3_logar_com_usuario_valida_e_senha_invalida(){
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        //Given
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        //When
        telaLogin.Logar("Marcelo", "invalida");

        //Then
        Assert.assertEquals("Usuário ou senha inválidos", telaLogin.ObterMensagemErro());
    }
}
