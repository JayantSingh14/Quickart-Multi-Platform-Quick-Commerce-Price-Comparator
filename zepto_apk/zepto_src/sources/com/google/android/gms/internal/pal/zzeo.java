package com.google.android.gms.internal.pal;

import android.view.View;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzeo extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f37699h;

    /* renamed from: i, reason: collision with root package name */
    public final View f37700i;

    public zzeo(zzdu zzduVar, zzr zzrVar, int i2, HashMap map, View view) {
        super(zzduVar, "RKC3mFMqGi7xOgQ7s39JMoZe9bnzGCFipcdUUf0vlgHDkBg7SvMkVmBGpwLs06ia", "8Xr1ilYJHo+oWZQAYAG91DIHBuqEmXK8yHtxL6KkyfU=", zzrVar, i2, 85);
        this.f37699h = map;
        this.f37700i = view;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        HashMap map = this.f37699h;
        long jLongValue = map.containsKey(1) ? ((Long) map.get(1)).longValue() : Long.MIN_VALUE;
        HashMap map2 = this.f37699h;
        long[] jArr = (long[]) this.f37727e.invoke(null, new long[]{jLongValue, map2.containsKey(2) ? ((Long) map2.get(2)).longValue() : Long.MIN_VALUE}, this.f37723a.f37634a, this.f37700i);
        long j2 = jArr[0];
        this.f37699h.put(1, Long.valueOf(jArr[1]));
        long j3 = jArr[2];
        this.f37699h.put(2, Long.valueOf(jArr[3]));
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.T((zzaf) zzrVar.f37405b, j2);
            zzr zzrVar2 = this.f37726d;
            if (zzrVar2.f37406c) {
                zzrVar2.k();
                zzrVar2.f37406c = false;
            }
            zzaf.U((zzaf) zzrVar2.f37405b, j3);
        }
    }
}
