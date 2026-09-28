package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzcfh extends zzfxo {

    /* renamed from: a, reason: collision with root package name */
    public final SensorManager f26064a;

    /* renamed from: c, reason: collision with root package name */
    public final Display f26066c;

    /* renamed from: f, reason: collision with root package name */
    public float[] f26069f;

    /* renamed from: g, reason: collision with root package name */
    public zzfxl f26070g;

    /* renamed from: h, reason: collision with root package name */
    public zzcfi f26071h;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f26067d = new float[9];

    /* renamed from: e, reason: collision with root package name */
    public final float[] f26068e = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final Object f26065b = new Object();

    public zzcfh(Context context) {
        this.f26064a = (SensorManager) context.getSystemService("sensor");
        this.f26066c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final void a(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.f26065b) {
            try {
                if (this.f26069f == null) {
                    this.f26069f = new float[9];
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        float[] fArr2 = this.f26067d;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f26066c.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(fArr2, 2, WKSRecord.Service.PWDGEN, this.f26068e);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(fArr2, WKSRecord.Service.PWDGEN, WKSRecord.Service.CISCO_FNA, this.f26068e);
        } else if (rotation != 3) {
            System.arraycopy(fArr2, 0, this.f26068e, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(fArr2, WKSRecord.Service.CISCO_FNA, 1, this.f26068e);
        }
        float[] fArr3 = this.f26068e;
        float f2 = fArr3[1];
        fArr3[1] = fArr3[3];
        fArr3[3] = f2;
        float f3 = fArr3[2];
        fArr3[2] = fArr3[6];
        fArr3[6] = f3;
        float f4 = fArr3[5];
        fArr3[5] = fArr3[7];
        fArr3[7] = f4;
        synchronized (this.f26065b) {
            System.arraycopy(fArr3, 0, this.f26069f, 0, 9);
        }
        zzcfi zzcfiVar = this.f26071h;
        if (zzcfiVar != null) {
            Object obj = zzcfiVar.u;
            synchronized (obj) {
                obj.notifyAll();
            }
        }
    }

    public final void b() {
        if (this.f26070g == null) {
            return;
        }
        this.f26064a.unregisterListener(this);
        this.f26070g.post(new zzcff());
        this.f26070g = null;
    }

    public final boolean c(float[] fArr) {
        synchronized (this.f26065b) {
            try {
                float[] fArr2 = this.f26069f;
                if (fArr2 == null) {
                    return false;
                }
                System.arraycopy(fArr2, 0, fArr, 0, 9);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
