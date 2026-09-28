package com.facebook.fresco.ui.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DimensionsInfo {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!DimensionsInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.fresco.ui.common.DimensionsInfo");
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "DimensionsInfo(viewportWidth=0, viewportHeight=0, encodedImageWidth=0, encodedImageHeight=0, decodedImageWidth=0, decodedImageHeight=0, scaleType=null)";
    }
}
