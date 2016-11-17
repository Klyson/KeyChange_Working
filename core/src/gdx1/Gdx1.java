package gdx1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

public class Gdx1 extends InputAdapter implements ApplicationListener {

    private SpriteBatch batch;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean S;
    private Rectangle recTL, recTR, recBL, recBR, recTemp;
    ArrayList<Rectangle> randRec = new ArrayList();
    int w, h;

    @Override
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        sprite1 = new Sprite(new Texture("Red.png"));
        sprite2 = new Sprite(new Texture("Blue.png"));
        sprite3 = new Sprite(new Texture("green.jpg"));
        sprite4 = new Sprite(new Texture("black.jpg"));
        sprite1.setSize(w / 2, h / 2);
        sprite2.setSize(w / 2, h / 2);
        sprite3.setSize(w / 2, h / 2);
        sprite4.setSize(w / 2, h / 2);
        recTL = new Rectangle(0, 0, w / 2, h / 2);
        recTR = new Rectangle(w / 2, 0, w / 2, h / 2);
        recBL = new Rectangle(0, h / 2, w / 2, h / 2);
        recBR = new Rectangle(w / 2, h / 2, w / 2, h / 2);
        recTemp = new Rectangle();
        randRec.add(recTL);
        randRec.add(recTR);
        randRec.add(recBL);
        randRec.add(recBR);
        sprite1.setPosition(recTL.x, recTL.y);
        sprite2.setPosition(recTR.x, recTR.y);
        sprite3.setPosition(recBL.x, recBL.y);
        sprite4.setPosition(recBR.x, recBR.y);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (S) {
            Collections.shuffle(randRec);
            sprite1.setPosition(randRec.get(0).x, randRec.get(0).y);
            sprite2.setPosition(randRec.get(1).x, randRec.get(1).y);
            sprite3.setPosition(randRec.get(2).x, randRec.get(2).y);
            sprite4.setPosition(randRec.get(3).x, randRec.get(3).y);
        }
        batch.begin();
        sprite1.draw(batch);
        sprite2.draw(batch);
        sprite3.draw(batch);
        sprite4.draw(batch);
        batch.end();
        S = false;
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
        if (button == Buttons.LEFT) {
            S = true;
        }
        return true;
    }
}