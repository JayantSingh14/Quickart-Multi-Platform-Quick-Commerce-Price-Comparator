package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$3 extends Lambda implements Function1<SplitInstallSessionState, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SplitInstallSessionState it = (SplitInstallSessionState) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f53572a;
    }
}
