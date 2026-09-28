package com.facebook.fresco.vito.source;

import android.support.v4.media.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FirstAvailableImageSource implements ImageSource {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!FirstAvailableImageSource.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.FirstAvailableImageSource");
        return Arrays.equals((Object[]) null, (Object[]) null);
    }

    public final int hashCode() {
        return Arrays.hashCode((Object[]) null);
    }

    public final String toString() {
        return b.D("FirstAvailableImageSource(imageSources=", Arrays.toString((Object[]) null), ")");
    }
}
