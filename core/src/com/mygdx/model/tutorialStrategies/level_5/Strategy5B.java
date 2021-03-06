package com.mygdx.model.tutorialStrategies.level_5;

import com.badlogic.gdx.utils.Timer;
import com.mygdx.model.Player;
import com.mygdx.model.tutorialStrategies.TutorialStrategy;
import com.mygdx.screens.GameScreen;

public class Strategy5B implements TutorialStrategy {
    @Override
    public void algorithm(final GameScreen gameScreen) {
        if(!gameScreen.getPlayer().isTop()) {
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    gameScreen.getPlayer().move(32);
                }
            }, 0.2f);
        } else if(gameScreen.getPlayer().isTop() && gameScreen.getPlayer().getState() == Player.Player_State.STANDING) {
            gameScreen.getPlayer().rotateRight();
        }
    }
}
