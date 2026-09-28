package okio;

import io.sentry.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class FileSystem {

    @NotNull
    public static final Companion Companion = new Companion();

    @JvmField
    @NotNull
    public static final FileSystem RESOURCES;

    @JvmField
    @NotNull
    public static final FileSystem SYSTEM;

    @JvmField
    @NotNull
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m72write$default(FileSystem fileSystem, Path file, boolean z, Function1 writerAction, int i2, Object obj) throws IOException {
        ?? r3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(writerAction, "writerAction");
        RealBufferedSink realBufferedSinkC = Okio.c(fileSystem.sink(file, z));
        Object th = null;
        try {
            Object objInvoke = writerAction.invoke(realBufferedSinkC);
            try {
                realBufferedSinkC.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r3 = th;
            th = objInvoke;
        } catch (Throwable th3) {
            try {
                realBufferedSinkC.close();
                r3 = th3;
            } catch (Throwable th4) {
                ExceptionsKt.a(th3, th4);
                r3 = th3;
            }
        }
        if (r3 == 0) {
            return th;
        }
        throw r3;
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        String str = Path.f56972b;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.a(property, false);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return fileSystem.appendingSink(path, z);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectories(path, z);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectory(path, z);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        fileSystem.delete(path, z);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        fileSystem.deleteRecursively(path, z);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        return new NioFileSystemWrappingFileSystem(fileSystem);
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return fileSystem.listRecursively(path, z);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return fileSystem.openReadWrite(path, z, z2);
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return fileSystem.sink(path, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @JvmName
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m73read(@NotNull Path file, @NotNull Function1<? super BufferedSource, ? extends T> readerAction) throws IOException {
        ?? r4;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(readerAction, "readerAction");
        RealBufferedSource realBufferedSourceD = Okio.d(source(file));
        T th = null;
        try {
            ?? Invoke = readerAction.invoke(realBufferedSourceD);
            try {
                realBufferedSourceD.close();
            } catch (Throwable th2) {
                th = th2;
            }
            T t = th;
            th = Invoke;
            r4 = t;
        } catch (Throwable th3) {
            try {
                realBufferedSourceD.close();
                r4 = th3;
            } catch (Throwable th4) {
                ExceptionsKt.a(th3, th4);
                r4 = th3;
            }
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @JvmName
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m74write(@NotNull Path file, boolean z, @NotNull Function1<? super BufferedSink, ? extends T> writerAction) throws IOException {
        ?? r5;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(writerAction, "writerAction");
        RealBufferedSink realBufferedSinkC = Okio.c(sink(file, z));
        T th = null;
        try {
            ?? Invoke = writerAction.invoke(realBufferedSinkC);
            try {
                realBufferedSinkC.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r5 = th;
            th = Invoke;
        } catch (Throwable th3) {
            try {
                realBufferedSinkC.close();
                r5 = th3;
            } catch (Throwable th4) {
                ExceptionsKt.a(th3, th4);
                r5 = th3;
            }
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return appendingSink(file, false);
    }

    public abstract Sink appendingSink(Path path, boolean z);

    public abstract void atomicMove(Path path, Path path2);

    public abstract Path canonicalize(Path path);

    public void copy(@NotNull Path source, @NotNull Path target) throws Throwable {
        Throwable th;
        Throwable th2;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = source(source);
        try {
            RealBufferedSink realBufferedSinkC = Okio.c(sink(target));
            th = null;
            try {
                lValueOf = Long.valueOf(realBufferedSinkC.g0(source2));
                try {
                    realBufferedSinkC.close();
                    th2 = null;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Throwable th4) {
                try {
                    realBufferedSinkC.close();
                } catch (Throwable th5) {
                    ExceptionsKt.a(th4, th5);
                }
                th2 = th4;
                lValueOf = null;
            }
        } catch (Throwable th6) {
            th = th6;
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th7) {
                    ExceptionsKt.a(th, th7);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        lValueOf.getClass();
        if (source2 != null) {
            try {
                source2.close();
            } catch (Throwable th8) {
                th = th8;
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final void createDirectories(@NotNull Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path pathC = dir; pathC != null && !exists(pathC); pathC = pathC.c()) {
            arrayDeque.addFirst(pathC);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            createDirectory((Path) it.next());
        }
    }

    public final void createDirectory(@NotNull Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(Path path, boolean z);

    public abstract void createSymlink(Path path, Path path2);

    public final void delete(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public abstract void delete(Path path, boolean z);

    public void deleteRecursively(@NotNull Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        okio.internal.FileSystem.b(this, fileOrDirectory, z);
    }

    public final boolean exists(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return metadataOrNull(path) != null;
    }

    public abstract List list(Path path);

    public abstract List listOrNull(Path path);

    public Sequence listRecursively(Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return okio.internal.FileSystem.c(this, dir, z);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException(a.a(path, "no such file: "));
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path path);

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract FileHandle openReadWrite(Path path, boolean z, boolean z2);

    @NotNull
    public final Sink sink(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return sink(file, false);
    }

    public abstract Sink sink(Path path, boolean z);

    public abstract Source source(Path path);

    public final void deleteRecursively(@NotNull Path fileOrDirectory) throws IOException {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    @NotNull
    public final Sequence<Path> listRecursively(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return listRecursively(dir, false);
    }

    public final void createDirectories(@NotNull Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectories(dir, false);
    }
}
