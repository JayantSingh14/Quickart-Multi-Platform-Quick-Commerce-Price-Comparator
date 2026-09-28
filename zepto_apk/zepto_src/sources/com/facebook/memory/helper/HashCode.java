package com.facebook.memory.helper;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class HashCode {
    public static final int a(int i2, Object obj) {
        return (i2 * 31) + (obj != null ? obj.hashCode() : 0);
    }
}
