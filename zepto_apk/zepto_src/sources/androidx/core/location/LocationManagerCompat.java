package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class LocationManagerCompat {

    public static class Api19Impl {
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api28Impl {
    }

    @RequiresApi
    public static class Api30Impl {
    }

    @RequiresApi
    public static class Api31Impl {
    }

    public static final class CancellableLocationListener implements LocationListener {
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            synchronized (this) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public static class GnssListenersHolder {
        static {
            new SimpleArrayMap();
            new SimpleArrayMap();
        }
    }

    @RequiresApi
    public static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {
        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public final void onStatusChanged(int i2) {
        }
    }

    @RequiresApi
    public static class GnssStatusTransport extends GnssStatus.Callback {
        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i2) {
            throw null;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            new GnssStatusWrapper(gnssStatus);
            throw null;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            throw null;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            throw null;
        }
    }

    public static class GpsStatusTransport implements GpsStatus.Listener {
        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i2) {
        }
    }

    public static final class InlineHandlerExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            Looper.myLooper();
            throw null;
        }
    }

    public static class LocationListenerKey {
        public final boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            ((LocationListenerKey) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            return Objects.hash(null, null);
        }
    }

    public static class LocationListenerTransport implements LocationListener {
        @Override // android.location.LocationListener
        public final void onFlushComplete(int i2) {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i2, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(List list) {
        }
    }

    @RequiresApi
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i2) {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
        }
    }

    static {
        new WeakHashMap();
    }
}
