package coil3.disk;

import coil3.disk.DiskCache;
import java.io.File;
import kotlin.Metadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class DiskCacheKt {
    @NotNull
    public static final DiskCache.Builder directory(@NotNull DiskCache.Builder builder, @NotNull File file) {
        String str = Path.f56972b;
        return builder.directory(Path.Companion.b(file));
    }
}
