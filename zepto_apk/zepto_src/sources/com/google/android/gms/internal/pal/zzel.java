package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzel extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final long f37696h;

    public zzel(zzdu zzduVar, zzr zzrVar, long j2, int i2) {
        super(zzduVar, "zwwnNjW/9dn+p0q/2u+mmA6XQB8+gtknmtJMKP3tBmoncBehPCILsKxRnck9yFjA", "vpqgk7W2OO4+emKKnTSxckIsP1c64LGVSWcdsnDvr3w=", zzrVar, i2, 25);
        this.f37696h = j2;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        long jLongValue = ((Long) this.f37727e.invoke(null, null)).longValue();
        synchronized (this.f37726d) {
            try {
                zzr zzrVar = this.f37726d;
                if (zzrVar.f37406c) {
                    zzrVar.k();
                    zzrVar.f37406c = false;
                }
                zzaf.Y((zzaf) zzrVar.f37405b, jLongValue);
                long j2 = this.f37696h;
                if (j2 != 0) {
                    zzr zzrVar2 = this.f37726d;
                    long j3 = jLongValue - j2;
                    if (zzrVar2.f37406c) {
                        zzrVar2.k();
                        zzrVar2.f37406c = false;
                    }
                    zzaf.u0((zzaf) zzrVar2.f37405b, j3);
                    zzr zzrVar3 = this.f37726d;
                    long j4 = this.f37696h;
                    if (zzrVar3.f37406c) {
                        zzrVar3.k();
                        zzrVar3.f37406c = false;
                    }
                    zzaf.x0((zzaf) zzrVar3.f37405b, j4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
