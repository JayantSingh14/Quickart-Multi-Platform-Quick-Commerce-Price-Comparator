package com.google.android.gms.internal.ads;

import java.io.FileInputStream;

/* loaded from: classes4.dex */
public abstract class zzhyw implements zzick {
    static {
        zziab zziabVar = zziab.f34620b;
        int i2 = zzhyy.f34536a;
    }

    @Override // com.google.android.gms.internal.ads.zzick
    public final zziar a(FileInputStream fileInputStream, zziab zziabVar) throws zzibg {
        zzhzo zzhzoVar = new zzhzo(fileInputStream);
        zziar zziarVarP = zziar.p(((zziam) this).f34639a, zzhzoVar, zziabVar);
        zzhzoVar.i(0);
        if (zziar.z(zziarVarP, true)) {
            return zziarVarP;
        }
        throw new zzibg(new zzide().getMessage());
    }
}
