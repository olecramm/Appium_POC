package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObject extends PageObjectBase {

    //Elementos da tela Login
    private MobileElement botaocadastro;
    private MobileElement botaoLogin;
    private MobileElement inputIdUsuario;
    private MobileElement inputSenha;
    private MobileElement erroMessage;

    //Variáveis com os locators dos elementos
    private final By botaocadastroId;
    private final By botaoLoginId;
    private final By inputIdUsuarioId;
    private final By inputSenhaId;
    private final By erroMessageId;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        botaocadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoLoginId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        inputIdUsuarioId = By.id("br.com.alura.aluraesporte:id/input_usuario");
        inputSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        erroMessageId = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
    }

    @Override
    public void BuscarElementos(){
        botaocadastro = (MobileElement) driver.findElement(botaocadastroId);
        botaoLogin = (MobileElement) driver.findElement(botaoLoginId);
        inputIdUsuario = (MobileElement) driver.findElement(inputIdUsuarioId);
        inputSenha = (MobileElement) driver.findElement(inputSenhaId);
    }

    public CadastroPageObject irParaTelaCadastro() {
        botaocadastro.click();
        return new CadastroPageObject(this.driver);
    }

    public ListaProdutosPageObject Logar(String idUsuario, String senha) {
        inputIdUsuario.setValue(idUsuario);
        inputSenha.setValue(senha);
        botaoLogin.click();

        return new ListaProdutosPageObject(this.driver);
    }

    public String ObterMensagemErro() {
        erroMessage = (MobileElement) driver.findElement(erroMessageId);

        return erroMessage.getText();
    }
}
