package nounou.taki.datastorage.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import nounou.taki.datastorage.dao.PlayerDao
import nounou.taki.datastorage.dao.TeamDao
import nounou.taki.datastorage.entity.Player
import nounou.taki.datastorage.entity.Team

@Database(entities = arrayOf(Team::class, Player::class), version = 1)

abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun getPlayerDao(): PlayerDao
    abstract fun getTeamDao(): TeamDao
}