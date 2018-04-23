package nounou.taki.datastorage

import android.app.Application
import nounou.taki.datastorage.singleton.MyRoomService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyRoomService.context = applicationContext
    }
}