package com.holtihealth.app.helper

import com.holtihealth.app.database.Article
import com.holtihealth.app.database.Disease

object InitialDataSource {
    fun getArticles(): List<Article> {
        return listOf(
            Article(
                title = "Penyakit Antraknos pada Cabai",

                description = "Antraknos pada cabai adalah penyakit yang disebabkan oleh jamur Colletotrichum spp., dengan gejala khas berupa bercak melingkar yang cekung, berwarna cokelat kehitaman pada buah. Penyakit ini dapat menyebabkan kerugian ekonomi yang signifikan karena menurunkan kualitas dan kuantitas panen.",
                image = "https://www.infarm.co.id/uploads/article/Xgg0sUuJn8IqiQHSGgWonRojj31w7moyiXdSVLOa.jpg",
                solusion = """
            1. Gunakan rotasi tanaman untuk memutus siklus hidup jamur.
            2. Hindari penggunaan benih dari tanaman yang terinfeksi.
            3. Usahakan drainase yang baik untuk mencegah genangan air.
            4. Kurangi kelembapan dengan menanam pada jarak tanam yang cukup.
            5. Bersihkan sisa tanaman yang terinfeksi dari lahan.
            6. Desinfeksi alat pertanian sebelum dan setelah digunakan.
            7.Gunakan varietas cabai yang tahan terhadap Antraknos.
            8.Semprotkan fungisida berbahan aktif seperti:Mancozeb,Chlorothalonil,Propineb
            9.Lakukan rotasi fungisida untuk mencegah resistensi.
            10.Gunakan agen hayati seperti Trichoderma harzianum atau Bacillus subtilis untuk menekan pertumbuhan jamur patogen.
            11.Hindari memanen cabai dalam kondisi basah.
            12.Simpan cabai di tempat yang kering dan memiliki ventilasi baik.
        """.trimIndent(),
                cause = """
            1. Jamur Patogen.
            2. Kondisi Lingkungan:Suhu tinggi (25–30°C) dan kelembapan tinggi (>80%),Curah hujan tinggi yang mempercepat penyebaran spora jamur.
            3. Penularan:Spora jamur dapat tersebar melalui angin, air, atau alat pertanian yang terkontaminasi,Jamur juga dapat bertahan pada sisa-sisa tanaman yang terinfeksi.
        """.trimIndent(),
                symptoms = """
            1. Muncul bercak bulat atau oval berwarna cokelat tua hingga hitam pada buah.
            2. Bercak membesar dan membentuk cekungan dengan cincin konsentris.
            3. Buah menjadi busuk, kering, dan akhirnya rontok.
        """.trimIndent()


            ),
            Article(
                title = "Penyakit Layu Fusarium pada Cabai",
                description = "Penyakit Layu Fusarium pada cabai disebabkan oleh jamur Fusarium oxysporum yang menyerang sistem perakaran tanaman. Penyakit ini sering menimbulkan kerugian besar karena menyebabkan tanaman layu dan mati sebelum berbuah. ",
                image = "https://trubus.id/wp-content/uploads/2020/02/Trubus-Edisi-603-Februari-2020-Highrest-78-2.jpg",
                solusion = """
            1. Gunakan tanah yang memiliki drainase baik untuk mencegah genangan.
            2. Lakukan rotasi tanaman dengan non-inang seperti padi atau jagung.
            3. Gunakan benih yang bebas penyakit atau telah direndam fungisida seperti carbendazim sebelum penanaman.
            4. Pilih varietas cabai yang tahan terhadap layu Fusarium.
            5. Hancurkan dan buang tanaman yang terinfeksi jauh dari lahan.
            6. Bersihkan alat pertanian dengan desinfektan.
            7. Gunakan mikroorganisme antagonis seperti:Trichoderma spp. untuk menekan pertumbuhan jamur Fusarium.,Pseudomonas fluorescens sebagai pelindung akar tanaman.
            8.Terapkan pupuk organik atau kompos untuk memperbaiki struktur tanah dan meningkatkan mikroba baik.
            9.Lakukan penyiraman dengan larutan fungisida pada daerah perakaran untuk mengurangi infeksi.
            10.Hindari penyiraman berlebihan yang menyebabkan genangan.
            11.Gunakan irigasi tetes untuk menjaga kelembapan tanah tetap stabil.
            12.Gunakan sensor tanah untuk memantau kelembapan dan suhu agar tetap ideal.
        """.trimIndent(),
                cause = """
            1. Jamur Patogen:Fusarium oxysporum f.sp. capsici menyerang sistem akar dan jaringan pembuluh angkut,jamur ini menghasilkan racun yang menyebabkan jaringan tanaman rusak.
            2. Kondisi Lingkungan:Tanah yang lembap dan tergenang,Suhu tanah optimal 20–30°C, yang ideal untuk perkembangan Fusarium.
            3. Penularan:Spora jamur dapat bertahan lama di tanah, hingga beberapa tahun.Penyebaran melalui air, angin, alat pertanian, atau tanaman yang terinfeksi.
        """.trimIndent(),
                symptoms = """
            1. Daun mulai menguning, terutama di bagian bawah, kemudian menyebar ke atas.
            2. Tanaman layu, terutama pada siang hari, dan kadang pulih di malam hari sebelum akhirnya mati.
            3. Batang dan akar terlihat cokelat atau hitam jika dibelah.
            4. Tanaman yang terinfeksi tidak menghasilkan buah atau menghasilkan buah kecil dengan kualitas buruk.
        """.trimIndent()
            ),
            Article(
                title = "Penyakit Bercak Daun Cabai",
                description = "Penyakit Bercak Daun pada cabai adalah salah satu penyakit umum yang menyerang tanaman cabai, menyebabkan penurunan kualitas dan hasil panen. Penyakit ini dapat disebabkan oleh patogen seperti bakteri, jamur, atau kondisi lingkungan yang tidak mendukung pertumbuhan tanaman secara optimal.",
                image = "https://asset.kompas.com/crops/PecRmY2jQCZ0CWNcMRmdvinTr6k=/0x77:375x452/340x340/data/photo/2022/11/28/63847b2635b1f.jpg",
                solusion = """
            1. Pastikan drainase lahan baik untuk mencegah genangan air.
            2. Jaga jarak tanam untuk meningkatkan sirkulasi udara di sekitar tanaman.
            3. Buang dan bakar daun atau tanaman yang terinfeksi untuk mencegah penyebaran patogen.
            4. Hindari penyiraman dari atas (overhead irrigation) yang menyebabkan daun basah.
            5. Gunakan benih bebas patogen atau benih yang telah direndam fungisida.
            6. Gunakan agen hayati seperti:Trichoderma harzianum untuk menekan patogen jamur.,Bacillus subtilis atau Pseudomonas fluorescens untuk mengendalikan patogen bakteri.
            7. Lakukan penyemprotan pada pagi hari saat cuaca cerah untuk hasil maksimal.
            8. Berikan pemupukan berimbang untuk meningkatkan daya tahan tanaman, seperti:Nitrogen (N) untuk pertumbuhan daun,Kalium (K) untuk meningkatkan ketahanan terhadap penyakit.
            9. Hindari penggunaan pupuk nitrogen berlebihan karena dapat meningkatkan kerentanan terhadap penyakit.
            10. pantau kelembapan dan suhu lingkungan menggunakan sensor untuk mengatur penyiraman.
        """.trimIndent(),
                cause = """
            1. Jamur Patogen:Cercospora capsici (penyebab bercak daun cercospora)mAlternaria solani (penyebab bercak daun alternaria).
            2. Bakteri Patogen:Xanthomonas campestris pv. vesicatoria (penyebab bercak bakteri).
            3. Kondisi Lingkungan:Suhu tinggi dan kelembapan yang tinggi (>80%) sangat mendukung perkembangan penyakit,Curah hujan tinggi atau penyiraman berlebihan yang menyebabkan daun basah dalam waktu lama.
            4. Faktor Penularan:Spora jamur atau bakteri menyebar melalui angin, air hujan, alat pertanian, atau kontak langsung antara daun sehat dan terinfeksi.
        """.trimIndent(),
                symptoms = """
            1. Muncul bercak kecil berwarna cokelat, abu-abu, atau hitam pada daun.
            2. Bercak sering dikelilingi oleh halo kekuningan.
            3. Bercak dapat menyatu, menyebabkan daun menguning dan rontok.
            4. Penurunan kemampuan fotosintesis akibat kerusakan daun.
            5. Tanaman terlihat lemah, pertumbuhan terhambat, dan hasil panen menurun.
        """.trimIndent()
=======
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