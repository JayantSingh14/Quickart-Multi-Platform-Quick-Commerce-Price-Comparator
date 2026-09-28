package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzvt extends zzacz implements zzaeg {
    private static final zzvt zzb;
    private String zze = "";
    private zzaby zzf = zzaby.f37363b;
    private int zzg;

    static {
        zzvt zzvtVar = new zzvt();
        zzb = zzvtVar;
        zzacz.h(zzvt.class, zzvtVar);
    }

    public static zzvs p() {
        return (zzvs) zzb.k();
    }

    public static zzvt q() {
        return zzb;
    }

    public static /* synthetic */ void t(zzvt zzvtVar, String str) {
        str.getClass();
        zzvtVar.zze = str;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzvt();
        }
        if (i3 == 4) {
            return new zzvs(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzaby r() {
        return this.zzf;
    }

    public final String s() {
        return this.zze;
    }

    public final int v() {
        int i2 = this.zzg;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 6 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
