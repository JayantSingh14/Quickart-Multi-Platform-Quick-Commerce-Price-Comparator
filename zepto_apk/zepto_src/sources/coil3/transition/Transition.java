package coil3.transition;

import coil3.request.ImageResult;
import coil3.transition.NoneTransition;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface Transition {

    @Metadata
    public interface Factory {

        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @JvmField
        @NotNull
        public static final Factory NONE = new NoneTransition.Factory();

        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        @NotNull
        Transition create(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult);
    }

    void transition();
}
