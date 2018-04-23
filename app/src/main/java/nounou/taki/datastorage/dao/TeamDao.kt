package nounou.taki.datastorage.dao

import android.arch.persistence.room.*
import nounou.taki.datastorage.entity.Player
import nounou.taki.datastorage.entity.Team

@Dao
interface TeamDao {
    @Query("select * from teams")
    fun getTeams(): List<Team>

    @Query("select * from teams where id_team = :id_team")
    fun getTeam(id_team: String): Team

    @Insert
    fun addTeam(vararg team: Team)

    @Update
    fun updateTeam(vararg team: Team)

    @Delete
    fun deleteTeam(vararg team: Team)

    @Query("select * from players natural join teams where team_name=:team_name")
    fun getPlayersTeam(team_name: String): List<Player>

}
