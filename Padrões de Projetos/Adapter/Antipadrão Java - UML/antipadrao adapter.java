interface Pato {
    void grasnar();
    void voar();
}

class PatoSelvagem implements Pato {
    public void grasnar() {
        System.out.println("Quack!");
    }
    public void voar() {
        System.out.println("Voando como um pato...");
    }
}


class Peru {
    public void glugluglu() {
        System.out.println("Glugluglu!");
    }
    public void voarCurto() {
        System.out.println("Voando pequeno trecho...");
    }
}

public class Main {
    public static void main(String[] args) {
        Peru peru = new Peru();

        // Ajuste manual (antipadrão)
        System.out.println("Adaptando na mão...");
        peru.glugluglu();
        peru.voarCurto();
    }
}
