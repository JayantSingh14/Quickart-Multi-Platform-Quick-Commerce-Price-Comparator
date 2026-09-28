package coil3.util;

import coil3.annotation.InternalCoilApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@InternalCoilApi
/* loaded from: classes3.dex */
public final class MimeTypeMap {

    @NotNull
    public static final MimeTypeMap INSTANCE = new MimeTypeMap();

    private MimeTypeMap() {
    }

    @Nullable
    public final String getMimeTypeFromExtension(@NotNull String str) {
        if (StringsKt.z(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strExtensionFromMimeTypeMap = MimeTypes_androidKt.extensionFromMimeTypeMap(lowerCase);
        return strExtensionFromMimeTypeMap == null ? (String) MimeTypesKt.mimeTypeData.get(lowerCase) : strExtensionFromMimeTypeMap;
    }

    @Nullable
    public final String getMimeTypeFromUrl(@NotNull String str) {
        if (StringsKt.z(str)) {
            return null;
        }
        String strV = StringsKt.V(StringsKt.V(str, '#'), '?');
        return getMimeTypeFromExtension(StringsKt.T(ClassUtils.PACKAGE_SEPARATOR_CHAR, StringsKt.T('/', strV, strV), ""));
    }
}
