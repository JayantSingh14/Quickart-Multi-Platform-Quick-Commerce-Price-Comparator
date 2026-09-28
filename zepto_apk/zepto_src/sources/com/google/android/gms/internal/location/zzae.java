package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzae extends IStatusCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36624a;

    public zzae(TaskCompletionSource taskCompletionSource) {
        this.f36624a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.setResultOrApiException(status, this.f36624a);
    }
}
