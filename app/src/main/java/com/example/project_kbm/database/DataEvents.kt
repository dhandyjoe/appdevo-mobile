package com.example.project_kbm.database

import com.example.project_kbm.R
import com.example.project_kbm.model.ModelEvent

object DataEvents {

    fun getEventList(): ArrayList<ModelEvent> {
        val eventList = ArrayList<ModelEvent>()

        val event1 = ModelEvent(
            R.drawable.isfest,
            "Talkshow Information System Festival",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform",
            R.drawable.card_detail_event
        )

        val event2 = ModelEvent(
            R.drawable.isfest,
            "Tournament PES",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform",
            R.drawable.card_detail_event
        )

        val event3 = ModelEvent(
            R.drawable.isfest,
            "qwe Information System Festival",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform",
            R.drawable.card_detail_event
        )

        val event4 = ModelEvent(
            R.drawable.isfest,
            "rqr Information System Festival",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform",
            R.drawable.card_detail_event
        )

        val event5 = ModelEvent(
            R.drawable.isfest,
            "ff Information System Festival",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform",
            R.drawable.card_detail_event
        )

        eventList.add(event1)
        eventList.add(event2)
        eventList.add(event3)
        eventList.add(event4)
        eventList.add(event5)
        return eventList
    }

}