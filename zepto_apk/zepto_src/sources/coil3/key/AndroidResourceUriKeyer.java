package coil3.key;

import coil3.Uri;
import coil3.request.Options;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AndroidResourceUriKeyer implements Keyer<Uri> {
    @Override // coil3.key.Keyer
    @Nullable
    public String key(@NotNull Uri uri, @NotNull Options options) {
        if (!Intrinsics.b(uri.getScheme(), "android.resource")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append(':');
        sb.append(Utils_androidKt.getNightMode(options.getContext().getResources().getConfiguration()));
        return sb.toString();
    }
}
