package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    /* loaded from: classes3.dex */
    public static abstract class AnimationCallback {

        /* renamed from: a, reason: collision with root package name */
        public Animatable2.AnimationCallback f12221a;

        /* renamed from: androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback$1, reason: invalid class name */
        class AnonymousClass1 extends Animatable2.AnimationCallback {
            public AnonymousClass1() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public final void onAnimationEnd(Drawable drawable) {
                AnimationCallback.this.a(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public final void onAnimationStart(Drawable drawable) {
                AnimationCallback.this.b(drawable);
            }
        }

        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }
    }
}
