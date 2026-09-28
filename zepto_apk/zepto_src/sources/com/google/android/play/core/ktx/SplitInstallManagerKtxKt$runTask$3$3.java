package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$runTask$3$3 implements OnFailureListener {
    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        ResultKt.a(exception);
        Result.Companion companion = Result.f53538b;
        throw null;
    }
}
