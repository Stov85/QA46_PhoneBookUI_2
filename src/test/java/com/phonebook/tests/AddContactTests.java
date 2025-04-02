package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("bonjovi001@gmail.com").setPassword("Bonjov321$"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Stan")
                .setLastName("Ost")
                .setPhone("9725612742")
                .setEmail("qwer@net.com")
                .setAddress("NewYork, Broken street 101")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Stan"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }

}