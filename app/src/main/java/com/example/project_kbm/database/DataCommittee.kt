package com.example.project_kbm.database

import com.example.project_kbm.model.ModelCommittee

object DataCommittee {

    fun getCommitteeList() :  ArrayList<ModelCommittee> {
        val committeeList = ArrayList<ModelCommittee>()

        val committee1 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia."
        )

        val committee2 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia."
        )

        val committee3 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia."
        )

        val committee4 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia."
        )

        val committee5 = ModelCommittee(
            "Youth Leadership",
            "Youth Leadership merupakan program pengembangan skill kepemimpinan yang ditujukan untuk mahasiswa Indonesia."
        )

        committeeList.add(committee1)
        committeeList.add(committee2)
        committeeList.add(committee3)
        committeeList.add(committee4)
        committeeList.add(committee5)
        return committeeList
    }

}