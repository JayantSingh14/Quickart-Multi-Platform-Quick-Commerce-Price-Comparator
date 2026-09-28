package coil3.transition;

import android.graphics.drawable.Drawable;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.decode.DataSource;
import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Scale;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;

    @NotNull
    private final ImageResult result;

    @NotNull
    private final TransitionTarget target;

    @Metadata
    @SourceDebugExtension
    public static final class Factory implements Transition.Factory {
        private final int durationMillis;
        private final boolean preferExactIntrinsicSize;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Factory() {
            this(0, 0 == true ? 1 : 0, 3, null);
        }

        @Override // coil3.transition.Transition.Factory
        @NotNull
        public Transition create(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult) {
            return !(imageResult instanceof SuccessResult) ? Transition.Factory.NONE.create(transitionTarget, imageResult) : ((SuccessResult) imageResult).getDataSource() == DataSource.MEMORY_CACHE ? Transition.Factory.NONE.create(transitionTarget, imageResult) : new CrossfadeTransition(transitionTarget, imageResult, this.durationMillis, this.preferExactIntrinsicSize);
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        public final boolean getPreferExactIntrinsicSize() {
            return this.preferExactIntrinsicSize;
        }

        @JvmOverloads
        public Factory(int i2) {
            this(i2, false, 2, null);
        }

        @JvmOverloads
        public Factory(int i2, boolean z) {
            this.durationMillis = i2;
            this.preferExactIntrinsicSize = z;
            if (i2 <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        public /* synthetic */ Factory(int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 200 : i2, (i3 & 2) != 0 ? false : z);
        }
    }

    @JvmOverloads
    public CrossfadeTransition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult) {
        this(transitionTarget, imageResult, 0, false, 12, null);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    @Override // coil3.transition.Transition
    public void transition() {
        Drawable drawable = this.target.getDrawable();
        Image image = this.result.getImage();
        Drawable drawableAsDrawable = image != null ? Image_androidKt.asDrawable(image, this.target.getView().getResources()) : null;
        Scale scale = this.result.getRequest().getScale();
        int i2 = this.durationMillis;
        ImageResult imageResult = this.result;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawable, drawableAsDrawable, scale, i2, ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).isPlaceholderCached()) ? false : true, this.preferExactIntrinsicSize);
        ImageResult imageResult2 = this.result;
        if (imageResult2 instanceof SuccessResult) {
            this.target.onSuccess(Image_androidKt.asImage(crossfadeDrawable));
        } else {
            if (!(imageResult2 instanceof ErrorResult)) {
                throw new NoWhenBranchMatchedException();
            }
            this.target.onError(Image_androidKt.asImage(crossfadeDrawable));
        }
    }

    @JvmOverloads
    public CrossfadeTransition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult, int i2) {
        this(transitionTarget, imageResult, i2, false, 8, null);
    }

    @JvmOverloads
    public CrossfadeTransition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult, int i2, boolean z) {
        this.target = transitionTarget;
        this.result = imageResult;
        this.durationMillis = i2;
        this.preferExactIntrinsicSize = z;
        if (i2 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    public /* synthetic */ CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionTarget, imageResult, (i3 & 4) != 0 ? 200 : i2, (i3 & 8) != 0 ? false : z);
    }
}
