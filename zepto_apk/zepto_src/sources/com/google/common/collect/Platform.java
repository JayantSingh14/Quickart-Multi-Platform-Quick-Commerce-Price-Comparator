package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Platform {
    public static Object[] a(Object[] objArr, int i2, int i3, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i2, i3, objArr2.getClass());
    }

    public static Object[] b(int i2, Object[] objArr) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i2);
    }
}
