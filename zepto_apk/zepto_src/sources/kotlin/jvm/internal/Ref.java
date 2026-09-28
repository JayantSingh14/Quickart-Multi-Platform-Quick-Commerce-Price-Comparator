package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Ref {

    /* loaded from: classes.dex */
    public static final class BooleanRef implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f53798a;

        public final String toString() {
            return String.valueOf(this.f53798a);
        }
    }

    public static final class ByteRef implements Serializable {
        public final String toString() {
            return String.valueOf(0);
        }
    }

    public static final class CharRef implements Serializable {
        public final String toString() {
            return String.valueOf((char) 0);
        }
    }

    public static final class DoubleRef implements Serializable {
        public final String toString() {
            return String.valueOf(0.0d);
        }
    }

    public static final class FloatRef implements Serializable {
        public final String toString() {
            return String.valueOf(0.0f);
        }
    }

    /* loaded from: classes.dex */
    public static final class IntRef implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public int f53799a;

        public final String toString() {
            return String.valueOf(this.f53799a);
        }
    }

    /* loaded from: classes.dex */
    public static final class LongRef implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public long f53800a;

        public final String toString() {
            return String.valueOf(this.f53800a);
        }
    }

    /* loaded from: classes.dex */
    public static final class ObjectRef<T> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Object f53801a;

        public final String toString() {
            return String.valueOf(this.f53801a);
        }
    }

    public static final class ShortRef implements Serializable {
        public final String toString() {
            return String.valueOf(0);
        }
    }
}
