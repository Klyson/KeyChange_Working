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
            //Top Left
            Gdx.gl.glClearColor(1, 0, 0, 1);
        } else if (button == Buttons.LEFT && screenX < XMid && screenY > YMid) {
            //Top Right
            Gdx.gl.glClearColor(0, 1, 0, 1);
        } else if (button == Buttons.LEFT && screenX > XMid && screenY < YMid) {
            //Bottom Left
            Gdx.gl.glClearColor(0, 0, 1, 1);
        } else if (button == Buttons.LEFT && screenX > XMid && screenY > YMid) {
            //Bottom Right
            Gdx.gl.glClearColor(0, 0, 0, 1);
        }
        //System.out.println(screenX + " screenX " + screenY + " screenY");
        return true;
    }
}
