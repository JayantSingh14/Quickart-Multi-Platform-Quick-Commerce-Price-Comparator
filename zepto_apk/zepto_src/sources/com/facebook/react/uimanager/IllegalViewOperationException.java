package com.facebook.react.uimanager;

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class IllegalViewOperationException extends JSApplicationCausedNativeException {

    /* renamed from: a, reason: collision with root package name */
    public final ReactRootView f19371a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalViewOperationException(String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalViewOperationException(String msg, ReactRootView reactRootView, StackOverflowError cause) {
        super(msg, cause);
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.f19371a = reactRootView;
    }
}
