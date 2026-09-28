package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
class zzj extends zzan {

    /* renamed from: a, reason: collision with root package name */
    public final zzl f22032a;

    public zzj(zzl zzlVar) {
        this.f22032a = zzlVar;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void Y6(Status status) {
        TaskCompletionSource taskCompletionSource = this.f22032a.f22033a;
        int i2 = AccountTransferClient.f22025a;
        taskCompletionSource.a(new AccountTransferException(status));
    }
}
