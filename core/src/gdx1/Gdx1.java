package gdx1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gdx1 extends InputAdapter implements ApplicationListener {

    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private boolean isLeft, isRight;

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("CoreSprite.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2 - 
                sprite.getHeight() / 2);
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (isLeft) {
            sprite.translateX(-1f);
        } if (isRight) {
            sprite.translateX(1f);
        }
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
    public boolean keyDown(int keycode) {
        if (keycode == Keys.LEFT) {
            isLeft = true;
        }
        if (keycode == Keys.RIGHT) {
            isRight = true;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.LEFT) {
            isLeft = false;
        }
        if (keycode == Keys.RIGHT) {
            isRight = false;
        }
        return true;
    }
}
