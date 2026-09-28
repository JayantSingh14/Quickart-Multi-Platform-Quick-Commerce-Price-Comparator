package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SourceImageSource implements ImageSource {

    @Nullable
    private Path file;

    @NotNull
    private final FileSystem fileSystem;
    private boolean isClosed;

    @NotNull
    private final Object lock = new Object();

    @Nullable
    private final ImageSource.Metadata metadata;

    @Nullable
    private BufferedSource source;

    public SourceImageSource(@NotNull BufferedSource bufferedSource, @NotNull FileSystem fileSystem, @Nullable ImageSource.Metadata metadata) {
        this.fileSystem = fileSystem;
        this.metadata = metadata;
        this.source = bufferedSource;
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
                Path path = this.file;
                if (path != null) {
                    getFileSystem().delete(path);
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
        Throwable th;
        synchronized (this.lock) {
            assertNotClosed();
            Path path = this.file;
            if (path != null) {
                return path;
            }
            Path pathCreateTempFile = FileSystemsKt.createTempFile(getFileSystem());
            RealBufferedSink realBufferedSinkC = Okio.c(getFileSystem().sink(pathCreateTempFile, false));
            try {
                BufferedSource bufferedSource = this.source;
                Intrinsics.c(bufferedSource);
                realBufferedSinkC.g0(bufferedSource);
                try {
                    realBufferedSinkC.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    realBufferedSinkC.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            this.source = null;
            this.file = pathCreateTempFile;
            return pathCreateTempFile;
        }
    }

    @Override // coil3.decode.ImageSource
    @Nullable
    public Path fileOrNull() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
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
            FileSystem fileSystem = getFileSystem();
            Path path = this.file;
            Intrinsics.c(path);
            RealBufferedSource realBufferedSourceD = Okio.d(fileSystem.source(path));
            this.source = realBufferedSourceD;
            return realBufferedSourceD;
        }
    }

    @Override // coil3.decode.ImageSource
    @NotNull
    public BufferedSource sourceOrNull() {
        return source();
    }
}
