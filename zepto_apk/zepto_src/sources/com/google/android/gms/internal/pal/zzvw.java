package com.google.android.gms.internal.pal;

@Deprecated
/* loaded from: classes4.dex */
public final class zzvw extends zzacz implements zzaeg {
    private static final zzvw zzb;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    static {
        zzvw zzvwVar = new zzvw();
        zzb = zzvwVar;
        zzacz.h(zzvw.class, zzvwVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i3 == 3) {
            return new zzvw();
        }
        if (i3 == 4) {
            return new zzvv(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final String p() {
        return this.zzi;
    }

    public final String q() {
        return this.zze;
    }

    public final String r() {
        return this.zzf;
    }

    public final boolean s() {
        return this.zzh;
    }
}
