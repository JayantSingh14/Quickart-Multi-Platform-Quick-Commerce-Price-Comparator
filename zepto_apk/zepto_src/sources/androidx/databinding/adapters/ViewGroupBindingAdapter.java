package androidx.databinding.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class ViewGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements ViewGroup.OnHierarchyChangeListener {
        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
        }
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public interface OnAnimationEnd {
    }

    public interface OnAnimationRepeat {
    }

    public interface OnAnimationStart {
    }

    public interface OnChildViewAdded {
    }

    public interface OnChildViewRemoved {
    }
}
