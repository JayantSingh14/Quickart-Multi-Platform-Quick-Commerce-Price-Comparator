package com.google.android.gms.internal.pal;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzfa extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final zzeb f37711h;

    /* renamed from: i, reason: collision with root package name */
    public final long f37712i;

    public zzfa(zzdu zzduVar, zzr zzrVar, int i2, zzeb zzebVar) {
        super(zzduVar, "mkunJHFc5vhTAVOcsaNSYx7OvFB6slgbORGrA/joIDO0IYq5rQvDcAbp2AI6CPUh", "k8GEQUoJxJPI/0jAlfeUix8QD7WaaXAfMcSQAzrpgrU=", zzrVar, i2, 53);
        this.f37711h = zzebVar;
        if (zzebVar != null) {
            if (zzebVar.f37680l <= -2) {
                WeakReference weakReference = zzebVar.f37676h;
                if ((weakReference != null ? (View) weakReference.get() : null) == null) {
                    zzebVar.f37680l = -3L;
                }
            }
            this.f37712i = zzebVar.f37680l;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        if (this.f37711h != null) {
            long jLongValue = ((Long) this.f37727e.invoke(null, Long.valueOf(this.f37712i))).longValue();
            zzr zzrVar = this.f37726d;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.D((zzaf) zzrVar.f37405b, jLongValue);
        }
    }
}
