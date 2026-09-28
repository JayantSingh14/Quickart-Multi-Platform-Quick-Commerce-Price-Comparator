package coil3.disk;

import coil3.util.Coroutines_nonJsCommonKt;
import coil3.util.FileSystems_androidKt;
import coil3.util.FileSystems_nonJsCommonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface DiskCache {

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        @Nullable
        private Path directory;
        private long maxSizeBytes;

        @NotNull
        private FileSystem fileSystem = FileSystems_nonJsCommonKt.defaultFileSystem();
        private double maxSizePercent = 0.02d;
        private long minimumMaxSizeBytes = 10485760;
        private long maximumMaxSizeBytes = 262144000;

        @NotNull
        private CoroutineDispatcher cleanupDispatcher = Coroutines_nonJsCommonKt.ioCoroutineDispatcher();

        @NotNull
        public final DiskCache build() {
            long jC;
            Path path = this.directory;
            if (path == null) {
                throw new IllegalStateException("directory == null");
            }
            double d2 = this.maxSizePercent;
            if (d2 > 0.0d) {
                try {
                    jC = RangesKt.c((long) (d2 * FileSystems_androidKt.remainingFreeSpaceBytes(this.fileSystem, path)), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    jC = this.minimumMaxSizeBytes;
                }
            } else {
                jC = this.maxSizeBytes;
            }
            return new RealDiskCache(jC, path, this.fileSystem, this.cleanupDispatcher);
        }

        @NotNull
        public final Builder cleanupDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
            this.cleanupDispatcher = coroutineDispatcher;
            return this;
        }

        @NotNull
        public final Builder directory(@NotNull Path path) {
            this.directory = path;
            return this;
        }

        @NotNull
        public final Builder fileSystem(@NotNull FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        @NotNull
        public final Builder maxSizeBytes(long j2) {
            if (j2 <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.maxSizePercent = 0.0d;
            this.maxSizeBytes = j2;
            return this;
        }

        @NotNull
        public final Builder maxSizePercent(double d2) {
            if (0.0d > d2 || d2 > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytes = 0L;
            this.maxSizePercent = d2;
            return this;
        }

        @NotNull
        public final Builder maximumMaxSizeBytes(long j2) {
            if (j2 <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.maximumMaxSizeBytes = j2;
            return this;
        }

        @NotNull
        public final Builder minimumMaxSizeBytes(long j2) {
            if (j2 <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.minimumMaxSizeBytes = j2;
            return this;
        }
    }

    @Metadata
    public interface Editor {
        void abort();

        void commit();

        @Nullable
        Snapshot commitAndOpenSnapshot();

        @NotNull
        Path getData();

        @NotNull
        Path getMetadata();
    }

    @Metadata
    public interface Snapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        @Nullable
        Editor closeAndOpenEditor();

        @NotNull
        Path getData();

        @NotNull
        Path getMetadata();
    }

    void clear();

    @NotNull
    Path getDirectory();

    @NotNull
    FileSystem getFileSystem();

    long getMaxSize();

    long getSize();

    @Nullable
    Editor openEditor(@NotNull String str);

    @Nullable
    Snapshot openSnapshot(@NotNull String str);

    boolean remove(@NotNull String str);

    void shutdown();
}
