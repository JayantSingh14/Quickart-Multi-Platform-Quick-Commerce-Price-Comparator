package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzer extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final zzcz f37703h;

    /* renamed from: i, reason: collision with root package name */
    public final long f37704i;

    /* renamed from: j, reason: collision with root package name */
    public final long f37705j;

    public zzer(zzdu zzduVar, zzr zzrVar, int i2, zzcz zzczVar, long j2, long j3) {
        super(zzduVar, "X9PgbTHLX0FFxbl3gdPDuVwcglfXy5CDrzo8siaVNaH+OIJ6JI34Wu3QK5rLega4", "JLulXGPEHVwHK+0FG96HP9my+NvwpTQbwIaIZrjn9OU=", zzrVar, i2, 11);
        this.f37703h = zzczVar;
        this.f37704i = j2;
        this.f37705j = j3;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzcz zzczVar = this.f37703h;
        if (zzczVar != null) {
            String str = (String) this.f37727e.invoke(null, zzczVar.f37604a, Long.valueOf(this.f37704i), Long.valueOf(this.f37705j));
            zzcx zzcxVar = new zzcx();
            HashMap mapA = zzbi.a(str);
            if (mapA != null) {
                zzcxVar.f37600a = (Long) mapA.get(0);
                zzcxVar.f37601b = (Long) mapA.get(1);
                zzcxVar.f37602c = (Long) mapA.get(2);
            }
            synchronized (this.f37726d) {
                try {
                    zzr zzrVar = this.f37726d;
                    long jLongValue = zzcxVar.f37600a.longValue();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.p0((zzaf) zzrVar.f37405b, jLongValue);
                    if (zzcxVar.f37601b.longValue() >= 0) {
                        zzr zzrVar2 = this.f37726d;
                        long jLongValue2 = zzcxVar.f37601b.longValue();
                        if (zzrVar2.f37406c) {
                            zzrVar2.k();
                            zzrVar2.f37406c = false;
                        }
                        zzaf.Q((zzaf) zzrVar2.f37405b, jLongValue2);
                    }
                    if (zzcxVar.f37602c.longValue() >= 0) {
                        zzr zzrVar3 = this.f37726d;
                        long jLongValue3 = zzcxVar.f37602c.longValue();
                        if (zzrVar3.f37406c) {
                            zzrVar3.k();
                            zzrVar3.f37406c = false;
                        }
                        zzaf.S((zzaf) zzrVar3.f37405b, jLongValue3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
