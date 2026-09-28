package coil3.decode;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ExifData {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final ExifData NONE = new ExifData(false, 0);
    private final boolean isFlipped;
    private final int rotationDegrees;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ExifData(boolean z, int i2) {
        this.isFlipped = z;
        this.rotationDegrees = i2;
    }

    public final int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public final boolean isFlipped() {
        return this.isFlipped;
    }
}
