
import java.util.InputMismatchException;
import java.util.Scanner;

public class Notas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao = 0;
        int quantidadeAlunos = 0;

        String[] nomes = new String[100];
        double[][] notas = new double[100][100];
        int[] quantidadeNotas = new int[100];
        double[] medias = new double[100];

        do {

            try {

                System.out.println("\n--- SISTEMA DE NOTAS ---");
                System.out.println("1 - Cadastrar alunos e notas");
                System.out.println("2 - Ordenar notas");
                System.out.println("3 - Exibir notas e medias");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcao: ");

                opcao = entrada.nextInt();

                switch (opcao) {

                    case 1:

                        System.out.print("\nQuantos alunos deseja cadastrar? ");
                        quantidadeAlunos = entrada.nextInt();

                        if (quantidadeAlunos <= 0 || quantidadeAlunos > 100) {

                            System.out.println("Quantidade invalida!");
                            quantidadeAlunos = 0;

                        } else {

                            for (int i = 0; i < quantidadeAlunos; i++) {

                                entrada.nextLine();

                                System.out.print("\nDigite o nome do aluno: ");
                                nomes[i] = entrada.nextLine();

                                System.out.print("Quantas notas deseja lancar para " + nomes[i] + "? ");
                                quantidadeNotas[i] = entrada.nextInt();

                                if (quantidadeNotas[i] <= 0 || quantidadeNotas[i] > 100) {

                                    System.out.println("Quantidade de notas invalida!");
                                    quantidadeNotas[i] = 0;

                                    i--;

                                } else {

                                    double soma = 0;

                                    for (int j = 0; j < quantidadeNotas[i]; j++) {

                                        System.out.print("Digite a nota " + (j + 1) + ": ");
                                        notas[i][j] = entrada.nextDouble();

                                        soma = soma + notas[i][j];
                                    }

                                    medias[i] = soma / quantidadeNotas[i];
                                }
                            }

                            System.out.println("\nAlunos cadastrados com sucesso!");
                        }

                        break;

                    case 2:

                        if (quantidadeAlunos == 0) {

                            System.out.println("\nCadastre os alunos primeiro!");

                        } else {

                            // Selection Sort
                            for (int i = 0; i < quantidadeAlunos; i++) {

                                for (int j = 0; j < quantidadeNotas[i] - 1; j++) {

                                    int menor = j;

                                    for (int k = j + 1; k < quantidadeNotas[i]; k++) {

                                        if (notas[i][k] < notas[i][menor]) {
                                            menor = k;
                                        }
                                    }

                                    double auxiliar = notas[i][j];
                                    notas[i][j] = notas[i][menor];
                                    notas[i][menor] = auxiliar;
                                }
                            }

                            System.out.println("\nNotas de todos os alunos ordenadas com sucesso!");
                        }

                        break;

                    case 3:

                        if (quantidadeAlunos == 0) {

                            System.out.println("\nCadastre os alunos primeiro!");

                        } else {

                            System.out.println("\n--- RESULTADO DOS ALUNOS ---");

                            for (int i = 0; i < quantidadeAlunos; i++) {

                                System.out.println("\nAluno: " + nomes[i]);

                                for (int j = 0; j < quantidadeNotas[i]; j++) {

                                    System.out.println("Nota " + (j + 1) + ": " + notas[i][j]);
                                }

                                System.out.printf("Media: %.2f%n", medias[i]);
                            }
                        }

                        break;

                    case 0:

                        System.out.println("\nSistema encerrado!");

                        break;

                    default:

                        System.out.println("\nOpcao invalida!");

                }

            } catch (InputMismatchException e) {

                System.out.println("\nErro: digite um valor valido!");

                entrada.nextLine();
            }

        } while (opcao != 0);

        entrada.close();
    }
}
