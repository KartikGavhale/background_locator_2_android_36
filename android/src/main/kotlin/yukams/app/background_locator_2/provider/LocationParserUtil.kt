package yukams.app.background_locator_2.provider

import android.location.Location
import android.os.Build
import com.google.android.gms.location.LocationResult
import yukams.app.background_locator_2.Keys

class LocationParserUtil {
    companion object {
        fun getLocationMapFromLocation(location: Location): HashMap<Any, Any> {
            val map = HashMap<Any, Any>()

            val speedAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                location.speedAccuracyMetersPerSecond
            } else {
                0f
            }

            val isMocked = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                location.isFromMockProvider
            } else {
                false
            }

            map[Keys.ARG_IS_MOCKED] = isMocked
            map[Keys.ARG_LATITUDE] = location.latitude
            map[Keys.ARG_LONGITUDE] = location.longitude
            map[Keys.ARG_ACCURACY] = location.accuracy
            map[Keys.ARG_ALTITUDE] = location.altitude
            map[Keys.ARG_SPEED] = location.speed
            map[Keys.ARG_SPEED_ACCURACY] = speedAccuracy
            map[Keys.ARG_HEADING] = location.bearing
            map[Keys.ARG_TIME] = location.time.toDouble()
            map[Keys.ARG_PROVIDER] = location.provider ?: ""

            return map
        }

        fun getLocationMapFromLocation(locationResult: LocationResult?): HashMap<Any, Any>? {
            val location = locationResult?.lastLocation ?: return null

            val map = HashMap<Any, Any>()

            val speedAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                location.speedAccuracyMetersPerSecond
            } else {
                0f
            }

            val isMocked = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                location.isFromMockProvider
            } else {
                false
            }

            map[Keys.ARG_IS_MOCKED] = isMocked
            map[Keys.ARG_LATITUDE] = location.latitude
            map[Keys.ARG_LONGITUDE] = location.longitude
            map[Keys.ARG_ACCURACY] = location.accuracy
            map[Keys.ARG_ALTITUDE] = location.altitude
            map[Keys.ARG_SPEED] = location.speed
            map[Keys.ARG_SPEED_ACCURACY] = speedAccuracy
            map[Keys.ARG_HEADING] = location.bearing
            map[Keys.ARG_TIME] = location.time.toDouble()

            return map
        }
    }
}
