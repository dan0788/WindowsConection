package com.example.windowsconection.Transform.interfaces

interface TransformCharactersInterface {
    fun transformToHexadecimal(value: String) : Int
    fun transformToBinary(value : String) : String
    fun hexCharToDecimal(char : Char) : Int
}