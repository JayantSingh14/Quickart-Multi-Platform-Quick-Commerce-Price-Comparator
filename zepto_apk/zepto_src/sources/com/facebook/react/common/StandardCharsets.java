package com.facebook.react.common;

import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public final class StandardCharsets {
    static {
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-8"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "forName(...)");
    }
}
