package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface DisplayOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void a();
    }

    @Deprecated
    public interface OnNavigationListener {
    }

    @Deprecated
    public static abstract class Tab {
    }

    @Deprecated
    public interface TabListener {
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void h(boolean z) {
    }

    public abstract int i();

    public Context j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    public void m() {
    }

    public boolean n(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public void q(boolean z) {
    }

    public abstract void r(boolean z);

    public void s(Drawable drawable) {
    }

    public void t(boolean z) {
    }

    public abstract void u(CharSequence charSequence);

    public void v(CharSequence charSequence) {
    }

    public ActionMode w(ActionMode.Callback callback) {
        return null;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f243a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f243a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f243a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f243a = 0;
            this.f243a = layoutParams.f243a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f243a = 0;
        }
    }

    public void l() {
    }
}
