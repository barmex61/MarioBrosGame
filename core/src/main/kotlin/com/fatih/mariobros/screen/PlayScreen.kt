package com.fatih.mariobros.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.utils.viewport.FitViewport
import com.fatih.mariobros.MarioBrosGame
import com.fatih.mariobros.scenes.Hud
import com.fatih.mariobros.sprites.Mario

class PlayScreen(private val game:MarioBrosGame) : Screen {

    private val gameCamera = OrthographicCamera()
    private val viewPort = FitViewport(4f,2f,gameCamera)
    private val hud = Hud(game.spriteBatch)
    private val tmxMapLoader : TmxMapLoader = TmxMapLoader()
    private val map : TiledMap = tmxMapLoader.load("map.tmx")
    private val orthogonalTiledMapRenderer: OrthogonalTiledMapRenderer = OrthogonalTiledMapRenderer(map,1/100f)
    private val world : World = World(Vector2(0f,-3f),true)
    private val box2DDebugRenderer: Box2DDebugRenderer = Box2DDebugRenderer()
    private lateinit var bodyDef: BodyDef
    private lateinit var fixtureDef: FixtureDef
    private lateinit var body: Body
    private val mario = Mario(world)

    init {
        gameCamera.position.set(viewPort.worldWidth/2f,viewPort.worldHeight/2f,0f)
        for (mapObject in map.layers[2].objects.getByType(RectangleMapObject::class.java)){
            val rectangle = mapObject.rectangle
            bodyDef = BodyDef().apply {
                type = BodyDef.BodyType.StaticBody
                position.set((rectangle.x + rectangle.width/2f)/100f,(rectangle.y + rectangle.height/2f)/100f)
            }
            body = world.createBody(bodyDef)
            val polygonShape = PolygonShape().apply {
                setAsBox(rectangle.width/200f,rectangle.height/200f)
            }
            fixtureDef = FixtureDef().apply {
                shape = polygonShape
                body.createFixture(this)
            }
            polygonShape.dispose()
        }
        for (mapObject in map.layers[3].objects.getByType(RectangleMapObject::class.java)){
            val rectangle = mapObject.rectangle
            bodyDef = BodyDef().apply {
                type = BodyDef.BodyType.StaticBody
                position.set((rectangle.x + rectangle.width / 2f)/100f,(rectangle.y + rectangle.height/2f)/100f)
            }
            body = world.createBody(bodyDef)
            val polygonShape = PolygonShape().apply {
                setAsBox(rectangle.width/200f,rectangle.height/200f)
            }
            fixtureDef = FixtureDef().apply {
                shape = polygonShape
                body.createFixture(this)
            }
            polygonShape.dispose()
        }
        for (mapObject in map.layers[5].objects.getByType(RectangleMapObject::class.java)){
            val rectangle = mapObject.rectangle
            bodyDef = BodyDef().apply {
                type = BodyDef.BodyType.StaticBody
                position.set((rectangle.x + rectangle.width/2f)/100f,(rectangle.y + rectangle.height /2f)/100f)
            }
            body = world.createBody(bodyDef)
            val polygonShape = PolygonShape().apply {
                setAsBox(rectangle.width/200f,rectangle.height/200f)
            }
            fixtureDef = FixtureDef().apply {
                shape = polygonShape
                body.createFixture(this)
            }
            polygonShape.dispose()
        }
        for (mapObject in map.layers[4].objects.getByType(RectangleMapObject::class.java)){
            val rectangle = mapObject.rectangle
            bodyDef = BodyDef().apply {
                type = BodyDef.BodyType.StaticBody
                position.set((rectangle.x + rectangle.width / 2f)/100f,(rectangle.y + rectangle.height /2f)/100f)
            }
            body = world.createBody(bodyDef)
            val polygonShape = PolygonShape().apply {
                setAsBox(rectangle.width/200f,rectangle.height/200f)
            }
            fixtureDef = FixtureDef().apply {
                shape = polygonShape
                body.createFixture(this)
            }
            polygonShape.dispose()
        }
    }

    private fun update(deltaTime : Float){
        handleInput(deltaTime)
        world.step(1/60f,6,2)
        gameCamera.update()
        orthogonalTiledMapRenderer.setView(gameCamera)
    }

    private fun handleInput(deltaTime: Float){
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            mario.body.applyLinearImpulse(Vector2(0f,2f),mario.body.worldCenter,true)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && mario.body.linearVelocity.x >= -2f){
            mario.body.applyLinearImpulse(Vector2(-0.1f,0f),mario.body.worldCenter,true)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && mario.body.linearVelocity.x <= 2f){
            mario.body.applyLinearImpulse(Vector2(0.1f,0f),mario.body.worldCenter,true)
        }

    }

    override fun show() {

    }

    override fun render(delta: Float) {
        update(delta)
        orthogonalTiledMapRenderer.render()
        box2DDebugRenderer.render(world,gameCamera.combined)
        game.spriteBatch.projectionMatrix = gameCamera.combined
        hud.stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewPort.update(width,height)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }
}
