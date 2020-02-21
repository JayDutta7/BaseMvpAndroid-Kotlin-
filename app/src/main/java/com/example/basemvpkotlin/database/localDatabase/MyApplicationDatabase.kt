package com.example.basemvpkotlin.database.localDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basemvpkotlin.database.localDatabase.dao.AppSettingsDao
import com.example.basemvpkotlin.database.localDatabase.model.AppSettingsTbl

@Database(
    entities =
    [AppSettingsTbl::class], version = 1, exportSchema = false
)
abstract class MyAppDataBase : RoomDatabase() {



    //For Color Code
    abstract fun appSettings(): AppSettingsDao




    companion object {

        private var INSTANCE: MyAppDataBase? = null

        fun getDatabase(context: Context): MyAppDataBase {

            if (INSTANCE == null) {

                /*
                 inMemoryDatabaseBuilder():
                 /////////////////////////////////////
                 The database will be created in system memory,
                  If you kill the app (Killing your process),
                   database will be removed and data will not be persisted.
                    This can be used while Testing.

                databaseBuilder() :
                 /////////////////////////////////////
                 The database will be created in /data/data/com.your.app and will be persisted.
                  This you will be using it in production.

                  */

                synchronized(MyAppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyAppDataBase::class.java,
                        "tracking_solution.db"
                    )     //.allowMainThreadQueries() //when publish no main thread call allowed
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

    }

}