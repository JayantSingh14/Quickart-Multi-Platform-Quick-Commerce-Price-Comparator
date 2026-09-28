package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzm extends com.google.android.play.core.appupdate.internal.zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f41725b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41726c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzr f41727d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzr zzrVar, String str) {
        super(taskCompletionSource);
        this.f41727d = zzrVar;
        this.f41725b = str;
        this.f41726c = taskCompletionSource2;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        TaskCompletionSource taskCompletionSource = this.f41726c;
        zzr zzrVar = this.f41727d;
        String str = this.f41725b;
        try {
            zzrVar.f41738a.f41712m.xb(zzrVar.f41739b, zzr.a(zzrVar, str), new zzq(zzrVar, taskCompletionSource, str));
        } catch (RemoteException e2) {
            zzr.f41736e.b(e2, "requestUpdateInfo(%s)", str);
            taskCompletionSource.c(new RuntimeException(e2));
        }
    }
}
