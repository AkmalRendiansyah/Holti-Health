package com.holtihealth.app.helper

import com.holtihealth.app.database.Article
import com.holtihealth.app.database.Disease

object InitialDataSource {
    fun getArticles(): List<Article> {
        return listOf(
            Article(
                title = "Penyakit Antraknos pada Cabai",
                description = "Penyakit Antraknos pada cabai disebabkan oleh jamur Colletotrichum spp. yang menyerang buah cabai, menyebabkan busuk buah.",
                image = "https://www.infarm.co.id/uploads/article/Xgg0sUuJn8IqiQHSGgWonRojj31w7moyiXdSVLOa.jpg"
            ),
            Article(
                title = "Penyakit Layu Fusarium pada Cabai",
                description = "Penyakit Layu Fusarium disebabkan oleh jamur Fusarium oxysporum yang menyebabkan tanaman cabai layu dan mati mendadak.",
                image = "https://trubus.id/wp-content/uploads/2020/02/Trubus-Edisi-603-Februari-2020-Highrest-78-2.jpg"
            ),
            Article(
                title = "Penyakit Bercak Daun Cabai",
                description = "Penyakit bercak daun cabai disebabkan oleh beberapa jenis jamur yang menyebabkan bercak pada daun cabai dan mengurangi kualitas hasil panen.",
                image = "https://asset.kompas.com/crops/PecRmY2jQCZ0CWNcMRmdvinTr6k=/0x77:375x452/340x340/data/photo/2022/11/28/63847b2635b1f.jpg"
            )
        )
    }

    fun getDiseases(): List<Disease> {

        return listOf(
            Disease(
                name = "Kutu Kebul",
                symptoms = """
            Penyakit ini menimbulkan kerusakan pada daun, batang, dan akar. Gejala serangan mulai terlihat dari munculnya bercak bulat berwarna coklat pada daun yang kemudian mengering. Ukuran bercak dapat mencapai sekitar 1 inci. Pusat bercak berwarna pucat hingga putih dengan warna tepi lebih gelap. Bercak yang tua dapat menyebabkan lubang-lubang pada daun.
            
            Serangan berat dapat menyebabkan daun layu dan rontok, sehingga tanaman cabai kehilangan hampir semua daunnya. Hal ini sangat memengaruhi kemampuan tanaman untuk menghasilkan buah. Penyakit ini lebih sering menyerang tanaman tua dan berkembang pesat di lingkungan yang lembab atau selalu hujan.
            
            Pada musim kemarau atau di lahan dengan drainase baik, perkembangan penyakit bercak daun biasanya lebih terhambat.
        """.trimIndent(),
                control = """
            1. Lakukan sanitasi dengan cara memusnahkan sisa-sisa tanaman yang terinfeksi.
            2. Gunakan bibit bebas patogen pada lahan yang tidak terkontaminasi, baik di persemaian maupun di lapangan.
            3. Perlakukan benih sebelum tanam untuk mencegah infeksi awal.
            4. Perbaiki drainase lahan agar tidak mudah tergenang.
            5. Pilih waktu tanam yang tepat, seperti musim kemarau dengan irigasi yang baik. Gunakan pergiliran tanaman dengan jenis non-solanaceae.
            6. Kendalikan penyakit secara kimiawi menggunakan fungisida yang bijaksana, efektif, dan terdaftar. Aplikasikan sesuai pedoman, berdasarkan ramalan cuaca dan populasi spora di lapangan.
        """.trimIndent()
            )
        )
    }
}