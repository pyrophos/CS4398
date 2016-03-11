package com.passwordGen;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This is mostly a stub to help us test what we have.  Most of what is written
 * here will be replaced with sqlite code.
 */
public class CredentialModel
{
  private final ArrayList<String> credentialList = new ArrayList<String>();

  /**
   * Loads data into the list of credentials.
   * This will be replaced once we get sqlite going.
   */
  public void loadData()
  {

  }

  /**
   * Adds a credential to the list of credentials.
   *
   * @param credential  The credential to add.
   */
  public void addcredential(final String credential)
  {
    credentialList.add(credential);
  }

  /**
   * Returns a random credential from the list of credentials.
   *
   * @return  A credential string.
   */
  public String getCredential()
  {
    return "";
  }

  /**
   * Uppercases the first letter of the credential.
   *
   * @param credential  The credential to uppercase.
   * @return  The credential with the first letter in uppercase.
   */
  private String upperCaseFirstLetter(String credential)
  {
    return credential.substring(0, 1).toUpperCase() + credential.substring(1);
  }

  /**
   * A random credential string.
   *
   * @return
   */
  private String randomcredential()
  {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}
