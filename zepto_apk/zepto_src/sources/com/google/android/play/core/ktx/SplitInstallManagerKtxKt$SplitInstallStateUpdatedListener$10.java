package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$10 implements SplitInstallStateUpdatedListener {
    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(Object obj) {
        SplitInstallSessionState state = (SplitInstallSessionState) obj;
        Intrinsics.checkNotNullParameter(state, "state");
        switch (state.h()) {
            case 0:
            case 6:
                throw null;
            case 1:
                throw null;
            case 2:
                throw null;
            case 3:
                throw null;
            case 4:
                throw null;
            case 5:
                throw null;
            case 7:
                throw null;
            case 8:
                throw null;
            case 9:
                throw null;
            default:
                int iH = state.h();
                if (iH != 0 && iH != 5 && iH != 6 && iH != 7) {
                    throw null;
                }
                throw null;
        }
    }
}
