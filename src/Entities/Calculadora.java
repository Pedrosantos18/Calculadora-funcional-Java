package Entities;

import java.util.Scanner;

public class Calculadora {

    private Scanner sc = new Scanner(System.in);
    private Historico historico = new Historico();

    public void iniciar() {
        System.out.println("=== Calculador Funcional com Histórico  ===");
        System.out.println("Operações disponíveis: +, -, *, /, ^(potência), r(raiz)");
        System.out.println("Comandos: 'historico', 'limpar', 'sair'\n");

        while (true) {
            try {
                System.out.print("\nDigite o primeiro número (ou sair): ");
                String entrada1 = sc.next();

                if (entrada1.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando...");
                    break;
                }

                if (entrada1.equalsIgnoreCase("historico")) {
                    historico.exibir();
                    continue;
                }

                if (entrada1.equalsIgnoreCase("limpar")) {
                    historico.limapr();
                }

                double num1 = Double.parseDouble(entrada1);

                System.out.print("Escolha a operação (+, -, *, /, ^, r): ");
                String op = sc.next();

                double num2 = 0;
                double resultado;

                if (!op.equalsIgnoreCase("r")) {
                    System.out.print("Digite o segundo número: ");
                    num2 = Double.parseDouble(sc.next());
                }

                switch (op) {
                    case "+":
                        resultado = Operacoes.SOMA.executar(num1, num2);
                        break;
                    case "-":
                        resultado = Operacoes.SUBTRACAO.executar(num1, num2);
                        break;
                    case "*":
                        resultado = Operacoes.MULTIPLICACAO.executar(num1, num2);
                        break;
                    case "/":
                        resultado = Operacoes.DIVISAO.executar(num1, num2);
                        break;
                    case "^":
                        resultado = Operacoes.POTENCIA.executar(num1, num2);
                        break;
                    case "r":
                        resultado = Operacoes.RAIZ.executar(num1, 0);
                        break;
                    default:
                        throw new IllegalArgumentException("Operação inválida!");
                }
                String registro = (op.equalsIgnoreCase("r"))
                        ? "√" + num1 + " = " + resultado
                        : num1 + " " + op + " " + num2 + " = " + resultado;

                historico.adicionar(registro);
                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida! Digite apenas números.");
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        System.out.println("\nPrograma finalizado.");
        historico.exibir();
    }
}
