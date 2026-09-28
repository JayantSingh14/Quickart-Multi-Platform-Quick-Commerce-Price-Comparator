package com.google.android.gms.internal.ads;

import android.util.Base64;

/* loaded from: classes4.dex */
final /* synthetic */ class zzpa implements zzgqs {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzpa f35282a = new zzpa();

    @Override // com.google.android.gms.internal.ads.zzgqs
    public final Object zza() {
        byte[] bArr = new byte[12];
        zzpc.f35291i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }
}
