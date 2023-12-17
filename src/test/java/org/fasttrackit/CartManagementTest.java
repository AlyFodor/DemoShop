package org.fasttrackit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CartManagementTest {
    Page page = new Page();
    Header header = new Header();
    CartPage cartPage = new CartPage();


    @BeforeClass
    public void setup() {
        page.openHomePage();
    }

    @AfterMethod
    public void cleanup() {
        Footer footer = new Footer();
        footer.clickToReset();
        header.clickOnTheShoppingBagIcon();
    }

    @Test
    public void when_user_navigates_to_cart_page_empty_cart_page_message_is_displayed() {
        header.clickOnTheCartIcon();
        assertEquals(cartPage.getEmptyCartPageText(), "How about adding some products in your cart?");
    }

    @Test
    public void adding_one_product_to_cart_empty_cart_message_is_not_shown() {
        Product product = new Product("5");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertFalse(cartPage.isEmptyCartMessageDisplayed());
    }

    @Test
    public void user_can_increment_the_amount_of_a_product_in_cart_page() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        CartItem item = new CartItem("9");
        item.increaseAmount();
        assertEquals(item.getItemAmount(), "2");
    }

    @Test
    public void user_can_reduce_the_amount_of_a_product_in_cart_page() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        CartItem item = new CartItem("9");
        item.reduceAmount();
        assertEquals(item.getItemAmount(), "1");
    }
}
