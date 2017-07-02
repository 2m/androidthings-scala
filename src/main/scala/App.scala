package lt.dvim.smarthome.androidthings

import android.app.Application
import com.google.firebase.FirebaseApp

class App extends Application {

  override def onCreate() = {
    super.onCreate()
    FirebaseApp.initializeApp(this)
  }

}
