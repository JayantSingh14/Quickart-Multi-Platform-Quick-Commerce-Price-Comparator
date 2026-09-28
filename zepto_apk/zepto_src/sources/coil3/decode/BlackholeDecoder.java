package coil3.decode;

import android.graphics.Canvas;
import coil3.Image;
import coil3.ImageLoader;
import coil3.annotation.ExperimentalCoilApi;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ExperimentalCoilApi
/* loaded from: classes3.dex */
public final class BlackholeDecoder implements Decoder {

    @NotNull
    private final Function0<Image> imageFactory;

    @Metadata
    public static final class Factory implements Decoder.Factory {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final Image EMPTY_IMAGE = new Image() { // from class: coil3.decode.BlackholeDecoder$Factory$Companion$EMPTY_IMAGE$1
            @Override // coil3.Image
            public void draw(Canvas canvas) {
            }

            @Override // coil3.Image
            public int getHeight() {
                return -1;
            }

            @Override // coil3.Image
            public boolean getShareable() {
                return true;
            }

            @Override // coil3.Image
            public long getSize() {
                return 0L;
            }

            @Override // coil3.Image
            public int getWidth() {
                return -1;
            }
        };

        @NotNull
        private final Function0<Image> imageFactory;

        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(@NotNull Function0<? extends Image> function0) {
            this.imageFactory = function0;
        }

        @Override // coil3.decode.Decoder.Factory
        @NotNull
        public BlackholeDecoder create(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new BlackholeDecoder(this.imageFactory);
        }

        public /* synthetic */ Factory(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? new b(0) : function0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlackholeDecoder(@NotNull Function0<? extends Image> function0) {
        this.imageFactory = function0;
    }

    @Override // coil3.decode.Decoder
    @Nullable
    public Object decode(@NotNull Continuation<? super DecodeResult> continuation) {
        return new DecodeResult((Image) this.imageFactory.invoke(), false);
    }
}
