import java.util.ArrayList;
import java.util.List;

public class Pasta {
    private String nome;
    private List<Arquivo> arquivos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionarArquivo(Arquivo a) {
        arquivos.add(a);
    }

    public void mostrar() {
        System.out.println("Pasta: " + nome);
        for (Arquivo a : arquivos) {
            a.mostrar();
        }
    }
}

public class Arquivo {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    public void mostrar() {
        System.out.println("Arquivo: " + nome);
    }
}

public class Main {
    public static void main(String[] args) {
        Pasta documentos = new Pasta("Documentos");
        documentos.adicionarArquivo(new Arquivo("curriculo.pdf"));
        documentos.adicionarArquivo(new Arquivo("contrato.docx"));

        documentos.mostrar();
    }
}
