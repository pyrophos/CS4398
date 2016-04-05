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
 * This is mostly a stub to help us test what we have.  Most of what is written
 * here will be replaced with sqlite code.
 */
public class WordModel
{
  private final ArrayList<String> wordList = new ArrayList<String>();
  Random rand = new Random(System.currentTimeMillis());

  /**
   * Loads data into the list of words.
   * This will be replaced once we get sqlite going.
   */
  public WordModel()
  {
    String[] names = { "terminator", "slicer", "ninja", "cow", "robot", "dog", "bear", "cat",
            "algebra", "alphabet", "library", "foo", "bar", "cabinet", "submit", "terminal",
            "super", "dumpster", "intelligent", "computer", "snake", "monitor", "university",
            "environment", "zucchini", "youthful", "wrangler", "vintage", "tortilla", "swap", "posh",
            "nutty", "ugly", "mug", "beautiful", "dusty", "pretty", "cute", "kitten", "lurk", "game",
            "frog", "eye", "robo", "jumpy", "stupid", "doozy", "gonzo", "klutz", "rambunctious", "yahoo",
            "tatterdemalion", "google", "second", "hour", "day", "sun", "moon", "rigmarole",
            "troglodyte", "canoodle"};
    for (String n : names)
    {
      wordList.add(n);
    }
    loadWords();
  }

  public void loadWords()
  {
    Context myContext = addRegister.getAppContext();
    AssetManager mngr = myContext.getAssets();
    try {
      InputStream is = mngr.open("small_dictionary.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      String line;

      line = reader.readLine();
      while (line != null){
        wordList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
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
    final int lowerBound = 0;
    final int upperBound = wordList.size();
    int random_integer;
    String word;
    do {
      random_integer = rand.nextInt(upperBound);
    }while((wordList.get(random_integer).length() > maxChar) || (wordList.get(random_integer).length() < minChar));

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
