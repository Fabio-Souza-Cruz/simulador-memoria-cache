

public class Bloco {
	
	private int endereco;
	private int indice;
	private int tag;
	private int validade;
	private String palavras[];
	private String dado[];
	
	
	// Insere conteudo no bloco
	public Bloco(int endereco, int n, int palavras, int assoc, String vetorDado[]) {
		 this.endereco = endereco;
		 this.indice = endereco % converterBinario(n/assoc);
		 this.tag = endereco / converterBinario(n)  ;
		 this.palavras = new String[palavras];
		 this.dado = vetorDado;
		 
	}


	public Bloco(int numeroBlocos, int n, int assoc) {
		calcularIndice(numeroBlocos, assoc);		
		this.tag = -1;
		palavras = new String [0];
		this.dado = new String[n];
		for(int i = 0; i < this.dado.length; i++) {
			this.dado[i] = "   ";
		}
	}
	
    // Calcula o indice
	private void calcularIndice(int n, int assoc) {
		this.indice = converterBinario(n)/converterBinario(assoc);
	}

    // Converte o numero em binario
	private int converterBinario(int n) {
		int d = n;
		if(n == 0) {
			return 0;
		}
		String bin = "";
		
		while(d > 0){
		
			if(d%2==0)
				bin = "0" + bin;
			
			else 
				bin = "1" + bin;
				
			d /= 2;
		}
		int numeroConvertido = Integer.parseInt(bin);
		return numeroConvertido;
	
		}
		


	@Override
	public String toString() {
		String str = "";
		
		str+= " indice: " + indice + " [validade: " + getValidade() + " | tag: " + tag + " | Dado:";
	    for(int i = 0; i < this.dado.length; i++) {
	    	str += " { ";
	    	str +=  this.dado[i] + " } ";
	    }
	    str+= "]";
	    
	    return str;
	}


	public int getIndice() {
		return indice;
	}


	public int getValidade() {
		return validade;
	}


	public void setValidade(int validade) {
		this.validade = validade;
	}


	public int getTag() {
		return tag;
	}


	
	
	
	

}
