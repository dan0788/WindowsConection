package com.example.windowsconection.transform.classes

import com.example.windowsconection.transform.interfaces.TransformCharactersInterface

class TransformCharactersClass :  TransformCharactersInterface{
    override fun transformToBinary(value: String): String {
        var num = value.toInt()
        var matrix : MutableList<Int> = mutableListOf()
        var rest : Int = 0
        var cociente = num
        var binaryValue : String = ""
        while (cociente >= 1){
            rest = cociente % 2
            cociente = (cociente / 2).toInt()
            matrix.add(rest)
        }

        for (i in 1 .. matrix.size){
            binaryValue = binaryValue + matrix[matrix.size - i]
        }

        return binaryValue;
    }

    override fun transformToHexadecimal(value: String): Int {
        var result : Int = 0
        var valueExp : Double = 0.0
        var matrix : MutableList<Char> = value.toMutableList()
        for (i in 0 until matrix.size){
            valueExp = Math.pow(16.0,(matrix.size - i - 1).toDouble())

            val myChar: Char = matrix[i]
            var valueHex = hexCharToDecimal(myChar)
            result = result + valueExp.toInt() * valueHex
        }

        return result;
    }

    override fun hexCharToDecimal(char: Char): Int {
        return when (char.uppercaseChar()) {
            '0' -> 0
            '1' -> 1
            '2' -> 2
            '3' -> 3
            '4' -> 4
            '5' -> 5
            '6' -> 6
            '7' -> 7
            '8' -> 8
            '9' -> 9
            'A' -> 10
            'B' -> 11
            'C' -> 12
            'D' -> 13
            'E' -> 14
            'F' -> 15
            else -> -1
        }
    }
}