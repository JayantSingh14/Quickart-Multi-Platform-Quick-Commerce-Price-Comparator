package com.swmansion.rnscreens.bottomsheet;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class SheetUtils {
    public static int a(int i2, int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalArgumentException(android.support.v4.media.b.d(i3, i2, "[RNScreens] Invalid detentCount/index combination ", " / "));
                }
                if (i2 == -1) {
                    return 5;
                }
                if (i2 == 0) {
                    return 4;
                }
                if (i2 == 1) {
                    return 6;
                }
                if (i2 != 2) {
                    throw new IllegalArgumentException(android.support.v4.media.b.d(i3, i2, "[RNScreens] Invalid detentCount/index combination ", " / "));
                }
            } else {
                if (i2 == -1) {
                    return 5;
                }
                if (i2 == 0) {
                    return 4;
                }
                if (i2 != 1) {
                    throw new IllegalArgumentException(android.support.v4.media.b.d(i3, i2, "[RNScreens] Invalid detentCount/index combination ", " / "));
                }
            }
        } else {
            if (i2 == -1) {
                return 5;
            }
            if (i2 != 0) {
                throw new IllegalArgumentException(android.support.v4.media.b.d(i3, i2, "[RNScreens] Invalid detentCount/index combination ", " / "));
            }
        }
        return 3;
    }
}
