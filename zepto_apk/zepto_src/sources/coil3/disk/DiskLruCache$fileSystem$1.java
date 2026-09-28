package coil3.disk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DiskLruCache$fileSystem$1 extends ForwardingFileSystem {
    public DiskLruCache$fileSystem$1(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override // okio.ForwardingFileSystem, okio.FileSystem
    public Sink sink(Path path, boolean z) throws IOException {
        Path pathC = path.c();
        if (pathC != null) {
            createDirectories(pathC);
        }
        return super.sink(path, z);
    }
}
