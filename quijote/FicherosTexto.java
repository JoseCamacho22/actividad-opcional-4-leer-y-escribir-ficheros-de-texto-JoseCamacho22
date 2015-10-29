package ut01.quijote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class FicherosTexto implements InterfazFicherosTexto {


	@Override
    public long countChars(String path) {
		
		long numberChars = 0;
		int letter;
		try(FileReader fr = new FileReader(path))
		{
			while( (letter=fr.read())!=-1){
					++numberChars;
			}
		} catch (IOException e) {
			
		}

		return numberChars;
	}

	@Override
	public long countLowCaseChars(String path) {
		long numberLowChars = 0;
		int letter;
		try(FileReader fr = new FileReader(path))
		{
			while( (letter=fr.read())!=-1){
				if(Character.isAlphabetic(letter) & Character.isLowerCase(letter))
					++numberLowChars;
			}
		} catch (IOException e) {
			
		}

		return numberLowChars;
	}

	@Override
	public long countAlphabeticChars(String path) {
		long numberLowChars = 0;
		int letter;
		try(FileReader fr = new FileReader(path))
		{
			while( (letter=fr.read())!=-1){
				if(Character.isLetter(letter))
					++numberLowChars;
			}
		} catch (IOException e) {
			
		}

		return numberLowChars;
	}

	@Override
	public long countLines(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countWords(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countWords(String path, String endText) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countDipWords(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String longestWords(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long posWord(String path, long pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int positionTripWord(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long positionPentaWord(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getPentaWords(String path, boolean alfabeticOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumberChar(String path, char letter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Character, Long> getNumberChars(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumberWord(String path, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeDiptongo(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeTriptongo(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformUpperCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeUpperCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeLowerCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}

}
