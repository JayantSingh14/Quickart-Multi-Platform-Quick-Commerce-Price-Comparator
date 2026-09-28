package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfpc implements zzgpr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzfpc f31535a = new zzfpc();

    @Override // com.google.android.gms.internal.ads.zzgpr
    public final Object apply(Object obj) {
        String str = ((zzfid) obj).f31196b;
        return TextUtils.isEmpty(str) ? "" : com.google.android.gms.ads.internal.util.client.zzl.e() ? "fakeForAdDebugLog" : str;
    }
}
