package com.fatih.mariobros

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.fatih.mariobros.screen.PlayScreen

class MarioBrosGame : Game(){

    lateinit var spriteBatch : SpriteBatch

    override fun create() {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        spriteBatch = SpriteBatch()
        setScreen(PlayScreen(this))
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        super.render()
    }

}
