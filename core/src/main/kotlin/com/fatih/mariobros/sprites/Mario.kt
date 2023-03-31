package com.fatih.mariobros.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.CircleShape
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.World

class Mario (world: World) : Sprite() {

    var body : Body


    init {
        val bodyDef = BodyDef().apply {
            position.set(32f/100f,32f/100f)
            this.gravityScale = 5f
            type = BodyDef.BodyType.DynamicBody
        }
        body = world.createBody(bodyDef)
        val circleShape = CircleShape().apply {
            radius = 5f/100f
        }
        FixtureDef().apply {
            shape = circleShape
            body.createFixture(this)
        }
    }
}
