package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class OrientationListener implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f8373a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f8374b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f8375c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f8376d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    public final Display f8377e;

    /* renamed from: f, reason: collision with root package name */
    public final Listener[] f8378f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8379g;

    public interface Listener {
        void a(float[] fArr, float f2);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.f8377e = display;
        this.f8378f = listenerArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i2;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f8373a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f8377e.getRotation();
        float[] fArr3 = this.f8374b;
        if (rotation != 0) {
            int i3 = WKSRecord.Service.PWDGEN;
            if (rotation != 1) {
                i2 = WKSRecord.Service.CISCO_FNA;
                if (rotation != 2) {
                    if (rotation != 3) {
                        throw new IllegalStateException();
                    }
                    i3 = 130;
                    i2 = 1;
                }
            } else {
                i2 = 129;
                i3 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i3, i2, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, WKSRecord.Service.CISCO_TNA, fArr3);
        float[] fArr4 = this.f8376d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f2 = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z = this.f8379g;
        float[] fArr5 = this.f8375c;
        if (!z) {
            FrameRotationQueue.a(fArr5, fArr2);
            this.f8379g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        for (Listener listener : this.f8378f) {
            listener.a(fArr2, f2);
        }
    }
}
