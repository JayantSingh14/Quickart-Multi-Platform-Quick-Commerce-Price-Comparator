package com.facebook.imagepipeline.transcoder;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImageTranscodeResult {

    /* renamed from: a, reason: collision with root package name */
    public final int f18384a;

    public ImageTranscodeResult(int i2) {
        this.f18384a = i2;
    }

    public final String toString() {
        String str = String.format(null, "Status: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f18384a)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
