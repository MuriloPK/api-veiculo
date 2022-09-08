
public class Voto {

	private double eleitores = 1000;
	private double validos = 800;
	private double votosBrancos = 150;
	private double votosNulos = 50;

	public double votosValidos() {
		return (this.eleitores / this.validos) % 100;
	}

	public double votosBrancos() {
		return (this.eleitores / this.votosBrancos) % 100;
	}
	
	public double votosNulos() {
		return (this.eleitores / this.votosNulos) % 100;
	}

	public double getEleitores() {
		return eleitores;
	}

	public double getValidos() {
		return validos;
	}

	public double getVotosBrancos() {
		return votosBrancos;
	}

	public double getVotosNulos() {
		return votosNulos;
	}

}
