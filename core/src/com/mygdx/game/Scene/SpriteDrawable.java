package com.mygdx.game.Scene;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Даниил on 29.08.2018.
 */
public class SpriteDrawable implements Drawable {

    private Sprite sprite;

    public SpriteDrawable(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {

        batch.draw(sprite.getTexture(),x,y,width,height);

    }

    @Override
    public float getLeftWidth() {
        return 50;
    }

    @Override
    public void setLeftWidth(float leftWidth) {

    }

    @Override
    public float getRightWidth() {
        return 50;
    }

    @Override
    public void setRightWidth(float rightWidth) {

    }

    @Override
    public float getTopHeight() {
        return 50;
    }

    @Override
    public void setTopHeight(float topHeight) {

    }

    @Override
    public float getBottomHeight() {
        return 50;
    }

    @Override
    public void setBottomHeight(float bottomHeight) {

    }

    @Override
    public float getMinWidth() {
        return 50;
    }

    @Override
    public void setMinWidth(float minWidth) {

    }

    @Override
    public float getMinHeight() {
        return 50;
    }

    @Override
    public void setMinHeight(float minHeight) {

    }
}
