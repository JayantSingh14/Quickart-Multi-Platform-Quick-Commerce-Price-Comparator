package coil3.util;

import kotlin.Metadata;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class FileSystems_nonJsCommonKt {
    @NotNull
    public static final FileSystem defaultFileSystem() {
        return FileSystem.SYSTEM;
    }
}
