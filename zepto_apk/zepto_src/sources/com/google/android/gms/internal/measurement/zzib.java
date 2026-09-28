package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzib extends zzme implements zznm {
    private static final zzib zzh;
    private int zzb;
    private zzmn zzd = zznu.f37165e;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        zzib zzibVar = new zzib();
        zzh = zzibVar;
        zzme.p(zzib.class, zzibVar);
    }

    public static zzhz A(zzib zzibVar) {
        zzma zzmaVarL = zzh.l();
        zzmaVarL.m(zzibVar);
        return (zzhz) zzmaVarL;
    }

    public static zzhz z() {
        return (zzhz) zzh.l();
    }

    public final /* synthetic */ void B(int i2, zzid zzidVar) {
        H();
        this.zzd.set(i2, zzidVar);
    }

    public final /* synthetic */ void C(zzid zzidVar) {
        H();
        this.zzd.add(zzidVar);
    }

    public final /* synthetic */ void D(ArrayList arrayList) {
        H();
        zzkr.h(arrayList, this.zzd);
    }

    public final void E() {
        this.zzd = zznu.f37165e;
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    public final void H() {
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
            return new zznv(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", zzid.class, "zze", "zzf", "zzg", zzia.f36965a});
        }
        if (i3 == 3) {
            return new zzib();
        }
        if (i3 == 4) {
            return new zzhz(zzh);
        }
        if (i3 == 5) {
            return zzh;
        }
        throw null;
    }

    public final List s() {
        return this.zzd;
    }

    public final int t() {
        return this.zzd.size();
    }

    public final zzid u(int i2) {
        return (zzid) this.zzd.get(i2);
    }

    public final boolean v() {
        return (this.zzb & 1) != 0;
    }

    public final String w() {
        return this.zze;
    }

    public final boolean x() {
        return (this.zzb & 2) != 0;
    }

    public final String y() {
        return this.zzf;
    }
}
