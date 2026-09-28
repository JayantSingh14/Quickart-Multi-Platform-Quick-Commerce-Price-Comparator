package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzbn extends zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36304a;

    public zzbn(TaskCompletionSource taskCompletionSource) {
        this.f36304a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void o(String str) {
        TaskUtil.setResultOrApiException(str != null ? Status.RESULT_SUCCESS : new Status(3006), str, this.f36304a);
    }
}
