package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class HeroTest {

    @Test

    public void heroGainsExperienceWhenKillTarget() {

        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Java Wizard", weapon);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(13);

        hero.attack(target);

        assertEquals(13, hero.getExperience());

    }
}