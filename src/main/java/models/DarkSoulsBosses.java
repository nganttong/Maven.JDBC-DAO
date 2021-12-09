package models;

import daos.Boss;
import daos.DaoConcreteClass;

import java.util.List;

public class DarkSoulsBosses {
    Boss doesThisWork;


    public static void main(String[] args) {
        DaoConcreteClass bosses = new DaoConcreteClass();

//        bossOutput(bosses.getBossByID(3));
//
//        bossListOutput(bosses.findAllBosses());
//
//        Boss exampleBossOne = new Boss("Soul of Cinder",
//                "Kiln of the First Flame",
//                10766, "Dark",
//                "Bleed",
//                100000);
//        Boss createdBoss = bosses.create(exampleBossOne);
//        bossOutput(createdBoss);
//
        Boss exampleBossTwo = bosses.getBossByID(1);
        exampleBossTwo.setResistances("Frost");
        bossOutput(bosses.update(exampleBossTwo));
//
//        bosses.delete(createdBoss.getId());
//        bossListOutput(bosses.findAllBosses());
    }


    public static void bossOutput(Boss boss) {
        System.out.println("Id: " + boss.getId() + "\n" +
                "Boss' Name: " + boss.getName() + "\n" +
                "Location: " + boss.getLocation() + "\n" +
                "Health Points: " + boss.getHp() + "\n" +
                "Weakness: " + boss.getWeakness() + "\n" +
                "Resistances: " + boss.getResistances() + "\n" +
                "Number of Souls: " + boss.getNumber_of_souls() + "\n");
    }

    public static void bossListOutput(List<Boss> bossList) {
        for (Boss boss : bossList) {
            bossOutput(boss);
        }
    }
}
