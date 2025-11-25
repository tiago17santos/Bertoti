abstract class Cliente {
    protected String nome;
    public Cliente(String nome) { this.nome = nome; }
    public abstract double calcularDesconto(double valor);
}


public class ClienteAposentado extends Cliente {
    public ClienteAposentado(String nome) { super(nome); }
    public double calcularDesconto(double valor) {
        return valor * 0.85; // 15% de desconto
    }
}


public class ClienteEstudante extends Cliente {
    public ClienteEstudante(String nome) { super(nome); }
    public double calcularDesconto(double valor) {
        return valor * 0.9; // 10% de desconto
    }
}


public class Main {
    public static void main(String[] args) {

        Cliente c1 = new ClienteEstudante("Maria");
        Cliente c2 = new ClienteAposentado("João");

        System.out.println(c1.calcularDesconto(100));
        System.out.println(c2.calcularDesconto(100));
    }


}