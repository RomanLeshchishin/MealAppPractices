package com.example.mealapppractices.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MealDbEntity (
  @PrimaryKey(autoGenerate = true) val id: Long? = null,
  @ColumnInfo(name = "mealId") val mealId: String?,
  @ColumnInfo(name = "mealName") val name: String?,
  @ColumnInfo(name = "mealCategory") val category: String?,
  @ColumnInfo(name = "mealArea") val area: String?,
  @ColumnInfo(name = "imgUrl") val imgUrl: String?
)