package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class DetalhesProdutoPageObject extends PageObjectBase{

    private MobileElement textViewDetalhesProdNome;
    private By textViewDetalhesProdNomeId;

    protected DetalhesProdutoPageObject(AppiumDriver driver) {
        super(driver);
        textViewDetalhesProdNomeId = By.id("br.com.alura.aluraesporte:id/detalhes_produto_nome");
    }

    @Override
    public void BuscarElementos() {
        textViewDetalhesProdNome = (MobileElement) driver.findElement(textViewDetalhesProdNomeId);
    }


    public boolean VerificarDetalhesProduto() {
        return textViewDetalhesProdNome.isDisplayed();
    }
}
