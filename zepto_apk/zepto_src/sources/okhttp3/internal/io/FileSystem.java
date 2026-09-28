package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata
/* loaded from: classes3.dex */
public interface FileSystem {

    /* renamed from: a, reason: collision with root package name */
    public static final FileSystem f56767a = new Companion.SystemFileSystem();

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public final void a(File directory) throws IOException {
                Intrinsics.checkNotNullParameter(directory, "directory");
                File[] fileArrListFiles = directory.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("not a readable directory: " + directory);
                }
                for (File file : fileArrListFiles) {
                    if (file.isDirectory()) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        a(file);
                    }
                    if (!file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public final boolean b(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public final Sink c(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return Okio.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.a(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public final long d(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public final Source e(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return Okio.l(file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public final Sink f(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return Okio.j(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.j(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public final void g(File from, File to) throws IOException {
                Intrinsics.checkNotNullParameter(from, "from");
                Intrinsics.checkNotNullParameter(to, "to");
                h(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.FileSystem
            public final void h(File file) throws IOException {
                Intrinsics.checkNotNullParameter(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            public final String toString() {
                return "FileSystem.SYSTEM";
            }
        }
    }

    void a(File file);

    boolean b(File file);

    Sink c(File file);

    long d(File file);

    Source e(File file);

    Sink f(File file);

    void g(File file, File file2);

    void h(File file);
}
