package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class Preferences {

    @Metadata
    public static final class Key<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f3725a;

        public Key(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f3725a = name;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            return Intrinsics.b(this.f3725a, ((Key) obj).f3725a);
        }

        public final int hashCode() {
            return this.f3725a.hashCode();
        }

        public final String toString() {
            return this.f3725a;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Pair<T> {
    }

    public abstract Map a();

    public abstract Object b(Key key);
}
