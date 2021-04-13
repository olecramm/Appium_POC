package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ListaProdutosPageObject extends PageObjectBase {

    private MobileElement buttonProdutos;
    private MobileElement buttonDeslogar;

    private WebElement parentElement;
    private List<WebElement> childElement;

    private String buttonProdutoStr;
    private String buttonDeslogarStr;
    private By parentElementId;
    private By childElementClassName;


    public ListaProdutosPageObject(AppiumDriver driver) {
        super(driver);
        buttonProdutoStr = "Produtos";
        buttonDeslogarStr = "Deslogar";

        parentElementId = By.id("br.com.alura.aluraesporte:id/lista_produtos_recyclerview");
        childElementClassName = By.className("android.view.ViewGroup");
    }

    @Override
    public void BuscarElementos() {
        buttonProdutos = (MobileElement) driver.findElementByAccessibilityId(buttonProdutoStr);
        buttonDeslogar = (MobileElement) driver.findElementByAccessibilityId(buttonDeslogarStr);
    }

    private void ObterListaProdutos() {
        parentElement = driver.findElement(parentElementId);
        childElement = parentElement.findElements(childElementClassName);
    }

    public boolean ChecarBotaoProduto() {
        return buttonProdutos.isDisplayed();
    }

    public void Deslogar() {
        buttonDeslogar.click();
    }

    public boolean VerficarListaProdutos(){
        ObterListaProdutos();
        return childElement.isEmpty();
    }

    public DetalhesProdutoPageObject IrParaDetalhesProduto() {
        ObterListaProdutos();
        if (!childElement.isEmpty()){
            childElement.get(2).click();
        }
        return new DetalhesProdutoPageObject(this.driver);
    }
}
