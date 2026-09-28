package coil3.decode;

import coil3.decode.ImageSource;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ImageSourceKt {
    @NotNull
    public static final ImageSource ImageSource(@NotNull Path path, @NotNull FileSystem fileSystem, @Nullable String str, @Nullable AutoCloseable autoCloseable, @Nullable ImageSource.Metadata metadata) {
        return new FileImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    public static /* synthetic */ ImageSource ImageSource$default(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            autoCloseable = null;
        }
        if ((i2 & 16) != 0) {
            metadata = null;
        }
        return ImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    @NotNull
    public static final ImageSource ImageSource(@NotNull BufferedSource bufferedSource, @NotNull FileSystem fileSystem, @Nullable ImageSource.Metadata metadata) {
        return new SourceImageSource(bufferedSource, fileSystem, metadata);
    }

    public static /* synthetic */ ImageSource ImageSource$default(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            metadata = null;
        }
        return ImageSource(bufferedSource, fileSystem, metadata);
    }
}
