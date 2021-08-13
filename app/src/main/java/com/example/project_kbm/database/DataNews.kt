package com.example.project_kbm.database

import com.example.project_kbm.model.ModelNews

object DataNews {

    fun getNewsList() : ArrayList<ModelNews> {
        val newsList = ArrayList<ModelNews>()

        val news1 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news2 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news3 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news4 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news5 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news6 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )

        val news7 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas"
        )


        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news4)
        newsList.add(news5)
        newsList.add(news6)
        newsList.add(news7)
        return newsList
    }
}