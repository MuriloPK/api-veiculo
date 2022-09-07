
public class VotoTeste {
	
	public static void main(String[] args) {
		
		Voto voto = new Voto();
		System.out.println("total de votos validos " + voto.votosValidos());
		System.out.println("total de votos brancos " + voto.votosBrancos());
		System.out.println("total de votos nulos " + voto.votosNulos());
	}

}
