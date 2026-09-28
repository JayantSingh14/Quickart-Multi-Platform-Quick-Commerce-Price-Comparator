package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
class zzo extends com.google.android.play.core.appupdate.internal.zzg {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.core.appupdate.internal.zzm f41731a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f41732b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f41733c;

    public zzo(zzr zzrVar, com.google.android.play.core.appupdate.internal.zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.f41733c = zzrVar;
        this.f41731a = zzmVar;
        this.f41732b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void b0(Bundle bundle) {
        this.f41733c.f41738a.d(this.f41732b);
        this.f41731a.c("onCompleteUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzc(Bundle bundle) {
        this.f41733c.f41738a.d(this.f41732b);
        this.f41731a.c("onRequestInfo", new Object[0]);
    }
}
