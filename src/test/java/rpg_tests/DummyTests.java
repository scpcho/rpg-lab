package rpg_tests;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 13;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before

    public void setUp() {
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test

    public void attackedTargetLosesHealth() {
        int attack = 5;
        aliveDummy.takeAttack(attack);

        Assert.assertEquals(HEALTH - attack, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)

    public void attackedTargetIsDead() {


        deadDummy.takeAttack(0);

    }

    @Test

    public void attackedTargetIsDeadAndGiveExp() {

        int actualExperience = deadDummy.giveExperience();
        Assert.assertEquals(EXPERIENCE, actualExperience);
    }

    @Test(expected = IllegalStateException.class)

    public void attackedTargetIsAliveAndGiveNoExp() {


        aliveDummy.giveExperience();
    }
}
