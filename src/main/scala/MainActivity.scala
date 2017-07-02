package lt.dvim.smarthome.androidthings.ui.main

import android.util.Log
import android.os.Bundle
import android.arch.lifecycle._
import com.google.android.things.pio._
import com.google.firebase.database._

class MainActivity extends LifecycleActivity {

  var relay: Gpio = _

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)

    relay = new PeripheralManagerService().openGpio("BCM18")
    relay.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
    relay.setActiveType(Gpio.ACTIVE_HIGH)

    Log.d("MainActivity", s"testo")
    val firebase = FirebaseDatabase.getInstance.getReference
    firebase.child("lights").addValueEventListener(new LampStateListener(relay))
  }

  override def onDestroy() = {
    super.onDestroy()

    relay.close
  }
}

class LampStateListener(relay: Gpio) extends ValueEventListener {

  def onDataChange(snapshot: DataSnapshot) = {
    val lampState = snapshot.child("on").getValue(classOf[Boolean])
    Log.d("LampStateListener", s"onDataChange (value=$lampState)")
    relay.setValue(lampState)
  }

  def onCancelled(error: DatabaseError) = {
    Log.w("LampStateListener", "onCancelled", error.toException)
  }

}


