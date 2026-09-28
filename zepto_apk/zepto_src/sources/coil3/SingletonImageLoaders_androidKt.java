package coil3;

import android.content.Context;
import android.widget.ImageView;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.util.CoilUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SingletonImageLoaders_androidKt {
    public static final void dispose(@NotNull ImageView imageView) {
        CoilUtils.dispose(imageView);
    }

    @NotNull
    public static final ImageLoader getImageLoader(@NotNull Context context) {
        return SingletonImageLoader.get(context);
    }

    @Nullable
    public static final ImageResult getResult(@NotNull ImageView imageView) {
        return CoilUtils.result(imageView);
    }

    @NotNull
    public static final Disposable load(@NotNull ImageView imageView, @Nullable Object obj, @NotNull ImageLoader imageLoader, @NotNull Function1<? super ImageRequest.Builder, Unit> function1) {
        ImageRequest.Builder builderTarget = ImageRequests_androidKt.target(new ImageRequest.Builder(imageView.getContext()).data(obj), imageView);
        function1.invoke(builderTarget);
        return imageLoader.enqueue(builderTarget.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, Object obj, ImageLoader imageLoader, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            imageLoader = SingletonImageLoader.get(imageView.getContext());
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<ImageRequest.Builder, Unit>() { // from class: coil3.SingletonImageLoaders_androidKt.load.1
                public final void invoke(ImageRequest.Builder builder) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((ImageRequest.Builder) obj3);
                    return Unit.f53572a;
                }
            };
        }
        ImageRequest.Builder builderTarget = ImageRequests_androidKt.target(new ImageRequest.Builder(imageView.getContext()).data(obj), imageView);
        function1.invoke(builderTarget);
        return imageLoader.enqueue(builderTarget.build());
    }
}
