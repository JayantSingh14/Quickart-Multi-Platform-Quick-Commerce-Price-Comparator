package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NoopPrinter implements Printer {

    /* renamed from: a, reason: collision with root package name */
    public static final NoopPrinter f17189a = new NoopPrinter();

    public final void a(DebugOverlayTag tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
