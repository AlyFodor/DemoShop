package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private final SelenideElement loginButton = $(".navbar .fa-sign-in-alt");

    private final SelenideElement logoutButton = $(".navbar .fa-sign-out-alt");

    private final SelenideElement greetingElement = $(".navbar-text span span");
    private final SelenideElement wishlistButton = $(".navbar .fa-heart");

    private final SelenideElement cartIcon = $(" .fa-shopping-cart");
    private final SelenideElement shoppingCartBadge = $(".shopping_cart_badge");
    private final ElementsCollection shoppingCartBadges = $$(".shopping_cart_badge");
    private final SelenideElement homePageButton = $("[data-icon=shopping-bag]");

    public void clickOnTheLoginButton() {
        loginButton.click();
        System.out.println("Click on the Login button.");

    }
    public void clickOnTheLogoutButton() {
        logoutButton.click();
        System.out.println("Click on the Logout button.");

    }

    public String getGreetingsMessage() {

        return greetingElement.text();
    }

    public void clickOnTheWishlistIcon() {
        System.out.println("Click on the Wishlist button.");
        wishlistButton.click();

    }

    public void clickOnTheShoppingBagIcon() {
        System.out.println("Click on the Shopping bag icon.");
        homePageButton.click();
    }

    public void clickOnTheCartIcon() {
        System.out.println("Click on the Cart icon.");
        cartIcon.click();
    }
    public String getShoppingCartBadgeValue() {
        
        return this.shoppingCartBadge.text();
    }
    public boolean isShoppingBadgeVisible() {

        return !this.shoppingCartBadges.isEmpty();
    }
}
