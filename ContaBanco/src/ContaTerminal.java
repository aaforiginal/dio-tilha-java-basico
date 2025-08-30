import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class ContaTerminal {
    public static void main(String[] args) {
        // Deixa a formatação no padrão Brasil (R$, vírgula etc.)
        Locale brasil = new Locale("pt", "BR");
        Locale.setDefault(brasil);

        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, digite o número da Conta: ");
        int numero = Integer.parseInt(sc.nextLine()); // lê como texto e converte p/ int

        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = sc.nextLine(); // pode ter hífen (ex.: 067-8)

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nomeCliente = sc.nextLine(); // aceita espaços

        System.out.print("Por favor, digite o saldo inicial: ");
        // aceita tanto 237,48 quanto 237.48
        String saldoDigitado = sc.nextLine().trim().replace(",", ".");
        double saldo = Double.parseDouble(saldoDigitado);

        // Formata o saldo como dinheiro BR (R$ 237,48)
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(brasil);
        String saldoFormatado = dinheiro.format(saldo);

        System.out.println();
        System.out.println(
            "Olá " + nomeCliente +
            ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +
            ", conta " + numero +
            " e seu saldo " + saldoFormatado +
            " já está disponível para saque."
        );

        sc.close();
    }
}

