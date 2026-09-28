package com.facebook.fresco.vito.source;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BitmapImageSource implements ImageSource {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!BitmapImageSource.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.BitmapImageSource");
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "BitmapImageSource(bitmap=null)";
    }
}
