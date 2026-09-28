package ch.qos.logback.core.spi;

import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public abstract class AbstractComponentTracker<C> implements ComponentTracker<C> {

    /* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements RemovalPredicator<C> {
    }

    /* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker$2, reason: invalid class name */
    public class AnonymousClass2 implements RemovalPredicator<C> {
    }

    /* renamed from: ch.qos.logback.core.spi.AbstractComponentTracker$3, reason: invalid class name */
    public class AnonymousClass3 implements RemovalPredicator<C> {
    }

    public static class Entry<C> {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "(null, null)";
        }
    }

    public interface RemovalPredicator<C> {
    }

    public AbstractComponentTracker() {
        new LinkedHashMap(32, 0.75f, true);
        new LinkedHashMap(16, 0.75f, true);
    }
}
