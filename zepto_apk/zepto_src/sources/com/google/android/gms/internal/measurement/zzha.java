package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzha extends zzme implements zznm {
    private static final zzha zzn;
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private long zzk;
    private zznf zzl;
    private zznf zzm;

    static {
        zzha zzhaVar = new zzha();
        zzn = zzhaVar;
        zzme.p(zzha.class, zzhaVar);
    }

    public zzha() {
        zznf zznfVar = zznf.f37140b;
        this.zzl = zznfVar;
        this.zzm = zznfVar;
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public static zzgx S() {
        return (zzgx) zzn.l();
    }

    public static zzha T() {
        return zzn;
    }

    public final zznf A() {
        zznf zznfVar = this.zzm;
        if (!zznfVar.f37141a) {
            this.zzm = zznfVar.a();
        }
        return this.zzm;
    }

    public final boolean C() {
        return (this.zzb & 1) != 0;
    }

    public final String D() {
        return this.zzd;
    }

    public final boolean E() {
        return (this.zzb & 2) != 0;
    }

    public final String F() {
        return this.zze;
    }

    public final boolean G() {
        return (this.zzb & 4) != 0;
    }

    public final String H() {
        return this.zzf;
    }

    public final boolean I() {
        return (this.zzb & 8) != 0;
    }

    public final long J() {
        return this.zzg;
    }

    public final boolean K() {
        return (this.zzb & 16) != 0;
    }

    public final String L() {
        return this.zzh;
    }

    public final boolean M() {
        return (this.zzb & 32) != 0;
    }

    public final String N() {
        return this.zzi;
    }

    public final boolean O() {
        return (this.zzb & 64) != 0;
    }

    public final String P() {
        return this.zzj;
    }

    public final boolean Q() {
        return (this.zzb & 128) != 0;
    }

    public final long R() {
        return this.zzk;
    }

    public final /* synthetic */ void U(String str) {
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void V() {
        this.zzb &= -2;
        this.zzd = zzn.zzd;
    }

    public final /* synthetic */ void W(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void X() {
        this.zzb &= -3;
        this.zze = zzn.zze;
    }

    public final /* synthetic */ void Y(String str) {
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void Z() {
        this.zzb &= -5;
        this.zzf = zzn.zzf;
    }

    public final /* synthetic */ void a0(long j2) {
        this.zzb |= 8;
        this.zzg = j2;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzn, "\u0004\n\u0000\u0001\u0001\n\n\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzgy.f36961a, "zzm", zzgz.f36962a});
        }
        if (i3 == 3) {
            return new zzha();
        }
        if (i3 == 4) {
            return new zzgx();
        }
        if (i3 == 5) {
            return zzn;
        }
        throw null;
    }

    public final /* synthetic */ void s(String str) {
        this.zzb |= 16;
        this.zzh = str;
    }

    public final /* synthetic */ void t() {
        this.zzb &= -17;
        this.zzh = zzn.zzh;
    }

    public final /* synthetic */ void u(String str) {
        this.zzb |= 32;
        this.zzi = str;
    }

    public final /* synthetic */ void v() {
        this.zzb &= -33;
        this.zzi = zzn.zzi;
    }

    public final /* synthetic */ void w(String str) {
        this.zzb |= 64;
        this.zzj = str;
    }

    public final /* synthetic */ void x() {
        this.zzb &= -65;
        this.zzj = zzn.zzj;
    }

    public final /* synthetic */ void y(long j2) {
        this.zzb |= 128;
        this.zzk = j2;
    }

    public final zznf z() {
        zznf zznfVar = this.zzl;
        if (!zznfVar.f37141a) {
            this.zzl = zznfVar.a();
        }
        return this.zzl;
    }
}
