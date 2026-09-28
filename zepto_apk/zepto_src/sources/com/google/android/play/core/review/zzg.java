package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzt;

/* loaded from: classes4.dex */
class zzg extends com.google.android.play.core.review.internal.zzg {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.core.review.internal.zzi f41892a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f41893b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzi f41894c;

    public zzg(zzi zziVar, com.google.android.play.core.review.internal.zzi zziVar2, TaskCompletionSource taskCompletionSource) {
        this.f41894c = zziVar;
        this.f41892a = zziVar2;
        this.f41893b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.review.internal.zzh
    public void b0(Bundle bundle) {
        zzt zztVar = this.f41894c.f41896a;
        if (zztVar != null) {
            zztVar.c(this.f41893b);
        }
        this.f41892a.a("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
