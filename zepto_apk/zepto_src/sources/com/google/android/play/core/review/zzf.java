package com.google.android.play.core.review;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzf extends com.google.android.play.core.review.internal.zzj {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41890b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzi f41891c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(zzi zziVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f41891c = zziVar;
        this.f41890b = taskCompletionSource2;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        TaskCompletionSource taskCompletionSource = this.f41890b;
        zzi zziVar = this.f41891c;
        try {
            zziVar.f41896a.f41881m.Ub(zziVar.f41897b, zzj.a(), new zzh(zziVar, new com.google.android.play.core.review.internal.zzi("OnRequestInstallCallback"), taskCompletionSource));
        } catch (RemoteException e2) {
            com.google.android.play.core.review.internal.zzi zziVar2 = zzi.f41895c;
            Object[] objArr = {zziVar.f41897b};
            zziVar2.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", com.google.android.play.core.review.internal.zzi.b(zziVar2.f41857a, "error requesting in-app review for %s", objArr), e2);
            }
            taskCompletionSource.c(new RuntimeException(e2));
        }
    }
}
