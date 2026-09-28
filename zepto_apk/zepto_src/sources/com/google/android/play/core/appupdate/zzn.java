package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzn extends com.google.android.play.core.appupdate.internal.zzn {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f41728b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f41729c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzr f41730d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzr zzrVar, String str) {
        super(taskCompletionSource);
        this.f41730d = zzrVar;
        this.f41728b = taskCompletionSource2;
        this.f41729c = str;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        TaskCompletionSource taskCompletionSource = this.f41728b;
        zzr zzrVar = this.f41730d;
        try {
            zzrVar.f41738a.f41712m.Ra(zzrVar.f41739b, zzr.b(), new zzp(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnCompleteUpdateCallback"), taskCompletionSource));
        } catch (RemoteException e2) {
            zzr.f41736e.b(e2, "completeUpdate(%s)", this.f41729c);
            taskCompletionSource.c(new RuntimeException(e2));
        }
    }
}
