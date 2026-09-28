package com.facebook.react.common;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public class JavascriptException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavascriptException(String jsStackTrace) {
        super(jsStackTrace);
        Intrinsics.checkNotNullParameter(jsStackTrace, "jsStackTrace");
    }
}
