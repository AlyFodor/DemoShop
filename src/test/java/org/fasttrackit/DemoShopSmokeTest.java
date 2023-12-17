package org.fasttrackit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class DemoShopSmokeTest {
    Page page = new Page();
    Header header = new Header();
    
    ModalDialog modal = new ModalDialog();

    ProductCards productList = new ProductCards();

    CartPage cartPage = new CartPage();

    @BeforeClass
    public void setup(){
        page.openHomePage();
    }

    @AfterMethod
    public void cleanup(){
        Footer footer = new Footer();
        footer.clickToReset();
    }

    @Test
    public void user_can_logout_after_login() {
        page.openHomePage();
        header.clickOnTheLoginButton();
        modal.typeInUsername("beetle");
        modal.typeInPassword("choochoo");
        modal.clickOnTheLogInButton();
        assertEquals(header.getGreetingsMessage(), "Hi beetle!", "Logged in with beetle, expected greetings message to be Hi bettle!");
        header.clickOnTheLogoutButton();
        assertEquals(header.getGreetingsMessage(), "Hello guest!", "User logged out, expected greetings message to be Hello guest!");

    }

    @Test
    public void guest_user_can_use_search_feature_to_search_a_product() {
        page.openHomePage();
        Product firstProductBeforeSort = productList.getFirstProductInList();
        Product lastProductBeforeSort = productList.getLastProductInList();
        productList.clickOnTheSearchField();
        productList.typeInTextInSearchField("metal");
        productList.clickOnTheSearchButton();
        assertEquals(productList.getProductTitle(),"Awesome Metal Chair","User logged out, expected greetings message to be Hello guest!");
    }

    @Test
    public void verify_functionality_of_continue_shopping_button_from_cart() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheContinueShoppingButton();
        assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products page.");
    }

    @Test
    public void verify_functionality_of_checkout_button_from_cart() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
    }
    @Test
    public void continue_checkout_with_empty_fields() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(cartPage.getErrorElement(), "First Name is required", "First Name field is empty, expecting error message");

    }

    @Test
    public void continue_checkout_with_first_name_field_completed() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
        cartPage.typeInTextInFirstNameField("Turtle");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(cartPage.getErrorElement(), "Last Name is required", "Last Name field is empty, expecting error message");
    }
    @Test
    public void continue_checkout_with_first_name_and_last_name_fields_completed() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
        cartPage.typeInTextInFirstNameField("Turtle");
        cartPage.typeInTextInLastNameField("Lulu");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(cartPage.getErrorElement(), "Address is required", "Last Name field is empty, expecting error message");
    }
    @Test
    public void continue_checkout_with_all_fields_completed() {
        page.openHomePage();
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
        cartPage.typeInTextInFirstNameField("Turtle");
        cartPage.typeInTextInLastNameField("Lulu");
        cartPage.typeInTextInAddressField("Strada lalelor, numarul 16");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Order summary", "Expected to be on the Order summary page.");
    }
    @Test
    public void complete_order() {
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Your information", "Expected to be on the Your information page.");
        cartPage.typeInTextInFirstNameField("Turtle");
        cartPage.typeInTextInLastNameField("Lulu");
        cartPage.typeInTextInAddressField("Strada lalelor, numarul 16");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Order summary", "Expected to be on the Order summary page.");
        cartPage.clickOnTheCheckoutButton();
        assertEquals(page.getPageTitle(), "Order complete", "Expected to be on the Order complete page.");
        assertEquals(cartPage.getThankYouMessage(), "Thank you for your order!", "Expected Thank you for your order! message is displayed");
    }

}
