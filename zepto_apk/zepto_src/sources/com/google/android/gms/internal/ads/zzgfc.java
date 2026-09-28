package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.Method;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzgfc extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Activity f32431f;

    /* renamed from: g, reason: collision with root package name */
    public final View f32432g;

    public zzgfc(zzavs zzavsVar, zzgev zzgevVar, View view, Activity activity, zzgnc zzgncVar) {
        super("qRoTIX01TXm6ZXZVmOMKT4ZXdjMMLNGK2c/NbGGBLqG2cMg0IUL/T2oTGpQvSnC1", "ca4PDuMQK3q/+ALDD/ITco9AaE4C+BCyDm2ZesJa1q0=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.SUNRPC));
        this.f32432g = view;
        this.f32431f = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Object[] objArr = (Object[]) method.invoke("", this.f32432g, this.f32431f);
        objArr.getClass();
        synchronized (zzavsVar) {
            long jLongValue = ((Long) objArr[0]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).f0(jLongValue);
            long jLongValue2 = ((Long) objArr[1]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).g0(jLongValue2);
            String str = (String) objArr[2];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).h0(str);
        }
    }
}
