package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwg extends zzacz implements zzaeg {
    private static final zzwg zzb;
    private int zze;
    private zzadf zzf = zzaeo.f37460d;

    static {
        zzwg zzwgVar = new zzwg();
        zzb = zzwgVar;
        zzacz.h(zzwg.class, zzwgVar);
    }

    public static zzwd p() {
        return (zzwd) zzb.k();
    }

    public static /* synthetic */ void r(zzwg zzwgVar, zzwf zzwfVar) {
        zzadf zzadfVar = zzwgVar.zzf;
        if (!zzadfVar.zzc()) {
            zzwgVar.zzf = zzacz.d(zzadfVar);
        }
        zzwgVar.zzf.add(zzwfVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzwf.class});
        }
        if (i3 == 3) {
            return new zzwg();
        }
        if (i3 == 4) {
            return new zzwd(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
