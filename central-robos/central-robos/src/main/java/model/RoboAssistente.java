package model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ASSISTENTE")
public class RoboAssistente extends Robo {

    public RoboAssistente() {
        super();
    }

    public RoboAssistente(String nome, String modelo) {
        super(nome, modelo);
    }

    @Override
    public String executarAcao() {
        return "Calculando rotas otimizadas... 🤖🧠";
    }
}
