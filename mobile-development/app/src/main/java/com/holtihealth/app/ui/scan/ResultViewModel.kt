package com.holtihealth.app.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.holtihealth.app.database.Disease
import com.holtihealth.app.database.DiseaseRepository

class ResultViewModel(private val diseaseRepository: DiseaseRepository) : ViewModel() {

    fun getDiseaseDetails(diseaseName: String): LiveData<Disease?> {
        return diseaseRepository.getDiseaseByName(diseaseName)
    }
}


