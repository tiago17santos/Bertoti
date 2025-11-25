public class Estoque {
    private int quantidade;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        // Notifica diretamente os interessados
        new EmailService().enviarAviso();
        new LogService().registrar();
    }
}

public class EmailService {
    public void enviarAviso() {
        System.out.println(" Enviando aviso de mudança de estoque...");
    }
}


public class LogService {
    public void registrar() {
        System.out.println(" Registrando mudança no log...");
    }
}

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.setQuantidade(10);
    }
}

