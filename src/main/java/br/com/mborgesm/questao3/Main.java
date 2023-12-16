package br.com.mborgesm.questao3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o tamanho da base do triângulo: ");
        int tamanho = sc.nextInt();

        char[][] triangulo = criarTriangulo(tamanho);
        imprimirTriangulos(triangulo);
    }

    public static char[][] criarTriangulo(int tamanho) {
        int qtdLinhas = (int) Math.ceil((double) tamanho / 2);
        char[][] triangulo = new char[qtdLinhas][tamanho];
        int posicaoElementoCentral = qtdLinhas - 1;

        for (int i = 0; i < qtdLinhas; i++) {
            triangulo[i][posicaoElementoCentral] = '*';
            for (int j = 0; j < posicaoElementoCentral; j++) {
                if (j >= posicaoElementoCentral - i) {
                    triangulo[i][j] = '*';
                } else {
                    triangulo[i][j] = ' ';
                }
            }

            for (int j = posicaoElementoCentral + 1; j < tamanho; j++) {
                if (j <= posicaoElementoCentral + i) {
                    triangulo[i][j] = '*';
                } else {
                    triangulo[i][j] = ' ';
                }
            }
        }

        return triangulo;
    }

    public static void imprimirTriangulos(char[][] primeiroTriangulo) {
        for (int i = 0; i < primeiroTriangulo.length; i++) {
            for (int j = 0; j < primeiroTriangulo[i].length; j++) {
                System.out.printf("%c", primeiroTriangulo[i][j]);
            }
            System.out.println();
        }
    }
}
