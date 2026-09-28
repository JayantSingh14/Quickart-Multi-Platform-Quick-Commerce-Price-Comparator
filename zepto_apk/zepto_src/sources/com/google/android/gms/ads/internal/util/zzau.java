package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzdm;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzau extends zzdm {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f21498a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzax f21499b;

    public zzau(zzax zzaxVar, Context context) {
        this.f21498a = context;
        Objects.requireNonNull(zzaxVar);
        this.f21499b = zzaxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void x0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        Context context = this.f21498a;
        this.f21499b.i(zzeVar.f21162b, context, true, true);
    }
}
