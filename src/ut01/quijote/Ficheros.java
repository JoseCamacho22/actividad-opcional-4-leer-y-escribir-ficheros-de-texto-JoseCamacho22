
package ut01.quijote;

/**
 * 
 *	Jose Augusto Camacho Fernandez
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.filechooser.FileFilter;

import org.omg.Messaging.SyncScopeHelper;


public class Ficheros implements InterfazFicheros {

	
	
	/**
	 * Utilizando el fichero quijote.txt que contiene letras mayúsculas y
	 * minúsculas, con o sin acento o diéresis, cifras y demás caracteres
	 * imprimibles posibles, además de fines de línea y fin de fichero. Crear un
	 * método que devuelva el número de carácteres:
	 * 
	 * @param path
	 * @return
	 */
	@Override
    public long countChars(String path) {
		
		long numberChars = 0;
		int letras;
		try(FileReader fr = new FileReader(path))
		{
			while( (letras=fr.read())!=-1){++numberChars;}
			
		} catch (IOException e) {
			
		}

		return numberChars;
	}

	
	
	/**
	 * Contar el número de letras minúsculas puras (sin acentuar ni diéresis)
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long countLowCaseChars(String path) {
		// TODO Auto-generated method stub
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

	
	
	/**
	 * Contar el número de letras (todas incluidas minúsculas, mayúsculas,
	 * acentuadas, etc., pero no los signos de puntuación, cifras y otros
	 * caracteres)
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long countAlphabeticChars(String path) {
		// TODO Auto-generated method stub
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

	
	
	/**
	 * Contar el número de líneas del fichero de texto.
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long countLines(String path) {
		// TODO Auto-generated method stub
			
			File fichero = new File(path);
			int countlineas = 0;
				String linea;
				
				 // Declaramos el fichero try
				try {
					FileReader fr = new FileReader(fichero);
					BufferedReader br = new BufferedReader(fr);
					// Creamos el flujo de entrada ;
					try {
						//se va leyendo el caracter
				while ((linea = br.readLine()) != null) {
					//lo sumamos al contador
							countlineas++;
						}
						br.close();// cerramos el fichero
		
						
					} catch (IOException e) {
						// TODO Bloque catch generado automáticamente
					e.printStackTrace();
					}
		
			} catch (FileNotFoundException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
		
				return countlineas;
			}


	
	
	
	/**
	 * Contar el número de palabras
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long countWords(String path) {
		// Leer el fichero de path caracter a caracter
		
		StringBuilder palabra = new StringBuilder();
		int caracter;
		int wordNumber = 0;
		try(FileReader fr = new FileReader(path)){
			while( (caracter = fr.read())!=-1 ){
				if(Character.isAlphabetic(caracter)){
					// leo un caracter que pertenece a una palabra
					palabra.append((char)caracter);
				}
				// termino de leer la palabra
				else if(palabra.length()>0){
					++wordNumber;
					palabra = new StringBuilder();
				}
			}	
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("IOException");
		}
		
		return wordNumber;
	}

	

	
	/**
	 * Contar el número de palabras terminadas en una palabra (por ejemplo
	 * “cion”) (con o sin acentos, en minúsculas o mayúsculas)
	 * 
	 * @param path
	 * @param text
	 * @return
	 */
	@Override
	public int countWords(String path, String endText) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/**
	 * Contar el número de diptongos (ojo con los acentos que deshacen
	 * diptongos). Ej: ai, oi, ei, au, ou, eu, io, ia, ie, uo, ua, ue, iu, ui.
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public int countDipWords(String path) {
		// TODO Auto-generated method stub
		int countDipWords =0;
		File fichero = new File(path);
		String linea;

		// Declaramos el fichero
		try {
			FileReader fr = new FileReader(fichero); // Creamos el flujo de entrada
			BufferedReader br = new BufferedReader(fr);
			
			try{

					while ((linea = br.readLine()) != null) {
						// se va leyendo un caracter
							for (int i = 0; i < path.length(); i++) {
									char ch = path.charAt(i);
									if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch == 'u') {
									//lo vamos sumando al contador 
										countDipWords++;
									}else{
										countDipWords++;
									}
							}
					}

						
			}catch (IOException e) {
				// TODO Bloque catch generado automáticamente
					e.printStackTrace();
		  }	

		} catch (FileNotFoundException e) {
				// TODO Bloque catch generado automáticamente
					e.printStackTrace();
		}
		
		return countDipWords;
		
	}
	
	
			

	
	/**
	 * Obtener la palabra más larga y en otro método su posición (número de
	 * orden en la secuencia de palabras). Si hay más de una se toma la primera.
	 * Nota: El número de orden o posición de la palabra en el texto es el lugar
	 * que ocupa, una vez contadas todas.
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public String longestWords(String path) {
		StringBuilder palabra = new StringBuilder();
		int caracter;
		String longestWord = "";
		try(FileReader fr = new FileReader(path)){
			while( (caracter = fr.read())!=-1 ){
				if(Character.isAlphabetic(caracter)){
					palabra.append((char)caracter);
				}
				else if(palabra.length()>0){
					if(longestWord.length() < 
							palabra.toString().length()){
						longestWord = palabra.toString();
					}
						
					palabra = new StringBuilder();
				}
			}	
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			System.err.println("IOException");
		}
		
		
		return longestWord;
	}
	
	
	
	/**
	 * Devuelve la posición de una palabra
	 * 
	 * @param path
	 * @return
	 */
	
	@Override
	public long posWord(String path, long pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	/**
	 * Encontrar la primera palabra que tiene un triptongo indicando el número
	 * tiene en la secuencia de palabras, si no existe devolverá 0.
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public int positionTripWord(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/**
	 * Encontrar la primera palabra pentavocálica, si existe devolver el número
	 * tiene en la secuencia de palabras y cero si no existe ninguna.
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public long positionPentaWord(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/**
	 * Devolver un array con todas las palabras pentavocálicas por orden de
	 * aparición.
	 * 
	 * @param path
	 * @param alfabeticOrder
	 * @return
	 */
	@Override
	public ArrayList<String> getPentaWords(String path, boolean alfabeticOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * Obtener la frecuencia de una letra.
	 * 
	 * @param path
	 * @param letter
	 * @return
	 */
	@Override
	public long getNumberChar(String path, char letter) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/**
	 * Obtener la frecuencia de las 27 letras del alfabeto en un Map en orden
	 * descendiente según la aparicion
	 */
	@Override
	public Map<Character, Long> getNumberChars(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * 	Obtener la frecuencia de una palabra.

	 * @param ath
	 * @return
	 */
	@Override
	public long getNumberWord(String path, String word) {
		
		int caracter ;
		int numero =0;
		String posicion = "";
			
			try(FileReader fr = new FileReader(path)){
					
				while( (caracter = fr.read())!=-1 ){

					if (caracter != ' ' && caracter != '\n' && Character.isAlphabetic(caracter)) {
							String i = String.valueOf((char) caracter);
							posicion = posicion.concat(i);
							
					} else {
							if (posicion.equals(word))
								numero++;
							posicion = "";
						}

			}
		} catch (IOException e) {

		}


	return numero;
}
	
	/**
	 * Crear un nuevo fichero “DIPTONGO.TXT” con todas las palabras que
	 * contengan al menos un diptongo.
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	@Override
	public void writeDiptongo(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
		FileWriter fw =null;
		PrintWriter pw =null;
		int letra;
		String cadena = "";
		String[] diptongos = { "ia", "ie", "io", "ua", "ue", "uo", 
				"ai", "au", "ei", "eu", "oi", "ou" };
		
			try (FileReader fr = new FileReader(pathIn)) {
				fw = new FileWriter(pathOut);
				pw = new PrintWriter(fw);
					while ((letra = fr.read()) != -1) {
						
						if (letra != ' ' && letra != '\n' && Character.isAlphabetic(letra)) {
							String cad = String.valueOf((char) letra);
							cadena = cadena.concat(cad );
						} else {
							for (int i = 0; i < diptongos.length; i++) {
								if (cadena.contains(diptongos[i]))
								pw.println(cadena );
						}

					cadena = "";
				}

			}
		} catch (IOException e) {

		}

	}


	
	/**
	 * Crear un nuevo fichero“TRIPTONGO.TXT” con todas las palabras que
	 * contengan al menos un triptongo.
	 * 
	 * @param in
	 * @param out
	 */
	@Override
	public void writeTriptongo(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Crear un nuevo fichero “QUIMAYUS.TXT” que cambie todas las letras a
	 * mayúsculas.
	 * 
	 * @param pathIn
	 * @param pathOut
	 */

	@Override
	public void transformUpperCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
			int caracter;
			String cadena = "";
			
			try (FileReader fr = new FileReader(pathIn)) {
				FileWriter fichero = new FileWriter(pathOut);
				PrintWriter pw = new PrintWriter(fichero);
				
				//mientras el caracter lo lea
				
					while ((caracter = fr.read()) != -1) {

						if (caracter!= ' ' && caracter != '\n' && Character.isAlphabetic(caracter)) {
							String i = String.valueOf((char) caracter);
							cadena = cadena.concat(i);
						} else {
							pw.println(cadena.toUpperCase());
							cadena = "";
						}

				}
			} catch (IOException e) {

			}
		}


	
	
	/**
	 * Crear fichero “PALMAYUS.TXT” con todas las palabras que empiezan por
	 * letra mayúscula, cada palabra en una línea).
	 * 
	 * @param pathIn
	 * @param pathOut
	 */
	@Override
	public void writeUpperCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		
		int caracter;
		String cadena = "";
			try (FileReader fr = new FileReader(pathIn)) {
				FileWriter fichero = new FileWriter(pathOut);
				PrintWriter pw = new PrintWriter(fichero);
				
				//mientras el caracter lo lea
				
				while ((caracter = fr.read()) != -1) {

					if (caracter!= ' ' && caracter != '\n' && Character.isAlphabetic(caracter)) {
						String i = String.valueOf((char) caracter);
						cadena = cadena.concat(i);
						
						
					} else {
						if (cadena.matches("[A-Z]+[a-z]*"))//sólo letras A a la Z
							pw.println(cadena);
						cadena = "";
					}

				}
			} catch (IOException e) {

			}

		}
	
	
	/**
	 * Crear fichero “PALMINUS.TXT”, con todas las palabras que empiezan por
	 * letra mayúscula y minúscula, respectivamente (cada palabra en una línea).
	 * 
	 * @param pathIn
	 * @param pathOut
	 */

	@Override
	public void writeLowerCase(String pathIn, String pathOut) {
		// TODO Auto-generated method stub
		int caracter;
		String cadena = "";
			try (FileReader fr = new FileReader(pathIn)) {
				FileWriter fichero = new FileWriter(pathOut);
				PrintWriter pw = new PrintWriter(fichero);
				
				//mientras el caracter lo lea
				
				while ((caracter = fr.read()) != -1) {

					if (caracter!= ' ' && caracter != '\n' && Character.isAlphabetic(caracter)) {
						String i = String.valueOf((char) caracter);
						cadena = cadena.concat(i);
						
						
					} else {
						if (!cadena.matches("[A-Z]+[a-z]*"))//sólo letras A a la Z
							pw.println(cadena);
						cadena = "";
					}

				}
			} catch (IOException e) {

			}

	}
	
		
}


