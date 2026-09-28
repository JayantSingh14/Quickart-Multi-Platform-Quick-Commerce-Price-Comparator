package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final /* synthetic */ class zzcpy implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzcpy f26877a = new zzcpy();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Bb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.f("GetTopicsApiWithRecordObservationActionHandlerUnsampled", th);
        } else {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("GetTopicsApiWithRecordObservationActionHandler", th);
        }
        zzgvs zzgvsVar = zzgtd.f33183b;
        return zzgym.a(new GetTopicsResponse(zzguy.f33232e));
    }
}
