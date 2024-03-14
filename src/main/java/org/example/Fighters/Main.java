package org.example.Fighters;

import java.util.Objects;

public class Main extends Two_Fighters{
    public static void main(String[] args) {

        Two_Fighters fighter1 = new Two_Fighters();
        Two_Fighters fighter2 = new Two_Fighters();

        fighter1.setName("Lew");
        fighter1.setHealth(10);
        fighter1.setDamagePerAttack(2);

        fighter2.setName("Harry");
        fighter2.setHealth(5);
        fighter2.setDamagePerAttack(4);

        String firstAttacker = "Lew";

        String winner = fighter1.fight(fighter2, firstAttacker);

        String result = Objects.equals(winner, fighter1.getName()) ? String.format("%s attacks %s. %s now has %d health " +
                "and is dead. %s wins.", fighter1.getName(), fighter2.getName(), fighter2.getName(), fighter2.getHealth(), fighter1.getName())
                : String.format("%s attacks %s. %s now has %d health " + "and is dead. %s wins.",
                fighter2.getName(), fighter1.getName(), fighter1.getName(), fighter2.getHealth(), fighter1.getName());

        System.out.println(result);

        System.out.println(fighter1.getHealth());
        System.out.println(fighter2.getHealth());

    }
}

/*

public class Kata {
  public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
    Fighter a=fighter1, b=fighter2;
    if (firstAttacker.equals(fighter2.name)) {
      a = fighter2; b = fighter1;
    }
    while (true) {
      if ((b.health -= a.damagePerAttack) <= 0) return a.name;  // a wins
      if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
    }
  }
}

 */