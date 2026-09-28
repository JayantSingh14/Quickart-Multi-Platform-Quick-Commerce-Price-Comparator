package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzal extends zzacz implements zzaeg {
    private static final zzal zzb;
    private int zze;
    private zzaby zzf;
    private zzaby zzg;
    private zzaby zzh;
    private zzaby zzi;

    static {
        zzal zzalVar = new zzal();
        zzb = zzalVar;
        zzacz.h(zzal.class, zzalVar);
    }

    public zzal() {
        zzaby zzabyVar = zzaby.f37363b;
        this.zzf = zzabyVar;
        this.zzg = zzabyVar;
        this.zzh = zzabyVar;
        this.zzi = zzabyVar;
    }

    public static zzak p() {
        return (zzak) zzb.k();
    }

    public static zzal q(byte[] bArr, zzacm zzacmVar) {
        return (zzal) zzacz.n(zzb, bArr, zzacmVar);
    }

    public static /* synthetic */ void v(zzal zzalVar, zzaby zzabyVar) {
        zzalVar.zze |= 1;
        zzalVar.zzf = zzabyVar;
    }

    public static /* synthetic */ void w(zzal zzalVar, zzaby zzabyVar) {
        zzalVar.zze |= 2;
        zzalVar.zzg = zzabyVar;
    }

    public static /* synthetic */ void x(zzal zzalVar, zzaby zzabyVar) {
        zzalVar.zze |= 4;
        zzalVar.zzh = zzabyVar;
    }

    public static /* synthetic */ void y(zzal zzalVar, zzaby zzabyVar) {
        zzalVar.zze |= 8;
        zzalVar.zzi = zzabyVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzal();
        }
        if (i3 == 4) {
            return new zzak(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzaby r() {
        return this.zzf;
    }

    public final zzaby s() {
        return this.zzg;
    }

    public final zzaby t() {
        return this.zzi;
    }

    public final zzaby u() {
        return this.zzh;
    }
}
