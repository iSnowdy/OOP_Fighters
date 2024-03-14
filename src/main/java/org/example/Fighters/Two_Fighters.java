package org.example.Fighters;

public class Two_Fighters {

    private String name;
    private int health, damagePerAttack;


    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamagePerAttack() {
        return damagePerAttack;
    }

    public void setDamagePerAttack(int damagePerAttack) {
        this.damagePerAttack = damagePerAttack;
    }

    public void damage (int health) {
        this.health -= health;
    }

    public String fight(Two_Fighters opponent, String firstArracker) {

        Two_Fighters attacker = firstArracker.equals(this.name) ? this : opponent;
        Two_Fighters defender = firstArracker.equals(this.name) ? opponent : this;
        // This sets the name of the fighter. If Lew is attacking first, then he's the attacker. And Harry defender

        do {
            defender.damage(attacker.getDamagePerAttack());

            System.out.println(String.format("%s attacks %s; %s now has %d health.",
                    attacker.getName(), defender.getName(),
                    defender.getName(), defender.getHealth()));

            Two_Fighters temp = attacker; // String swap
            attacker = defender;
            defender = temp;
        }
        while (attacker.getHealth() > 0 && defender.getHealth() > 0);

        if (this.getHealth() <= 0) {
            return opponent.getName();
        }
        else {
            return this.getName();
        }
    }
}