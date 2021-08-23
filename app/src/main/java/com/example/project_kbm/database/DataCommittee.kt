package com.example.project_kbm.database

import com.example.project_kbm.model.ModelCommittee

object DataCommittee {

    fun getCommitteeList() :  ArrayList<ModelCommittee> {
        val committeeList = ArrayList<ModelCommittee>()

        val committee1 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia.",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform"
        )

        val committee2 = ModelCommittee(
            "asd Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia.",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform"
        )

        val committee3 = ModelCommittee(
            "qwe Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia.",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform"
        )

        val committee4 = ModelCommittee(
            "zxc Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia.",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform"
        )

        val committee5 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia.",
            "https://docs.google.com/forms/d/e/1FAIpQLSdWQ_RlgT30piyBi2QAbgfT1uGcJ-TZwBq3B7Ai-NJLnJHiXA/viewform"
        )

        committeeList.add(committee1)
        committeeList.add(committee2)
        committeeList.add(committee3)
        committeeList.add(committee4)
        committeeList.add(committee5)
        return committeeList
    }

}