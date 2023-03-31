package com.fatih.mariobros.scenes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class Hud (spriteBatch: SpriteBatch) {

    private val viewPort : Viewport = FitViewport(4f,2f,OrthographicCamera())
    val stage : Stage = Stage(viewPort,spriteBatch)
    private var worldTimer = 300
    private var timeCount = 0f
    private var score = 0
    private val countDownLabel : Label = Label(String.format("%03d",worldTimer),Label.LabelStyle(BitmapFont(), Color.WHITE))
    private val scoreLabel : Label = Label(String.format("%06d",score),Label.LabelStyle(BitmapFont(), Color.WHITE))
    private val timeLabel : Label = Label("TIME",Label.LabelStyle(BitmapFont(), Color.WHITE))
    private val levelLabel : Label = Label("1-1",Label.LabelStyle(BitmapFont(), Color.WHITE))
    private val worldLabel : Label = Label("WORLD",Label.LabelStyle(BitmapFont(), Color.WHITE))
    private val marioLabel : Label =  Label("MARIO",Label.LabelStyle(BitmapFont(), Color.WHITE))

    init {
        val table = Table().apply {
            top()
            setFillParent(true)
            add(marioLabel).expandX().padTop(10f)
            add(worldLabel).expandX().padTop(10f)
            add(timeLabel).expandX().padTop(10f)
            row()
            add(scoreLabel).expandX()
            add(levelLabel).expandX()
            add(countDownLabel).expandX()
        }
        stage.addActor(table)
    }
}
