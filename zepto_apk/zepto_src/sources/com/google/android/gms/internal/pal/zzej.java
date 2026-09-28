package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzej extends zzfg {
    public zzej(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "C6OPKdOx6rUdfDdOmaUimt8yM1FrOv7bKCITdJ0Uo74WwXDfvXouJ4oz4kHBjTSk", "dTWRHHPyYq/fNXOTAS/wjayGzv2SlrSwyDcB+vX+h5Q=", zzrVar, i2, 5);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzr zzrVar = this.f37726d;
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.n0((zzaf) zzrVar.f37405b, -1L);
        zzr zzrVar2 = this.f37726d;
        if (zzrVar2.f37406c) {
            zzrVar2.k();
            zzrVar2.f37406c = false;
        }
        zzaf.o0((zzaf) zzrVar2.f37405b, -1L);
        int[] iArr = (int[]) this.f37727e.invoke(null, this.f37723a.f37634a);
        synchronized (this.f37726d) {
            try {
                zzr zzrVar3 = this.f37726d;
                long j2 = iArr[0];
                if (zzrVar3.f37406c) {
                    zzrVar3.k();
                    zzrVar3.f37406c = false;
                }
                zzaf.n0((zzaf) zzrVar3.f37405b, j2);
                zzr zzrVar4 = this.f37726d;
                long j3 = iArr[1];
                if (zzrVar4.f37406c) {
                    zzrVar4.k();
                    zzrVar4.f37406c = false;
                }
                zzaf.o0((zzaf) zzrVar4.f37405b, j3);
                int i2 = iArr[2];
                if (i2 != Integer.MIN_VALUE) {
                    zzr zzrVar5 = this.f37726d;
                    long j4 = i2;
                    if (zzrVar5.f37406c) {
                        zzrVar5.k();
                        zzrVar5.f37406c = false;
                    }
                    zzaf.J((zzaf) zzrVar5.f37405b, j4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
