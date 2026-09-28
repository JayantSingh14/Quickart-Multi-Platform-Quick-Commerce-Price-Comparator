package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzex extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final boolean f37709h;

    public zzex(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "RjfRn/7K/Mx2/M8Fl6a7u1D5niklht4X0VG1cOixOa4SuaPG6Qd7la4v6f0IM/MO", "cZ2qwY2ZIJRch325gepGJtH7dQ9IcqmfWvaHdfiFi6Y=", zzrVar, i2, 61);
        this.f37709h = zzduVar.q.f37625a;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        long jLongValue = ((Long) this.f37727e.invoke(null, this.f37723a.f37634a, Boolean.valueOf(this.f37709h))).longValue();
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.L((zzaf) zzrVar.f37405b, jLongValue);
        }
    }
}
