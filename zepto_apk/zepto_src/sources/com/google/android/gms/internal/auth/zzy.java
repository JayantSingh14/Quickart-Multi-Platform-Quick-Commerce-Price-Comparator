package com.google.android.gms.internal.auth;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzy extends zzj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36449a;

    public zzy(TaskCompletionSource taskCompletionSource) {
        this.f36449a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth.zzk
    public final void W5(Status status, Bundle bundle) {
        zzab.b(status, bundle, this.f36449a);
    }
}
