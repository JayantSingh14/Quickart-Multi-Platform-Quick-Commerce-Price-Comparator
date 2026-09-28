package org.shadow.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Class f57761a;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.f57761a.equals(((MutableObject) obj).f57761a);
        }
        return false;
    }

    public final int hashCode() {
        Class cls = this.f57761a;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public final String toString() {
        Class cls = this.f57761a;
        return cls == null ? "null" : cls.toString();
    }
}
