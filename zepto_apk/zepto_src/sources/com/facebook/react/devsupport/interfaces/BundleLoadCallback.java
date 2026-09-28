package com.facebook.react.devsupport.interfaces;

import com.facebook.react.common.DebugServerException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public interface BundleLoadCallback {
    default void b(DebugServerException cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    void onSuccess();
}
