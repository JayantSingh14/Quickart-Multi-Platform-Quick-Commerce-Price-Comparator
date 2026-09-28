package coil3.map;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class FileMapper implements Mapper<File, Uri> {
    @Override // coil3.map.Mapper
    @NotNull
    public Uri map(@NotNull File file, @NotNull Options options) {
        return UriKt.Uri$default(UtilsKt.SCHEME_FILE, null, file.getPath(), null, null, null, 58, null);
    }
}
