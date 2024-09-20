package atividade01;

public class Busca implements Busca_IF {

	@Override
	public boolean checaVetorOrdenado(Filme[] filmes) {
		for (int i = 0; i < filmes.length - 1; i++) {
			if (filmes[i].compareTo(filmes[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {
		if (nota < 0) {
			throw new Exception("Nota inválida.");
		}
		for (Filme f : filmes) {
			if (f.getNota() == nota) {
				return f;
			}
		}
		return null;
	}

	@Override
	public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {
		if (nota < 0) {
			throw new Exception("Nota inválida.");
		}
		return buscaLinear_recursiva_auxiliar(filmes, nota, 0);
	}
	public Filme buscaLinear_recursiva_auxiliar(Filme[] filmes, int nota, int index) {
		if (index >= filmes.length) {
			return null;
		} else if (filmes[index].getNota() == nota) {
			return filmes[index];
		} else {
			return buscaLinear_recursiva_auxiliar(filmes, nota, index + 1);
		}
	}

	@Override
	public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {
		if (nota < 0) {
			throw new Exception("Nota invalida.");
		}
		int start = 0;
		int end = filmes.length -1;	
		while(start <= end) {
			int middle = start + (end - start)/2;
			if (filmes[middle].getNota() == nota) {
				return filmes[middle];
			}
			else if(filmes[middle].getNota() > nota) {
				start = middle + 1;
			}
			else {
				end = middle - 1;
			}	
		}	
		return null;
	}

	@Override
	public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
		if (nota < 0) {
			throw new Exception("Nota invalida.");
		}
		return buscaBinaria_recursiva_auxiliar(filmes, nota, 0, filmes.length - 1);
	}
	
	public Filme buscaBinaria_recursiva_auxiliar(Filme[] filmes, int nota, int start, int end){
		if (start > end) return null;
		int middle = start + (end - start)/2;	
		if (filmes[middle].getNota() == nota) {
			return filmes[middle];
		} 
		else if(filmes[middle].getNota() > nota) {
			return buscaBinaria_recursiva_auxiliar(filmes,nota, middle + 1,end);
		}
		else{
			return buscaBinaria_recursiva_auxiliar(filmes,nota,start, middle - 1);
		}
	}
	
	@Override
	public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception {
		if (nota < 0) {
			throw new Exception("Nota inválida.");
		}
		int start = 0;
		int end = filmes.length - 1;
		while (start <= end) {
			if (filmes[start].getNota() == nota) {
				return filmes[start];
			}
			if (filmes[end].getNota() == nota) {
				return filmes[end];
			}
			start++;
			end--;
		}
		return null;
	}
}