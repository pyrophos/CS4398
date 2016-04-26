package com.example.wwjdt.passphrasegenerator;

/**
 * This is a container class to hold word text for the credential.  Words can then be shuffled later.
 */
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
  private void setWord(String word) {this.word = word;}

  /**
   * Returns word from word object
   */
  public String getWord(){return this.word;}

  /**
   * Capitalize the first letter of the word
   */
  public void capitalize(){
      word = word.substring(0,1).toUpperCase() + word.substring(1);
  }

  /**
   * Alternates the case of every other letter in the word.
   */
  public void alternateCaps()
  {
    for (int i=0; i < word.length(); i++)
    {
      if (i%2 == 0)
      {
        word = word.substring(0,i).toUpperCase();
      }
    }
  }

  /**
   * Simple replacement of specific letters with numbers or symbols to increase entropy.
   */
  public void munge()
  {
    word = word.replaceAll("o","0");
    word = word.replaceAll("t","7");
    word = word.replaceAll("a","@");
    word = word.replaceAll("l","1");
    word = word.replaceAll("s","\\$");
    word = word.replaceAll("g","9");
    word = word.replaceAll("e","3");
    word = word.replaceAll("h","#");
    word = word.replaceAll("w","uu");
    word = word.replaceAll("x","%");
    word = word.replaceAll("i","!");
    word = word.replaceAll("b","8");
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
