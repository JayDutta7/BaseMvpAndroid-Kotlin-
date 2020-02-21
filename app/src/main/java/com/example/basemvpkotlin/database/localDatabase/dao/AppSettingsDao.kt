package com.example.basemvpkotlin.database.localDatabase.dao

import androidx.room.*
import com.example.basemvpkotlin.database.localDatabase.model.AppSettingsTbl
import io.reactivex.Single

@Dao
interface AppSettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAppSettings(appSettings: AppSettingsTbl)

    @Query("SELECT * FROM AppSettings")
    fun getAppSettings(): Single<AppSettingsTbl>

    @Update
    fun updateLastAppSettingsDetails(appSettings: AppSettingsTbl)


}
