package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Serialization {

    public static final class FieldSetter<T> {
    }

    public static void a(Class cls, String str) throws SecurityException {
        try {
            cls.getDeclaredField(str).setAccessible(true);
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }
}
