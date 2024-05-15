package com.mac.jamil.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mac.jamil.convertors.Convertors
import com.mac.jamil.dao.CategoryDAO
import com.mac.jamil.entities.Categories

@Database(entities = [Categories::class], version = 2)
@TypeConverters(Convertors::class)
abstract class InventoryDatabase: RoomDatabase() {

    abstract fun categoriesDao() : CategoryDAO

    companion object {
        val migration_database_version_1_2 = object : Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE categories ADD COLUMN status INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        /*Ye annotation iss liye use krty hain ta k jesy he hmary instance ko koi value assign
        ho to sary threads ko pata chal jata k iski value update ho gyi hai
        Signleton Pattern for saving threads
        Locking implementation
        */
        private var INSTANCE : InventoryDatabase? = null

        fun getDatabase(context: Context) : InventoryDatabase {
            if(INSTANCE == null){
               synchronized(this){
                   INSTANCE = Room.databaseBuilder (
                       context.applicationContext,
                       InventoryDatabase::class.java,
                       "inventory_db")
                       .addMigrations(migration_database_version_1_2)
                       .build()
               }
            }
            return INSTANCE!!
        }
    }
}