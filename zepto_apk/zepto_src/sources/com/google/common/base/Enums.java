package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.WeakHashMap;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Enums {

    @GwtIncompatible
    public static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        @Override // com.google.common.base.Converter
        public final Object b(Object obj) {
            return Enum.valueOf(null, (String) obj);
        }

        @Override // com.google.common.base.Function
        public final boolean equals(Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            ((StringConverter) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    static {
        new WeakHashMap();
    }
}
