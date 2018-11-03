package com.mygdx.model.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.enums.MapEnum;
import com.mygdx.game.PledgeGame;
import com.mygdx.game.TutorialTexts;
import com.mygdx.model.difficulties.Difficulty;
import com.mygdx.model.difficulties.DifficultyTutorial;
import com.mygdx.model.tutorialStrategies.TutorialStrategy;
import com.mygdx.model.tutorialStrategies.level_5.Strategy5A;

import static com.mygdx.game.ResourcePaths.TUTMAP6;

public class TutMap6 extends AbstractMap{

    public TutMap6(final PledgeGame game, MapEnum nextMap) {
        super(game, nextMap);
        tiledMap = new TmxMapLoader().load(TUTMAP6);
        Label textArea = new Label(TutorialTexts.LEVEL6, game.uiSkin);
        window = new Window("Algorithmus fertiggestellt", game.uiSkin);

        final Label algoText = new Label("1: Laufe geradeaus ", game.uiSkin);
        final Label algoText2 = new Label("2: Wand vor dir, aber links keine und Zaehler < 0:\nDrehe dich nach links und Zaehler + 1 ", game.uiSkin);
        final Label algoText3 = new Label("3: Wand vor dir: Drehe dich nach rechts und Zaehler - 1 ", game.uiSkin);
        algoText.setFontScale(0.9f);
        algoText2.setFontScale(0.9f);
        algoText3.setFontScale(0.9f);


        window.add(textArea);
        window.pack();
        window.setPosition(64, Gdx.graphics.getHeight());

        algoWindow = new Window(TutorialTexts.ALGO_WINDOW_HEADLINE, game.uiSkin);
        algoWindow.add(algoText);
        algoWindow.row();
        algoWindow.add(algoText2);
        algoWindow.row();
        algoWindow.add(algoText3);
        algoWindow.pack();
        algoWindow.setPosition(128, 128);
    }

    @Override
    public int getStartX() {
        return 32;
    }

    @Override
    public int getStartY() {
        return 32;
    }

    @Override
    public TutorialStrategy getStartStrategy() {
        return new Strategy5A();
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
    public boolean getTutorialFlag() {
        return true;
    }

    @Override
    public MapEnum getNextMap() {
        return nextMap;
    }

    @Override
    public void showInstructions() {

    }

    @Override
    public void goalAchieved(MapEnum nextMap, boolean tutorialFlag) {
        super.goalAchieved(nextMap, false);
        //((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen(game));
    }

    @Override
    public Difficulty getDifficulty() {
        return new DifficultyTutorial(false);
    }
}