package coil3.size;

import coil3.size.Dimension;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class Size {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final Size ORIGINAL;

    @NotNull
    private final Dimension height;

    @NotNull
    private final Dimension width;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        ORIGINAL = new Size(undefined, undefined);
    }

    public Size(@NotNull Dimension dimension, @NotNull Dimension dimension2) {
        this.width = dimension;
        this.height = dimension2;
    }

    public static /* synthetic */ Size copy$default(Size size, Dimension dimension, Dimension dimension2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dimension = size.width;
        }
        if ((i2 & 2) != 0) {
            dimension2 = size.height;
        }
        return size.copy(dimension, dimension2);
    }

    @NotNull
    public final Dimension component1() {
        return this.width;
    }

    @NotNull
    public final Dimension component2() {
        return this.height;
    }

    @NotNull
    public final Size copy(@NotNull Dimension dimension, @NotNull Dimension dimension2) {
        return new Size(dimension, dimension2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return Intrinsics.b(this.width, size.width) && Intrinsics.b(this.height, size.height);
    }

    @NotNull
    public final Dimension getHeight() {
        return this.height;
    }

    @NotNull
    public final Dimension getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.height.hashCode() + (this.width.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }
}
