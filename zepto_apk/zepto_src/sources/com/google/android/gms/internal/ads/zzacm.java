package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Surface;

/* loaded from: classes4.dex */
public final class zzacm {

    /* renamed from: a, reason: collision with root package name */
    public final zzabw f22730a;

    /* renamed from: b, reason: collision with root package name */
    public final zzact f22731b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22732c;

    /* renamed from: f, reason: collision with root package name */
    public long f22735f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22738i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22741l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22742m;

    /* renamed from: d, reason: collision with root package name */
    public int f22733d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f22734e = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f22736g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f22737h = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public float f22739j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public zzfc f22740k = zzdn.f27991a;

    public zzacm(Context context, zzabw zzabwVar) {
        this.f22730a = zzabwVar;
        this.f22731b = new zzact(context);
    }

    public final void a(int i2) {
        if (i2 == 0) {
            this.f22733d = 1;
        } else if (i2 != 1) {
            this.f22733d = Math.min(this.f22733d, 2);
        } else {
            this.f22733d = 0;
        }
        this.f22731b.a();
    }

    public final void b() {
        this.f22732c = true;
        this.f22740k.getClass();
        this.f22735f = zzfj.s(SystemClock.elapsedRealtime());
        zzact zzactVar = this.f22731b;
        zzactVar.f22756d = true;
        zzactVar.a();
        DisplayManager displayManager = (DisplayManager) zzactVar.f22754b.getSystemService("display");
        zzacp zzacsVar = null;
        if (displayManager != null) {
            try {
                Choreographer choreographer = Choreographer.getInstance();
                zzacsVar = Build.VERSION.SDK_INT >= 33 ? new zzacs(choreographer, displayManager) : new zzacq(choreographer, displayManager);
            } catch (RuntimeException e2) {
                zzee.d("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
            }
        }
        zzactVar.f22755c = zzacsVar;
        if (zzacsVar != null) {
            zzacsVar.a();
        }
        zzactVar.c(false);
    }

    public final void c(Surface surface) {
        this.f22741l = surface != null;
        this.f22742m = false;
        zzact zzactVar = this.f22731b;
        if (zzactVar.f22757e != surface) {
            zzactVar.d();
            zzactVar.f22757e = surface;
            zzactVar.c(true);
        }
        this.f22733d = Math.min(this.f22733d, 1);
    }

    public final void d(float f2) {
        zzact zzactVar = this.f22731b;
        zzactVar.f22758f = f2;
        zzabp zzabpVar = zzactVar.f22753a;
        zzabpVar.f22668a.a();
        zzabpVar.f22669b.a();
        zzabpVar.f22670c = false;
        zzabpVar.f22671d = -9223372036854775807L;
        zzabpVar.f22672e = 0;
        zzactVar.b();
    }

    public final boolean e(boolean z) {
        if (z && (this.f22733d == 3 || (!this.f22741l && this.f22742m))) {
            this.f22737h = -9223372036854775807L;
            return true;
        }
        if (this.f22737h == -9223372036854775807L) {
            return false;
        }
        this.f22740k.getClass();
        if (SystemClock.elapsedRealtime() < this.f22737h) {
            return true;
        }
        this.f22737h = -9223372036854775807L;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x015d, code lost:
    
        if (r3 > 100000) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016c, code lost:
    
        if (r33 >= r37) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0175, code lost:
    
        if (r30.f22732c != false) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(long r31, long r33, long r35, long r37, boolean r39, boolean r40, com.google.android.gms.internal.ads.zzack r41) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacm.f(long, long, long, long, boolean, boolean, com.google.android.gms.internal.ads.zzack):int");
    }

    public final void g(float f2) {
        zzgqa.a(f2 > 0.0f);
        if (f2 == this.f22739j) {
            return;
        }
        this.f22739j = f2;
        zzact zzactVar = this.f22731b;
        zzactVar.f22761i = f2;
        zzactVar.c(false);
    }
}
