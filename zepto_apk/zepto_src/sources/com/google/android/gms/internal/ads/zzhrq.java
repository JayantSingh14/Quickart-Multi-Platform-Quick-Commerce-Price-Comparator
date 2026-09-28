package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrq implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrq f34127a = new zzhrq();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) {
        zzhro zzhroVar = (zzhro) zzhanVar;
        zzhjs zzhjsVar = zzhru.f34131a;
        byte[] bArrA = zzhkc.a(32);
        if (bArrA.length != 32) {
            throw new IllegalArgumentException("Given secret seed length is not 32");
        }
        return zzhrp.d(zzhrv.d(zzhroVar.f34124a, zzhxc.a(Arrays.copyOf(zzhhm.a(zzhhm.b(bArrA)), 32)), num), zzhxe.a(Arrays.copyOf(bArrA, bArrA.length)));
    }
}
