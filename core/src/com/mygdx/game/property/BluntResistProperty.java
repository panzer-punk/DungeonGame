package com.mygdx.game.property;



import com.mygdx.game.enumerations.AttackType;
import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Weapon;

import static com.mygdx.game.enumerations.AttackType.*;
import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 26.12.2018.
 */
public class BluntResistProperty extends AbstractProperty {

    @Override
    public int updateDamage(int dmg) {return dmg-4;}

    @Override
    public String getName() {
        return "Blunt resist";
    }

    @Override
    public AttackType getAttackType() {
        return EMPTY;
    }

    @Override
    public WeaponType getWeaponType() {
        return  STABBING;
    }
}
