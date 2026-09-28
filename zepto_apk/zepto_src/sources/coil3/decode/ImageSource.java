package coil3.decode;

import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata
/* loaded from: classes.dex */
public interface ImageSource extends AutoCloseable {

    @kotlin.Metadata
    /* loaded from: classes3.dex */
    public static abstract class Metadata {
    }

    @NotNull
    Path file();

    @Nullable
    Path fileOrNull();

    @NotNull
    FileSystem getFileSystem();

    @Nullable
    Metadata getMetadata();

    @NotNull
    BufferedSource source();

    @Nullable
    BufferedSource sourceOrNull();
}
