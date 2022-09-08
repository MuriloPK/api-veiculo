public class Urna {

	private long totalEleitores;
	private long validos;
	private long votosBrancos;
	private long nulos;

	public void calculaValidos() {
		long percentual = validos * 100 / totalEleitores;
		System.out.println("O percentual de votos Validos em relação ao total de eleitores é: " + percentual + "%");
	}

	public void calculaVotosBrancos() {
		long percentual = votosBrancos * 100 / totalEleitores;
		System.out.println("O percentual de votos Brancos em relação ao total de eleitores é: " + percentual + "%");
	}

	public void calculaVotosNulos() {
		long percentual = nulos * 100 / totalEleitores;
		System.out.println("O percentual de votos Nulos em relação ao total de eleitores é: " + percentual + "%");
	}

	public Urna(long totalEleitores, long validos, long votosBrancos, long nulos) {
		super();
		this.totalEleitores = totalEleitores;
		this.validos = validos;
		this.votosBrancos = votosBrancos;
		this.nulos = nulos;
	}

	public long getTotalEleitores() {
		return totalEleitores;
	}

	public void setTotalEleitores(long totalEleitores) {
		this.totalEleitores = totalEleitores;
	}

	public long getValidos() {
		return validos;
	}

	public void setValidos(long validos) {
		this.validos = validos;
	}

	public long getVotosBrancos() {
		return votosBrancos;
	}

	public void setVotosBrancos(long votosBrancos) {
		this.votosBrancos = votosBrancos;
	}

	public long getNulos() {
		return nulos;
	}

	public void setNulos(long nulos) {
		this.nulos = nulos;
	}
}