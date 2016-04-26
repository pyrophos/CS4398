package com.example.wwjdt.passphrasegenerator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CredentialTest {

  WordModel testWordModel = new WordModel();

  String getRandomWord()
  {
    Random rand = new Random(System.currentTimeMillis());
    String r = "";
    for(int i = 0; i < rand.nextInt(20) + 1; i++) {
      r += (char)(Math.random() * 26 + 97);
    }
    return r;
  }

  private void customLoadWords()
  {
    for (int i = 0; i < 20000; i++)
    {
      testWordModel.addWord(getRandomWord());
    }
  }


  @Before
  public void setup() throws Exception {
    customLoadWords();
  }
  
  @Test
  public void credentialTest1() {
    int numWords = 0;
    int maxCharacters = 0;
    int minCharacters = 0;

    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);

    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }

    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() == 0);
  }

  @Test
  public void credentialTest2() {
    int numWords = 1;
    int maxCharacters = 8;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest3() {
    int numWords = 1;
    int maxCharacters = 3;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest4() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest5() {
    int numWords = 100;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest6() {
    int numWords = 100;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest7() {
    int numWords = 1;
    int maxCharacters = 30;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);

    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() >= numWords * minCharacters);

    // Add words to the credential
    for (int i = 0; i <= 100; i++)
    {
      Assert.assertEquals(numWords, testCredential.getNumWords());
      Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
      Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
      Assert.assertTrue(testCredential.getNumCharacters() > 0);
    }
  }

  @Test
  public void credentialTest8() {
    int numWords = 100;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    testCredential.makeCaseSensitive();
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest9() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    testCredential.addWord();
    numWords++;
    testCredential.appendNumber();
    numWords++;
    testCredential.appendSpecialCharacter();
    numWords++;
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  @Test
  public void credentialTest10() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for(int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    testCredential.alternateCase();
    testCredential.munge();
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

}