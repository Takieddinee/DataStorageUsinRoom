package nounou.taki.datastorage.dao

import android.arch.persistence.room.*
import nounou.taki.datastorage.entity.Player
import nounou.taki.datastorage.entity.Team

@Dao
interface PlayerDao {
    @Query("select * from players")
    fun getPlayers(): List<Player>

    @Query("select * from players where id_player = :id_player")
    fun getPlayer(id_player: String): Player

    @Insert
    fun addPlayer(vararg player: Player)

    @Update
    fun updatePlayer(vararg player: Player)

    @Delete
    fun deletePlayer(vararg player: Player)

}