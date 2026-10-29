import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameCharacterTest {
    private GameCharacter character(int health, int defence) {
        return new GameCharacter(1, "Target", 1, 100, health, 10, defence) {
            @Override
            public void attack(GameCharacter target) {
                // Only damage reception is under test.
            }
        };
    }

    @Test
    void damageGreaterThanDefenceReducesHealthByTheDifference() {
        GameCharacter target = character(100, 20);

        target.receiveDamage(45);

        assertEquals(75, target.getCurrentHealth());
    }

    @Test
    void damageEqualToDefenceLeavesHealthUnchanged() {
        GameCharacter target = character(70, 20);

        target.receiveDamage(20);

        assertEquals(70, target.getCurrentHealth());
    }

    @Test
    void damageLessThanDefenceLeavesHealthUnchanged() {
        GameCharacter target = character(70, 20);

        target.receiveDamage(10);

        assertEquals(70, target.getCurrentHealth());
    }

    @Test
    void lethalDamageClampsHealthToZero() {
        GameCharacter target = character(15, 20);

        target.receiveDamage(50);

        assertEquals(0, target.getCurrentHealth());
        assertFalse(target.isAlive());
    }
}
