package coil3.request;

import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: classes3.dex */
public final class ImageRequest$Builder$listener$5 implements ImageRequest.Listener {
    final /* synthetic */ Function1<ImageRequest, Unit> $onCancel;
    final /* synthetic */ Function2<ImageRequest, ErrorResult, Unit> $onError;
    final /* synthetic */ Function1<ImageRequest, Unit> $onStart;
    final /* synthetic */ Function2<ImageRequest, SuccessResult, Unit> $onSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageRequest$Builder$listener$5(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
        this.$onStart = function1;
        this.$onCancel = function12;
        this.$onError = function2;
        this.$onSuccess = function22;
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onCancel(ImageRequest imageRequest) {
        this.$onCancel.invoke(imageRequest);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        this.$onError.invoke(imageRequest, errorResult);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onStart(ImageRequest imageRequest) {
        this.$onStart.invoke(imageRequest);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        this.$onSuccess.invoke(imageRequest, successResult);
    }
}
