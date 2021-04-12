package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {
    protected final AppiumDriver driver;

    protected PageObjectBase(AppiumDriver driver) {
        this.driver = driver;
    }

    protected abstract void BuscarElementos();
}
