package coil3;

import coil3.util.Collections_jvmCommonKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class Extras {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final Extras EMPTY = new Builder().build();

    @NotNull
    private final Map<Key<?>, Object> data;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class Key<T> {

        @NotNull
        public static final Companion Companion = new Companion(null);

        /* renamed from: default, reason: not valid java name */
        private final T f0default;

        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Key(T t) {
            this.f0default = t;
        }

        public final T getDefault() {
            return this.f0default;
        }
    }

    public /* synthetic */ Extras(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    @NotNull
    public final Map<Key<?>, Object> asMap() {
        return this.data;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Extras) && Intrinsics.b(this.data, ((Extras) obj).data);
    }

    @Nullable
    public final <T> T get(@NotNull Key<T> key) {
        return (T) this.data.get(key);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public String toString() {
        return "Extras(data=" + this.data + ')';
    }

    @Metadata
    public static final class Builder {

        @NotNull
        private final Map<Key<?>, Object> data;

        public Builder() {
            this.data = new LinkedHashMap();
        }

        @NotNull
        public final Extras build() {
            return new Extras(Collections_jvmCommonKt.toImmutableMap(this.data), null);
        }

        @NotNull
        public final <T> Builder set(@NotNull Key<T> key, @Nullable T t) {
            if (t != null) {
                this.data.put(key, t);
                return this;
            }
            this.data.remove(key);
            return this;
        }

        @NotNull
        public final Builder setAll(@NotNull Extras extras) {
            for (Map.Entry entry : extras.data.entrySet()) {
                Key key = (Key) entry.getKey();
                Object value = entry.getValue();
                Intrinsics.d(key, "null cannot be cast to non-null type coil3.Extras.Key<kotlin.Any>");
                set(key, value);
            }
            return this;
        }

        public Builder(@NotNull Map<Key<?>, ? extends Object> map) {
            this.data = MapsKt.n(map);
        }

        public Builder(@NotNull Extras extras) {
            this.data = MapsKt.n(extras.data);
        }
    }

    private Extras(Map<Key<?>, ? extends Object> map) {
        this.data = map;
    }
}
