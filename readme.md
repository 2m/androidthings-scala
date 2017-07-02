This is a simplified Android Things smart home Android app from the [original project](https://github.com/Nilhcem/smarthome-androidthings) implemented in Scala and having only the light control functionality.

## Build

> Below are only the additional steps required after [Nilhcem/smarthome-androidthings](https://github.com/Nilhcem/smarthome-androidthings/blob/master/README.md#build)

* Download the `google-services.json` file and save it to the root project directory
* Build and install the application to the Android Things device:

      sbt android:run
