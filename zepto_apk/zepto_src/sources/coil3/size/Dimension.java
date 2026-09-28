package coil3.size;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Dimension {

    @Metadata
    @JvmInline
    @SourceDebugExtension
    public static final class Pixels implements Dimension {
        private final int px;

        private /* synthetic */ Pixels(int i2) {
            this.px = i2;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Pixels m36boximpl(int i2) {
            return new Pixels(i2);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m37constructorimpl(int i2) {
            if (i2 > 0) {
                return i2;
            }
            throw new IllegalArgumentException("px must be > 0.");
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m38equalsimpl(int i2, Object obj) {
            return (obj instanceof Pixels) && i2 == ((Pixels) obj).m42unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m39equalsimpl0(int i2, int i3) {
            return i2 == i3;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m40hashCodeimpl(int i2) {
            return Integer.hashCode(i2);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m41toStringimpl(int i2) {
            return "Pixels(px=" + i2 + ')';
        }

        public boolean equals(Object obj) {
            return m38equalsimpl(this.px, obj);
        }

        public final int getPx() {
            return this.px;
        }

        public int hashCode() {
            return m40hashCodeimpl(this.px);
        }

        public String toString() {
            return m41toStringimpl(this.px);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m42unboximpl() {
            return this.px;
        }
    }

    @Metadata
    public static final class Undefined implements Dimension {

        @NotNull
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof Undefined);
        }

        public int hashCode() {
            return -2093724603;
        }

        @NotNull
        public String toString() {
            return "Undefined";
        }
    }
}
