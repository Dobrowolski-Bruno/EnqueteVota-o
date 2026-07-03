import java.util.Scanner;

public class EnqueteVotacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos candidatos vao participar da enquete? ");
        int qtdCandidatos = sc.nextInt();
        sc.nextLine();

        String[] candidatos = new String[qtdCandidatos];
        int[] votos = new int[qtdCandidatos];

        for (int i = 0; i < qtdCandidatos; i++) {
            System.out.print("Nome do candidato " + (i + 1) + ": ");
            candidatos[i] = sc.nextLine();
            votos[i] = 0;
        }

        System.out.print("\nQuantos eleitores vao votar? ");
        int qtdEleitores = sc.nextInt();

        for (int v = 1; v <= qtdEleitores; v++) {
            System.out.println("\nEleitor " + v + ", escolha um candidato:");
            for (int i = 0; i < qtdCandidatos; i++) {
                System.out.println((i + 1) + " - " + candidatos[i]);
            }
            System.out.print("Numero do candidato: ");
            int escolha = sc.nextInt();

            if (escolha >= 1 && escolha <= qtdCandidatos) {
                votos[escolha - 1]++;
            } else {
                System.out.println("Voto invalido, indo pro proximo eleitor.");
            }
        }

        System.out.println("\n===== RESULTADO DA ENQUETE =====");
        int totalVotos = 0;
        for (int i = 0; i < qtdCandidatos; i++) {
            totalVotos = totalVotos + votos[i];
        }

        int indiceVencedor = 0;
        for (int i = 0; i < qtdCandidatos; i++) {
            double percentual = 0;
            if (totalVotos > 0) {
                percentual = (votos[i] * 100.0) / totalVotos;
            }
            System.out.printf("%-15s %d voto(s) - %.1f%%%n", candidatos[i], votos[i], percentual);

            if (votos[i] > votos[indiceVencedor]) {
                indiceVencedor = i;
            }
        }

        System.out.println("\nTotal de votos validos: " + totalVotos);

        if (totalVotos > 0) {
            System.out.println("Candidato vencedor: " + candidatos[indiceVencedor]
                    + " com " + votos[indiceVencedor] + " votos!");
        } else {
            System.out.println("Ninguem votou em ninguem, sem vencedor.");
        }

        sc.close();
    }
}
