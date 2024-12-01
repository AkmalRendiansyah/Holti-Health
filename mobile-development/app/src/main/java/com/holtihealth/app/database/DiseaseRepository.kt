package com.holtihealth.app.database

import androidx.lifecycle.LiveData


class DiseaseRepository(private val diseaseDao: DiseaseDao) {

    fun getDiseaseByName(name: String): LiveData<Disease?> {
        return diseaseDao.getDiseaseByName(name)
    }
}
