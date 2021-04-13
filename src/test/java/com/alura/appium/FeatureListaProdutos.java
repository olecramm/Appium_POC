package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.DetalhesProdutoPageObject;
import com.alura.appium.PageObjects.ListaProdutosPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureListaProdutos {

    private AppiumDriver driver;

    @Before
    public void before() {
        driver = AppiumDriverConfig.Instance().driver;
    }

    @Test
    public void T1_verificar_lista_produtos_presente() {

        //Given
        String usuario = "Marcelo";
        String senha = "123";
        String confirmaSenha = "123";
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        //Certificar usuario esta cadastrado
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar(usuario, senha, confirmaSenha);
        telaLogin.BuscarElementos();
        ListaProdutosPageObject telaListaProdutos = telaLogin.Logar(usuario, senha);

        //Then
        Assert.assertFalse(telaListaProdutos.VerficarListaProdutos());
    }

    @Test
    public void verificar_abertura_tela_detalhes_do_produto() {

        //Gives
        ListaProdutosPageObject telaListaProdutos = new ListaProdutosPageObject(driver);

        //When
        DetalhesProdutoPageObject telaDetalhesProduto = telaListaProdutos.IrParaDetalhesProduto();
        telaDetalhesProduto.BuscarElementos();

        //Then
        Assert.assertTrue(telaDetalhesProduto.VerificarDetalhesProduto());
    }
}
