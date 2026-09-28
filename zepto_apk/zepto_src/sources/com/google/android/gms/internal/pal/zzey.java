package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzey extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final StackTraceElement[] f37710h;

    public zzey(zzdu zzduVar, zzr zzrVar, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzduVar, "d2tnKFzXPwiZyQGi+81r0jKuUmc/wF2bs8mf3rZLUgisIeswnimQDm/skPYjpEo4", "e/DvqiTz4SkFtBEBn/3V8Pr2h2slHO4xuLOBAItCJ4w=", zzrVar, i2, 45);
        this.f37710h = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        StackTraceElement[] stackTraceElementArr = this.f37710h;
        if (stackTraceElementArr != null) {
            zzdn zzdnVar = new zzdn((String) this.f37727e.invoke(null, stackTraceElementArr));
            synchronized (this.f37726d) {
                try {
                    zzr zzrVar = this.f37726d;
                    long jLongValue = zzdnVar.f37622a.longValue();
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.x((zzaf) zzrVar.f37405b, jLongValue);
                    if (zzdnVar.f37623b.booleanValue()) {
                        zzr zzrVar2 = this.f37726d;
                        int i2 = true != zzdnVar.f37624c.booleanValue() ? 2 : 1;
                        if (zzrVar2.f37406c) {
                            zzrVar2.k();
                            zzrVar2.f37406c = false;
                        }
                        zzaf.d0((zzaf) zzrVar2.f37405b, i2);
                    } else {
                        zzr zzrVar3 = this.f37726d;
                        if (zzrVar3.f37406c) {
                            zzrVar3.k();
                            zzrVar3.f37406c = false;
                        }
                        zzaf.d0((zzaf) zzrVar3.f37405b, 3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
