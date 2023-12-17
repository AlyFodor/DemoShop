package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class CartItem {
    private final SelenideElement row;
    private final SelenideElement reduceAmount;
    private final SelenideElement increaseAmount;
    private final SelenideElement amountControlSection;

    public CartItem(String productId) {
        String itemById = String.format("item_%s_title_link", productId);
        SelenideElement item = $(By.id(itemById));
        this.row = item.parent().parent();
        this.reduceAmount = row.$(".fa-minus-circle");
        this.increaseAmount = row.$(".fa-plus-circle");
        this.amountControlSection = this.increaseAmount.parent().parent();
    }
    public void increaseAmount() {
        this.increaseAmount.click();
    }
    public void reduceAmount() {

        this.reduceAmount.click();
    }
    public String getItemAmount() {
        return this.amountControlSection.text();
    }
}
