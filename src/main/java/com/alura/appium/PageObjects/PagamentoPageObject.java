package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PagamentoPageObject extends PageObjectBase {
    private MobileElement editTextNumeroCartao;
    private MobileElement editTextDataValidade;
    private MobileElement editTextCVC;
    private MobileElement buttonConfirmaPagamento;

    private final By editTextNumeroCartaoId;
    private final By editTextDataValidadeId;
    private final By editTextCVCId;
    private final By buttonConfirmaPagamentoId;

    //private List<WebElement> childElementNumeroCartao;

    public PagamentoPageObject(AppiumDriver driver) {
        super(driver);
        editTextNumeroCartaoId = By.id("br.com.alura.aluraesporte:id/pagamento_numero_cartao");
        editTextDataValidadeId = By.id("br.com.alura.aluraesporte:id/pagamento_data_validade");
        editTextCVCId = By.id("br.com.alura.aluraesporte:id/pagamento_cvc");
        buttonConfirmaPagamentoId = By.id("br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento");
    }

    @Override
    public void BuscarElementos() {
       /* WebElement parentElementTest =  driver.findElement(By.id("br.com.alura.aluraesporte:id/pagamento_numero_cartao"));
        WebElement childElementFrameLayout = parentElementTest.findElement(By.className("android.widget.FrameLayout"));
        MobileElement childElementTextView = (MobileElement) childElementFrameLayout.findElement(By.className("android.widget.EditText"));
        childElementTextView.sendKeys("123");*/

        editTextNumeroCartao = BuscaElementoFilho(editTextNumeroCartaoId);
        editTextDataValidade = BuscaElementoFilho(editTextDataValidadeId);
        editTextCVC = BuscaElementoFilho(editTextCVCId);
        buttonConfirmaPagamento = (MobileElement) driver.findElement(buttonConfirmaPagamentoId);
    }

    private MobileElement BuscaElementoFilho(By linearLayoutParentid) {
        WebElement linearLayoutParent =  driver.findElement(linearLayoutParentid);
        WebElement frameLayoutChild = linearLayoutParent.findElement(By.className("android.widget.FrameLayout"));
        MobileElement textViewChildElement = frameLayoutChild.findElement(By.className("android.widget.EditText"));

        return textViewChildElement;
    }

    public ListaProdutosPageObject ConfirmarPagamento() {
        buttonConfirmaPagamento.click();

        return new ListaProdutosPageObject(this.driver);
    }

    public void PreencherDadosBancario(String numeroCartao, String dataValidade, String cvc) {
        editTextNumeroCartao.sendKeys(numeroCartao);
        editTextDataValidade.sendKeys(dataValidade);
        editTextCVC.sendKeys(cvc);
    }
}
