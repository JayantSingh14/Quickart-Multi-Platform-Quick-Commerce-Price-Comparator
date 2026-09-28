package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzep extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f37701h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f37702i = new Object();

    public zzep(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "N0mA2OgFUnHXhnZTWHrO10/LZw/fChWm76LMkbZzvR9G3lxQkMoE65IWMn9zBWSu", "uxIInGM9FQ+1gujg5A7z9IJxIqStl6tvqqzSbuEi494=", zzrVar, i2, 22);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        if (f37701h == null) {
            synchronized (f37702i) {
                try {
                    if (f37701h == null) {
                        f37701h = (Long) this.f37727e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            long jLongValue = f37701h.longValue();
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.w0((zzaf) zzrVar.f37405b, jLongValue);
        }
    }
}
