package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public interface zzmi extends zzmd {
    String d();

    boolean e();

    default void f() {
    }

    default boolean g(long j2) {
        return false;
    }

    void h(long j2, boolean z);

    default long i(long j2, long j3) {
        if (zze() == 1) {
            return (e() || t()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    void k(zzbf zzbfVar);

    void l(zzml zzmlVar, zzv[] zzvVarArr, zzxw zzxwVar, boolean z, boolean z2, long j2, long j3, zzwg zzwgVar);

    default void m(float f2, float f3) {
    }

    void n(int i2, zzpn zzpnVar, zzfc zzfcVar);

    void o(long j2, long j3);

    void p();

    boolean t();

    void v(zzv[] zzvVarArr, zzxw zzxwVar, long j2, long j3, zzwg zzwgVar);

    zzxw w();

    boolean x();

    int zza();

    zzij zzb();

    zzlj zzd();

    int zze();

    long zzk();

    void zzl();

    boolean zzm();

    void zzn();

    void zzq();

    void zzr();

    void zzs();

    default void r() {
    }
}
