/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jesses
 */
public class WordFinder {

    /**
     * @param args the command line arguments
     */
    public ArrayList<String> WordList = new ArrayList<>();
    public ArrayList<String> newList = new ArrayList<>();
    public ArrayList<String> finalList = new ArrayList<>();
    
    public void ReadInWords() throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("Dictionary.txt"));
        while(input.hasNext())
            WordList.add(input.nextLine());
        input.close();
    }
    
    public void findWords(String w)
    {
        w = w.trim();
        for(int i = 0; i < WordList.size(); i++)
        {
            if(w.length() == WordList.get(i).trim().length())
            {
                newList.add(WordList.get(i));
            }
        }
        char[] word = w.toCharArray();
        
        for(int i = 0; i < newList.size(); i++)
        {
            int ld = 0;
            char[] nword = newList.get(i).trim().toCharArray();
            for(int j = 0; j < word.length; j++)
            {
                if(word[j] != nword[j])
                    ld++;
            }
            if(ld == 1)
                finalList.add(newList.get(i));
        }
    }    
}
