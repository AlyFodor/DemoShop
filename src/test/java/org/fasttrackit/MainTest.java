package org.fasttrackit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest {
    Page page = new Page();
    Header header = new Header();
    ModalDialog modal = new ModalDialog();    //-> Create login modal object!

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
    public void user_turtle_can_login_with_valid_credentials() {
        header.clickOnTheLoginButton();
        modal.typeInUsername("turtle");
        modal.typeInPassword("choochoo");
        modal.clickOnTheLogInButton();
        assertEquals(header.getGreetingsMessage(), "Hi turtle!", "Logged in with turtle, expected greetings message to be Hi turtle!");
    }

    @Test
    public void user_dino_can_login_with_valid_credentials() {
        header.clickOnTheLoginButton();
        modal.typeInUsername("dino");
        modal.typeInPassword("choochoo");
        modal.clickOnTheLogInButton();
        assertEquals(header.getGreetingsMessage(), "Hi dino!", "Logged in with dino, expected greetings message to be Hi dino!");
    }

    @Test
    public void user_can_navigate_to_Wishlist_Page() {
        header.clickOnTheWishlistIcon();
        assertEquals(page.getPageTitle(), "Wishlist", "Expected to be on the Wishlist page.");
    }

    @Test
    public void user_can_navigate_to_Cart_Page() {
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart page");
    }

    @Test
    public void user_can_navigate_to_Home_Page_from_Wishlist_Page() {
        header.clickOnTheWishlistIcon();
        header.clickOnTheShoppingBagIcon();
        assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products page.");
    }

    @Test
    public void user_can_navigate_to_Home_Page_from_Cart_Page() {
        header.clickOnTheCartIcon();
        header.clickOnTheShoppingBagIcon();
        assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products page");
    }

    @Test
    public void user_can_add_product_to_cart_from_product_cards() {
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "1", "After adding one product to cart, badge shows 1.");
    }

    @Test
    public void user_can_add_two_products_to_cart_from_product_cards() {
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "2", "After adding two products to cart, badge shows 2.");
    }

}

