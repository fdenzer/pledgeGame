package com.mygdx.model.difficulties;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.model.maze_algorithm.LabyrinthErstellen2;

public class DifficultyTutorial implements Difficulty {

    public DifficultyTutorial() {
        createMap();
    }

    @Override
    public Texture getFOVTexture() {
        return null;
    }

    @Override
    public void createMap() {    }

    @Override
    public boolean hasTexture() {
        return false;
    }
}