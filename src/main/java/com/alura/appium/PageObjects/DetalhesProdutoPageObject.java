package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class DetalhesProdutoPageObject extends PageObjectBase{

    private MobileElement textViewDetalhesProdNome;
    private MobileElement buttonComprarProduto;

    private By textViewDetalhesProdNomeId;
    private By buttonCompraProdutoId;

    protected DetalhesProdutoPageObject(AppiumDriver driver) {
        super(driver);
        textViewDetalhesProdNomeId = By.id("br.com.alura.aluraesporte:id/detalhes_produto_nome");
        buttonCompraProdutoId = By.id("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
    }

    @Override
    public void BuscarElementos() {
        textViewDetalhesProdNome = (MobileElement) driver.findElement(textViewDetalhesProdNomeId);
        buttonComprarProduto = (MobileElement) driver.findElement(buttonCompraProdutoId);
    }

    public boolean VerificarDetalhesProduto() {
        return textViewDetalhesProdNome.isDisplayed();
    }

    public void ComprarProduto() {
        buttonComprarProduto.click();
    }
}
