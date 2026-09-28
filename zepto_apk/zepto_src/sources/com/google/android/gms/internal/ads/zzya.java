package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzya extends zzbf {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f35887g = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final long f35888b;

    /* renamed from: c, reason: collision with root package name */
    public final long f35889c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f35890d;

    /* renamed from: e, reason: collision with root package name */
    public final zzak f35891e;

    /* renamed from: f, reason: collision with root package name */
    public final zzaf f35892f;

    static {
        zzz zzzVar = new zzz();
        zzzVar.f35941a = "SinglePeriodTimeline";
        zzzVar.f35942b = Uri.EMPTY;
        zzzVar.a();
    }

    public zzya(long j2, long j3, boolean z, zzak zzakVar, zzaf zzafVar) {
        this.f35888b = j2;
        this.f35889c = j3;
        this.f35890d = z;
        zzakVar.getClass();
        this.f35891e = zzakVar;
        this.f35892f = zzafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int a() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe b(int i2, zzbe zzbeVar, long j2) {
        zzgqa.i(i2, 1);
        Object obj = zzbe.f24822m;
        zzbeVar.a(this.f35891e, this.f35890d, false, this.f35892f, this.f35889c);
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int c() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd d(int i2, zzbd zzbdVar, boolean z) {
        zzgqa.i(i2, 1);
        Object obj = z ? f35887g : null;
        zzc zzcVar = zzc.f25783b;
        zzbdVar.a(null, obj, 0, this.f35888b, false);
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int e(Object obj) {
        return f35887g.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object f(int i2) {
        zzgqa.i(i2, 1);
        return f35887g;
    }
}
