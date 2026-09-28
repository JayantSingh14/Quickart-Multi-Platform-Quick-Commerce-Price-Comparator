package androidx.work.impl.constraints;

import android.support.v4.media.b;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class ConstraintsState {

    @Metadata
    public static final class ConstraintsMet extends ConstraintsState {

        /* renamed from: a, reason: collision with root package name */
        public static final ConstraintsMet f12795a = new ConstraintsMet();
    }

    @Metadata
    public static final class ConstraintsNotMet extends ConstraintsState {

        /* renamed from: a, reason: collision with root package name */
        public final int f12796a;

        public ConstraintsNotMet(int i2) {
            this.f12796a = i2;
        }

        public final int a() {
            return this.f12796a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.f12796a == ((ConstraintsNotMet) obj).f12796a;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f12796a);
        }

        public final String toString() {
            return b.n(new StringBuilder("ConstraintsNotMet(reason="), this.f12796a, ')');
        }
    }
}
