package coil3;

import coil3.Extras;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ExtrasKt {
    public static final <T> T getExtra(@NotNull ImageRequest imageRequest, @NotNull Extras.Key<T> key) {
        T t = (T) imageRequest.getExtras().get(key);
        if (t != null) {
            return t;
        }
        T t2 = (T) imageRequest.getDefaults().getExtras().get(key);
        return t2 == null ? key.getDefault() : t2;
    }

    public static final <T> T getOrDefault(@NotNull Extras extras, @NotNull Extras.Key<T> key) {
        T t = (T) extras.get(key);
        return t == null ? key.getDefault() : t;
    }

    @NotNull
    public static final Extras orEmpty(@Nullable Extras extras) {
        return extras == null ? Extras.EMPTY : extras;
    }

    @NotNull
    public static final Extras plus(@NotNull Extras extras, @NotNull Extras extras2) {
        return new Extras.Builder(MapsKt.j(extras.asMap(), extras2.asMap())).build();
    }

    public static final <T> T getExtra(@NotNull Options options, @NotNull Extras.Key<T> key) {
        T t = (T) options.getExtras().get(key);
        return t == null ? key.getDefault() : t;
    }
}
