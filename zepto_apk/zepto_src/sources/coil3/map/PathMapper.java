package coil3.map;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class PathMapper implements Mapper<Path, Uri> {
    @Override // coil3.map.Mapper
    @NotNull
    public Uri map(@NotNull Path path, @NotNull Options options) {
        return UriKt.Uri$default(UtilsKt.SCHEME_FILE, null, path.f56973a.z(), null, null, null, 58, null);
    }
}
