package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzcl extends IStatusCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f36644a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36645b;

    public zzcl(Boolean bool, TaskCompletionSource taskCompletionSource) {
        this.f36644a = bool;
        this.f36645b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.setResultOrApiException(status, this.f36644a, this.f36645b);
    }
}
