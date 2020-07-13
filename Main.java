/*Este algoritmo recebe como entrada informa��es sobre a organiza��o da mem�ria e da cache (n�mero total de
blocos da cache, associatividade da cache, n�mero de palavras do bloco). 

Para cada endere�o da sequ�ncia, simula o acesso � cache, determinando se ocorre acerto ou falha,
e atualizando a cache, se necess�rio.

*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String vetorDado[];
		String dado = "";
		
		// Numero total de blocos
		System.out.println("Digite n�mero total de blocos da cache: ");
		int blocos = teclado.nextInt();
		// Associatividade da cache
		System.out.println("Associatividade da cache: ");
		int associatividade = teclado.nextInt();
		// N�mero de palavras do bloco
		System.out.println("N�mero de palavras do bloco: ");
		int nPalavras = teclado.nextInt();
		
		
		// Criando a memoria cache
		Cache cache = new Cache(blocos, associatividade, nPalavras);
		
		
		// Digite um endere�o para buscar, para finalizar a busca digite -1;
		System.out.println("Digite um endere�o (em binario) para buscar na Cache, para finalizar a busca digite -1");
		int endereco = teclado.nextInt();
		teclado.nextLine();
		
		
		while(endereco != -1) {
			vetorDado = new String[nPalavras];
			for(int i = 0; i < nPalavras; i++) {
				System.out.println("Digite uma letra para representar uma palavra na Cache: ");
				dado = teclado.nextLine();
				vetorDado[i] = dado;
			}
			cache.busca(endereco, vetorDado);
			System.out.println("Digite um novo endereco: ");
			endereco = teclado.nextInt();
			teclado.nextLine();
		}
		
		
		
		System.out.println(cache);
		teclado.close();

	}

}
