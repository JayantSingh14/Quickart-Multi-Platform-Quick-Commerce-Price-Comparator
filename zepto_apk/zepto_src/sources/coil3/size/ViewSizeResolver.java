package coil3.size;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import coil3.size.Dimension;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public interface ViewSizeResolver<T extends View> extends SizeResolver {
    private default Dimension getDimension(int i2, int i3, int i4) {
        if (i2 == -2) {
            return Dimension.Undefined.INSTANCE;
        }
        int i5 = i2 - i4;
        if (i5 > 0) {
            return Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i5));
        }
        int i6 = i3 - i4;
        if (i6 > 0) {
            return Dimension.Pixels.m36boximpl(DimensionKt.Dimension(i6));
        }
        return null;
    }

    private default Dimension getHeight() {
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        return getDimension(layoutParams != null ? layoutParams.height : -1, getView().getHeight(), getSubtractPadding() ? getView().getPaddingBottom() + getView().getPaddingTop() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    default Size getSize() {
        Dimension height;
        Dimension width = getWidth();
        if (width == null || (height = getHeight()) == null) {
            return null;
        }
        return new Size(width, height);
    }

    private default Dimension getWidth() {
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        return getDimension(layoutParams != null ? layoutParams.width : -1, getView().getWidth(), getSubtractPadding() ? getView().getPaddingRight() + getView().getPaddingLeft() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    default void removePreDrawListenerSafe(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        } else {
            getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewTreeObserver$OnPreDrawListener, coil3.size.ViewSizeResolver$size$3$preDrawListener$1] */
    static <T extends View> Object size$suspendImpl(final ViewSizeResolver<T> viewSizeResolver, Continuation<? super Size> frame) throws Throwable {
        Size size = viewSizeResolver.getSize();
        if (size != null) {
            return size;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        final ViewTreeObserver viewTreeObserver = viewSizeResolver.getView().getViewTreeObserver();
        final ?? r2 = new ViewTreeObserver.OnPreDrawListener(viewSizeResolver) { // from class: coil3.size.ViewSizeResolver$size$3$preDrawListener$1
            private boolean isResumed;
            final /* synthetic */ ViewSizeResolver<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.this$0 = viewSizeResolver;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Size size2 = this.this$0.getSize();
                if (size2 != null) {
                    this.this$0.removePreDrawListenerSafe(viewTreeObserver, this);
                    if (!this.isResumed) {
                        this.isResumed = true;
                        CancellableContinuation<Size> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.f53538b;
                        cancellableContinuation.resumeWith(size2);
                    }
                }
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r2);
        cancellableContinuationImpl.u(new Function1<Throwable, Unit>(viewSizeResolver) { // from class: coil3.size.ViewSizeResolver$size$3$1
            final /* synthetic */ ViewSizeResolver<T> this$0;

            {
                this.this$0 = viewSizeResolver;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f53572a;
            }

            public final void invoke(Throwable th) {
                this.this$0.removePreDrawListenerSafe(viewTreeObserver, r2);
            }
        });
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    default boolean getSubtractPadding() {
        return true;
    }

    @NotNull
    T getView();

    @Override // coil3.size.SizeResolver
    @Nullable
    default Object size(@NotNull Continuation<? super Size> continuation) {
        return size$suspendImpl(this, continuation);
    }
}
