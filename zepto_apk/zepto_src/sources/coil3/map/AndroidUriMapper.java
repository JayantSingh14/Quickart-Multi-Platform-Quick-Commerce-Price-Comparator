package coil3.map;

import android.net.Uri;
import coil3.Uri_androidKt;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class AndroidUriMapper implements Mapper<Uri, coil3.Uri> {
    @Override // coil3.map.Mapper
    @NotNull
    public coil3.Uri map(@NotNull Uri uri, @NotNull Options options) {
        return Uri_androidKt.toCoilUri(uri);
    }
}
