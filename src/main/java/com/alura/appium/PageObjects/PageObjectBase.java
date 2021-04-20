package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObjectBase {
    protected final AppiumDriver driver;

    protected PageObjectBase(AppiumDriver driver) {
        this.driver = driver;
    }

    protected abstract void BuscarElementos();

    protected static void EsperarElemento(AppiumDriver driver , By ByElement, long segundos ){
        WebDriverWait espera = new WebDriverWait(driver, segundos);
        espera.until(ExpectedConditions.presenceOfElementLocated(ByElement));
    }
}
