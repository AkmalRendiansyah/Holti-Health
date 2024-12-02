package com.holtihealth.app.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity(
    tableName = "history",
    foreignKeys = [ForeignKey(
        entity = Disease::class,
        parentColumns = ["id"],
        childColumns = ["diseaseId"],
        onDelete = ForeignKey.CASCADE // Menghapus history jika disease terkait dihapus
    )]
)
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val scanTime: String,          // Waktu scan (timestamp)
    val photoUri: String,        // URI gambar hasil scan
    val diseaseId: Int           // Foreign key mengacu ke Disease
)


data class HistoryWithDisease(
    @Embedded val history: History,
    @Relation(
        parentColumn = "diseaseId",
        entityColumn = "id"
    )
    val disease: Disease
)