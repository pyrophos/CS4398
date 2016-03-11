package com.passwordGen;

public class UserModel
{

  public UserModel()
  {

  }

  public Boolean checkUsername(final String username)
  {
    return true;
  }

  public Boolean checkPassword(final String password)
  {
    return true;
  }

  public Boolean isAuthenticated(final String username,
                                 final String password)
  {
    return checkUsername(username) && checkPassword(password);
  }
}
