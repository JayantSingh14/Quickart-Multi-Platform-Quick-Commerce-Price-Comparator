package okio;

import io.sentry.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class JvmSystemFileSystem extends FileSystem {
    public static ArrayList a(Path path, boolean z) throws IOException {
        File fileG = path.g();
        String[] list = fileG.list();
        if (list == null) {
            if (!z) {
                return null;
            }
            if (fileG.exists()) {
                throw new IOException(a.a(path, "failed to list "));
            }
            throw new FileNotFoundException(a.a(path, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Intrinsics.c(str);
            arrayList.add(path.e(str));
        }
        CollectionsKt.V(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!z || exists(file)) {
            File fileG = file.g();
            Logger logger = Okio__JvmOkioKt.f56966a;
            Intrinsics.checkNotNullParameter(fileG, "<this>");
            return Okio.i(new FileOutputStream(fileG, true));
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        if (source.g().renameTo(target.g())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        File canonicalFile = path.g().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        String str = Path.f56972b;
        return Path.Companion.b(canonicalFile);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.g().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(dir);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.f56942b) {
            throw new IOException(a.a(dir, "failed to create directory: "));
        }
        if (z) {
            throw new IOException(dir + " already exists.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileG = path.g();
        if (fileG.delete()) {
            return;
        }
        if (fileG.exists()) {
            throw new IOException(a.a(path, "failed to delete "));
        }
        if (z) {
            throw new FileNotFoundException(a.a(path, "no such file: "));
        }
    }

    @Override // okio.FileSystem
    public List list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayList arrayListA = a(dir, true);
        Intrinsics.c(arrayListA);
        return arrayListA;
    }

    @Override // okio.FileSystem
    public List listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return a(dir, false);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File fileG = path.g();
        boolean zIsFile = fileG.isFile();
        boolean zIsDirectory = fileG.isDirectory();
        long jLastModified = fileG.lastModified();
        long length = fileG.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !fileG.exists()) {
            return null;
        }
        return new FileMetadata(zIsFile, zIsDirectory, (Path) null, Long.valueOf(length), (Long) null, Long.valueOf(jLastModified), (Long) null, 128);
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.g(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z && z2) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z && exists(file)) {
            throw new IOException(file + " already exists.");
        }
        if (!z2 || exists(file)) {
            return new JvmFileHandle(true, new RandomAccessFile(file.g(), "rw"));
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!z || !exists(file)) {
            return Okio.j(file.g());
        }
        throw new IOException(file + " already exists.");
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.l(file.g());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
