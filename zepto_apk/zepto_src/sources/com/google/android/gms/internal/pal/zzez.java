package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzez extends zzfg {
    public zzez(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "sdX902x/AS9226TxUXaqji9wP1uHqRQA8nkg2YMN1TcruTTaw008l9z5V3jZGjLO", "z3i9M2k4RJ/f7GArNBcGbUcpUFpuRmLev6S20UO7Vqs=", zzrVar, i2, 51);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        synchronized (this.f37726d) {
            String str = (String) this.f37727e.invoke(null, null);
            zzdp zzdpVar = new zzdp();
            HashMap mapA = zzbi.a(str);
            if (mapA != null) {
                zzdpVar.f37626a = (Long) mapA.get(0);
                zzdpVar.f37627b = (Long) mapA.get(1);
            }
            zzr zzrVar = this.f37726d;
            long jLongValue = zzdpVar.f37626a.longValue();
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.A((zzaf) zzrVar.f37405b, jLongValue);
            zzr zzrVar2 = this.f37726d;
            long jLongValue2 = zzdpVar.f37627b.longValue();
            if (zzrVar2.f37406c) {
                zzrVar2.k();
                zzrVar2.f37406c = false;
            }
            zzaf.C((zzaf) zzrVar2.f37405b, jLongValue2);
        }
    }
}
