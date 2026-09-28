package com.google.android.gms.internal.pal;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzew extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public List f37708h;

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzr zzrVar = this.f37726d;
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.A0((zzaf) zzrVar.f37405b, -1L);
        zzr zzrVar2 = this.f37726d;
        if (zzrVar2.f37406c) {
            zzrVar2.k();
            zzrVar2.f37406c = false;
        }
        zzaf.B0((zzaf) zzrVar2.f37405b, -1L);
        if (this.f37708h == null) {
            this.f37708h = (List) this.f37727e.invoke(null, this.f37723a.f37634a);
        }
        List list = this.f37708h;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.f37726d) {
            zzr zzrVar3 = this.f37726d;
            long jLongValue = ((Long) this.f37708h.get(0)).longValue();
            if (zzrVar3.f37406c) {
                zzrVar3.k();
                zzrVar3.f37406c = false;
            }
            zzaf.A0((zzaf) zzrVar3.f37405b, jLongValue);
            zzr zzrVar4 = this.f37726d;
            long jLongValue2 = ((Long) this.f37708h.get(1)).longValue();
            if (zzrVar4.f37406c) {
                zzrVar4.k();
                zzrVar4.f37406c = false;
            }
            zzaf.B0((zzaf) zzrVar4.f37405b, jLongValue2);
        }
    }
}
