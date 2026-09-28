package coil3.util;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.text.StringsKt;
import okio.FileSystem;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class FileSystemsKt {
    public static final void createFile(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        if (z) {
            UtilsKt.closeQuietly((Closeable) fileSystem.sink(path, true));
        } else {
            if (fileSystem.exists(path)) {
                return;
            }
            UtilsKt.closeQuietly((Closeable) fileSystem.sink(path));
        }
    }

    public static /* synthetic */ void createFile$default(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            z = false;
        }
        createFile(fileSystem, path, z);
    }

    @NotNull
    public static final Path createTempFile(@NotNull FileSystem fileSystem) throws IOException {
        Path pathE;
        do {
            Path path = FileSystem.SYSTEM_TEMPORARY_DIRECTORY;
            StringBuilder sb = new StringBuilder("tmp_");
            long jA = URandomKt.a(Random.f53818a);
            ULong.Companion companion = ULong.f53561b;
            sb.append((Object) UnsignedKt.c(jA));
            pathE = path.e(sb.toString());
        } while (fileSystem.exists(pathE));
        createFile(fileSystem, pathE, true);
        return pathE;
    }

    public static final void deleteContents(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).f56942b) {
                        deleteContents(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e2) {
                    if (iOException == null) {
                        iOException = e2;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    @NotNull
    public static final String getExtension(@NotNull Path path) {
        return StringsKt.T(ClassUtils.PACKAGE_SEPARATOR_CHAR, path.b(), "");
    }
}
