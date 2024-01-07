package leetcode.demo.problems;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * There are N warriors, the ith of which has a health of H i units and can deal D i units of damage per second.
 * They are confronting a boss who has unlimited health and can deal B units of damage per second. Both the warriors and the boss deal damage continuously -− for example, in half a second, the boss deals B/2 units of damage.
 *
 * The warriors feel it would be unfair for many of them to fight the boss at once, so they'll select just two representatives to go into battle. One warrior i will be the front line, and a different warrior j will back them up. During the battle, the boss will attack warrior ii until that warrior is defeated (that is, until the boss has dealt H i units of damage to them), and will then attack warrior j until that warrior is also defeated, at which point the battle will end. Along the way, each of the two warriors will do damage to the boss as long as they are undefeated.
 *
 * Of course, the warriors will never prevail, but they'd like to determine the maximum amount of damage they could deal to the boss for any choice of warriors i and j before the battle ends.
 * Note: Your return value must have an absolute or relative error of at most 10^-6
 * to be considered correct.
 */
public class BestWarriorPairFacebook {
    public double getMaxDamageDealt(int N, int[] H, int[] D, int B) {

        double dam = (double) B;
        Warrior[] wars = new Warrior[N];
        for (int i = 0; i < N; i++) {
            wars[i] = new Warrior(H[i], D[i]);
        }
        Arrays.sort(wars);
        Warrior best = wars[0];
        Warrior second = wars[1];
        double res = fightTogether(best, second, dam);

        for (int i = 2; i < N; i++) {
            double dam1 =fightTogether(wars[i], best, dam);
            double dam2 = fightTogether(wars[i], second, dam);
            if (res < dam1) {
                res = dam1;
                second = wars[i];
            }
            if (res < dam2) {
                res = dam2;
                best = wars[i];
            }
        }
        DecimalFormat df = new DecimalFormat("#.000000");
        String formattedValue = df.format(res);
        return Double.valueOf(formattedValue);
    }

    public double fightTogether(Warrior w1, Warrior w2, double damage) {
        return Math.max(w1.battleWith(w2, damage), w2.battleWith(w1, damage));
    }

    class Warrior implements Comparable<Warrior> {
        long health;
        long damage;

        public Warrior(int health, int damage) {
            this.health = health;
            this.damage = damage;
        }

        public int compareTo(Warrior that) {
            return -Long.compare(this.health * this.damage, that.health * that.damage);
        }

        double battleWith(Warrior another, double damage) {
            return (this.health / damage) * (this.damage + another.damage) + (another.health / damage) * another.damage;
        }
    }
}
