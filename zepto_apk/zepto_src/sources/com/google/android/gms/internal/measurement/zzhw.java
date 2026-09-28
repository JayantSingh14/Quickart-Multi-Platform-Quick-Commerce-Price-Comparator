package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzhw extends zzme implements zznm {
    private static final zzhw zzj;
    private int zzb;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private zzmn zzi = zznu.f37165e;

    static {
        zzhw zzhwVar = new zzhw();
        zzj = zzhwVar;
        zzme.p(zzhw.class, zzhwVar);
    }

    public static zzhv E() {
        return (zzhv) zzj.l();
    }

    public final boolean A() {
        return (this.zzb & 16) != 0;
    }

    public final double B() {
        return this.zzh;
    }

    public final List C() {
        return this.zzi;
    }

    public final int D() {
        return this.zzi.size();
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void H() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    public final /* synthetic */ void I(long j2) {
        this.zzb |= 4;
        this.zzf = j2;
    }

    public final /* synthetic */ void J() {
        this.zzb &= -5;
        this.zzf = 0L;
    }

    public final /* synthetic */ void K(double d2) {
        this.zzb |= 16;
        this.zzh = d2;
    }

    public final /* synthetic */ void L() {
        this.zzb &= -17;
        this.zzh = 0.0d;
    }

    public final void M(zzhw zzhwVar) {
        zzmn zzmnVar = this.zzi;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzi = zzmnVar.zzg(size + size);
        }
        this.zzi.add(zzhwVar);
    }

    public final void N(ArrayList arrayList) {
        zzmn zzmnVar = this.zzi;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzi = zzmnVar.zzg(size + size);
        }
        zzkr.h(arrayList, this.zzi);
    }

    public final void O() {
        this.zzi = zznu.f37165e;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhw.class});
        }
        if (i3 == 3) {
            return new zzhw();
        }
        if (i3 == 4) {
            return new zzhv(zzj);
        }
        if (i3 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final String t() {
        return this.zzd;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final String v() {
        return this.zze;
    }

    public final boolean w() {
        return (this.zzb & 4) != 0;
    }

    public final long x() {
        return this.zzf;
    }

    public final boolean y() {
        return (this.zzb & 8) != 0;
    }

    public final float z() {
        return this.zzg;
    }
}
