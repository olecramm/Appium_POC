package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase {

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmaSenha;
    private MobileElement botaoCadastrar;
    private MobileElement erroMessageCadastro;

    private final By erroID;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By campoConfirmaSenhaId;
    private final By botaoCadastrarId;

    public CadastroPageObject(AppiumDriver driver) {
        super(driver);

        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmaSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmaSenha = (MobileElement) driver.findElement(campoConfirmaSenhaId);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void PreencherCadastro(String usuario, String senha, String confirmacao) {
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmaSenha.setValue(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao){
        PreencherCadastro(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(this.driver);
    }

    public String ObterErroMessage (){
        EsperarElemento(driver,erroID,10);
        erroMessageCadastro = (MobileElement) driver.findElement(erroID);
        return erroMessageCadastro.getText();
    }
}
