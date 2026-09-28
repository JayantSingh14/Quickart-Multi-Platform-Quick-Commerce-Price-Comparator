package coil3.request;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.Image;
import coil3.ImageLoader;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.size.ViewSizeResolver;
import coil3.size.ViewSizeResolverKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import coil3.util.BitmapsKt;
import coil3.util.ContextsKt;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidRequestService implements RequestService {

    @NotNull
    private final HardwareBitmapService hardwareBitmapService;

    @NotNull
    private final ImageLoader imageLoader;

    @Nullable
    private final Logger logger;

    @NotNull
    private final SystemCallbacks systemCallbacks;

    public AndroidRequestService(@NotNull ImageLoader imageLoader, @NotNull SystemCallbacks systemCallbacks, @Nullable Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.logger = logger;
        this.hardwareBitmapService = HardwareBitmapsKt.HardwareBitmapService(logger);
    }

    private final Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        return ContextsKt.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : imageRequest.getContext());
    }

    private final boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        if (!BitmapsKt.isHardware(config)) {
            return true;
        }
        if (!ImageRequests_androidKt.getAllowHardware(imageRequest)) {
            return false;
        }
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    private final Extras resolveExtras(ImageRequest imageRequest, Size size) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(imageRequest);
        boolean allowRgb565 = ImageRequests_androidKt.getAllowRgb565(imageRequest);
        if (!isBitmapConfigValidMainThread(imageRequest, size)) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        boolean z = allowRgb565 && ImageRequests_androidKt.getTransformations(imageRequest).isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        Extras.Builder builder = new Extras.Builder(MapsKt.j(imageRequest.getDefaults().getExtras().asMap(), imageRequest.getExtras().asMap()));
        if (bitmapConfig != ImageRequests_androidKt.getBitmapConfig(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), bitmapConfig);
        }
        if (z != ImageRequests_androidKt.getAllowRgb565(imageRequest)) {
            builder = builder.set(ImageRequests_androidKt.getAllowRgb565(Extras.Key.Companion), Boolean.valueOf(z));
        }
        return builder.build();
    }

    private final Precision resolvePrecision(ImageRequest imageRequest, SizeResolver sizeResolver) {
        return imageRequest.getDefined().getPrecision() != null ? imageRequest.getDefined().getPrecision() : (imageRequest.getDefined().getSizeResolver() == null && Intrinsics.b(sizeResolver, SizeResolver.ORIGINAL)) ? Precision.INEXACT : ((imageRequest.getTarget() instanceof ViewTarget) && (sizeResolver instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && ((ViewTarget) imageRequest.getTarget()).getView() == ((ViewSizeResolver) sizeResolver).getView()) ? Precision.INEXACT : Precision.EXACT;
    }

    private final Scale resolveScale(ImageRequest imageRequest, Size size) {
        Dimension width = size.getWidth();
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        return (Intrinsics.b(width, undefined) || Intrinsics.b(size.getHeight(), undefined)) ? Scale.FIT : imageRequest.getScale();
    }

    public final boolean isBitmapConfigValidMainThread(@NotNull ImageRequest imageRequest, @NotNull Size size) {
        return (ImageRequests_androidKt.getTransformations(imageRequest).isEmpty() || ArraysKt.h(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), ImageRequests_androidKt.getBitmapConfig(imageRequest))) && (!BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(imageRequest)) || (isConfigValidForHardware(imageRequest, ImageRequests_androidKt.getBitmapConfig(imageRequest)) && this.hardwareBitmapService.allowHardwareMainThread(size)));
    }

    public final boolean isBitmapConfigValidWorkerThread(@NotNull Options options) {
        return !BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(options)) || this.hardwareBitmapService.allowHardwareWorkerThread();
    }

    @Override // coil3.request.RequestService
    public boolean isCacheValueValidForHardware(@NotNull ImageRequest imageRequest, @NotNull MemoryCache.Value value) {
        Image image = value.getImage();
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null) {
            return true;
        }
        return isConfigValidForHardware(imageRequest, BitmapsKt.getSafeConfig(bitmapImage.getBitmap()));
    }

    @Override // coil3.request.RequestService
    @NotNull
    public Options options(@NotNull ImageRequest imageRequest, @NotNull SizeResolver sizeResolver, @NotNull Size size) {
        return new Options(imageRequest.getContext(), size, resolveScale(imageRequest, size), resolvePrecision(imageRequest, sizeResolver), imageRequest.getDiskCacheKey(), imageRequest.getFileSystem(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), imageRequest.getNetworkCachePolicy(), resolveExtras(imageRequest, size));
    }

    @Override // coil3.request.RequestService
    @NotNull
    public RequestDelegate requestDelegate(@NotNull ImageRequest imageRequest, @NotNull Job job, boolean z) {
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            Lifecycle lifecycle = ImageRequests_androidKt.getLifecycle(imageRequest);
            if (lifecycle == null) {
                lifecycle = findLifecycle(imageRequest);
            }
            return new ViewTargetRequestDelegate(this.imageLoader, imageRequest, (ViewTarget) target, lifecycle, job);
        }
        Lifecycle lifecycle2 = ImageRequests_androidKt.getLifecycle(imageRequest);
        if (lifecycle2 == null) {
            lifecycle2 = z ? findLifecycle(imageRequest) : null;
        }
        return lifecycle2 != null ? new LifecycleRequestDelegate(lifecycle2, job) : BaseRequestDelegate.m28boximpl(BaseRequestDelegate.m29constructorimpl(job));
    }

    @Override // coil3.request.RequestService
    @NotNull
    public SizeResolver sizeResolver(@NotNull ImageRequest imageRequest) {
        ImageView.ScaleType scaleType;
        if (imageRequest.getDefined().getSizeResolver() != null) {
            return imageRequest.getDefined().getSizeResolver();
        }
        Target target = imageRequest.getTarget();
        if (!(target instanceof ViewTarget)) {
            return SizeResolver.ORIGINAL;
        }
        View view = ((ViewTarget) target).getView();
        return ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) ? SizeResolver.ORIGINAL : ViewSizeResolverKt.ViewSizeResolver$default(view, false, 2, null);
    }

    @Override // coil3.request.RequestService
    @NotNull
    public Options updateOptionsOnWorkerThread(@NotNull Options options) {
        boolean z;
        Extras extras = options.getExtras();
        if (isBitmapConfigValidWorkerThread(options)) {
            z = false;
        } else {
            extras = extras.newBuilder().set(ImageRequests_androidKt.getBitmapConfig(Extras.Key.Companion), Bitmap.Config.ARGB_8888).build();
            z = true;
        }
        return z ? Options.copy$default(options, null, null, null, null, null, null, null, null, null, extras, 511, null) : options;
    }
}
