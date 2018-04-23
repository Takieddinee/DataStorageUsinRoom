package nounou.taki.datastorage.singleton

import android.arch.persistence.room.Room
import android.content.Context
import nounou.taki.datastorage.database.MyRoomDatabase

object MyRoomService {
    lateinit var context: Context

    val appDataBase: MyRoomDatabase by lazy {
        Room.databaseBuilder(context, MyRoomDatabase::class.java, "name").allowMainThreadQueries().build()
    }
}