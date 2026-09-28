package com.google.android.gms.internal.atv_ads_framework;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzfr extends zzfp {
    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final int a(Object obj) {
        zzfq zzfqVar = (zzfq) obj;
        int i2 = zzfqVar.f36204c;
        if (i2 != -1) {
            return i2;
        }
        zzfqVar.f36204c = 0;
        return 0;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final int b(Object obj) {
        zzfq zzfqVar = (zzfq) obj;
        int i2 = zzfqVar.f36204c;
        if (i2 != -1) {
            return i2;
        }
        zzfqVar.f36204c = 0;
        return 0;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final /* synthetic */ zzfq c(Object obj) {
        return ((zzdh) obj).zzc;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final Object d(Object obj, Object obj2) {
        zzfq zzfqVar = zzfq.f36201e;
        if (!zzfqVar.equals(obj2)) {
            if (zzfqVar.equals(obj)) {
                zzfq zzfqVar2 = (zzfq) obj2;
                zzfq zzfqVar3 = (zzfq) obj;
                zzfqVar3.getClass();
                zzfqVar2.getClass();
                int[] iArrCopyOf = Arrays.copyOf(zzfqVar3.f36202a, 0);
                System.arraycopy(zzfqVar2.f36202a, 0, iArrCopyOf, 0, 0);
                Object[] objArrCopyOf = Arrays.copyOf(zzfqVar3.f36203b, 0);
                System.arraycopy(zzfqVar2.f36203b, 0, objArrCopyOf, 0, 0);
                return new zzfq(iArrCopyOf, objArrCopyOf, true);
            }
            zzfq zzfqVar4 = (zzfq) obj2;
            zzfq zzfqVar5 = (zzfq) obj;
            zzfqVar5.getClass();
            if (!zzfqVar4.equals(zzfqVar)) {
                if (!zzfqVar5.f36205d) {
                    throw new UnsupportedOperationException();
                }
                int[] iArr = zzfqVar5.f36202a;
                int length = iArr.length;
                System.arraycopy(zzfqVar4.f36202a, 0, iArr, 0, 0);
                System.arraycopy(zzfqVar4.f36203b, 0, zzfqVar5.f36203b, 0, 0);
                return obj;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final void e(Object obj) {
        zzfq zzfqVar = ((zzdh) obj).zzc;
        if (zzfqVar.f36205d) {
            zzfqVar.f36205d = false;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfp
    public final /* synthetic */ void f(Object obj, Object obj2) {
        ((zzdh) obj).zzc = (zzfq) obj2;
    }
}
