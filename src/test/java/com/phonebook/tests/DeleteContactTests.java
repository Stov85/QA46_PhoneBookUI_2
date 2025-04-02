package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("bonjovi111@gmail.com").setPassword("Bonjov321$"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Stan")
                .setLastName("Ost")
                .setPhone("9725612742")
                .setEmail("qwer@net.com")
                .setAddress("NewYork, Broken street 101")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore= app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        app.getContact().pause(2000);
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }


}