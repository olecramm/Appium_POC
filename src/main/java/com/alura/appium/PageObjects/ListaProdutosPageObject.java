package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ListaProdutosPageObject extends PageObjectBase {

    private MobileElement buttonProdutos;
    private MobileElement buttonDeslogar;

    private String buttonProdutoStr;
    private String buttonDeslogarStr;

    protected ListaProdutosPageObject(AppiumDriver driver) {
        super(driver);
        buttonProdutoStr = "Produtos";
        buttonDeslogarStr = "Deslogar";
    }

    @Override
    public void BuscarElementos() {
        buttonProdutos = (MobileElement) driver.findElementByAccessibilityId(buttonProdutoStr);
        buttonDeslogar = (MobileElement) driver.findElementByAccessibilityId(buttonDeslogarStr);
    }

    public boolean ChecarBotaoProduto() {
        return buttonProdutos.isDisplayed();
    }

    public void Deslogar() {
        buttonDeslogar.click();
    }
}
