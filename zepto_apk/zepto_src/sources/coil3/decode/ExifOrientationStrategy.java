package coil3.decode;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface ExifOrientationStrategy {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final ExifOrientationStrategy IGNORE;

    @JvmField
    @NotNull
    public static final ExifOrientationStrategy RESPECT_ALL;

    @JvmField
    @NotNull
    public static final ExifOrientationStrategy RESPECT_PERFORMANCE;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    static {
        final int i2 = 0;
        IGNORE = new ExifOrientationStrategy() { // from class: coil3.decode.c
            @Override // coil3.decode.ExifOrientationStrategy
            public final boolean supports(String str, BufferedSource bufferedSource) {
                switch (i2) {
                    case 0:
                        return ExifOrientationStrategy.IGNORE$lambda$0(str, bufferedSource);
                    case 1:
                        return ExifOrientationStrategy.RESPECT_PERFORMANCE$lambda$1(str, bufferedSource);
                    default:
                        return ExifOrientationStrategy.RESPECT_ALL$lambda$2(str, bufferedSource);
                }
            }
        };
        final int i3 = 1;
        RESPECT_PERFORMANCE = new ExifOrientationStrategy() { // from class: coil3.decode.c
            @Override // coil3.decode.ExifOrientationStrategy
            public final boolean supports(String str, BufferedSource bufferedSource) {
                switch (i3) {
                    case 0:
                        return ExifOrientationStrategy.IGNORE$lambda$0(str, bufferedSource);
                    case 1:
                        return ExifOrientationStrategy.RESPECT_PERFORMANCE$lambda$1(str, bufferedSource);
                    default:
                        return ExifOrientationStrategy.RESPECT_ALL$lambda$2(str, bufferedSource);
                }
            }
        };
        final int i4 = 2;
        RESPECT_ALL = new ExifOrientationStrategy() { // from class: coil3.decode.c
            @Override // coil3.decode.ExifOrientationStrategy
            public final boolean supports(String str, BufferedSource bufferedSource) {
                switch (i4) {
                    case 0:
                        return ExifOrientationStrategy.IGNORE$lambda$0(str, bufferedSource);
                    case 1:
                        return ExifOrientationStrategy.RESPECT_PERFORMANCE$lambda$1(str, bufferedSource);
                    default:
                        return ExifOrientationStrategy.RESPECT_ALL$lambda$2(str, bufferedSource);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean IGNORE$lambda$0(String str, BufferedSource bufferedSource) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean RESPECT_ALL$lambda$2(String str, BufferedSource bufferedSource) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean RESPECT_PERFORMANCE$lambda$1(String str, BufferedSource bufferedSource) {
        if (str != null) {
            return str.equals("image/jpeg") || str.equals("image/webp") || str.equals("image/heic") || str.equals("image/heif");
        }
        return false;
    }

    boolean supports(@Nullable String str, @NotNull BufferedSource bufferedSource);
}
