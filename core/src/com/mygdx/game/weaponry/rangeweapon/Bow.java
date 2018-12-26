package com.mygdx.game.weaponry.rangeweapon;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.particles.ArrowParticle;
import com.mygdx.game.systems.GameScreenManager;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

import static com.mygdx.game.enumerations.WeaponType.*;

public class Bow extends WeaponryStuff {

    private Shell shell;

    public Bow() {
        super("Bow", STABBING, 4);
        }

        @Override
        public  void makeDamage(GameObject dealer, GameObject gainer){

            GameScreenManager.addParticle(new ArrowParticle(new Vector3(dealer.getSprite().getX(), 0, dealer.getSprite().getZ()),
                                                            new Vector3(gainer.getX(), 0, gainer.getY())));

            //реализация по умолчанию
          /*  if((dealer.getDEX() + Dice.d20()) >= gainer.getArmorClass()) {
                if(gainer.getClassification() == Classification.OBJECT) {
                    gainer.takeDamage(dealer);
                }
                else
                gainer.takeDamage(shell);
            }else {
                getDamage();//стрельнули вхолостую
                System.out.println("Miss");
            }*/
        }


    public void setShell(Shell shell) {
        this.shell = shell;
    }

    @Override
    public int getDamage() {
        return 1;
    }
}
