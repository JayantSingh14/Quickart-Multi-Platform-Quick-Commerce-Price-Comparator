package com.truecaller.android.sdk.common.callVerification;

import android.annotation.TargetApi;
import android.content.Context;
import android.telecom.TelecomManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@TargetApi(28)
/* loaded from: classes4.dex */
public final class CallRejectorPieImpl implements CallRejector {

    /* renamed from: a, reason: collision with root package name */
    public final TelecomManager f47209a;

    public CallRejectorPieImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("telecom");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        this.f47209a = (TelecomManager) systemService;
    }

    @Override // com.truecaller.android.sdk.common.callVerification.CallRejector
    public final boolean a() {
        try {
            return this.f47209a.endCall();
        } catch (Exception unused) {
            return false;
        }
    }
}
