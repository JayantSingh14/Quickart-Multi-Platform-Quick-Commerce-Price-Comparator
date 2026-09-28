package com.facebook.imageutils;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class JfifUtil {
    public static final int a(int i2) {
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        if (i2 == 3) {
            return 180;
        }
        if (i2 != 6) {
            return i2 != 8 ? 0 : 270;
        }
        return 90;
    }
}
