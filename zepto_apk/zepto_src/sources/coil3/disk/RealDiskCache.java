package coil3.disk;

import coil3.disk.DiskCache;
import coil3.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealDiskCache implements DiskCache {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_DATA = 1;
    private static final int ENTRY_METADATA = 0;

    @NotNull
    private final DiskLruCache cache;

    @NotNull
    private final Path directory;

    @NotNull
    private final FileSystem fileSystem;
    private final long maxSize;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class RealEditor implements DiskCache.Editor {

        @NotNull
        private final DiskLruCache.Editor editor;

        public RealEditor(@NotNull DiskLruCache.Editor editor) {
            this.editor = editor;
        }

        @Override // coil3.disk.DiskCache.Editor
        public void abort() {
            this.editor.abort();
        }

        @Override // coil3.disk.DiskCache.Editor
        public void commit() {
            this.editor.commit();
        }

        @Override // coil3.disk.DiskCache.Editor
        @NotNull
        public Path getData() {
            return this.editor.file(1);
        }

        @Override // coil3.disk.DiskCache.Editor
        @NotNull
        public Path getMetadata() {
            return this.editor.file(0);
        }

        @Override // coil3.disk.DiskCache.Editor
        @Nullable
        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot snapshotCommitAndGet = this.editor.commitAndGet();
            if (snapshotCommitAndGet != null) {
                return new RealSnapshot(snapshotCommitAndGet);
            }
            return null;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class RealSnapshot implements DiskCache.Snapshot {

        @NotNull
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(@NotNull DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // coil3.disk.DiskCache.Snapshot, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // coil3.disk.DiskCache.Snapshot
        @NotNull
        public Path getData() {
            return this.snapshot.file(1);
        }

        @Override // coil3.disk.DiskCache.Snapshot
        @NotNull
        public Path getMetadata() {
            return this.snapshot.file(0);
        }

        @Override // coil3.disk.DiskCache.Snapshot
        @Nullable
        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor editorCloseAndEdit = this.snapshot.closeAndEdit();
            if (editorCloseAndEdit != null) {
                return new RealEditor(editorCloseAndEdit);
            }
            return null;
        }
    }

    public RealDiskCache(long j2, @NotNull Path path, @NotNull FileSystem fileSystem, @NotNull CoroutineDispatcher coroutineDispatcher) {
        this.maxSize = j2;
        this.directory = path;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), coroutineDispatcher, getMaxSize(), 3, 2);
    }

    private final String hash(String str) {
        ByteString byteString = ByteString.f56924d;
        return ByteString.Companion.c(str).c(MessageDigestAlgorithms.SHA_256).e();
    }

    @Override // coil3.disk.DiskCache
    public void clear() {
        this.cache.evictAll();
    }

    @Override // coil3.disk.DiskCache
    @NotNull
    public Path getDirectory() {
        return this.directory;
    }

    @Override // coil3.disk.DiskCache
    @NotNull
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.disk.DiskCache
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // coil3.disk.DiskCache
    public long getSize() {
        return this.cache.size();
    }

    @Override // coil3.disk.DiskCache
    @Nullable
    public DiskCache.Editor openEditor(@NotNull String str) {
        DiskLruCache.Editor editorEdit = this.cache.edit(hash(str));
        if (editorEdit != null) {
            return new RealEditor(editorEdit);
        }
        return null;
    }

    @Override // coil3.disk.DiskCache
    @Nullable
    public DiskCache.Snapshot openSnapshot(@NotNull String str) {
        DiskLruCache.Snapshot snapshot = this.cache.get(hash(str));
        if (snapshot != null) {
            return new RealSnapshot(snapshot);
        }
        return null;
    }

    @Override // coil3.disk.DiskCache
    public boolean remove(@NotNull String str) {
        return this.cache.remove(hash(str));
    }

    @Override // coil3.disk.DiskCache
    public void shutdown() {
        coil3.util.UtilsKt.closeQuietly(this.cache);
    }
}
