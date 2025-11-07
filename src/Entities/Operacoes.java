package Entities;

public class Operacoes {

    public static final OperacaoFuncional SOMA = (a, b) -> a + b;
    public static final OperacaoFuncional SUBTRACAO = (a, b) -> a - b;
    public static final OperacaoFuncional MULTIPLICACAO = (a, b) -> a * b;
    public static final OperacaoFuncional DIVISAO = (a, b) -> {
        if (b == 0) throw new ArithmeticException("Divisão por zero não permitida");
        return a / b;
    };

    public static final OperacaoFuncional POTENCIA = (a, b) -> Math.pow(a, b);
    public static final OperacaoFuncional RAIZ = (a, b) -> {
        if (a < 0) throw new ArithmeticException("Não é possível calcular raiz de número negativo!");
        return Math.sqrt(a);
    };
}
