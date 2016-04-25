package com.example.wwjdt.passphrasegenerator;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class LoginTest extends TestCase {

  @Test
  public void LoginWithInvalidUsernameAndInvalidPasswordTest() {

    Login testLogin = new Login();
    Assert.assertEquals(2, testLogin.checkLogin("doesNotExist", "doesNotExist"));
  }

  @Test //TODO: NEEDS TO BE UPDATED
  public void LoginWithValidUsernameAndInvalidPasswordTest() {

    Login testLogin = new Login();

    Assert.assertEquals(1, testLogin.checkLogin("validLogin", "doesNotExist"));
  }

  @Test //TODO: NEEDS TO BE UPDATED
  public void LoginWithValidUsernameAndValidPasswordTest() {

    Login testLogin = new Login();

    Assert.assertEquals(1, testLogin.checkLogin("validLogin", "validPassword"));
  }
}