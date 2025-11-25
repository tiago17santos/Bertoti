import java.util.ArrayList;
import java.util.List;

public interface Componente {
    void mostrar();
}

public class Arquivo implements Componente {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    public void mostrar() {
        System.out.println("📄 Arquivo: " + nome);
    }
}


public class Pasta implements Componente {
    private String nome;
    private List<Componente> filhos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(Componente c) {
        filhos.add(c);
    }

    public void remover(Componente c) {
        filhos.remove(c);
    }

    public void mostrar() {
        System.out.println("📁 Pasta: " + nome);
        for (Componente c : filhos) {
            c.mostrar();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Componente curriculo = new Arquivo("curriculo.pdf");
        Componente contrato = new Arquivo("contrato.docx");

        Pasta docs = new Pasta("Documentos");
        docs.adicionar(curriculo);
        docs.adicionar(contrato);

        Pasta raiz = new Pasta("Raiz");
        raiz.adicionar(docs);
        raiz.adicionar(new Arquivo("leia-me.txt"));

        raiz.mostrar();
    }
}