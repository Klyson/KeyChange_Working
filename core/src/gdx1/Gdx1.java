package gdx1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gdx1 extends InputAdapter implements ApplicationListener {

    private SpriteBatch batch;
    private Texture img;
    private Sprite sprite;
    private boolean isLeft, isRight;
    private float XMid, YMid;
    private int j = 0, nNailedIt //0 == true;
    SongOne song1 = new SongOne();

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        batch = new SpriteBatch();
        img = new Texture("CoreSprite.png");
        sprite = new Sprite(img);
        sprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2
                - sprite.getHeight() / 2);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);        
        //for (int i = 0; i < 3; i++) {
        //System.out.println(song1.TL[i]);
        //}this prints the entire array each frame, i is reset each frame after printing the array
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Buttons.LEFT && screenX < XMid && screenY < YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.TL[k] == j) {
                    nNailedIt = ;
                }
            }
        } else if (button == Buttons.LEFT && screenX < XMid && screenY > YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.TR[k] == j) {
                    nNailedIt = true;
                }
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY < YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.BL[k] == j) {
                    nNailedIt = true;
                }
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY > YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.BR[k] == j) {
                    nNailedIt = true;
                }
            }
        }
        j++;
        //System.out.println(screenX + " screenX " + screenY + " screenY");
        return true;
    }
}