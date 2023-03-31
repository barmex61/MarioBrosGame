@file:JvmName("DesktopLauncher")

package com.fatih.mariobros.desktop

import com.badlogic.gdx.Files
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.fatih.mariobros.MarioBrosGame

/** Launches the desktop (LWJGL) application. */
fun main() {
    LwjglApplication(MarioBrosGame(), LwjglApplicationConfiguration().apply {
        title = "MarioBros"
        width = 640
        height = 480
        intArrayOf(128, 64, 32, 16).forEach{
            addIcon("libgdx$it.png", Files.FileType.Internal)
        }
    })
}
