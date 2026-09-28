package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.view.Surface;

/* loaded from: classes4.dex */
public final class zzact {

    /* renamed from: b, reason: collision with root package name */
    public final Context f22754b;

    /* renamed from: c, reason: collision with root package name */
    public zzacp f22755c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22756d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f22757e;

    /* renamed from: g, reason: collision with root package name */
    public float f22759g;

    /* renamed from: h, reason: collision with root package name */
    public float f22760h;

    /* renamed from: k, reason: collision with root package name */
    public long f22763k;

    /* renamed from: l, reason: collision with root package name */
    public long f22764l;

    /* renamed from: m, reason: collision with root package name */
    public long f22765m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;

    /* renamed from: a, reason: collision with root package name */
    public final zzabp f22753a = new zzabp();

    /* renamed from: f, reason: collision with root package name */
    public float f22758f = -1.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f22761i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f22762j = 0;

    public zzact(Context context) {
        this.f22754b = context;
    }

    public final void a() {
        this.f22765m = 0L;
        this.q = -1L;
        this.n = -1L;
        this.f22763k = 0L;
        this.f22764l = 0L;
    }

    public final void b() {
        float f2;
        if (Build.VERSION.SDK_INT < 30 || this.f22757e == null) {
            return;
        }
        zzabp zzabpVar = this.f22753a;
        if (!zzabpVar.f22668a.b()) {
            f2 = this.f22758f;
        } else if (zzabpVar.f22668a.b()) {
            f2 = (float) (1.0E9d / (zzabpVar.f22668a.f22664e != 0 ? r2.f22665f / r4 : 0L));
        } else {
            f2 = -1.0f;
        }
        float f3 = this.f22759g;
        if (f2 != f3) {
            if (f2 != -1.0f && f3 != -1.0f) {
                float f4 = 1.0f;
                if (zzabpVar.f22668a.b()) {
                    if ((zzabpVar.f22668a.b() ? zzabpVar.f22668a.f22665f : -9223372036854775807L) >= 5000000000L) {
                        f4 = 0.1f;
                    }
                }
                if (Math.abs(f2 - this.f22759g) < f4) {
                    return;
                }
            } else if (f2 == -1.0f && zzabpVar.f22672e < 30) {
                return;
            }
            this.f22759g = f2;
            c(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r4) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L48
            android.view.Surface r0 = r3.f22757e
            if (r0 == 0) goto L48
            int r1 = r3.f22762j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L48
            boolean r0 = r0.isValid()
            if (r0 != 0) goto L17
            goto L48
        L17:
            boolean r0 = r3.f22756d
            r1 = 0
            if (r0 == 0) goto L28
            float r0 = r3.f22759g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L28
            float r2 = r3.f22761i
            float r0 = r0 * r2
            goto L29
        L28:
            r0 = r1
        L29:
            if (r4 != 0) goto L31
            float r4 = r3.f22760h
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 == 0) goto L48
        L31:
            r3.f22760h = r0
            android.view.Surface r4 = r3.f22757e
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L3b
            r1 = 0
            goto L3c
        L3b:
            r1 = 1
        L3c:
            androidx.media3.exoplayer.hls.d.u(r4, r0, r1)     // Catch: java.lang.IllegalStateException -> L40
            return
        L40:
            r4 = move-exception
            java.lang.String r0 = "VideoFrameReleaseHelper"
            java.lang.String r1 = "Failed to call Surface.setFrameRate"
            com.google.android.gms.internal.ads.zzee.f(r0, r1, r4)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzact.c(boolean):void");
    }

    public final void d() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f22757e) == null || this.f22762j == Integer.MIN_VALUE || this.f22760h == 0.0f || !surface.isValid()) {
            return;
        }
        this.f22760h = 0.0f;
        try {
            this.f22757e.setFrameRate(0.0f, 0);
        } catch (IllegalStateException e2) {
            zzee.f("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
        }
    }
}
