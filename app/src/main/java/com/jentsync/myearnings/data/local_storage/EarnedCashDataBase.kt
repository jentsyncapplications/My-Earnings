package com.jentsync.myearnings.data.local_storage


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jentsync.myearnings.model.EarnedCashEntity
import com.jentsync.myearnings.model.AppConfigEntity


@Database(entities = [EarnedCashEntity::class, AppConfigEntity::class], version = 5, exportSchema = false)
abstract class EarnedCashDataBase : RoomDatabase() {

    abstract fun earnedCashDao(): EarnedCashDao



    companion object {
        @Volatile
        private var INSTANCE: EarnedCashDataBase? = null

        fun getDatabase(context: Context): EarnedCashDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                                context.applicationContext,
                                EarnedCashDataBase::class.java,
                                "earnings_data"
                            ).fallbackToDestructiveMigration(false).build()
                INSTANCE = instance
                instance
            }
        }
    }
}