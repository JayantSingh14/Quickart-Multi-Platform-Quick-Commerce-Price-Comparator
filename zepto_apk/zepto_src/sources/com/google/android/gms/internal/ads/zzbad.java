package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;

/* loaded from: classes4.dex */
public final class zzbad extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final Activity f24626h;

    /* renamed from: i, reason: collision with root package name */
    public final View f24627i;

    public zzbad(zzazt zzaztVar, zzavs zzavsVar, int i2, View view, Activity activity) {
        super(zzaztVar, "YJMz4lZ/SFOXN6kW19UKnvAqcLtndNv4f6er9d24/5MuXcrsMTIC+9Jfbhpe2HMW", "6iuDHA2XEqaGCIdpenyLvoYWzHjKpoW5EjYN40bz5Cs=", zzavsVar, i2, 62);
        this.f24627i = view;
        this.f24626h = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        View view = this.f24627i;
        if (view == null) {
            return;
        }
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.e3);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.f24673e.invoke(null, view, this.f24626h, bool);
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            try {
                long jLongValue = ((Long) objArr[0]).longValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).f0(jLongValue);
                long jLongValue2 = ((Long) objArr[1]).longValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).g0(jLongValue2);
                if (zBooleanValue) {
                    String str = (String) objArr[2];
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).h0(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
