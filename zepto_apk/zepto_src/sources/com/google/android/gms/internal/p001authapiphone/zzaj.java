package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzaj extends zzl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36246a;

    public zzaj(TaskCompletionSource taskCompletionSource) {
        this.f36246a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzm
    public final void G5(Status status) {
        TaskUtil.setResultOrApiException(status, this.f36246a);
    }
}
