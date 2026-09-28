package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.view.View;

/* loaded from: classes4.dex */
public final class zzee extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final Activity f37687h;

    /* renamed from: i, reason: collision with root package name */
    public final View f37688i;

    public zzee(zzdu zzduVar, zzr zzrVar, int i2, View view, Activity activity) {
        super(zzduVar, "uJ6tafbdnitpIiJcEDt3zh4lzBZEYeFsW45S60suhbKyZNy2K2MuNEbuksualim4", "Cv/m6MvBjdOit7tT7cC+xPCpFEqovwYj4XIOcXUxCMs=", zzrVar, i2, 62);
        this.f37688i = view;
        this.f37687h = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        if (this.f37688i == null) {
            return;
        }
        Boolean bool = (Boolean) zzfv.f37741d.f37744c.a(zzgk.f37772i);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.f37727e.invoke(null, this.f37688i, this.f37687h, bool);
        synchronized (this.f37726d) {
            try {
                zzr zzrVar = this.f37726d;
                long jLongValue = ((Long) objArr[0]).longValue();
                if (zzrVar.f37406c) {
                    zzrVar.k();
                    zzrVar.f37406c = false;
                }
                zzaf.M((zzaf) zzrVar.f37405b, jLongValue);
                zzr zzrVar2 = this.f37726d;
                long jLongValue2 = ((Long) objArr[1]).longValue();
                if (zzrVar2.f37406c) {
                    zzrVar2.k();
                    zzrVar2.f37406c = false;
                }
                zzaf.N((zzaf) zzrVar2.f37405b, jLongValue2);
                if (zBooleanValue) {
                    zzr zzrVar3 = this.f37726d;
                    String str = (String) objArr[2];
                    if (zzrVar3.f37406c) {
                        zzrVar3.k();
                        zzrVar3.f37406c = false;
                    }
                    zzaf.O((zzaf) zzrVar3.f37405b, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
