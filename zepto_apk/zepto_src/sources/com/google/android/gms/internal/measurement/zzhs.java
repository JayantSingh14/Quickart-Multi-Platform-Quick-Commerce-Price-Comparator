package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzhs extends zzme implements zznm {
    private static final zzhs zzi;
    private int zzb;
    private zzmn zzd = zznu.f37165e;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    static {
        zzhs zzhsVar = new zzhs();
        zzi = zzhsVar;
        zzme.p(zzhs.class, zzhsVar);
    }

    public static zzhr C() {
        return (zzhr) zzi.l();
    }

    public final boolean A() {
        return (this.zzb & 8) != 0;
    }

    public final int B() {
        return this.zzh;
    }

    public final /* synthetic */ void D(int i2, zzhw zzhwVar) {
        L();
        this.zzd.set(i2, zzhwVar);
    }

    public final /* synthetic */ void E(zzhw zzhwVar) {
        zzhwVar.getClass();
        L();
        this.zzd.add(zzhwVar);
    }

    public final /* synthetic */ void F(Iterable iterable) {
        L();
        zzkr.h(iterable, this.zzd);
    }

    public final void G() {
        this.zzd = zznu.f37165e;
    }

    public final /* synthetic */ void H(int i2) {
        L();
        this.zzd.remove(i2);
    }

    public final /* synthetic */ void I(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void J(long j2) {
        this.zzb |= 2;
        this.zzf = j2;
    }

    public final /* synthetic */ void K(long j2) {
        this.zzb |= 4;
        this.zzg = j2;
    }

    public final void L() {
        zzmn zzmnVar = this.zzd;
        if (zzmnVar.zza()) {
            return;
        }
        int size = zzmnVar.size();
        this.zzd = zzmnVar.zzg(size + size);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzhs();
        }
        if (i3 == 4) {
            return new zzhr(zzi);
        }
        if (i3 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List s() {
        return this.zzd;
    }

    public final int t() {
        return this.zzd.size();
    }

    public final zzhw u(int i2) {
        return (zzhw) this.zzd.get(i2);
    }

    public final String v() {
        return this.zze;
    }

    public final boolean w() {
        return (this.zzb & 2) != 0;
    }

    public final long x() {
        return this.zzf;
    }

    public final boolean y() {
        return (this.zzb & 4) != 0;
    }

    public final long z() {
        return this.zzg;
    }
}
