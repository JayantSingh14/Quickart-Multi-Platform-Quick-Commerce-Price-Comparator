package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzchj implements zzlg {

    /* renamed from: a, reason: collision with root package name */
    public final zzaan f26261a = new zzaan();

    /* renamed from: b, reason: collision with root package name */
    public long f26262b = 15000000;

    /* renamed from: c, reason: collision with root package name */
    public long f26263c = 30000000;

    /* renamed from: d, reason: collision with root package name */
    public long f26264d = 2500000;

    /* renamed from: e, reason: collision with root package name */
    public long f26265e = 5000000;

    /* renamed from: f, reason: collision with root package name */
    public int f26266f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26267g;

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void a(zzpn zzpnVar) {
        this.f26266f = 0;
        this.f26267g = false;
        zzaan zzaanVar = this.f26261a;
        synchronized (zzaanVar) {
            zzaanVar.c(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final zzaah b(zzpn zzpnVar) {
        return this.f26261a;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void c(zzpn zzpnVar) {
        this.f26266f = 0;
        this.f26267g = false;
        zzaan zzaanVar = this.f26261a;
        synchronized (zzaanVar) {
            zzaanVar.c(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void d(zzpn zzpnVar) {
        this.f26266f = 0;
        this.f26267g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void e(zzlf zzlfVar, zzzw[] zzzwVarArr) {
        int i2;
        this.f26266f = 0;
        for (zzzw zzzwVar : zzzwVarArr) {
            if (zzzwVar != null) {
                int i3 = this.f26266f;
                int i4 = zzzwVar.zza().f24985c;
                if (i4 == 0) {
                    i2 = 144310272;
                } else if (i4 == 1) {
                    i2 = 13107200;
                } else if (i4 != 2) {
                    i2 = 131072;
                    if (i4 != 3 && i4 != 5 && i4 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i2 = 131072000;
                }
                this.f26266f = i3 + i2;
            }
        }
        this.f26261a.c(this.f26266f);
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final boolean f(zzlf zzlfVar) {
        long j2 = zzlfVar.f35088f ? this.f26265e : this.f26264d;
        return j2 <= 0 || zzlfVar.f35086d >= j2;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final boolean g(zzlf zzlfVar) {
        int i2;
        long j2 = zzlfVar.f35086d;
        boolean z = true;
        char c2 = j2 > this.f26263c ? (char) 0 : j2 < this.f26262b ? (char) 2 : (char) 1;
        zzaan zzaanVar = this.f26261a;
        synchronized (zzaanVar) {
            i2 = zzaanVar.f22593b * 65536;
        }
        int i3 = this.f26266f;
        if (c2 != 2 && (c2 != 1 || !this.f26267g || i2 >= i3)) {
            z = false;
        }
        this.f26267g = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final long zzf() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void zzg() {
    }
}
