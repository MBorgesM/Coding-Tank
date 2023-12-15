package br.com.mborgesm.questao1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do empréstimo: ");
        double saldoDevedorTotal = sc.nextDouble();
        sc.nextLine();

        System.out.print("Digite a taxa de juros do empréstimo: ");
        double jurosAoMes = sc.nextDouble() / 100;
        sc.nextLine();

        System.out.print("Digite o tempo de pagamento do empréstimo: ");
        int totalDeMeses = sc.nextInt();
        sc.nextLine();

        calculaParcelas(saldoDevedorTotal, jurosAoMes, totalDeMeses);
    }

    public static void calculaParcelas(double saldoDevedorTotal, double jurosAoMes, int totalDeMeses) {
        double amortizacao = saldoDevedorTotal / totalDeMeses;
        double saldoDevedorAtual = saldoDevedorTotal;
        double totalPrestacoes = 0, amortizacaoTotal = 0, jurosTotais = 0;

        System.out.printf(
                "\nValor fixo da amortização R$%.2f, Saldo devedor total R$%.2f com um juros de %.2f%% ao mês",
                amortizacao, saldoDevedorTotal, jurosAoMes);

        for (int i = 1; i <= totalDeMeses; i++) {
            double jurosMensal = saldoDevedorAtual * jurosAoMes;
            double valorPrestacao = jurosMensal + amortizacao;
            saldoDevedorAtual -= amortizacao;

            System.out.printf(
                    "\nParcela %d | Juros: R$%.2f | Prestação: R$%.2f | Saldo devedor: R$%.2f",
                    i, jurosMensal, valorPrestacao, saldoDevedorAtual);

            totalPrestacoes += valorPrestacao;
            amortizacaoTotal += amortizacao;
            jurosTotais += jurosMensal;
        }

        System.out.printf("\nTotal: Prestação R$%.2f, Juros R$%.2f, Amortização R$%.2f",
                totalPrestacoes, jurosTotais, amortizacaoTotal);
    }
}
