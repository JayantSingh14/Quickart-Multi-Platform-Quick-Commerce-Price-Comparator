package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfpd implements zzgpr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzfpd f31536a = new zzfpd();

    @Override // com.google.android.gms.internal.ads.zzgpr
    public final Object apply(Object obj) {
        String str = ((zzfid) obj).f31195a;
        return TextUtils.isEmpty(str) ? "" : com.google.android.gms.ads.internal.util.client.zzl.e() ? "fakeForAdDebugLog" : str;
    }
}
