package com.example.windowsconection.barGraph.classes

import com.example.windowsconection.barGraph.interfaces.DateInterface
import java.util.Calendar

class DateClass : DateInterface{
    override fun getCurrentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}