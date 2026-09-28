package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdmy implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f27988a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdnh f27989b;

    public zzdmy(zzdnh zzdnhVar, View view) {
        this.f27988a = view;
        Objects.requireNonNull(zzdnhVar);
        this.f27989b = zzdnhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d6)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("omid native display exp", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        this.f27989b.n(this.f27988a, (zzejb) obj);
    }
}
