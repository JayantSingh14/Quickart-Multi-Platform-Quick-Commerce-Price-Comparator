package okio;

import io.sentry.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {

    /* renamed from: a, reason: collision with root package name */
    public final java.nio.file.FileSystem f56965a;

    public NioFileSystemWrappingFileSystem(java.nio.file.FileSystem nioFileSystem) {
        Intrinsics.checkNotNullParameter(nioFileSystem, "nioFileSystem");
        this.f56965a = nioFileSystem;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        ListBuilder builder = CollectionsKt.u();
        builder.add(StandardOpenOption.APPEND);
        if (!z) {
            builder.add(StandardOpenOption.CREATE);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        ListBuilder listBuilderJ = builder.j();
        java.nio.file.Path pathE = e(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuilderJ.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathE, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(...)");
        return Okio.i(outputStreamNewOutputStream);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public final void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Intrinsics.checkNotNullExpressionValue(Files.move(e(source), e(target), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(...)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            String str = Path.f56972b;
            java.nio.file.Path realPath = e(path).toRealPath(new LinkOption[0]);
            Intrinsics.checkNotNullExpressionValue(realPath, "toRealPath(...)");
            return Path.Companion.c(realPath);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(a.a(path, "no such file: "));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void createDirectory(okio.Path r4, boolean r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okio.FileMetadata r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L12
            r2 = 1
            boolean r0 = r0.f56942b
            if (r0 != r2) goto L12
            goto L13
        L12:
            r2 = r1
        L13:
            if (r2 == 0) goto L2f
            if (r5 != 0) goto L18
            goto L2f
        L18:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L2f:
            java.nio.file.Path r5 = r3.e(r4)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L45
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L45
            java.nio.file.Path r5 = java.nio.file.Files.createDirectory(r5, r0)     // Catch: java.io.IOException -> L45
            java.lang.String r0 = "createDirectory(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch: java.io.IOException -> L45
            return
        L45:
            r5 = move-exception
            if (r2 == 0) goto L49
            return
        L49:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "failed to create directory: "
            java.lang.String r4 = io.sentry.a.a(r4, r1)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.createDirectory(okio.Path, boolean):void");
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public final void createSymlink(Path source, Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullExpressionValue(Files.createSymbolicLink(e(source), e(target), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(...)");
    }

    public final ArrayList d(Path path, boolean z) throws IOException {
        java.nio.file.Path pathE = e(path);
        try {
            Intrinsics.checkNotNullParameter(pathE, "<this>");
            Intrinsics.checkNotNullParameter("*", "glob");
            DirectoryStream<java.nio.file.Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(pathE, "*");
            try {
                Intrinsics.c(directoryStreamNewDirectoryStream);
                List<java.nio.file.Path> listE0 = CollectionsKt.e0(directoryStreamNewDirectoryStream);
                CloseableKt.a(directoryStreamNewDirectoryStream, null);
                ArrayList arrayList = new ArrayList();
                for (java.nio.file.Path path2 : listE0) {
                    String str = Path.f56972b;
                    arrayList.add(Path.Companion.c(path2));
                }
                CollectionsKt.V(arrayList);
                return arrayList;
            } finally {
            }
        } catch (Exception unused) {
            if (!z) {
                return null;
            }
            if (Files.exists(pathE, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(a.a(path, "failed to list "));
            }
            throw new FileNotFoundException(a.a(path, "no such file: "));
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        java.nio.file.Path pathE = e(path);
        try {
            Files.delete(pathE);
        } catch (NoSuchFileException unused) {
            if (z) {
                throw new FileNotFoundException(a.a(path, "no such file: "));
            }
        } catch (IOException unused2) {
            if (Files.exists(pathE, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(a.a(path, "failed to delete "));
            }
        }
    }

    public final java.nio.file.Path e(Path path) {
        java.nio.file.Path path2 = this.f56965a.getPath(path.f56973a.z(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return path2;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final List list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayList arrayListD = d(dir, true);
        Intrinsics.c(arrayListD);
        return arrayListD;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final List listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return d(dir, false);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return NioSystemFileSystem.b(e(path));
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final FileHandle openReadOnly(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            FileChannel fileChannelOpen = FileChannel.open(e(file), StandardOpenOption.READ);
            Intrinsics.c(fileChannelOpen);
            return new NioFileSystemFileHandle(false, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(a.a(file, "no such file: "));
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (z && z2) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        ListBuilder builder = CollectionsKt.u();
        builder.add(StandardOpenOption.READ);
        builder.add(StandardOpenOption.WRITE);
        if (z) {
            builder.add(StandardOpenOption.CREATE_NEW);
        } else if (!z2) {
            builder.add(StandardOpenOption.CREATE);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        ListBuilder listBuilderJ = builder.j();
        try {
            java.nio.file.Path pathE = e(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuilderJ.toArray(new StandardOpenOption[0]);
            FileChannel fileChannelOpen = FileChannel.open(pathE, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            Intrinsics.c(fileChannelOpen);
            return new NioFileSystemFileHandle(true, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(a.a(file, "no such file: "));
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        ListBuilder builder = CollectionsKt.u();
        if (z) {
            builder.add(StandardOpenOption.CREATE_NEW);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        ListBuilder listBuilderJ = builder.j();
        try {
            java.nio.file.Path pathE = e(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listBuilderJ.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathE, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(...)");
            return Okio.i(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(a.a(file, "no such file: "));
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public final Source source(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(e(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            Intrinsics.checkNotNullExpressionValue(inputStreamNewInputStream, "newInputStream(...)");
            return Okio.m(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(a.a(file, "no such file: "));
        }
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem
    public final String toString() {
        String strI = Reflection.a(this.f56965a.getClass()).i();
        Intrinsics.c(strI);
        return strI;
    }
}
