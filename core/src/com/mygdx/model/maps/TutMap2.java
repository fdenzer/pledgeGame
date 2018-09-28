package com.mygdx.model.maps;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.enums.MapEnum;
import com.mygdx.game.PledgeGame;
import com.mygdx.game.TutorialTexts;
import com.mygdx.model.difficulties.Difficulty;
import com.mygdx.model.difficulties.DifficultyTutorial;
import com.mygdx.model.tutorialStrategies.TutorialStrategy;
import com.mygdx.model.tutorialStrategies.level_1.Strategy1A;
import com.mygdx.model.tutorialStrategies.level_2.Strategy2A;
import com.mygdx.model.tutorialStrategies.level_2.Strategy2B;
import com.mygdx.model.tutorialStrategies.level_2.Strategy2C;
import com.mygdx.screens.GameScreen;

public class TutMap2 extends AbstractMap {

    public TutMap2(final PledgeGame game, final GameScreen gameScreen, MapEnum nextMap) {
        super(game, gameScreen, nextMap);
        tiledMap = new TmxMapLoader().load("core/assets/maps/TutorialMap2.tmx");
        Label textArea = new Label(TutorialTexts.LEVEL1, game.uiSkin);
        window = new Window("Anfang des Algorithmus", game.uiSkin);
        CheckBox checkBoxA = new CheckBox("A", game.uiSkin);
        CheckBox checkBoxB = new CheckBox("B", game.uiSkin);
        CheckBox checkBoxC = new CheckBox("C", game.uiSkin);

        checkBoxA.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("A clicked");
                gameScreen.setButtonStrategy(new Strategy2A());
            }
        });

        checkBoxB.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("B clicked");
                gameScreen.setButtonStrategy(new Strategy2B());
            }
        });

        checkBoxC.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameScreen.setButtonStrategy(new Strategy2C());
            }
        });

        ButtonGroup<CheckBox> buttonGroup = new ButtonGroup<>(checkBoxA, checkBoxB, checkBoxC);
        window.add(textArea);
        window.row();
        window.add(checkBoxA);
        window.row();
        window.add(checkBoxB);
        window.row();
        window.add(checkBoxC);
        window.pack();
        window.setPosition(64, 500);
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
        return new Strategy1A();
    }

    @Override
    public Window getWindow() {
        return window;
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
    public void zielErreicht(MapEnum nextMap, boolean tutorialFlag) {
        super.zielErreicht(nextMap, true);
    }

    @Override
    public Difficulty getDifficulty() {
        return new DifficultyTutorial();
    }
}
