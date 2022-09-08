package bubble;

public class BubbleSort {

	private int vetor[];

	public void ordenaNumeros(int[] v) {
		int auxiliar;
		boolean controle;
		setVetor(v);

		for (int i = 0; i < vetor.length; i++) {
			controle = true;
			for (int j = 0; j < (vetor.length - 1); j++) {
				if (vetor[j] > vetor[j + 1]) {
					auxiliar = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = auxiliar;
					controle = false;
				}
			}
			if (controle) {
				break;
			}
		}
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i] + "");
		}
	}

	public int[] getVetor() {
		return vetor;
	}

	private void setVetor(int[] vetor) {
		this.vetor = vetor;

	}
}
