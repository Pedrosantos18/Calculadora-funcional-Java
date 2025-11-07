package Entities;

import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<String> registros = new ArrayList<>();

    public void adicionar(String registro) {
        registros.add(registro);
    }

    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Nenhuma operação realizada ainda.");
        } else {
            System.out.println("=== Histórico de Operações ===");
            for (String linha : registros) {
                System.out.println(linha);
            }
        }
    }

    public void limapr() {
        registros.clear();
        System.out.println("Histórico limpo com sucesso!");
    }
}
