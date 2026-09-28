package coil3.transition;

import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class NoneTransition implements Transition {

    @NotNull
    private final ImageResult result;

    @NotNull
    private final TransitionTarget target;

    @Metadata
    public static final class Factory implements Transition.Factory {
        @Override // coil3.transition.Transition.Factory
        @NotNull
        public Transition create(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult) {
            return new NoneTransition(transitionTarget, imageResult);
        }
    }

    public NoneTransition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult) {
        this.target = transitionTarget;
        this.result = imageResult;
    }

    @Override // coil3.transition.Transition
    public void transition() {
        ImageResult imageResult = this.result;
        if (imageResult instanceof SuccessResult) {
            this.target.onSuccess(((SuccessResult) imageResult).getImage());
        } else {
            if (!(imageResult instanceof ErrorResult)) {
                throw new NoWhenBranchMatchedException();
            }
            this.target.onError(((ErrorResult) imageResult).getImage());
        }
    }
}
