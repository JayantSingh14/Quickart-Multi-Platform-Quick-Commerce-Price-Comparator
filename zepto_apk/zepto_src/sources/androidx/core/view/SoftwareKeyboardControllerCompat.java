package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class SoftwareKeyboardControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final Impl20 f3067a;

    public static class Impl {
    }

    @RequiresApi
    public static class Impl20 extends Impl {

        /* renamed from: a, reason: collision with root package name */
        public final View f3068a;

        public Impl20(View view) {
            this.f3068a = view;
        }

        public void a() {
            View view = this.f3068a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        public void b() {
            View viewFindViewById;
            View view = this.f3068a;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
                viewFindViewById = view;
            } else {
                viewFindViewById = view.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = view.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new d(0, viewFindViewById));
        }
    }

    @RequiresApi
    public static class Impl30 extends Impl20 {

        /* renamed from: b, reason: collision with root package name */
        public View f3069b;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsetsController f3070c;

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.core.view.f] */
        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20
        public final void a() {
            WindowInsetsController windowInsetsController = this.f3070c;
            View view = this.f3069b;
            if (windowInsetsController == null) {
                windowInsetsController = view != null ? view.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ?? r4 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.f
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i2) {
                    atomicBoolean.set((i2 & 8) != 0);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(r4);
            if (!atomicBoolean.get() && view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(r4);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20
        public final void b() {
            View view = this.f3069b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f3070c;
            if (windowInsetsController == null) {
                windowInsetsController = view != null ? view.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            this.f3067a = new Impl20(view);
            return;
        }
        Impl30 impl30 = new Impl30(view);
        impl30.f3069b = view;
        this.f3067a = impl30;
    }

    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        Impl30 impl30 = new Impl30(null);
        impl30.f3070c = windowInsetsController;
        this.f3067a = impl30;
    }
}
