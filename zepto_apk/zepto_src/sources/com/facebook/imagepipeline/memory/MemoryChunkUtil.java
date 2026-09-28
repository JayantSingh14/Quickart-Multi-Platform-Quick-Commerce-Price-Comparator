package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class MemoryChunkUtil {
    public static final int a(int i2, int i3, int i4) {
        return Math.min(Math.max(0, i4 - i2), i3);
    }

    public static final void b(int i2, int i3, int i4, int i5, int i6) {
        Preconditions.c(i5 >= 0, "count (%d) ! >= 0", Integer.valueOf(i5));
        Preconditions.c(i2 >= 0, "offset (%d) ! >= 0", Integer.valueOf(i2));
        Preconditions.c(i4 >= 0, "otherOffset (%d) ! >= 0", Integer.valueOf(i4));
        Preconditions.c(i2 + i5 <= i6, "offset (%d) + count (%d) ! <= %d", Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i6));
        Preconditions.c(i4 + i5 <= i3, "otherOffset (%d) + count (%d) ! <= %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3));
    }
}
