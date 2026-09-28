package com.google.android.gms.internal.pal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzeg extends zzfg {
    public zzeg(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "6vt+8E5GP5AwoxquDM0Y7lVJzS23/VCjNo5D8xB8rgAaaF6IhToGZhlIAUkgigHl", "jx9F7EAIAhvEI8G+/hWsHBitt0z+K8moFRn7/w45eYc=", zzrVar, i2, 49);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() throws InvocationTargetException {
        zzr zzrVar = this.f37726d;
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.c0((zzaf) zzrVar.f37405b, 3);
        try {
            int i2 = 1;
            if (true == ((Boolean) this.f37727e.invoke(null, this.f37723a.f37634a)).booleanValue()) {
                i2 = 2;
            }
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.c0((zzaf) zzrVar.f37405b, i2);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
