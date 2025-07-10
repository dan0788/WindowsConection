package com.example.windowsconection.musicPlayer.interfaces

import android.content.res.AssetManager

interface GetSongsInterface {
    fun getSongs(assetManager: AssetManager) : MutableList<String>
}