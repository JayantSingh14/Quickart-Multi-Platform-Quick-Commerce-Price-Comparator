package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final /* synthetic */ class zzeth implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzeth f30274a = new zzeth();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return appSetIdInfo == null ? zzgym.a(new zzetl(null, -1)) : zzgym.a(new zzetl(appSetIdInfo.f21994a, appSetIdInfo.f21995b));
    }
}
