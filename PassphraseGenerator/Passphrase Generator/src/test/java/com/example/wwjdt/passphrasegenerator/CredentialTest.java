package com.example.wwjdt.passphrasegenerator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The following tests the credential generator.
 */
public class CredentialTest {

  WordModel testWordModel = new WordModel();

  /**
   * Generates a random word.
   * @return
   */
  String getRandomWord() {
    Random rand = new Random(System.currentTimeMillis());
    String r = "";
    for (int i = 0; i < rand.nextInt(20) + 1; i++) {
      r += (char)(Math.random() * 26 + 97);
    }
    return r;
  }

  /**
   * Adds words to the test WordModel.
   */
  private void customLoadWords() {
    for (int i = 0; i < 20000; i++) {
      testWordModel.addWord(getRandomWord());
    }
  }

  /**
   * Setup loads random words into a the WordModel test object.
   * @throws Exception
   */
  @Before
  public void setup() throws Exception {
    customLoadWords();
  }

  /**
   * Tests that if zero words are requested for a credential, only zero words are generated, along with
   * the number of words, max characters, min characters and total characters.
   */
  @Test
  public void credentialTest1() {
    int numWords = 0;
    int maxCharacters = 0;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() == 0);
  }

  /**
   * Tests that if one word is requsted for a credential, only one word is generated, along with
   * the number of words, max characters, min characters and total characters.
   */
  @Test
  public void credentialTest2() {
    int numWords = 1;
    int maxCharacters = 8;
    int minCharacters = 0;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * Tests that if one word is requested for a credential, only one word is generated, along with
   * the number of words, max characters, min characters and total characters.
   */
  @Test
  public void credentialTest3() {
    int numWords = 1;
    int maxCharacters = 3;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * Tests that if four word is requested for a credential, only four word is generated, along with
   * the number of words, max characters, min characters and total characters.
   */
  @Test
  public void credentialTest4() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * Tests that if one hundred word are requested for a credential, only one hundred words are generated, along with
   * the number of words, max characters, min characters and total characters.
   */
  @Test
  public void credentialTest5() {
    int numWords = 100;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * Tests the range of characters in words.
   */
  @Test
  public void credentialTest6() {
    int numWords = 100;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * Tests adding words after the fact.
   */
  @Test
  public void credentialTest7() {
    int numWords = 1;
    int maxCharacters = 30;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);

    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() >= numWords * minCharacters);

    // Add words to the credential
    for (int i = 0; i <= 100; i++) {
      testCredential.addWord();
      numWords++;
      Assert.assertEquals(numWords, testCredential.getNumWords());
      Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
      Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
      Assert.assertTrue(testCredential.getNumCharacters() > 0);
    }
  }

  /**
   * Tests that makeCaseSensitive actually makes the words in the credential uppercase.
   */
  @Test
  public void credentialTest8() {
    int numWords = 100;
    int maxCharacters = 100;
    int minCharacters = 1;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }

    // Use a regular expression to check that no uppercase letters are in the credential.
    Pattern pattern = Pattern.compile("[A-Z]");
    Matcher matcher = pattern.matcher(testCredential.toString());
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    // Initially there should be no uppercase letters
    Assert.assertEquals(0, count);

    testCredential.makeCaseSensitive();
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);

    // Use a regular expression to check the number of uppercase letters in the credential.
    pattern = Pattern.compile("[A-Z]");
    matcher = pattern.matcher(testCredential.toString());
    count = 0;
    while (matcher.find()) {
      count++;
    }
    // There should be as many uppercase letters as there are words in the credential
    Assert.assertEquals(count, testCredential.getNumWords());
  }

  /**
   * Tests credential methods appendNumber and appendSpecialCharacter work properly.
   */
  @Test
  public void credentialTest9() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
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

  /**
   * A test which uses alternateCase and munge methods.
   */
  @Test
  public void credentialTest10() {
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
    for (int i = 0; i < numWords; i++){
      testCredential.addWord();
    }
    testCredential.alternateCase();
    testCredential.munge();
    Assert.assertEquals(numWords, testCredential.getNumWords());
    Assert.assertEquals(maxCharacters, testCredential.getMaxCharacters());
    Assert.assertEquals(minCharacters, testCredential.getMinCharacters());
    Assert.assertTrue(testCredential.getNumCharacters() > 0);
  }

  /**
   * A test checks for duplicate credentials.
   */
  @Test
  public void credentialTest11() {
    ArrayList<Credential> credentials = new ArrayList<>();
    int numWords = 4;
    int maxCharacters = 8;
    int minCharacters = 3;
    for (int i = 0; i < 2000000; i++) {
      Credential testCredential = new Credential(numWords, maxCharacters, minCharacters, testWordModel);
      for (int j = 0; i < numWords; i++) {
        testCredential.addWord();
      }
      credentials.add(testCredential);
    }

    // Since a set cannot have duplicates, here we are converting the ArrayList to a set and then
    // check that the size of the set and arraylist are the same.
    Set<Credential> testSet = new HashSet<>(credentials);
    Assert.assertEquals(credentials.size(), testSet.size());
  }

}