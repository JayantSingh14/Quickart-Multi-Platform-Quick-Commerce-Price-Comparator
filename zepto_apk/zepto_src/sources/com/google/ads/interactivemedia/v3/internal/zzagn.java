package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes3.dex */
final class zzagn {
    public static Object zza(Field field, Object obj) {
        try {
            Objects.requireNonNull(field, "field");
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
