package io.ktor.http;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class ContentRange {

    @Metadata
    public static final class Bounded extends ContentRange {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Bounded)) {
                return false;
            }
            ((Bounded) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return Long.hashCode(0L) + (Long.hashCode(0L) * 31);
        }

        public final String toString() {
            return "0-0";
        }
    }

    @Metadata
    public static final class Suffix extends ContentRange {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Suffix)) {
                return false;
            }
            ((Suffix) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return Long.hashCode(0L);
        }

        public final String toString() {
            return "-0";
        }
    }

    @Metadata
    public static final class TailFrom extends ContentRange {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TailFrom)) {
                return false;
            }
            ((TailFrom) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return Long.hashCode(0L);
        }

        public final String toString() {
            return "0-";
        }
    }
}
