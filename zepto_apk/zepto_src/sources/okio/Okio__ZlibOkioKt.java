package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ZipFilesKt;
import okio.internal.ZipFilesKt$openZip$1;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class Okio__ZlibOkioKt {
    public static final ZipFileSystem a(FileSystem fileSystem, Path zipPath) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return ZipFilesKt.c(zipPath, fileSystem, ZipFilesKt$openZip$1.f57060c);
    }
}
