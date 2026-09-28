package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class ViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    @TargetApi(12)
    public interface OnViewAttachedToWindow {
    }

    @TargetApi(12)
    public interface OnViewDetachedFromWindow {
    }
}
