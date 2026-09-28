package com.facebook.fresco.vito.source;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SingleImageSourceImpl implements SingleImageSource {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!SingleImageSourceImpl.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.SingleImageSourceImpl");
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "SingleImageSourceImpl(uri=null, extras=null)";
    }
}
