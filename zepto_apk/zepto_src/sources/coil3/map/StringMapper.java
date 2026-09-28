package coil3.map;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class StringMapper implements Mapper<String, Uri> {
    @Override // coil3.map.Mapper
    @NotNull
    public Uri map(@NotNull String str, @NotNull Options options) {
        return UriKt.toUri$default(str, null, 1, null);
    }
}
