public class UrnaTeste {

	public static void main(String[] args) {
		Urna urna = new Urna(1000, 800, 150, 50);

		urna.calculaValidos();
		urna.calculaVotosBrancos();
		urna.calculaVotosNulos();
	}
}