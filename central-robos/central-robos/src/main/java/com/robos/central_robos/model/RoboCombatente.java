package com.robos.central_robos.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMBATENTE")
public class RoboCombatente extends Robo {

    public RoboCombatente() {
        super();
    }

    public RoboCombatente(String nome, String modelo) {
        super(nome, modelo);
    }

    @Override
    public String executarAcao() {
        return "Atacando inimigos com precisão! 💥";
    }
}
