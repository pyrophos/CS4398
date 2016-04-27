package com.example.wwjdt.passphrasegenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The type Credential.
 */
public class Credential
{
  // Container for the words
  private ArrayList<Word> credential = new ArrayList<Word>();

  // Limits on number of words
  private int maxWords;
  private int minWords;
  private int numWords;

  // Limits on number of characters
  private int maxCharacters;
  private int minCharacters;
  private int numCharacters;
  private int totalCharacters;

  /**
   * The Word model.
   */
  WordModel wordModel = new WordModel();


  /**
   * Constructor for the credential.
   *
   * @param numWords      The number of words the credential should
   * @param maxCharacters The maximum number of characters the credential                      should contain.
   * @param minCharacters The minimum number of characters the credential                      should contain.
   * @param wordModel     the word model
   */
  public Credential(final int numWords,
                    final int maxCharacters, final int minCharacters, WordModel wordModel)
  {
    this.minCharacters = minCharacters;
    this.maxCharacters = maxCharacters;
    this.numWords = numWords;
      this.wordModel = wordModel;

  }

  /**
   * Add random word to credential
   */
  public void addWord(){
      Word word = new Word(wordModel.getRandomWord(minCharacters, maxCharacters));
      credential.add(word);
      totalCharacters =+ word.getWord().length();
  }

  @Override
  public String toString(){
      String credentialString = new String();
      for(int i = 0; i < credential.size(); i++){
          credentialString += credential.get(i).getWord();
      }
      return credentialString;
  }

  /**
   * Make case sensitive.
   */
  public void makeCaseSensitive(){
      for(int i = 0; i < credential.size(); i++){
          credential.get(i).capitalize();
      }
  }

  /**
   * Append special character.
   */
  public void appendSpecialCharacter(){
      final String specialCharacters = "@#+\\/!#$^?:.(){}[]~-_";
      Random rand = new Random();
      String randSpecialCharacter = Character.toString(specialCharacters.charAt(rand.nextInt(specialCharacters.length())));
      Word word = new Word(randSpecialCharacter);
      credential.add(word);
  }

  /**
   * Append number.
   */
  public void appendNumber(){
      Random rand = new Random();
      String randNumber = Integer.toString(rand.nextInt(9)+1);
      Word word = new Word(randNumber);
      credential.add(word);
  }

  /**
   * Munge.
   */
  public void munge(){
    for(int i = 0; i < credential.size(); i++){
      credential.get(i).munge();
    }
  }

  /**
   * Alternate case.
   */
  public void alternateCase(){
    for(int i = 0; i < credential.size(); i++){
      credential.get(i).alternateCaps();
    }
  }

  /**
   * Gets the current number of words in the credential.
   *
   * @return The number of words within the credential.
   */
  public int getNumWords(){
      return credential.size();
  }

  /**
   * Gets the number of characters within the credential.
   *
   * @return The number of characters within the credential.
   */
  public int getNumCharacters()
  {
    return totalCharacters;
  }

  /**
   * Determines if the credential
   *
   * @return Returns the status of the filling of the credential.
   */
  public Boolean isFull()
  {
    return (maxWords >= credential.size());
  }

  /**
   * Gets the maximum number of words for the credential.
   *
   * @return The maximum number of words for the credential.
   */
  public int getMaxWords()
  {
    return this.maxWords;
  }

  /**
   * Gets the minimum number of words for the credential.
   *
   * @return The minimum number of words for the credential.
   */
  public int getMinWords()
  {
    return this.minWords;
  }

  /**
   * Gets the maximum number of characters for the credential.
   *
   * @return The maximum number of characters for the credential.
   */
  public int getMaxCharacters()
  {
    return this.maxCharacters;
  }

  /**
   * Gets the minimum number of characters for the credential.
   *
   * @return The minimum number of characters for the credential.
   */
  public int getMinCharacters()
  {
    return this.minCharacters;
  }

  /**
   * Sets max words.
   *
   * @param maxWords the max words
   */
  public void setMaxWords(final int maxWords)
  {
    this.maxWords = maxWords;
  }

  /**
   * Sets the minimum number of words for the credential.
   *
   * @param minWords The minimum number of words for the credential.
   */
  public void setMinWords(final int minWords)
  {
    this.minWords = minWords;
  }

  /**
   * Sets the maximum number of characters for the credential.
   *
   * @param maxCharacters The maximum number of characters for the credential.
   */
  public void setMaxCharacters(final int maxCharacters)
  {
    this.maxCharacters = maxCharacters;
  }

  /**
   * Sets the minimum number of characters for the credential.
   *
   * @param minCharacters The minimum number of characters for the credential.
   */
  public void setMinCharacters(final int minCharacters)
  {
    this.minCharacters = minCharacters;
  }

  /**
   * Shuffles the words that make up the credential.
   */
  public void shuffleCredential(){
      Collections.shuffle(credential);
  }

}
