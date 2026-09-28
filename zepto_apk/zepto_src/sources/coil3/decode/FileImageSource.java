package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.UtilsKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.RealBufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FileImageSource implements ImageSource {

    @Nullable
    private final AutoCloseable closeable;

    @Nullable
    private final String diskCacheKey;

    @NotNull
    private final Path file;

    @NotNull
    private final FileSystem fileSystem;
    private boolean isClosed;

    @NotNull
    private final Object lock = new Object();

    @Nullable
    private final ImageSource.Metadata metadata;

    @Nullable
    private BufferedSource source;

    public FileImageSource(@NotNull Path path, @NotNull FileSystem fileSystem, @Nullable String str, @Nullable AutoCloseable autoCloseable, @Nullable ImageSource.Metadata metadata) {
        this.file = path;
        this.fileSystem = fileSystem;
        this.diskCacheKey = str;
        this.closeable = autoCloseable;
        this.metadata = metadata;
    }

    private final void assertNotClosed() {
        if (this.isClosed) {
            throw new IllegalStateException("closed");
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                this.isClosed = true;
                BufferedSource bufferedSource = this.source;
                if (bufferedSource != null) {
                    UtilsKt.closeQuietly((Closeable) bufferedSource);
                }
                AutoCloseable autoCloseable = this.closeable;
                if (autoCloseable != null) {
                    UtilsKt.closeQuietly(autoCloseable);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // coil3.decode.ImageSource
    @NotNull
    public Path file() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
    }

    @Override // coil3.decode.ImageSource
    @NotNull
    public Path fileOrNull() {
        return file();
    }

    @Nullable
    public final String getDiskCacheKey$coil_core_release() {
        return this.diskCacheKey;
    }

    @NotNull
    public final Path getFile$coil_core_release() {
        return this.file;
    }

    @Override // coil3.decode.ImageSource
    @NotNull
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.decode.ImageSource
    @Nullable
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // coil3.decode.ImageSource
    @NotNull
    public BufferedSource source() {
        synchronized (this.lock) {
            assertNotClosed();
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            RealBufferedSource realBufferedSourceD = Okio.d(getFileSystem().source(this.file));
            this.source = realBufferedSourceD;
            return realBufferedSourceD;
        }
    }

    @Override // coil3.decode.ImageSource
    @Nullable
    public BufferedSource sourceOrNull() {
        BufferedSource bufferedSource;
        synchronized (this.lock) {
            assertNotClosed();
            bufferedSource = this.source;
        }
        return bufferedSource;
    }
}
