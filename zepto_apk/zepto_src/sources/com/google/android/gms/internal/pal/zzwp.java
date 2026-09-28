package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwp extends zzacz implements zzaeg {
    private static final zzwp zzb;
    private int zze;
    private zzws zzf;

    static {
        zzwp zzwpVar = new zzwp();
        zzb = zzwpVar;
        zzacz.h(zzwp.class, zzwpVar);
    }

    public static zzwo q() {
        return (zzwo) zzb.k();
    }

    public static zzwp r(zzaby zzabyVar, zzacm zzacmVar) {
        return (zzwp) zzacz.m(zzb, zzabyVar, zzacmVar);
    }

    public static /* synthetic */ void u(zzwp zzwpVar, zzws zzwsVar) {
        zzwsVar.getClass();
        zzwpVar.zzf = zzwsVar;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzwp();
        }
        if (i3 == 4) {
            return new zzwo(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zze;
    }

    public final zzws s() {
        zzws zzwsVar = this.zzf;
        return zzwsVar == null ? zzws.q() : zzwsVar;
    }
}
