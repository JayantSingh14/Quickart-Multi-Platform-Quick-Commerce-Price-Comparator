package coil3.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class MimeTypes_androidKt {
    @Nullable
    public static final String extensionFromMimeTypeMap(@NotNull String str) {
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }
}
