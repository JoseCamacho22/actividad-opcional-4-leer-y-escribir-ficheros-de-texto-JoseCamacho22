package ut01.quijote;

public class Main {

	final static String fichero = "res/quijote.txt";
	final static String ficheroDiptongo = "res/Ficherodictongo.txt";
	final static String mayus = "res/mayus.txt";
	final static String PALMAYUS = "res/PALMAYUS.TXT";
	final static String PALMINUS = "res/PALMINUS.TXT";
	//final static String fichero = "res/pruebas.txt";


	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		long total = 0;
		System.out.println("Bienvenido al fichero del Quijote  \n Vamos a analizar sus metodos: \n" );
		
		System.out.format("El %s tiene %d caracteres que son imprimibles \n",fichero,new Ficheros().countChars(fichero));
		System.out.format("El %s tiene %d caracteres en letras minúsculas \n",fichero,new Ficheros().countLowCaseChars(fichero));
		System.out.format("El %s tiene %d caracteres del alfabeto \n",fichero,new Ficheros().countAlphabeticChars(fichero));
		System.out.format("El %s tiene %d palabras  \n",fichero,new Ficheros().countWords(fichero));
		System.out.format("El %s La palabra mas larga es %s   \n",fichero,new Ficheros().longestWords(fichero));
		System.out.format("El %s Tiene %d numero de lineas de texto imprimibles dentro del fichero \n",fichero,new Ficheros().countLines(fichero));
		System.out.format("El %s Tiene %d numeros de diptongos del quijote imprimibles dentro del fichero \n",fichero,new Ficheros().countDipWords(fichero));
		System.out.format("El %s tiene %d veces la palabra (hijo) repetida \n", fichero,new Ficheros().getNumberWord(fichero,"hijo"));
		new Ficheros().writeDiptongo(fichero,ficheroDiptongo);
		new Ficheros().transformUpperCase(fichero,mayus);
		new Ficheros().writeUpperCase(fichero, PALMAYUS);
		new Ficheros().writeLowerCase(fichero, PALMINUS);
		
		
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		System.out.format("Ejecutado en %d milisegundos", elapsedTime);
		
	}
}

