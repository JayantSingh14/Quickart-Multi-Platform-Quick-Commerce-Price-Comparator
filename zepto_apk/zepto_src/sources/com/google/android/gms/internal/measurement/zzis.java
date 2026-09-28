package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzis extends zzme implements zznm {
    private static final zzis zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzis zzisVar = new zzis();
        zzg = zzisVar;
        zzme.p(zzis.class, zzisVar);
    }

    public static zzil t() {
        return (zzil) zzg.l();
    }

    public static zzis u() {
        return zzg;
    }

    public final /* synthetic */ void A(int i2) {
        this.zzf = i2 - 1;
        this.zzb |= 4;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zziq.f36982a, "zze", zzim.f36967a, "zzf", zzio.f36981a});
        }
        if (i3 == 3) {
            return new zzis();
        }
        if (i3 == 4) {
            return new zzil();
        }
        if (i3 == 5) {
            return zzg;
        }
        throw null;
    }

    public final zzin s() {
        zzin zzinVarA = zzin.a(this.zze);
        return zzinVarA == null ? zzin.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzinVarA;
    }

    public final void v(zzin zzinVar) {
        this.zze = zzinVar.f36980a;
        this.zzb |= 2;
    }

    public final int x() {
        int iA = zzir.a(this.zzd);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int y() {
        int iA = zzip.a(this.zzf);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final /* synthetic */ void z(int i2) {
        this.zzd = i2 - 1;
        this.zzb |= 1;
    }
}
