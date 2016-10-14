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
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4;
    private boolean jUp = false;
    private float XMid, YMid;
    private int j = 0, nNailedIt = 0, nPrev; //0 == true;
    SongOne song1 = new SongOne();

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        batch = new SpriteBatch();
        img1 = new Texture("Red.png");
        img2 = new Texture("Blue.png");
        img3 = new Texture("green.jpg");
        img4 = new Texture("black.jpg");
        sprite1 = new Sprite(img1);//TL
        sprite2 = new Sprite(img2);//TR
        sprite3 = new Sprite(img3);//BL
        sprite4 = new Sprite(img4);//BR
        sprite1.setSize((w / 2) - 50, h / 2);
        sprite2.setSize((w / 2) - 50, h / 2);
        sprite3.setSize((w / 2) - 50, h / 2);
        sprite4.setSize((w / 2) - 50, h / 2);
        sprite1.setPosition(0, h / 2);
        sprite2.setPosition((w / 2) + 50, h / 2);
        sprite3.setPosition(0, 0);
        sprite4.setPosition((w / 2) + 50, 0);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img1.dispose();
        img2.dispose();
        img3.dispose();
        img4.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (int k = 0; k < 3; k++) {
            if (song1.TL[k] == j && nNailedIt == 1) {
                j++; //hit TL when TL is supposed to be hit
                jUp = true;
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.TR[k] == j && nNailedIt == 2) {
                j++; //hit TR when TR is supposed to be hit
                jUp = true;
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.BL[k] == j && nNailedIt == 3) {
                j++; //hit BL when BL is supposed to be hit
                jUp = true;
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.BR[k] == j && nNailedIt == 4) {
                j++; //hit BR when BR is supposed to be hit
                jUp = true;
            }
        }
        if (nNailedIt != nPrev && !jUp) { //click occured. It was wrong.
            j++;
        }
        for (int k = 0; k < 3; k++) {
            if (song1.TL[k] == j + 1) {
                Gdx.gl.glClearColor(1, 0, 0, 1);
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.TR[k] == j + 1) {
                Gdx.gl.glClearColor(0, 0, 1, 1);
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.BL[k] == j + 1) {
                Gdx.gl.glClearColor(0, 0, 1, 1);
            }
        }
        for (int k = 0; k < 3; k++) {
            if (song1.BR[k] == j + 1) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
            }
        }
        batch.begin();
        sprite1.draw(batch);
        sprite2.draw(batch);
        sprite3.draw(batch);
        sprite4.draw(batch);
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
                    nNailedIt = 1;
                }
            }
        } else if (button == Buttons.LEFT && screenX < XMid && screenY > YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.TR[k] == j) {
                    nNailedIt = 2;
                }
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY < YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.BL[k] == j) {
                    nNailedIt = 3;
                }
            }
        } else if (button == Buttons.LEFT && screenX > XMid && screenY > YMid) {
            for (int k = 0; k < 3; k++) {
                if (song1.BR[k] == j) {
                    nNailedIt = 4;
                }
            }
        } else if (button == Buttons.LEFT && nNailedIt != 6) {
            nNailedIt = 6;
        } else if (button == Buttons.LEFT && nNailedIt == 5) {
            nNailedIt = 5;
        }
        j++;
        //System.out.println(screenX + " screenX " + screenY + " screenY");
        return true;
    }
}