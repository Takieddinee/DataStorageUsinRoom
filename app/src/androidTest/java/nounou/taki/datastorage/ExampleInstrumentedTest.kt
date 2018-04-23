package nounou.taki.datastorage

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import nounou.taki.datastorage.dao.PlayerDao
import nounou.taki.datastorage.dao.TeamDao
import nounou.taki.datastorage.database.MyRoomDatabase
import nounou.taki.datastorage.entity.Player
import nounou.taki.datastorage.entity.Team

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.After
import java.io.IOException


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private var mDb: MyRoomDatabase? = null
    private var teamDao: TeamDao? = null
    private var playerDao: PlayerDao? = null


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        val team = Team(id_team = 1, team_name = "Real Madrid", continent = "Europe")
        val player1 = Player(1, first_name = "Iheb Eddine", last_name = "Imad", age = 22, height = 1.80, id_team = 1)
        val player2 = Player(2, first_name = "Anderrahmane", last_name = "Bentaiba", age = 22, height = 1.80, id_team = 1)

        teamDao!!.addTeam(team)
        playerDao!!.addPlayer(player1, player2)

        var players = teamDao!!.getPlayersTeam("Real Madrid")





        assertArrayEquals(players.toTypedArray(), arrayOf(player1, player2))
    }

    @Before
    fun initDB() {
        val appContext = InstrumentationRegistry.getTargetContext()
        mDb =
                Room.inMemoryDatabaseBuilder(InstrumentationRegistry
                        .getContext(), MyRoomDatabase::class.java).build()
        teamDao = mDb!!.getTeamDao()
        playerDao = mDb!!.getPlayerDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDb!!.close()
    }

}
