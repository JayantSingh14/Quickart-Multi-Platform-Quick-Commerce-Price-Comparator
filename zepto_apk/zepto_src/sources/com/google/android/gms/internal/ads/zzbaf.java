package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzbaf extends zzbbh {
    public zzbaf(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "Ps5Xy95qN5Bq7sgqC6/M4zZXLDS2M1Isx7H/g2/CV37zoy2ILxNb7iAARKvnhAcR", "UDDHIUrqun7cz3t6d4j2iVVfWcHKtBQnSOoDChOFM5Y=", zzavsVar, i2, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() throws InvocationTargetException {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).t0(3);
        try {
            int i2 = 1;
            if (true == ((Boolean) this.f24673e.invoke(null, this.f24669a.f24558a)).booleanValue()) {
                i2 = 2;
            }
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).t0(i2);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
