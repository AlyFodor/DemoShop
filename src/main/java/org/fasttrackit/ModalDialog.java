package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ModalDialog {

    private final SelenideElement userName = $("#user-name");
    private final SelenideElement password = $("#password");

private final SelenideElement loginButton = $(".modal-dialog .fa-sign-in-alt");

//    public void clickOnTheUsernameField() {
//        System.out.println("Click on the Username Field.");
//    }
    public void typeInUsername(String user) {
        System.out.println("Click on the Username Field.");
        userName.click();
        System.out.println("Type in " + user);
        userName.type(user);
    }
//    public  void clickOnThePasswordField() {
//        System.out.println("Click on the Password field.");
//    }
    public void typeInPassword(String pass) {
        System.out.println("Click on the Password field.");
        password.click();
        System.out.println("Type in " + pass);
        password.type(pass);
    }
    public void clickOnTheLogInButton(){
        System.out.println("Click on the LogIn button.");
        loginButton.click();
    }
}

