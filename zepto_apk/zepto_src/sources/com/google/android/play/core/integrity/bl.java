package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class bl extends bi {

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.s f41814c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ bn f41815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f41815d = bnVar;
        this.f41814c = new com.google.android.play.integrity.internal.s("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, com.google.android.play.integrity.internal.k
    public final void P9(Bundle bundle) {
        super.P9(bundle);
        this.f41814c.b("onWarmUpExpressIntegrityToken", new Object[0]);
        ApiException apiExceptionA = this.f41815d.f41820d.a(bundle);
        TaskCompletionSource taskCompletionSource = this.f41810a;
        if (apiExceptionA != null) {
            taskCompletionSource.c(apiExceptionA);
        } else {
            taskCompletionSource.d(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
