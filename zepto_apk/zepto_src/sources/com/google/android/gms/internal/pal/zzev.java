package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzev extends zzfg {
    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzr zzrVar = this.f37726d;
        try {
            int i2 = 1;
            if (true == ((Boolean) this.f37727e.invoke(null, this.f37723a.f37634a)).booleanValue()) {
                i2 = 2;
            }
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.e0((zzaf) zzrVar.f37405b, i2);
        } catch (InvocationTargetException unused) {
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.e0((zzaf) zzrVar.f37405b, 3);
        }
    }
}
