package com.example.project_kbm.database

import com.example.project_kbm.R
import com.example.project_kbm.model.ModelEvent

object DataEvents {

    fun getEventList(): ArrayList<ModelEvent> {
        val eventList = ArrayList<ModelEvent>()

        val event1 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival"
        )

        val event2 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival"
        )

        val event3 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival"
        )

        val event4 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival"
        )

        val event5 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival"
        )

        eventList.add(event1)
        eventList.add(event2)
        eventList.add(event3)
        eventList.add(event4)
        eventList.add(event5)
        return eventList
    }

}