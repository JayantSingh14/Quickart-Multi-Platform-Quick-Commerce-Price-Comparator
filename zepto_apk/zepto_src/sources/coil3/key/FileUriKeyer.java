package coil3.key;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;
import org.apache.commons.codec.language.Soundex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class FileUriKeyer implements Keyer<Uri> {
    @Override // coil3.key.Keyer
    @Nullable
    public String key(@NotNull Uri uri, @NotNull Options options) {
        String filePath;
        if (!UtilsKt.isFileUri(uri) || !ImageRequestsKt.getAddLastModifiedToFileCacheKey(options) || (filePath = UriKt.getFilePath(uri)) == null) {
            return null;
        }
        FileSystem fileSystem = options.getFileSystem();
        String str = Path.f56972b;
        Long l2 = fileSystem.metadata(Path.Companion.a(filePath, false)).f56946f;
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append(Soundex.SILENT_MARKER);
        sb.append(l2);
        return sb.toString();
    }
}
