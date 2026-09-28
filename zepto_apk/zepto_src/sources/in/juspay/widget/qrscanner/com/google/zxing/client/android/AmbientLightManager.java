package in.juspay.widget.qrscanner.com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.c;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d;

/* loaded from: classes4.dex */
public final class AmbientLightManager implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private c f48834a;

    /* renamed from: b, reason: collision with root package name */
    private d f48835b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f48836c;

    /* renamed from: d, reason: collision with root package name */
    private Context f48837d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f48838e = new Handler();

    public AmbientLightManager(Context context, c cVar, d dVar) {
        this.f48837d = context;
        this.f48834a = cVar;
        this.f48835b = dVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        if (this.f48834a != null) {
            if (f2 <= 45.0f) {
                a(true);
            } else if (f2 >= 450.0f) {
                a(false);
            }
        }
    }

    public void start() {
        if (this.f48835b.d()) {
            SensorManager sensorManager = (SensorManager) this.f48837d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f48836c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void stop() {
        if (this.f48836c != null) {
            ((SensorManager) this.f48837d.getSystemService("sensor")).unregisterListener(this);
            this.f48836c = null;
        }
    }

    private void a(final boolean z) {
        this.f48838e.post(new Runnable() { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.AmbientLightManager.1
            @Override // java.lang.Runnable
            public void run() {
                AmbientLightManager.this.f48834a.b(z);
            }
        });
    }
}
