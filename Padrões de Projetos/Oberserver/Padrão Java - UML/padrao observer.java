public interface Observador {
    void atualizar(int novaQuantidade);
}

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Observador> observadores = new ArrayList<>();
    private int quantidade;

    public void adicionarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar(quantidade);
        }
    }
}


public class EmailService implements Observador {
    public void atualizar(int novaQuantidade) {
        System.out.println(" Enviando aviso: estoque agora tem " + novaQuantidade + " unidades.");
    }
}


public class LogService implements Observador {
    public void atualizar(int novaQuantidade) {
        System.out.println(" Log atualizado: quantidade = " + novaQuantidade);
    }
}


public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        // Adiciona observadores
        estoque.adicionarObservador(new EmailService());
        estoque.adicionarObservador(new LogService());

        estoque.setQuantidade(5);
        estoque.setQuantidade(20);
    }
}




