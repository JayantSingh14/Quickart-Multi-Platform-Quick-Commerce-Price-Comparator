package coil3.key;

import coil3.Uri;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class UriKeyer implements Keyer<Uri> {
    @Override // coil3.key.Keyer
    @NotNull
    public String key(@NotNull Uri uri, @NotNull Options options) {
        return uri.toString();
    }
}
