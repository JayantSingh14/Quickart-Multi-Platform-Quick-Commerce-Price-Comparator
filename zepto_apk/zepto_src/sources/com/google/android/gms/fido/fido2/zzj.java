package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzj extends com.google.android.gms.internal.fido.zzd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f22471a;

    public zzj(TaskCompletionSource taskCompletionSource) {
        this.f22471a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void M0(Status status) {
        this.f22471a.c(new ApiException(status));
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void h3(boolean z) {
        this.f22471a.b(Boolean.valueOf(z));
    }
}
