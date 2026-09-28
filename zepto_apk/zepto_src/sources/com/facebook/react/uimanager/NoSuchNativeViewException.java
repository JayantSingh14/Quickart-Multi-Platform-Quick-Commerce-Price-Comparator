package com.facebook.react.uimanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NoSuchNativeViewException extends IllegalViewOperationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchNativeViewException(String detailMessage) {
        super(detailMessage);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
    }
}
