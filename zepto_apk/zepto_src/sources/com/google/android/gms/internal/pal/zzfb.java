package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzfb extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f37713h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f37714i = new Object();

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        if (f37713h == null) {
            synchronized (f37714i) {
                try {
                    if (f37713h == null) {
                        f37713h = (Long) this.f37727e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            long jLongValue = f37713h.longValue();
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.C0((zzaf) zzrVar.f37405b, jLongValue);
        }
    }
}
