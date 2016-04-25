package com.example.wwjdt.passphrasegenerator;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 *
 */
public class WordModel
{
  private final ArrayList<String> wordList = new ArrayList<>();
  Random rand = new Random(System.currentTimeMillis());

  public void loadWords(Context c)
  {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(
              new InputStreamReader(c.getAssets().open("small_dictionary.txt")));

      // do reading, loop until end of file reading
      String mLine;
      while ((mLine = reader.readLine()) != null) {
        wordList.add(mLine);
      }
    } catch (IOException e) {
      //log the exception
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          //log the exception
        }
      }
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
  public String getRandomWord(int minChar, int maxChar)
  {
    final int upperBound = wordList.size();
    int random_integer;
    do {
      random_integer = rand.nextInt(upperBound);
    }while((wordList.get(random_integer).length() > maxChar)
        || (wordList.get(random_integer).length() < minChar));

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
   * Generates random text.
   *
   * @return
   */
  private String randomWord()
  {
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}
