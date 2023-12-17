package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Product {
    private final SelenideElement card;
    private final SelenideElement addToCartButton;

    private final String title;
    private final String price;

    public Product(SelenideElement card) {
        this.card = card;
        this.addToCartButton = card.$(".fa-cart-plus");
        this.title = this.card.$(".card-link").text();
        this.price = this.card.$(".card-footer .card-text span").text();
    }

    public Product(String productId) {
        String productIdSelector = String.format("[href='#/product/%s']", productId);
        SelenideElement cardLink = $(productIdSelector);
        this.card = cardLink.parent().parent();
        this.addToCartButton = card.$(".fa-cart-plus");
        this.title = cardLink.text();
        this.price = this.card.$(".card-footer .card-text span").text();

    }

    public String getTitle() {

        return title;
    }

    public String getPrice() {
        return price;
    }

    public void clickOnTheProductCartIcon() {
        System.out.println("Click on the cart icon.");
        this.addToCartButton.click();
    }
}

