package ScrabbleGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Reads and store words from file filled with legal scrabble words to play
public class Dictionary 
{
	Trie trie;
	
	public Dictionary()
	{
		trie = new Trie();
		try 
		{
			addFileToDictionary();
		}
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public void addFileToDictionary() throws FileNotFoundException
	{
		List<String> s;
		try {
			s = Files.lines(Path.of("sowpods.txt")).toList();
			for(String word : s)
			{
				word = word.toLowerCase();
				trie.insertWord(word);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public boolean verifyWord(String word)
	{
		word = word.toLowerCase();
		return trie.searchWord(word);
	}
	
	
}