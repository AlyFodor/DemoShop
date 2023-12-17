package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Footer {
    private final SelenideElement resetStateButton = $(".fa-undo");
public void clickToReset(){
    resetStateButton.click();
    System.out.println("Resetting page to default...");
}
}
