package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductCards {
    private final ElementsCollection cards = $$(".card");

    private final SelenideElement searchField = $(".form-control");

    private final SelenideElement search = $("#input-search");

    private final SelenideElement searchButton = $(".btn-light");

    private final SelenideElement productTitle = $(".card-link");
    private final SelenideElement sortButton = $(".sort-products-select");

    private final SelenideElement sortAZ = $("option[value=az]");
    private final SelenideElement sortZA = $("option[value=za]");
    private final SelenideElement sortLoHi = $("option[value=lohi]");
    private final SelenideElement sortHiLo = $("option[value=hilo]");
    public ProductCards() {
    }

    public void clickOnTheSearchField() {this.searchField.click();}

    public void clickOnTheSearchButton() {this.searchButton.click();}
    public void clickOnTheSortButton(){
        this.sortButton.click();
    }
    public void clickOnTheAZSortButton() {
        this.sortAZ.click();
    }

    public void clickOnTheZASortButton() {
this.sortZA.click();
    }
    public void clickOnTheSortByPriceLoHi() {
this.sortLoHi.click();
    }
    public void clickOnTheSortByPriceHiLo() {
this.sortHiLo.click();
    }

    public String getProductTitle() {

        return productTitle.text();
    }


public Product getFirstProductInList() {
        SelenideElement first = cards.first();
        return new Product(first);
}
public Product getLastProductInList(){
    SelenideElement last = cards.last();
    return new Product(last);
}
    public Product getProductById(String productId) {
        for (SelenideElement product : cards) {
            if (product.$(".card-link").getAttribute("href").endsWith("/" + productId)) {
                return new Product(product);
            }
        }
        return null;
    }

    public void typeInTextInSearchField(String text) {
        System.out.println("Click on the Search Field.");
        searchField.click();
        System.out.println("Type in " + text);
        search.type(text);
    }
}
