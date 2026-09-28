package coil3.target;

import coil3.Image;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Target {
    default void onError(@Nullable Image image) {
    }

    default void onStart(@Nullable Image image) {
    }

    default void onSuccess(@NotNull Image image) {
    }
}
