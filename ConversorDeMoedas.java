import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha uma opção de conversão:");
        System.out.println("1: BRL para USD");
        System.out.println("2: USD para BRL");
        System.out.println("3: BRL para EUR");
        System.out.println("4: EUR para BRL");
        System.out.println("5: BRL para GBP");
        System.out.println("6: GBP para BRL");

        int opcao = scanner.nextInt();
        System.out.println("Digite o valor que deseja converter:");
        double valor = scanner.nextDouble();

        RespostaApi api = new RespostaApi(); // Simulação de uma instância de RespostaApi

        String moedaDe = "BRL";
        String moedaPara = "";

        try {
            switch (opcao) {
                case 1:
                    moedaPara = "USD";
                    break;
                case 2:
                    moedaPara = "BRL";
                    valor = converter(api, moedaDe, moedaPara, valor);
                    break;
                case 3:
                    moedaPara = "EUR";
                    break;
                case 4:
                    moedaPara = "BRL";
                    valor = converter(api, moedaDe, moedaPara, valor);
                    break;
                case 5:
                    moedaPara = "GBP";
                    break;
                case 6:
                    moedaPara = "BRL";
                    valor = converter(api, moedaDe, moedaPara, valor);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            System.out.printf("Valor convertido: %.2f%n", valor);
        } catch (IOException e) {
            System.out.println("Erro ao converter: " + e.getMessage());
        }

        scanner.close();
    }

    private static double converter(RespostaApi api, String moedaDe, String moedaPara, double valor) throws IOException {
        double taxaDeCambio = api.obterTaxaDeCambio(moedaDe, moedaPara);
        return valor * taxaDeCambio;
    }
}

class RespostaApi {

    public double obterTaxaDeCambio(String moedaDe, String moedaPara) throws IOException {
        // Implementação para obter a taxa de câmbio a partir de uma API
        // Aqui estamos simulando uma resposta com um valor fixo
        if (moedaDe.equals("BRL")) {
            // Simulação de uma taxa de câmbio fixa
            if (moedaPara.equals("USD")) {
                return 0.19; // 1 BRL = 0.19 USD
            } else if (moedaPara.equals("EUR")) {
                return 0.16; // 1 BRL = 0.16 EUR
            } else if (moedaPara.equals("GBP")) {
                return 0.14; // 1 BRL = 0.14 GBP
            }
        } else if (moedaDe.equals("USD")) {
            // Simulação de uma taxa de câmbio fixa
            if (moedaPara.equals("BRL")) {
                return 5.30; // 1 USD = 5.30 BRL
            }
        } else if (moedaDe.equals("EUR")) {
            // Simulação de uma taxa de câmbio fixa
            if (moedaPara.equals("BRL")) {
                return 6.20; // 1 EUR = 6.20 BRL
            }
        } else if (moedaDe.equals("GBP")) {
            // Simulação de uma taxa de câmbio fixa
            if (moedaPara.equals("BRL")) {
                return 7.20; // 1 GBP = 7.20 BRL
            }
        }

        throw new IllegalArgumentException("Par de moedas não suportado: " + moedaDe + " para " + moedaPara);
    }
}


