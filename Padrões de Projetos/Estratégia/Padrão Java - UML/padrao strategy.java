public class Cliente {
    private String nome;
    private DescontoStrategy descontoStrategy;

    public Cliente(String nome, DescontoStrategy descontoStrategy) {
        this.nome = nome;
        this.descontoStrategy = descontoStrategy;
    }

    public double calcularDesconto(double valor) {
        return descontoStrategy.aplicarDesconto(valor);
    }

    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }
}


public class DescontoAposentado implements DescontoStrategy {
    public double aplicarDesconto(double valor) {
        return valor * 0.85;
    }
}


public class DescontoEstudante implements DescontoStrategy {
    public double aplicarDesconto(double valor) {
        return valor * 0.9;
    }
}

public interface DescontoStrategy {
    double aplicarDesconto(double valor);
}


public class Main {
    public static void main(String[] args) {

        Cliente maria = new Cliente("Maria", new DescontoEstudante());
        Cliente joao = new Cliente("João", new DescontoAposentado());

        System.out.println(maria.calcularDesconto(100));
        System.out.println(joao.calcularDesconto(100));

        // Muda a estratégia em tempo de execução
        maria.setDescontoStrategy(new DescontoAposentado());
        System.out.println(maria.calcularDesconto(100));

    }

}