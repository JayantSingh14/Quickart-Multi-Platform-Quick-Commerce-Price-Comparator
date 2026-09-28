package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zztw extends zzacz implements zzaeg {
    private static final zztw zzb;
    private zztz zze;

    static {
        zztw zztwVar = new zztw();
        zzb = zztwVar;
        zzacz.h(zztw.class, zztwVar);
    }

    public static zztv p() {
        return (zztv) zzb.k();
    }

    public static zztw q(zzaby zzabyVar, zzacm zzacmVar) {
        return (zztw) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        }
        if (i3 == 3) {
            return new zztw();
        }
        if (i3 == 4) {
            return new zztv(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zztz r() {
        zztz zztzVar = this.zze;
        return zztzVar == null ? zztz.r() : zztzVar;
    }
}
