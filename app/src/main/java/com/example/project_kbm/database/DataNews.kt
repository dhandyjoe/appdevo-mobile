package com.example.project_kbm.database

import com.example.project_kbm.model.ModelNews

object DataNews {

    fun getNewsList() : ArrayList<ModelNews> {
        val newsList = ArrayList<ModelNews>()

        val news1 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news2 = ModelNews (
            "Koordinator Tugas AKhir",
            "24 August 2021",
            "Pendaftaran Tugas Akhir di SITA (D3 dan S1) Sem Ganjil 2021-2022",
            "Pengumuman Tugas Akhir",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news3 = ModelNews (
            "YRB",
            "06 August 2021",
            "Perwalian Yos Richard Beeh",
            "Pengumuman Dosen",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news4 = ModelNews (
            "Koordinator Tugas AKhir",
            "28 July 2021",
            "Pencariran Nilai DT TA SEM Antara 2020-2021 ",
            "Pengumuman Tugas Akhir",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news5 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news6 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakasdasdultas",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
        )

        val news7 = ModelNews (
            "Sekretaris Progdi S1 Teknik Informatika",
            "08 July 2021",
            "Informasi Administrasi FTI Selama PPKM ",
            "Pengumuman Fakultas",
            "Ditujukan bagi mahasiswa yang mengambil Tugas Akhir, berikut kami informasikan hal-hal penting terkait Wisuda Oktober tahun 2021:\\n\\n\n" +
                    "\n" +
                    "1. Prosedur Wisuda Oktober 2021, silahkan dapat dibaca di sini\n" +
                    "2. Tanggal-tanggal penting:\n" +
                    "\n" +
                    "Tanda tangan pembimbing, reviewer, pimpinan pada berkas mahasiswa (Berita Acara Ujian/Review, Halaman Judul dan Lembar Pengesahan akan dikirimkan oleh Bagian TA  ke email Pembimbing, Reviewer dan Pimpinan melalui aplikasi SignNow. Batas pengiriman berkas dari mahasiswa ke email Bagian TA:\n" +
                    "a.      Gelombang I : Rabu, 23 Juni  2021 jam 15.00\n" +
                    "b.      Gelombang II: Rabu, 4 Agustusl 2021 jam 15.00\n" +
                    "\n" +
                    "Batas akhir penyerahan berkas syarat Yudisium (hard copy) ke Bagian TA (Ruang 327 Kantor FTI):\n" +
                    "a. Gelombang I  : Jumat, 30 Juni 2021 jam 16.00\n" +
                    "b. Gelombang II : Senin, 9 Agustus 2021 jam 16.00\n" +
                    "\n" +
                    "Pelaksanaan Upacara Yudisium:\n" +
                    "Kamis, 7 Oktober 2021\n" +
                    "\n" +
                    "Pelaksanaan Wisuda:\n" +
                    "Sabtu, 9 Oktober 2021"
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