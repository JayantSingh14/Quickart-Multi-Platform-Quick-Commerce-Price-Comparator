package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzakj {
    public static void a(int i2, zzap zzapVar, zzt zztVar, zzap zzapVar2, zzap... zzapVarArr) {
        if (zzapVar2 == null) {
            zzapVar2 = new zzap(new zzao[0]);
        }
        if (zzapVar != null) {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzgta zzgtaVar = new zzgta();
            for (zzao zzaoVar : zzapVar.f24032a) {
                if (zzfs.class.isAssignableFrom(zzaoVar.getClass())) {
                    zzgtaVar.c((zzao) zzfs.class.cast(zzaoVar));
                }
            }
            zzguy zzguyVar = (zzguy) zzgtaVar.f();
            int i3 = zzguyVar.f33234d;
            for (int i4 = 0; i4 < i3; i4++) {
                zzfs zzfsVar = (zzfs) zzguyVar.get(i4);
                if (!zzfsVar.f31762a.equals("com.android.capture.fps") || i2 == 2) {
                    zzapVar2 = zzapVar2.c(zzfsVar);
                }
            }
        }
        for (zzap zzapVar3 : zzapVarArr) {
            zzapVar2 = zzapVar2.b(zzapVar3);
        }
        if (zzapVar2.f24032a.length > 0) {
            zztVar.f35573j = zzapVar2;
        }
    }

    public static zzail b(int i2, String str, zzer zzerVar) {
        int iB = zzerVar.b();
        if (zzerVar.b() == 1684108385) {
            zzerVar.G(8);
            return new zzail(str, null, zzgtd.n(zzerVar.l(iB - 16)));
        }
        zzee.c("MetadataUtil", "Failed to parse text attribute: ".concat(zzfw.a(i2)));
        return null;
    }

    public static zzaig c(int i2, String str, zzer zzerVar, boolean z, boolean z2) {
        int iD = d(zzerVar);
        if (z2) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            return z ? new zzail(str, null, zzgtd.n(Integer.toString(iD))) : new zzaia("und", str, Integer.toString(iD));
        }
        zzee.c("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzfw.a(i2)));
        return null;
    }

    public static int d(zzer zzerVar) {
        int iB = zzerVar.b();
        if (zzerVar.b() == 1684108385) {
            zzerVar.G(8);
            int i2 = iB - 16;
            if (i2 == 1) {
                return zzerVar.K();
            }
            if (i2 == 2) {
                return zzerVar.L();
            }
            if (i2 == 3) {
                return zzerVar.O();
            }
            if (i2 == 4 && (zzerVar.I() & 128) == 0) {
                return zzerVar.h();
            }
        }
        zzee.c("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static zzail e(int i2, String str, zzer zzerVar) {
        int iB = zzerVar.b();
        if (zzerVar.b() == 1684108385 && iB >= 22) {
            zzerVar.G(10);
            int iL = zzerVar.L();
            if (iL > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iL).length());
                sb.append(iL);
                String string = sb.toString();
                int iL2 = zzerVar.L();
                if (iL2 > 0) {
                    StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(iL2).length());
                    sb2.append(string);
                    sb2.append("/");
                    sb2.append(iL2);
                    string = sb2.toString();
                }
                return new zzail(str, null, zzgtd.n(string));
            }
        }
        zzee.c("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzfw.a(i2)));
        return null;
    }
}
