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
            )
        )
    }

    fun getDiseases(): List<Disease> {

        return listOf(
            Disease(
                name = "Sehat",
                symptoms = """
            Tanaman cabai yang sehat memiliki daun yang hijau cerah, tegak, dan bebas dari bercak atau kerusakan. Tanaman tumbuh subur dengan batang yang kuat dan akar yang berkembang baik. Tidak ada tanda-tanda penyakit atau hama pada daun atau buah cabai.
            
            Tanaman juga menunjukkan pertumbuhan yang konsisten, dengan daun yang tidak layu, tidak menguning, dan tidak terhambat oleh kondisi cuaca atau lingkungan.
        """.trimIndent(),
                control = """
            1. Pastikan tanaman mendapatkan cukup air dan sinar matahari untuk pertumbuhannya.
            2. Gunakan pupuk yang seimbang dan sesuai dengan kebutuhan tanaman cabai.
            3. Prune atau potong daun yang sudah tua atau rusak untuk mendorong pertumbuhan baru.
            4. Lakukan pemeliharaan berkala seperti pengecekan terhadap potensi serangan hama atau penyakit.
            5. Jaga kebersihan lingkungan sekitar tanaman dan lakukan rotasi tanaman untuk menghindari penurunan kualitas tanah.
        """.trimIndent()
            ),
            Disease(
                name = "Thrips & Tungau",
                symptoms = """
            Hama ini menyerang tanaman dengan menghisap cairan permukaan bawah daun (terutama daun-daun muda). Serangan ditandai dengan adanya bercak keperak-perakkan. Daun yang terserang berubah warna menjadi coklat tembaga, mengeriting atau keriput dan akhirnya mati. Pada serangan berat menyebabkan daun, tunas atau pucuk menggulung ke dalam dan muncul benjolan seperti tumor, pertumbuhan tanaman terhambat dan kerdil bahkan pucuk tanaman menjadi mati. Hama ini merupakan vektor penyakit virus mosaik dan virus keriting. 
            Pada musim kemarau perkembangan hama sangat cepat, sehingga populasi lebih tinggi sedangkan pada musim penghujan populasinya akan berkurang karena banyak thrips yang mati akibat tercuci oleh air hujan. Hama ini bersifat polifag dengan tanaman inang utama cabai, bawang merah, bawang daun, jenis bawang lainnya dan tomat, sedangkan tanaman inang lainnya tembakau, kopi, ubi jalar, waluh, bayam, kentang, kapas, tanaman dari famili Crusiferae, Crotalaria dan kacang-kacangan.
        """.trimIndent(),
                control = """
            1. Menggunakan tanaman perangkap seperti kenikir kuning.
            2. Menggunakan mulsa perak.
            3. Sanitasi lingkungan dan pemotongan bagian tanaman yang terserang thrips.
            4. Penggunaan perangkap warna kuning sebanyak 40 buah per ha atau 2 buah per 500 m2 yang dipasang sejak tanaman berumur 2 minggu. Perangkap dapat dibuat dari potongan bambu yang dipasang plastik map warna kuning. Plastik diolesi dengan lem agar thrips yang tertarik menempel. Apabila plastik sudah penuh dengan thrips maka plastik perlu diganti.
            5. Pemanfaatan musuh alami yang potensial untuk mengendalikan hama thrips, antara lain predator kumbang Coccinellidae, tungau, predator larva Chrysopidae, kepik Entomophthora sp. Anthocoridae dan patogen.
            6. Pestisida digunakan apabila populasi hama atau kerusakan tanaman telah mencapai ambang pengendalian (serangan mencapai lebih atau sama dengan 15% per tanaman contoh) atau cara-cara pengendalian lainnya tidak dapat menekan populasi hama.
        """.trimIndent()
            ),
            Disease(
                name = "Bercak Daun",
                symptoms = """
            Penyakit ini menimbulkan kerusakan pada daun, batang dan akar. Gejala serangan penyakit ini mulai terlihat dari munculnya bercak bulat berwarna coklat pada daun dan kering, ukuran bercak bisa mencapai sekitar 1 inci. Pusat bercak berwarna pucat sampai putih dengan warna tepi lebih tua. Bercak yang tua dapat menyebabkan lubang-lubang. Bercak daun mampu menimbulkan kerugian ekonomi yang besar pada budidaya cabai, daun yang terserang akan layu dan rontok. Penyakit bercak daun ini dapat menyerang tanaman muda di persemaian, dan cenderung lebih banyak menyerang tanaman tua. Serangan berat menyebabkan tanaman cabai kehilangan hampir semua daunnya, kondisi ini akan mempengaruhi kemampuan cabai dalam menghasilkan buah. 
            Kondisi lingkungan yang selalu hujan mendukung perkembangan dan penyebaran penyakit bercak daun. Pada musim kemarau dan pada lahan yang mempunyai drainase baik, penyakit layu kurang berkembang.
        """.trimIndent(),
                control = """
            1. Sanitasi dengan cara memusnahkan dan atau sisa-sisa tanaman yang terinfeksi/terserang.
            2. Menanam bibit yang bebas patogen pada lahan yang tidak terkontaminasi oleh patogen, baik di persemaian maupun di lapangan.
            3. Perlakuan benih sebelum tanam.
            4. Perbaikan drainase.
            5. Waktu tanam yang tepat adalah musim kemarau dengan irigasi yang baik dan pergiliran tanaman dengan tanaman non solanaceae.
            6. Pengendalian kimia dapat dilakukan dengan fungisida secara bijaksana, efektif, terdaftar dan diijinkan oleh Menteri Pertanian, berpedoman pada peramalan cuaca dan populasi spora di lapangan.
        """.trimIndent()
            ),
            Disease(
                name = "Busuk Buah Antraknosa",
                symptoms = """
            Gejala awal penyakit ini ditandai dengan munculnya bercak yang agak mengkilap, sedikit terbenam dan berair, berwarna hitam, orange dan coklat. Warna hitam merupakan struktur dari cendawan (mikro skelerotia dan aservulus), apabila kondisi lingkungan lembab tubuh buah akan berwarna orange atau merah muda. Luka yang ditimbulkan akan semakin melebar dan membentuk sebuah lingkaran konsentris dengan ukuran diameter sekitar 30 mm atau lebih. Dalam waktu yang tidak lama buah akan berubah menjadi coklat kehitaman dan membusuk, ledakan penyakit ini sangat cepat pada musim hujan. Serangan yang berat menyebabkan seluruh buah keriput dan mengering. Warna kulit buah seperti jerami padi. Penyakit ini menyerang bagian buah cabai, baik buah yang masih muda maupun yang sudah masak. Cendawan ini termasuk salah satu patogen yang terbawa oleh benih. Penyebaran penyakit ini terjadi melalui percikan air, baik air hujan maupun alat semprot. Suhu optimum bagi perkembangan cendawan ini berkisar antara 20–24° C.
        """.trimIndent(),
                control = """
            1. Pencegahan dapat dilakukan dengan membersihkan lahan dan tanaman yang terserang agar tidak menyebar.
            2. Seleksi benih atau menggunakan benih cabai yang tahan terhadap penyakit ini perlu dilakukan mengingat penyakit ini termasuk patogen tular benih.
            3. Kultur teknis dengan pergiliran tanaman, penggunaan benih sehat dan sanitasi dengan memotong dan memusnahkan buah yang sakit.
            4. Penggunaan fungisida sesuai anjuran sebagai alternatif terakhir. Hindari penggunaan alat semprot, atau lakukan sanitasi terlebih dahulu sebelum menggunakan alat semprot.
        """.trimIndent()
            ),
            Disease(
                name = "Kutu Daun",
                symptoms = """
            Serangan berat biasanya terjadi pada musim kemarau. Bagian tanaman yang diserang oleh nimfa dan imago biasanya pucuk tanaman dan daun muda. Daun yang diserang akan mengkerut, mengeriting dan melingkar, menyebabkan pertumbuhan tanaman terhambat dan tanaman menjadi kerdil. Hama ini juga mengeluarkan cairan manis seperti madu, yang biasanya disebut dengan embun madu. Embun madu menarik datangnya semut dan cendawan jelaga. Adanya cendawan pada buah dapat menurunkan kualitas buah. Aphid juga dapat berperan sebagai vektor virus (50 jenis virus) seperti, Papaya Ringspot Virus, Watermelon Mosaic Virus, Cucumber MosaicVirus (CMV). Penyebaran hama ini sangat luas, meliputi daerah beriklim tropis dan sedang kecuali Canada bagian utara dan Asia bagian utara. Kisaran inang dari hama ini cukup luas, seperti tanaman dari family Fabaceaae (Legumes, Lucerne), Solanaceae, Cucurbitaceae dan asteraceae. Kutu daun menyebabkan kerusakan yang cukup serius pada beberapa tanaman sayuran, seperti asparagus, cabai, terong dan okra. Selain tanaman sayuran, kutu daun juga menyebabkan kerusakan yang cukup parah pada jeruk, kapas dan melon.
        """.trimIndent(),
                control = """
            1. Hindari menanam cabai secara berurutan di lokasi yang sama. Lakukan rotasi tanaman dan kosongkan area penanaman selama sekitar satu bulan untuk memutus siklus hidup kutu daun.
            2. Menjaga kebersihan kebun sangat penting. Singkirkan sisa-sisa tanaman dan gulma yang dapat menjadi tempat persembunyian bagi kutu daun.
            3. Menggunakan mulsa perak dapat membantu menekan perkembangan kutu daun dengan mengurangi kelembapan yang disukai oleh hama ini.
            4. Tanam tanaman pendamping seperti catnip, yang dapat menolak kutu daun. Sementara itu, tanaman seperti mustard dan nasturtium dapat berfungsi sebagai perangkap untuk menarik kutu jauh dari tanaman cabai.
            5. Semprotkan minyak hortikultura yang tidak aktif untuk membunuh telur kutu daun yang mungkin bertahan di musim dingin.
        """.trimIndent()
            ),
            Disease(
                name = "Virus Kuning",
                symptoms = """
            Helai daun mengalami vein clearing dimulai dari daun pucuk berkembang menjadi warna kuning jelas, tulang daun menebal dan daun menggulung ke atas. Infeksi lanjut dari gemini virus menyebabkan daun mengecil dan berwarna kuning terang, tanaman kerdil dan tidak berbuah. Keberadaan penyakit ini sangat merugikan karena mampu mempengaruhi produksi buah. Selain cabai virus ini juga mampu menyerang tanaman tomat, buncis, gula bit, babadotan, atau tanaman pertanian yang lain. Penyakit ini disebabkan oleh virus gemini dengan diameter partikel isometri berukuran 18–22 nm. Virus gemini mempunyai genome sirkular DNA tunggal. Virus dapat ditularkan melalui penyambungan dan melalui vektor Bemisia tabaci.
        """.trimIndent(),
                control = """
            1. Kendalikan serangga vektor virus kuning yaitu kutu kebul (Bemisia tabaci) dengan menggunakan musuh alami predator seperti Menochilus sexmaculatus atau jamur patogen serangga seperti Beauveria bassiana atau Verticillium lecani.
            2. Penanaman varietas tahan seperti hotchilli.
            3. Melakukan sanitasi lingkungan terutama tanaman inang seperti ciplukan, terong, gulma bunga kancing.
            4. Pemupukan tambahan untuk meningkatkan daya tahan tanaman sehingga tanaman tetap berproduksi walaupun terserang virus kuning.
            5. Kultur teknik yang meliputi: perendaman benih, penggunaan mulsa plastik (untuk menekan gulma inang, populasi vektor, menunda perkembangan virus).
            6. Penanaman tanaman pembatas seperti jagung dan tagetes.
        """.trimIndent()
            )
        )
    }
}