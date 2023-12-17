package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement emptyCartPageElement = $(".text-center");

    private final SelenideElement continueShoppingButton = $(".btn-danger");

    private final SelenideElement checkoutButton = $(".btn-success");

    private final SelenideElement errorElement = $("[data-test=error]");

    private final SelenideElement firstNameField = $("#first-name");

    private final SelenideElement lastNameField = $("#last-name");

    private final SelenideElement addressField = $("#address");

    private final SelenideElement thankYouMessage = $(".text-center");
        public CartPage() {
    }
    public String getEmptyCartPageText() {
        return this.emptyCartPageElement.text();
    }
    public boolean isEmptyCartMessageDisplayed() {
            return emptyCartPageElement.isDisplayed();
    }

    public void clickOnTheContinueShoppingButton() {
        continueShoppingButton.click();
        System.out.println("Click on the continue shopping button.");
    }
    public void clickOnTheCheckoutButton() {
        checkoutButton.click();
        System.out.println("Click on the checkout button.");
    }

    public void clickOnTheFirstNameField() {
        firstNameField.click();
        System.out.println("Click on the first name field.");
    }
    public void clickOnTheLastNameField() {
        lastNameField.click();
        System.out.println("Click on the last name field.");
    }
    public void clickOnTheAddressField() {
        addressField.click();
        System.out.println("Click on the address field.");
    }
    public void typeInTextInFirstNameField(String text) {
        System.out.println("Click on the First Name Field.");
        firstNameField.click();
        System.out.println("Type in " + text);
        firstNameField.type(text);
    }

    public void typeInTextInLastNameField(String text) {
        System.out.println("Click on the Last Name Field.");
        lastNameField.click();
        System.out.println("Type in " + text);
        lastNameField.type(text);
    }
    public void typeInTextInAddressField(String text) {
        System.out.println("Click on the Address Field.");
        addressField.click();
        System.out.println("Type in " + text);
        addressField.type(text);
    }
    public String getErrorElement() {

        return errorElement.text();
    }

    public String getThankYouMessage() {
        return this.thankYouMessage.text();
    }

    }
