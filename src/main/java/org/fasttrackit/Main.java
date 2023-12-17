package org.fasttrackit;

public class Main {
    public static void main(String[] args) {
        System.out.println("- * Demo Shop! * -");
        System.out.println("1. User can login with valid credentials");
        Page page = new Page();   //-> Create homePage object!
        page.openHomePage();
        Header header = new Header();   //- > Create header object!
        header.clickOnTheLoginButton();
        ModalDialog modal = new ModalDialog();    //-> Create login modal object!
//        modal.clickOnTheUsernameField();
        modal.typeInUsername("t");
//        modal.clickOnThePasswordField();
        modal.typeInPassword("choochoo");
        modal.clickOnTheLogInButton();
        String greetingsMessage = header.getGreetingsMessage();
        boolean isLogged = greetingsMessage.contains("dino");
        System.out.println("Hi Dino is displayed in the header: " + isLogged);
        System.out.println("Greetings msg is: " + greetingsMessage);


        System.out.println("-----------------------------");
        System.out.println("2. User can add product to cart from product cards.");
        page.openHomePage();
        ProductCards cards = new ProductCards();
//        Product awesomeGraniteChips = cards.getProductByName("Awesome Granite Chips");
//        System.out.println("Product is: " + awesomeGraniteChips);
//        awesomeGraniteChips.clickOnTheProductCartIcon();

        System.out.println("------------------------------------");
        System.out.println("3. User can navigate to Home Page from Whishlist Page.");
        page.openHomePage();
        header.clickOnTheWishlistIcon();
        String pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Wishlist page. Title is: " + pageTitle);
        header.clickOnTheShoppingBagIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Home Page. Title is: " + pageTitle);

        System.out.println("------------------------------------");
        System.out.println("4. User can navigate to Home Page from Cart Page.");
        page.openHomePage();
        header.clickOnTheCartIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Cart page. Title is: " + pageTitle);
        header.clickOnTheShoppingBagIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Home Page. Title is: " + pageTitle);

    }
}

// User can navigate to Home Page from Whishlist Page
// 1. Open Home Page
// 2. Click on the "favorites" icon
// 3. Click on the "Shopping bag" icon
// Expected results: Home Page is loaded.



// User can add product to cart from product cards
// 1. Open Home page
// 2. Click on the "Awesome Ganite Chips" cart icon
// Expected results: Mini Cart icon shows 1 product in cart


//-----
//1.Open Home page
//2. Click on the Login button
//3.Click on the username field
//4.Type in dino
//5. Click on the Password field
//6. Type in choochoo
//7. Click on the Login button
//Expected: Hi dino is displayed in the header
