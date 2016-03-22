package com.example.wwjdt.passphrasegenerator;

public class Word
{
  private String word;

  /**
   * Constructor for the word object.
   *
   * @param word  The string to place into the word object.
   */
  Word(String word)
  {
    this.word = word;
  }

  /**
   * Sets the word object with a new string.
   *
   * @param word  The string to place into the word object.
   */
  private void setWord(String word)
  {
    this.word = word;
  }

  /**
   * Updates the word object with a new string.
   *
   * @param updatedWord The updated string for the word object.
   */
  private void updateWord(String updatedWord)
  {
    this.word = updatedWord;
  }

}
