package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzacg implements zzbs {

    /* renamed from: a, reason: collision with root package name */
    public final zzbq f22714a = new zzacf();

    @Override // com.google.android.gms.internal.ads.zzbs
    public final zzbu a(Context context, zzi zziVar, zzbt zzbtVar, Executor executor) {
        try {
            return ((zzbs) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(zzbq.class).newInstance(this.f22714a)).a(context, zziVar, zzbtVar, executor);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }
}
