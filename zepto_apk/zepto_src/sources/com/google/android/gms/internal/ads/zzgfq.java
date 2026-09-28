package com.google.android.gms.internal.ads;

import android.net.NetworkCapabilities;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgfq extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Map f32476f;

    public zzgfq(zzavs zzavsVar, zzgev zzgevVar, Map map, zzgnc zzgncVar) {
        super("HfOLt/75P0inB1ACQtpmoZ+1+wQRBgHtknW9eFeTyv4KW5Suh8LSIOlyCgysGkTB", "H5oaXmgEE2ioSjZtswlhWck6Iz70pHSCwKmqgx59qOA=", zzavsVar, zzgevVar, zzgncVar.a(118));
        this.f32476f = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Map map = this.f32476f;
        Object[] objArr = (Object[]) method.invoke("", (NetworkCapabilities) map.get("ntc"), (Long) map.get("vs"), (Long) map.get("vf"));
        objArr.getClass();
        synchronized (zzavsVar) {
            long jLongValue = ((Long) objArr[0]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).M0(jLongValue);
            long jLongValue2 = ((Long) objArr[1]).longValue();
            if (jLongValue2 >= 0) {
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).j0(jLongValue2);
            }
            long jLongValue3 = ((Long) objArr[2]).longValue();
            if (jLongValue3 >= 0) {
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).k0(jLongValue3);
            }
        }
    }
}
