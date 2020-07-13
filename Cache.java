
public class Cache {
	
	private int numeroBlocos;
	private int numeroAssociatividades;
	private int numeroPalavras;
	private Bloco bloco[];
	
	private int erros = 0;
	private int substituicoes = 0;
	private int acertos = 0;
	
	

	public Cache(int nblocos, int associatividade, int palavras) {
		this.numeroBlocos = nblocos;
		this.numeroAssociatividades = associatividade;
		this.numeroPalavras = palavras;
		this.bloco = new Bloco[nblocos];
		
		// Criar quantidade de blocos 
		for(int i = 0; i < this.numeroBlocos; i ++) {
			bloco[i] = (new Bloco(i, palavras, associatividade));
		}
		
	}
	
	public void busca(int endereco, String vetorDado[]) {
		Bloco novoBloco = new Bloco(endereco, numeroBlocos, this.numeroPalavras, numeroAssociatividades, vetorDado);
		System.out.println(novoBloco);
		percorrerCache(novoBloco);
		
		
	}
	


	private void percorrerCache(Bloco novoBloco) {
		
		for(int i = 0; i < numeroBlocos;) {
			
			// Se for o mesmo indice
			for(int j = 0; j < numeroAssociatividades; j++) {
			if(bloco[i].getIndice() == novoBloco.getIndice()) {
				
				// Verifica se a validade esta em 0, ou seja bloco vazio.
				// Então ele salva o bloco no indice, coloca a validade em 1, e erros++
				if(bloco[i].getValidade() == 0) {
					bloco[i] = novoBloco;
					bloco[i].setValidade(1);
					this.erros++;
				}else if(bloco[i].getValidade() == 1) {
					
					if(bloco[i].getTag() == novoBloco.getTag()) {
						this.acertos++;
						i = numeroBlocos;
						j = numeroAssociatividades;
					} else {
						bloco[i] = novoBloco;
						erros++;
						substituicoes++;
					} // fim do else
					
				} // Fim do else if que verifica se a validade é 1
				
				// Avança para a proxima casa por causa da associatividade
				i = numeroBlocos;
				j = numeroAssociatividades;
				
			} // fim do if que compara o indice
			// Aumentar o contador para avançar pro proximo blodo dentro da associatividade.
			i++;

		  } //fim for da associatividade
		} // fim fo for que percorre todos os blocos

		
	}

	@Override
	public String toString() {	
		String str = "";
		for(int i = 0; i < numeroBlocos ; i++) {
			str += bloco[i].toString();
			str += "\n";
		}
		str += "\n";
		str += "Acertos: " + acertos;
		str += "\n";
		str += "Erros: " + erros;
		str += "\n";
		str += "Substituicoes: " + substituicoes;
		
		return str;
	}
	
	

}
