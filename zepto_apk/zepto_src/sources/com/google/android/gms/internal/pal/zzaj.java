package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzaj extends zzacz implements zzaeg {
    private static final zzaj zzb;
    private int zze;
    private zzaby zzf;
    private zzaby zzg;

    static {
        zzaj zzajVar = new zzaj();
        zzb = zzajVar;
        zzacz.h(zzaj.class, zzajVar);
    }

    public zzaj() {
        zzaby zzabyVar = zzaby.f37363b;
        this.zzf = zzabyVar;
        this.zzg = zzabyVar;
    }

    public static zzai p() {
        return (zzai) zzb.k();
    }

    public static /* synthetic */ void q(zzaj zzajVar, zzaby zzabyVar) {
        zzajVar.zze |= 1;
        zzajVar.zzf = zzabyVar;
    }

    public static /* synthetic */ void r(zzaj zzajVar, zzaby zzabyVar) {
        zzajVar.zze |= 2;
        zzajVar.zzg = zzabyVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzaj();
        }
        if (i3 == 4) {
            return new zzai(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
