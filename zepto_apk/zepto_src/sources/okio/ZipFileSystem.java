package okio;

import io.sentry.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ZipFileSystem extends FileSystem {

    /* renamed from: d, reason: collision with root package name */
    public static final Path f57005d;

    /* renamed from: a, reason: collision with root package name */
    public final Path f57006a;

    /* renamed from: b, reason: collision with root package name */
    public final FileSystem f57007b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f57008c;

    @Metadata
    public static final class Companion {
    }

    static {
        String str = Path.f56972b;
        f57005d = Path.Companion.a("/", false);
    }

    public ZipFileSystem(Path zipPath, FileSystem fileSystem, LinkedHashMap entries) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f57006a = zipPath;
        this.f57007b = fileSystem;
        this.f57008c = entries;
    }

    public final List a(Path child, boolean z) throws IOException {
        Path path = f57005d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        ZipEntry zipEntry = (ZipEntry) this.f57008c.get(okio.internal.Path.b(path, child, true));
        if (zipEntry != null) {
            return CollectionsKt.e0(zipEntry.q);
        }
        if (z) {
            throw new IOException(a.a(child, "not a directory: "));
        }
        return null;
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final Path canonicalize(Path child) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(child, "path");
        Path path = f57005d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        Path pathB = okio.internal.Path.b(path, child, true);
        if (this.f57008c.containsKey(pathB)) {
            return pathB;
        }
        throw new FileNotFoundException(String.valueOf(child));
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List listA = a(dir, true);
        Intrinsics.c(listA);
        return listA;
    }

    @Override // okio.FileSystem
    public final List listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return a(dir, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0136  */
    @Override // okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okio.FileMetadata metadataOrNull(okio.Path r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.metadataOrNull(okio.Path):okio.FileMetadata");
    }

    @Override // okio.FileSystem
    public final FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public final FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public final Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path child) throws Throwable {
        Throwable th;
        RealBufferedSource realBufferedSourceD;
        Intrinsics.checkNotNullParameter(child, "file");
        Path path = f57005d;
        path.getClass();
        Intrinsics.checkNotNullParameter(child, "child");
        ZipEntry zipEntry = (ZipEntry) this.f57008c.get(okio.internal.Path.b(path, child, true));
        if (zipEntry == null) {
            throw new FileNotFoundException(a.a(child, "no such file: "));
        }
        FileHandle fileHandleOpenReadOnly = this.f57007b.openReadOnly(this.f57006a);
        try {
            realBufferedSourceD = Okio.d(fileHandleOpenReadOnly.x(zipEntry.f57054h));
            try {
                fileHandleOpenReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
            }
            th = th3;
            realBufferedSourceD = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNullParameter(realBufferedSourceD, "<this>");
        ZipFilesKt.g(realBufferedSourceD, null);
        int i2 = zipEntry.f57053g;
        long j2 = zipEntry.f57052f;
        return i2 == 0 ? new FixedLengthSource(realBufferedSourceD, j2, true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(realBufferedSourceD, zipEntry.f57051e, true), new Inflater(true)), j2, false);
    }
}
