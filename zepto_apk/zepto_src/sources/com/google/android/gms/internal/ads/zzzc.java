package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzzc extends zzzm implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public final int f35951e;

    /* renamed from: f, reason: collision with root package name */
    public final int f35952f;

    public zzzc(int i2, zzbg zzbgVar, int i3, zzzf zzzfVar, int i4) {
        int i5;
        super(i2, zzbgVar, i3);
        this.f35951e = zzmk.a(i4, zzzfVar.B) ? 1 : 0;
        zzv zzvVar = this.f35973d;
        int i6 = zzvVar.t;
        int i7 = -1;
        if (i6 != -1 && (i5 = zzvVar.u) != -1) {
            i7 = i6 * i5;
        }
        this.f35952f = i7;
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final /* bridge */ /* synthetic */ boolean a(zzzm zzzmVar) {
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f35952f, ((zzzc) obj).f35952f);
    }

    @Override // com.google.android.gms.internal.ads.zzzm
    public final int zza() {
        return this.f35951e;
    }
}
