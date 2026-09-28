package coil3;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Uri_androidKt {
    @NotNull
    public static final android.net.Uri toAndroidUri(@NotNull Uri uri) {
        return android.net.Uri.parse(uri.toString());
    }

    @NotNull
    public static final Uri toCoilUri(@NotNull android.net.Uri uri) {
        return UriKt.toUri$default(uri.toString(), null, 1, null);
    }
}
