package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class bk extends bi {

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.s f41812c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ bn f41813d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f41813d = bnVar;
        this.f41812c = new com.google.android.play.integrity.internal.s("OnRequestIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, com.google.android.play.integrity.internal.k
    public final void s0(Bundle bundle) {
        super.s0(bundle);
        this.f41812c.b("onRequestExpressIntegrityToken", new Object[0]);
        ApiException apiExceptionA = this.f41813d.f41820d.a(bundle);
        TaskCompletionSource taskCompletionSource = this.f41810a;
        if (apiExceptionA != null) {
            taskCompletionSource.c(apiExceptionA);
            return;
        }
        bundle.getLong("request.token.sid");
        new bj();
        String string = bundle.getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN);
        if (string == null) {
            throw new NullPointerException("Null token");
        }
        taskCompletionSource.d(new br(string));
    }
}
