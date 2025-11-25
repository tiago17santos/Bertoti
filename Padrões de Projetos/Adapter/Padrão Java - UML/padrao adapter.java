interface Pato {
    void grasnar();
    void voar();
}

class Peru {
    public void glugluglu() {
        System.out.println("Glugluglu!");
    }
    public void voarCurto() {
        System.out.println("Voando só um pouquinho...");
    }
}

class PeruAdapter implements Pato {

    private Peru peru;

    public PeruAdapter(Peru peru) {
        this.peru = peru;
    }

    @Override
    public void grasnar() {
        peru.glugluglu();
    }

    @Override
    public void voar() {
        // Perus voam pouco — simulando múltiplas tentativas
        for (int i = 0; i < 3; i++) {
            peru.voarCurto();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pato pato = new PatoSelvagem();
        Peru peru = new Peru();

        // Cria o adaptador
        Pato peruAdaptado = new PeruAdapter(peru);

        System.out.println("=== Pato Selvagem ===");
        pato.grasnar();
        pato.voar();

        System.out.println("\n=== Peru Adaptado ===");
        peruAdaptado.grasnar();
        peruAdaptado.voar();
    }
}
