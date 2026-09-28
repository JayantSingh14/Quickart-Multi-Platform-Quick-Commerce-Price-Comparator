package coil3;

import android.graphics.Bitmap;
import coil3.decode.DecodeResult;
import coil3.decode.Decoder;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.SuccessResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public abstract class EventListener implements ImageRequest.Listener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final EventListener NONE = new EventListener() { // from class: coil3.EventListener$Companion$NONE$1
    };

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public interface Factory {

        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @JvmField
        @NotNull
        public static final Factory NONE = new androidx.work.impl.model.a(1);

        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static EventListener NONE$lambda$0(ImageRequest imageRequest) {
            return EventListener.NONE;
        }

        @NotNull
        EventListener create(@NotNull ImageRequest imageRequest);
    }

    public void decodeEnd(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options, @Nullable DecodeResult decodeResult) {
    }

    public void decodeStart(@NotNull ImageRequest imageRequest, @NotNull Decoder decoder, @NotNull Options options) {
    }

    public void fetchEnd(@NotNull ImageRequest imageRequest, @NotNull Fetcher fetcher, @NotNull Options options, @Nullable FetchResult fetchResult) {
    }

    public void fetchStart(@NotNull ImageRequest imageRequest, @NotNull Fetcher fetcher, @NotNull Options options) {
    }

    public void keyEnd(@NotNull ImageRequest imageRequest, @Nullable String str) {
    }

    public void keyStart(@NotNull ImageRequest imageRequest, @NotNull Object obj) {
    }

    public void mapEnd(@NotNull ImageRequest imageRequest, @NotNull Object obj) {
    }

    public void mapStart(@NotNull ImageRequest imageRequest, @NotNull Object obj) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onCancel(@NotNull ImageRequest imageRequest) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onError(@NotNull ImageRequest imageRequest, @NotNull ErrorResult errorResult) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onStart(@NotNull ImageRequest imageRequest) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onSuccess(@NotNull ImageRequest imageRequest, @NotNull SuccessResult successResult) {
    }

    public void resolveSizeEnd(@NotNull ImageRequest imageRequest, @NotNull Size size) {
    }

    public void resolveSizeStart(@NotNull ImageRequest imageRequest, @NotNull SizeResolver sizeResolver) {
    }

    public void transformEnd(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
    }

    public void transformStart(@NotNull ImageRequest imageRequest, @NotNull Bitmap bitmap) {
    }

    public void transitionEnd(@NotNull ImageRequest imageRequest, @NotNull Transition transition) {
    }

    public void transitionStart(@NotNull ImageRequest imageRequest, @NotNull Transition transition) {
    }
}
