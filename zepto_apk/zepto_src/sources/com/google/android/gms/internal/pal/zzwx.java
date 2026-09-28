package com.google.android.gms.internal.pal;

@Deprecated
/* loaded from: classes4.dex */
public final class zzwx extends zzacz implements zzaeg {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38103a = 0;
    private static final zzwx zzb;
    private String zze = "";
    private zzadf zzf = zzaeo.f37460d;

    static {
        zzwx zzwxVar = new zzwx();
        zzb = zzwxVar;
        zzacz.h(zzwx.class, zzwxVar);
    }

    public static zzwx p() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzvw.class});
        }
        if (i3 == 3) {
            return new zzwx();
        }
        if (i3 == 4) {
            return new zzww(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzadf q() {
        return this.zzf;
    }
}
