package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzau extends zzacz implements zzaeg {
    private static final zzau zzb;
    private int zze;
    private zzadf zzf = zzaeo.f37460d;
    private zzaby zzg = zzaby.f37363b;
    private int zzh = 1;
    private int zzi = 1;

    static {
        zzau zzauVar = new zzau();
        zzb = zzauVar;
        zzacz.h(zzau.class, zzauVar);
    }

    public static zzat p() {
        return (zzat) zzb.k();
    }

    public static /* synthetic */ void q(zzau zzauVar, zzaby zzabyVar) {
        zzadf zzadfVar = zzauVar.zzf;
        if (!zzadfVar.zzc()) {
            zzauVar.zzf = zzacz.d(zzadfVar);
        }
        zzauVar.zzf.add(zzabyVar);
    }

    public static /* synthetic */ void r(zzau zzauVar, zzaby zzabyVar) {
        zzauVar.zze |= 1;
        zzauVar.zzg = zzabyVar;
    }

    public static /* synthetic */ void s(zzau zzauVar) {
        zzauVar.zzi = 2;
        zzauVar.zze |= 4;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", zzao.f37524a, "zzi", zzam.f37522a});
        }
        if (i3 == 3) {
            return new zzau();
        }
        if (i3 == 4) {
            return new zzat(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
