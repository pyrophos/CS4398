package com.example.wwjdt.passphrasegenerator;

import junit.framework.Assert;

import org.junit.Test;

public class CredentialTest {

  @Test
  public void CredentialTest1() {
    int numWords = 0;
    int maxCharacters = 0;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() == 0);
  }

  @Test
  public void CredentialTest2() {
    int numWords = 1;
    int maxCharacters = 8;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() == 0);
  }

  @Test
  public void CredentialTest3() {
    int numWords = 1;
    int maxCharacters = 1;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void CredentialTest4() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void CredentialTest5() {
    int numWords = 100;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void CredentialTest6() {
    int numWords = 100;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void CredentialTest7() {
    int numWords = 0;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, new WordModel());
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() == 0);

    // Add words to the credential
    for (int i = 0; i <= 100; i++)
    {
      testCredential.addWord();
      Assert.assertEquals(numWords, testCredential.getNumWords());
      Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
      Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
      Assert.assertTrue(testCredential.getNumCharacters() > 0);
    }

  }
}