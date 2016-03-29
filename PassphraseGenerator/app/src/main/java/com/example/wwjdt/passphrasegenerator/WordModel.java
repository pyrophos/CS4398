package com.example.wwjdt.passphrasegenerator;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * This is mostly a stub to help us test what we have.  Most of what is written
 * here will be replaced with sqlite code.
 */
public class WordModel
{
  private final ArrayList<String> wordList = new ArrayList<String>();
  Random rand = new Random();

  /**
   * Loads data into the list of words.
   * This will be replaced once we get sqlite going.
   */
  public WordModel()
  {
    String[] names = { "Terminator", "Slicer", "Ninja", "cow", "Robot", "Dog" };
    for (String n : names)
    {
      wordList.add(n);
    }
  }

  /**
   * Adds a word to the list of words.
   *
   * @param word  The word to add.
   */
  public void addWord(final String word)
  {
    wordList.add(word);
  }

  /**
   * Returns a random word from the list of words.
   *
   * @return  A word string.
   */
  public String getRandomWord()
  {
    final int lowerBound = 0;
    final int upperBound = wordList.size();
    int random_integer = rand.nextInt(upperBound);
    return wordList.get(random_integer);
  }

  /**
   * Uppercases the first letter of the word.
   *
   * @param word  The word to uppercase.
   * @return  The word with the first letter in uppercase.
   */
  private String upperCaseFirstLetter(String word)
  {
    return word.substring(0, 1).toUpperCase() + word.substring(1);
  }


  /**
   * A random word string.
   *
   * @return
   */
  private String randomWord()
  {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}
