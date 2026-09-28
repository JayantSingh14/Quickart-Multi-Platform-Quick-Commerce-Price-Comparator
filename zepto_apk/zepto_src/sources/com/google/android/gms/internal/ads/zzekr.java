package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzekr implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f29565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29566b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzekt f29567c;

    public zzekr(zzekt zzektVar, zzcdt zzcdtVar, zzfhr zzfhrVar) {
        this.f29565a = zzcdtVar;
        this.f29566b = zzfhrVar;
        Objects.requireNonNull(zzektVar);
        this.f29567c = zzektVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) {
        try {
            com.google.android.gms.ads.internal.overlay.zzn zznVar = com.google.android.gms.ads.internal.zzt.C.f21678b;
            com.google.android.gms.ads.internal.overlay.zzn.a(context, (AdOverlayInfoParcel) this.f29565a.f25992a.get(), true, this.f29567c.f29577e);
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29566b;
    }
}
