package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzek extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f37694h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f37695i = new Object();

    public zzek(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "XFxH1z0dBuMDP7aWA+P/3WKwW9qr8sC2ASjEfciaKHfSLryjCNl4cmJgfsh2Tylb", "r0MNv9zqwvoUwASL1pBJjOA1OkDa8Kcs5NaA6VOkJEI=", zzrVar, i2, 44);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        if (f37694h == null) {
            synchronized (f37695i) {
                try {
                    if (f37694h == null) {
                        f37694h = (Long) this.f37727e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            long jLongValue = f37694h.longValue();
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.w((zzaf) zzrVar.f37405b, jLongValue);
        }
    }
}
