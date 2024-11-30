package com.holtihealth.app.database

class ArticleRepository(private val articleDao: ArticleDao) {

    // Fungsi untuk menambahkan data penyakit cabai default
    suspend fun addDefaultArticles() {
        // Cek apakah artikel sudah ada
        val existingArticles = articleDao.getAllArticles().value ?: listOf()

        if (existingArticles.isEmpty()) {
            // Jika belum ada data, masukkan data penyakit cabai default
            val diseaseArticles = listOf(
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
            articleDao.insertAll(diseaseArticles) // Menyimpan artikel ke dalam database
        }
    }

    // Fungsi untuk mendapatkan semua artikel
    fun getAllArticles() = articleDao.getAllArticles()

    suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

    suspend fun update(article: Article) {
        articleDao.update(article)
    }

    suspend fun delete(article: Article) {
        articleDao.delete(article)
    }
}
