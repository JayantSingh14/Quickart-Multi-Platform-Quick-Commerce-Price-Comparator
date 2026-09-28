package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 implements SplitInstallStateUpdatedListener {
    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(Object obj) {
        SplitInstallSessionState state = (SplitInstallSessionState) obj;
        Intrinsics.checkNotNullParameter(state, "state");
        state.g();
        throw null;
    }
}
