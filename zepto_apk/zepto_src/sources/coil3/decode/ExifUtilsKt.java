package coil3.decode;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ExifUtilsKt {
    public static final boolean isRotated(@NotNull ExifData exifData) {
        return exifData.getRotationDegrees() > 0;
    }

    public static final boolean isSwapped(@NotNull ExifData exifData) {
        return exifData.getRotationDegrees() == 90 || exifData.getRotationDegrees() == 270;
    }
}
