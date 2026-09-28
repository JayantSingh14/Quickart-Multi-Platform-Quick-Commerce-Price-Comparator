package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzgl extends zzme implements zznm {
    private static final zzgl zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private zzmn zzg;
    private zzmn zzh;
    private zzmn zzi;
    private String zzj;
    private boolean zzk;
    private zzmn zzl;
    private zzmn zzm;
    private String zzn;
    private String zzo;
    private zzgf zzp;
    private zzgp zzq;
    private zzgv zzr;
    private zzgr zzs;
    private zzgn zzt;

    static {
        zzgl zzglVar = new zzgl();
        zzu = zzglVar;
        zzme.p(zzgl.class, zzglVar);
    }

    public zzgl() {
        zznu zznuVar = zznu.f37165e;
        this.zzg = zznuVar;
        this.zzh = zznuVar;
        this.zzi = zznuVar;
        this.zzj = "";
        this.zzl = zznuVar;
        this.zzm = zznuVar;
        this.zzn = "";
        this.zzo = "";
    }

    public static zzgk I() {
        return (zzgk) zzu.l();
    }

    public static zzgl J() {
        return zzu;
    }

    public final zzmn A() {
        return this.zzl;
    }

    public final int B() {
        return this.zzl.size();
    }

    public final List C() {
        return this.zzm;
    }

    public final String D() {
        return this.zzn;
    }

    public final boolean E() {
        return (this.zzb & 128) != 0;
    }

    public final zzgf F() {
        zzgf zzgfVar = this.zzp;
        return zzgfVar == null ? zzgf.y() : zzgfVar;
    }

    public final boolean G() {
        return (this.zzb & 512) != 0;
    }

    public final zzgv H() {
        zzgv zzgvVar = this.zzr;
        return zzgvVar == null ? zzgv.u() : zzgvVar;
    }

    public final void K(int i2, zzgj zzgjVar) {
        zzmn zzmnVar = this.zzh;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzh = zzmnVar.zzg(size + size);
        }
        this.zzh.set(i2, zzgjVar);
    }

    public final void L() {
        this.zzi = zznu.f37165e;
    }

    public final void M() {
        this.zzl = zznu.f37165e;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", zzgt.class, "zzh", zzgj.class, "zzi", zzfd.class, "zzj", "zzk", "zzl", zzja.class, "zzm", zzgh.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i3 == 3) {
            return new zzgl();
        }
        if (i3 == 4) {
            return new zzgk();
        }
        if (i3 == 5) {
            return zzu;
        }
        throw null;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final long t() {
        return this.zzd;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final String v() {
        return this.zze;
    }

    public final zzmn w() {
        return this.zzg;
    }

    public final int x() {
        return this.zzh.size();
    }

    public final zzgj y(int i2) {
        return (zzgj) this.zzh.get(i2);
    }

    public final zzmn z() {
        return this.zzi;
    }
}
