package coil3.disk;

import coil3.decode.b;
import coil3.disk.DiskCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class UtilsKt {

    @NotNull
    private static final Lazy instance$delegate = LazyKt.b(new b(1));

    private static final DiskCache getInstance() {
        return (DiskCache) instance$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiskCache instance_delegate$lambda$0() {
        return new DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY.e("coil3_disk_cache")).build();
    }

    @Nullable
    public static final DiskCache singletonDiskCache() {
        return getInstance();
    }
}
