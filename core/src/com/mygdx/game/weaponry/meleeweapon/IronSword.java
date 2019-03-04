package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;
import com.mygdx.game.weaponry.attacks.D8Attack;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 09.09.2017.
 */
public class IronSword extends WeaponryStuff {

    public IronSword(String label, WeaponType type, int distance, Attack attack) {
        super(label, type, distance, attack);
    }

    public IronSword(){
        super("IronSword", STABBING,1, new D8Attack());

    }



}
