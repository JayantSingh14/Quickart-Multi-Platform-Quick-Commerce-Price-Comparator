package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;

/* loaded from: classes4.dex */
public final class zzaby extends Surface {

    /* renamed from: d, reason: collision with root package name */
    public static int f22691d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f22692e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22693a;

    /* renamed from: b, reason: collision with root package name */
    public final zzabx f22694b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22695c;

    public /* synthetic */ zzaby(zzabx zzabxVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f22694b = zzabxVar;
        this.f22693a = z;
    }

    public static synchronized boolean a(Context context) {
        if (!f22692e) {
            try {
            } catch (zzdu e2) {
                zzee.e("PlaceholderSurface", "Failed to determine secure mode due to GL error: ".concat(String.valueOf(e2.getMessage())));
            }
            int i2 = zzdv.a(context) ? zzdv.d("EGL_KHR_surfaceless_context") ? 1 : 2 : 0;
            f22691d = i2;
            f22692e = true;
        }
        return f22691d != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        zzabx zzabxVar = this.f22694b;
        synchronized (zzabxVar) {
            try {
                if (!this.f22695c) {
                    Handler handler = zzabxVar.f22687b;
                    handler.getClass();
                    handler.sendEmptyMessage(2);
                    this.f22695c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
