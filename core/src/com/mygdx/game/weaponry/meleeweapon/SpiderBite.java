package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.weaponry.attacks.SpiderBiteAttack;
import com.mygdx.game.weaponry.buffs.Buff;
import com.mygdx.game.weaponry.poisons.Poison;
import com.mygdx.game.weaponry.poisons.SpiderPoison;
import com.mygdx.game.weaponry.WeaponryStuff;

import static com.mygdx.game.enumerations.WeaponType.*;

public class SpiderBite extends WeaponryStuff {
    private Poison poison;

    public SpiderBite(String label, WeaponType type, int distance, Attack attack) {
        super(label, type, distance, attack);

    }


    public SpiderBite(){
        super("SpiderBite", STABBING,1, new SpiderBiteAttack());
    }




}
