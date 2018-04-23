package nounou.taki.datastorage.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players",
        foreignKeys = arrayOf(ForeignKey(
                entity = Team::class,
                parentColumns = arrayOf("id_team"),
                childColumns = arrayOf("id_team"),
                onDelete = ForeignKey.CASCADE)))
data class Player(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_player")
        var id_player: Int,
        @ColumnInfo(name = "first_name")
        var first_name: String,
        @ColumnInfo(name = "last_name")
        var last_name: String,
        @ColumnInfo(name = "age")
        var age: Int,
        @ColumnInfo(name = "height")
        var height: Double,
        @ColumnInfo(name = "id_team")
        var id_team: Int
)

