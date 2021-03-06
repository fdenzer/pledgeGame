package com.mygdx.model.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.enums.MapEnum;
import com.mygdx.game.PledgeGame;
import com.mygdx.game.TutorialTexts;
import com.mygdx.model.difficulties.Difficulty;
import com.mygdx.model.difficulties.DifficultyHigh;

import static com.mygdx.game.ResourcePaths.INTRODUCTIONMAP3;

public class TutMap8 extends AbstractMap {
    private Label algoText;
    private Label algoText2;
    private Label algoText3;
    //private boolean justTurned = false;
    private int revC;
    private int flag2;

    public TutMap8(final PledgeGame game, MapEnum nextMap) {
        super(game, nextMap);
        tiledMap = new TmxMapLoader().load(INTRODUCTIONMAP3);
        Label textArea = new Label(TutorialTexts.LEVEL6, game.uiSkin);
        window = new Window("Algorithmus fertiggestellt", game.uiSkin);

        algoText = new Label("S-1: Laufe geradeaus. \nWenn links frei und Kompass < 0, dann S-2, wenn Weg versperrt, dann S-3 ", game.uiSkin);
        algoText2 = new Label("S-2: Nach links drehen und Kompass + 1 und weiter mit S-1 ", game.uiSkin);
        algoText3 = new Label("S-3: Nach rechts drehen und Kompass - 1 und weiter mit S-1 ", game.uiSkin);
        algoText.setFontScale(0.9f);
        algoText2.setFontScale(0.9f);
        algoText3.setFontScale(0.9f);


        window.add(textArea);
        window.pack();
        window.setPosition(0, Gdx.graphics.getHeight());

        algoWindow = new Window(TutorialTexts.ALGO_WINDOW_HEADLINE, game.uiSkin);
        algoWindow.add(algoText);
        algoWindow.row();
        algoWindow.add(algoText2);
        algoWindow.row();
        algoWindow.add(algoText3);
        algoWindow.pack();
        algoWindow.setPosition(100, 0);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                window.remove();
            }
        }, 0.1f);
    }

    @Override
    public int getStartX() {
        return 96;
    }

    @Override
    public int getStartY() {
        return 32;
    }

    @Override
    public Window getWindow() {
        return window;
    }

    @Override
    public Window getAlgoWindow() {
        return algoWindow;
    }

    @Override
    public boolean getTutorialFlagOfNextLevel() {
        return true;
    }

    @Override
    public MapEnum getNextMap() {
        return nextMap;
    }

    @Override
    public void triggerGoalAchievedMethod() {
        super.goalAchieved(nextMap, false);
    }

    @Override
    public void showInstructions(int x, int y) {

    }

    @Override
    public void showInstructions(int revCounter, boolean up, boolean right, boolean bottom, boolean left) {

        if(revCounter == 0 && !up) {
            algoText.setColor(Color.RED);
            algoText2.setColor(Color.WHITE);
            algoText3.setColor(Color.WHITE);
        } else if(revCounter < 0 && !left) {
            if(flag2 == 0)
                test(revCounter);
            algoText.setColor(Color.WHITE);
            algoText2.setColor(Color.RED);
            algoText3.setColor(Color.WHITE);
            if(revCounter-1 == revC) {
                algoText.setColor(Color.RED);
                algoText2.setColor(Color.WHITE);
                algoText3.setColor(Color.WHITE);
            }
        } else if((revCounter < 0 && left && up) || (revCounter == 0 & up)) {
            algoText.setColor(Color.WHITE);
            algoText2.setColor(Color.WHITE);
            algoText3.setColor(Color.RED);
        } else if(revCounter < 0 && left && !up) {
            algoText.setColor(Color.RED);
            algoText2.setColor(Color.WHITE);
            algoText3.setColor(Color.WHITE);
            flag2 = 0;
        }
        /*if (revCounter <= 0 && !up) {
            algoText.setColor(Color.RED);
            algoText2.setColor(Color.WHITE);
            algoText3.setColor(Color.WHITE);
            if (left)
                justTurned = false;
        }

        if ((revCounter < 0 && up && left) || (revCounter == 0 && up)) {
            algoText3.setColor(Color.RED);
            algoText.setColor(Color.WHITE);
            algoText2.setColor(Color.WHITE);
        }

        if (revCounter < 0 && !left && !justTurned) {
            algoText.setColor(Color.WHITE);
            algoText3.setColor(Color.WHITE);
            algoText2.setColor(Color.RED);
            justTurned = true;
        }*/
    }

    private void test(int counter) {
        flag2++;
        revC = counter;
    }

    @Override
    public Difficulty getDifficulty() {
        return new DifficultyHigh();
    }
}
