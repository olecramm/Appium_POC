package com.alura.appium;

import com.alura.appium.PageObjects.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureDetalhesProduto {

    private static AppiumDriver driver;

    @Before
    public void Before(){
        driver = AppiumDriverConfig.Instance().driver;
    }

    @AfterClass
    public static void AfterClass(){
        AppiumDriverConfig.InvalidaInstance();
    }

    @Test
    public void T1_retornar_para_tela_lista_produtos_pelo_botao_back_device(){
        //Given
        String usuario = "Marcelo";
        String senha = "123";
        String confirmaSenha = "123";

        //Certificar usuario esta cadastrado
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.irParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar(usuario, senha, confirmaSenha);
        telaLogin.BuscarElementos();

        //When
        ListaProdutosPageObject telaListaProdutos = telaLogin.Logar(usuario, senha);

        telaListaProdutos.IrParaDetalhesProduto();

        driver.navigate().back();

        //Then
        Assert.assertFalse(telaListaProdutos.VerficarListaProdutos());
    }


    @Test
    public void T2_Efetuar_compra_produto(){
        //Given
        String numeroCartao = "123456789";
        String dataValidade = "09/2027";
        String cvc = "234";

        //When
        ListaProdutosPageObject telaListaProdutos = new ListaProdutosPageObject(driver);
        DetalhesProdutoPageObject telaDetalhesProdutos = telaListaProdutos.IrParaDetalhesProduto();
        telaDetalhesProdutos.BuscarElementos();
        telaDetalhesProdutos.ComprarProduto();
        PagamentoPageObject telaPagamento = new PagamentoPageObject(driver);
        telaPagamento.BuscarElementos();
        telaPagamento.PreencherDadosBancario(numeroCartao, dataValidade, cvc);
        telaListaProdutos = telaPagamento.ConfirmarPagamento();
        telaListaProdutos.BuscarElementos();

        //Then
        Assert.assertTrue(telaListaProdutos.ChecarBotaoProduto());
    }
}
