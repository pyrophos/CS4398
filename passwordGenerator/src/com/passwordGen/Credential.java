package com.passwordGen;

import java.util.ArrayList;

public class Credential
{
  // Container for the words
  private ArrayList<Word> credential;

  // Limits on number of words
  private int maxWords;
  private int minWords;

  // Limits on number of characters
  private int maxCharacters;
  private int minCharacters;
  private int totalCharacters;


  /**
   * Constructor for the credential.
   *
   * @param maxCharacters The maximum number of characters the credential
   *                      should contain.
   * @param minCharacters The minimum number of characters the credential
   *                      should contain.
   * @param maxWords      The maximum number of words the credential should
   *                      contain.
   * @param minWords      The minimum number of words the credential should
   *                      contain.
   */
  public void Credential(final int maxCharacters,
                         final int minCharacters,
                         final int maxWords,
                         final int minWords)
  {
    this.maxCharacters = maxCharacters;
    this.minCharacters = minCharacters;
    this.maxWords = maxWords;
    this.minWords = minWords;
  }

  /**
   *
   * @param word
   */
  public void addWord(final Word word)
  {
    if (credential.size() <= maxWords)
    {
      credential.add(word);
    }
  }

  public void addRandomWord()
  {

  }

  /**
   * Gets the currenty number of words in the credential.
   *
   * @return  The number of words within the credential.
   */
  public int getNumWords()
  {
    return credential.size();
  }

  /**
   * Gets the number of characters within the credential.
   *
   * @return  The number of characters within the credential.
   */
  public int getNumCharacters()
  {
    return totalCharacters;
  }

  /**
   * Determines if the credential
   *
   * @return  Returns the status of the filling of the credential.
   */
  public Boolean isFull()
  {
    return (maxWords >= credential.size());
  }

  /**
   * Gets the maximum number of words for the credential.
   *
   * @return  The maximum number of words for the credential.
   */
  public int getMaxWords()
  {
    return this.maxWords;
  }

  /**
   * Gets the minimum number of words for the credential.
   *
   * @return  The minimum number of words for the credential.
   */
  public int getMinWords()
  {
    return this.minWords;
  }

  /**
   * Gets the maximum number of characters for the credential.
   *
   * @return  The maximum number of characters for the credential.
   */
  public int getMaxCharacters()
  {
    return this.maxCharacters;
  }

  /**
   * Gets the minimum number of characters for the credential.
   *
   * @return  The minimum number of characters for the credential.
   */
  public int getMinCharacters()
  {
    return this.minCharacters;
  }

  public void setMaxWords(final int maxWords)
  {
    this.maxWords = maxWords;
  }

  /**
   * Sets the minimum number of words for the credential.
   *
   * @param minWords  The minimum number of words for the credential.
   */
  public void setMinWords(final int minWords)
  {
    this.minWords = minWords;
  }

  /**
   * Sets the maximum number of characters for the credential.
   *
   * @param maxCharacters  The maximum number of characters for the credential.
   */
  public void setMaxCharacters(final int maxCharacters)
  {
    this.maxCharacters = maxCharacters;
  }

  /**
   * Sets the minimum number of characters for the credential.
   *
   * @param minCharacters  The minimum number of characters for the credential.
   */
  public void setMinCharacters(final int minCharacters)
  {
    this.minCharacters = minCharacters;
  }

}
