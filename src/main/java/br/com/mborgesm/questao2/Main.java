package br.com.mborgesm.questao2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a temperatura: ");
        double temperaturaBase = sc.nextDouble();
        sc.nextLine();

        System.out.println("Qual a unidade de origem dessa temperatura? [C, K, F]");
        char unidadeOrigem = sc.nextLine().toUpperCase().charAt(0);

        System.out.println("Qual a unidade de destino dessa temperatura? [C, K, F]");
        char unidadeDestino = sc.nextLine().toUpperCase().charAt(0);

        double temperaturaConvertida = 0;

        if (unidadeOrigem == 'C') {
            if (unidadeDestino == 'K') {
                temperaturaConvertida = celsiusParaKelvin(temperaturaBase);
            } else if (unidadeDestino == 'F') {
                temperaturaConvertida = celsiusParaFahrenheit(temperaturaBase);
            }
        } else if (unidadeOrigem == 'K') {
            if (unidadeDestino == 'C') {
                temperaturaConvertida = kelvinParaCelsius(temperaturaBase);
            } else if (unidadeDestino == 'F') {
                double temperaturaAuxiliar = kelvinParaCelsius(temperaturaBase);
                temperaturaConvertida = celsiusParaFahrenheit(temperaturaAuxiliar);
            }
        } else if (unidadeOrigem == 'F') {
            if (unidadeDestino == 'C') {
                temperaturaConvertida = fahrenheitParaCelsius(temperaturaBase);
            } else if (unidadeDestino == 'K') {
                double temperaturaAuxiliar = fahrenheitParaCelsius(temperaturaBase);
                temperaturaConvertida = celsiusParaKelvin(temperaturaAuxiliar);
            }
        }

        System.out.printf("\n%.2f %c = %.2f %c", temperaturaBase, unidadeOrigem, temperaturaConvertida, unidadeDestino);
    }

    public static double celsiusParaKelvin(double temperatura) {
        return 273.15 + temperatura;
    }

    public static double celsiusParaFahrenheit(double temperatura) {
        return (temperatura * 9 / 5) + 32;
    }

    public static double kelvinParaCelsius(double temperatura) {
        return temperatura - 273.15;
    }

    public static double fahrenheitParaCelsius(double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }
}
