package org.shadow.apache.commons.lang3.reflect;

import java.lang.reflect.TypeVariable;

/* loaded from: classes5.dex */
public abstract class TypeLiteral<T> implements Typed<T> {
    static {
        TypeVariable typeVariable = TypeLiteral.class.getTypeParameters()[0];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeLiteral)) {
            return false;
        }
        ((TypeLiteral) obj).getClass();
        return TypeUtils.d(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return null;
    }
}
