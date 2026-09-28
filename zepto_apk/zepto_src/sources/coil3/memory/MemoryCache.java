package coil3.memory;

import android.content.Context;
import coil3.Image;
import coil3.memory.MemoryCache;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.ContextsKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface MemoryCache {

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        @Nullable
        private Function0<Long> maxSizeBytesFactory;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        /* JADX INFO: Access modifiers changed from: private */
        public static final long maxSizeBytes$lambda$1$lambda$0(long j2) {
            return j2;
        }

        public static /* synthetic */ Builder maxSizePercent$default(Builder builder, Context context, double d2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                d2 = ContextsKt.defaultMemoryCacheSizePercent(context);
            }
            return builder.maxSizePercent(context, d2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long maxSizePercent$lambda$5$lambda$4(double d2, Context context) {
            return (long) (d2 * ContextsKt.totalAvailableMemoryBytes(context));
        }

        @NotNull
        public final MemoryCache build() {
            StrongMemoryCache emptyStrongMemoryCache;
            WeakMemoryCache realWeakMemoryCache = this.weakReferencesEnabled ? new RealWeakMemoryCache() : new EmptyWeakMemoryCache();
            if (this.strongReferencesEnabled) {
                Function0<Long> function0 = this.maxSizeBytesFactory;
                if (function0 == null) {
                    throw new IllegalStateException("maxSizeBytesFactory == null");
                }
                long jLongValue = ((Number) function0.invoke()).longValue();
                emptyStrongMemoryCache = jLongValue > 0 ? new RealStrongMemoryCache(jLongValue, realWeakMemoryCache) : new EmptyStrongMemoryCache(realWeakMemoryCache);
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(realWeakMemoryCache);
            }
            return new RealMemoryCache(emptyStrongMemoryCache, realWeakMemoryCache);
        }

        @NotNull
        public final Builder maxSizeBytes(final long j2) {
            this.maxSizeBytesFactory = new Function0() { // from class: coil3.memory.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(MemoryCache.Builder.maxSizeBytes$lambda$1$lambda$0(j2));
                }
            };
            return this;
        }

        @NotNull
        public final Builder maxSizePercent(@NotNull final Context context, final double d2) {
            if (0.0d > d2 || d2 > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytesFactory = new Function0() { // from class: coil3.memory.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(MemoryCache.Builder.maxSizePercent$lambda$5$lambda$4(d2, context));
                }
            };
            return this;
        }

        @NotNull
        public final Builder strongReferencesEnabled(boolean z) {
            this.strongReferencesEnabled = z;
            return this;
        }

        @NotNull
        public final Builder weakReferencesEnabled(boolean z) {
            this.weakReferencesEnabled = z;
            return this;
        }

        @NotNull
        public final Builder maxSizeBytes(@NotNull Function0<Long> function0) {
            this.maxSizeBytesFactory = function0;
            return this;
        }
    }

    @Metadata
    public static final class Key {

        @NotNull
        private final Map<String, String> extras;

        @NotNull
        private final String key;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Key(@NotNull String str) {
            this(str, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = key.key;
            }
            if ((i2 & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        @NotNull
        public final Key copy(@NotNull String str, @NotNull Map<String, String> map) {
            return new Key(str, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.b(this.key, key.key) && Intrinsics.b(this.extras, key.extras);
        }

        @NotNull
        public final Map<String, String> getExtras() {
            return this.extras;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        public int hashCode() {
            return this.extras.hashCode() + (this.key.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @JvmOverloads
        public Key(@NotNull String str, @NotNull Map<String, String> map) {
            this.key = str;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        public /* synthetic */ Key(String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? MapsKt.c() : map);
        }
    }

    @Metadata
    public static final class Value {

        @NotNull
        private final Map<String, Object> extras;

        @NotNull
        private final Image image;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Value(@NotNull Image image) {
            this(image, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, Image image, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                image = value.image;
            }
            if ((i2 & 2) != 0) {
                map = value.extras;
            }
            return value.copy(image, map);
        }

        @NotNull
        public final Value copy(@NotNull Image image, @NotNull Map<String, ? extends Object> map) {
            return new Value(image, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Intrinsics.b(this.image, value.image) && Intrinsics.b(this.extras, value.extras);
        }

        @NotNull
        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        public int hashCode() {
            return this.extras.hashCode() + (this.image.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "Value(image=" + this.image + ", extras=" + this.extras + ')';
        }

        @JvmOverloads
        public Value(@NotNull Image image, @NotNull Map<String, ? extends Object> map) {
            this.image = image;
            this.extras = Collections_jvmCommonKt.toImmutableMap(map);
        }

        public /* synthetic */ Value(Image image, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(image, (i2 & 2) != 0 ? MapsKt.c() : map);
        }
    }

    void clear();

    @Nullable
    Value get(@NotNull Key key);

    @NotNull
    Set<Key> getKeys();

    long getMaxSize();

    long getSize();

    boolean remove(@NotNull Key key);

    void set(@NotNull Key key, @NotNull Value value);

    void trimToSize(long j2);
}
