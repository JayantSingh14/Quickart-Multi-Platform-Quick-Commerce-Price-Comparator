package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzez {

    /* renamed from: a, reason: collision with root package name */
    public final int f30624a;

    /* renamed from: b, reason: collision with root package name */
    public int f30625b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f30626c;

    /* renamed from: d, reason: collision with root package name */
    public long f30627d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzfa f30628e;

    public zzez(zzfa zzfaVar, int i2) {
        Objects.requireNonNull(zzfaVar);
        this.f30628e = zzfaVar;
        this.f30624a = i2;
    }

    public final void a() {
        zzfa zzfaVar = this.f30628e;
        int iZzi = ((zzkp) zzfaVar.f30705a).zzi();
        zzkp zzkpVar = (zzkp) zzfaVar.f30705a;
        boolean zZzk = zzkpVar.zzk();
        zzdx zzdxVar = zzfaVar.f30709e;
        if (!zZzk || zzkpVar.zzh() == 1 || zzkpVar.zzh() == 4 || iZzi == 0 || iZzi == 1) {
            if (this.f30626c) {
                zzdxVar.r(4);
            }
            this.f30626c = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.f30626c;
        int i2 = this.f30624a;
        if (z && this.f30625b == iZzi) {
            if (jElapsedRealtime - this.f30627d >= i2) {
                zzfaVar.f30707c.a(new zzfb(4, i2));
                return;
            }
            return;
        }
        this.f30626c = true;
        this.f30627d = jElapsedRealtime;
        this.f30625b = iZzi;
        zzdxVar.r(4);
        zzdxVar.zzi(4, i2);
    }
}
