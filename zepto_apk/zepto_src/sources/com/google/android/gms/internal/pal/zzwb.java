package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwb extends zzacz implements zzaeg {
    private static final zzwb zzb;
    private int zze;
    private zzadf zzf = zzaeo.f37460d;

    static {
        zzwb zzwbVar = new zzwb();
        zzb = zzwbVar;
        zzacz.h(zzwb.class, zzwbVar);
    }

    public static zzvy r() {
        return (zzvy) zzb.k();
    }

    public static zzwb s(byte[] bArr, zzacm zzacmVar) {
        return (zzwb) zzacz.n(zzb, bArr, zzacmVar);
    }

    public static /* synthetic */ void v(zzwb zzwbVar, zzwa zzwaVar) {
        zzadf zzadfVar = zzwbVar.zzf;
        if (!zzadfVar.zzc()) {
            zzwbVar.zzf = zzacz.d(zzadfVar);
        }
        zzwbVar.zzf.add(zzwaVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzwa.class});
        }
        if (i3 == 3) {
            return new zzwb();
        }
        if (i3 == 4) {
            return new zzvy(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final int p() {
        return this.zzf.size();
    }

    public final int q() {
        return this.zze;
    }

    public final zzadf t() {
        return this.zzf;
    }
}
