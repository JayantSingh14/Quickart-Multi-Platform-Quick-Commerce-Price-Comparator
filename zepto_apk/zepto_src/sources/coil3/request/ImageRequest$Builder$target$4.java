package coil3.request;

import coil3.Image;
import coil3.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class ImageRequest$Builder$target$4 implements Target {
    final /* synthetic */ Function1<Image, Unit> $onError;
    final /* synthetic */ Function1<Image, Unit> $onStart;
    final /* synthetic */ Function1<Image, Unit> $onSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageRequest$Builder$target$4(Function1<? super Image, Unit> function1, Function1<? super Image, Unit> function12, Function1<? super Image, Unit> function13) {
        this.$onStart = function1;
        this.$onError = function12;
        this.$onSuccess = function13;
    }

    @Override // coil3.target.Target
    public void onError(Image image) {
        this.$onError.invoke(image);
    }

    @Override // coil3.target.Target
    public void onStart(Image image) {
        this.$onStart.invoke(image);
    }

    @Override // coil3.target.Target
    public void onSuccess(Image image) {
        this.$onSuccess.invoke(image);
    }
}
