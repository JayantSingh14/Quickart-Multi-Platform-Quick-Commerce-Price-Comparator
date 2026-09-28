package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class ViewUtils {

    /* renamed from: com.google.android.material.internal.ViewUtils$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.x(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    public static class RelativePadding {

        /* renamed from: a, reason: collision with root package name */
        public int f40660a;

        /* renamed from: b, reason: collision with root package name */
        public int f40661b;

        /* renamed from: c, reason: collision with root package name */
        public int f40662c;

        /* renamed from: d, reason: collision with root package name */
        public int f40663d;
    }

    public static Rect a(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i4 = i2 - iArr2[0];
        int i5 = i3 - iArr2[1];
        return new Rect(i4, i5, view2.getWidth() + i4, view2.getHeight() + i5);
    }

    public static void b(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int paddingStart = view.getPaddingStart();
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        final RelativePadding relativePadding = new RelativePadding();
        relativePadding.f40660a = paddingStart;
        relativePadding.f40661b = paddingTop;
        relativePadding.f40662c = paddingEnd;
        relativePadding.f40663d = paddingBottom;
        ViewCompat.H(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view2, WindowInsetsCompat windowInsetsCompat) {
                RelativePadding relativePadding2 = new RelativePadding();
                RelativePadding relativePadding3 = relativePadding;
                relativePadding2.f40660a = relativePadding3.f40660a;
                relativePadding2.f40661b = relativePadding3.f40661b;
                relativePadding2.f40662c = relativePadding3.f40662c;
                relativePadding2.f40663d = relativePadding3.f40663d;
                return onApplyWindowInsetsListener.a(view2, windowInsetsCompat, relativePadding2);
            }
        });
        if (view.isAttachedToWindow()) {
            ViewCompat.x(view);
        } else {
            view.addOnAttachStateChangeListener(new AnonymousClass3());
        }
    }

    public static void c(BottomAppBar bottomAppBar, AttributeSet attributeSet, int i2, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray typedArrayObtainStyledAttributes = bottomAppBar.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, BottomAppBar.d1);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        b(bottomAppBar, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding) {
                if (z) {
                    relativePadding.f40663d = windowInsetsCompat.g() + relativePadding.f40663d;
                }
                boolean zH = ViewUtils.h(view);
                if (z2) {
                    if (zH) {
                        relativePadding.f40662c = windowInsetsCompat.h() + relativePadding.f40662c;
                    } else {
                        relativePadding.f40660a = windowInsetsCompat.h() + relativePadding.f40660a;
                    }
                }
                if (z3) {
                    if (zH) {
                        relativePadding.f40660a = windowInsetsCompat.i() + relativePadding.f40660a;
                    } else {
                        relativePadding.f40662c = windowInsetsCompat.i() + relativePadding.f40662c;
                    }
                }
                int i3 = relativePadding.f40660a;
                int i4 = relativePadding.f40661b;
                int i5 = relativePadding.f40662c;
                int i6 = relativePadding.f40663d;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.setPaddingRelative(i3, i4, i5, i6);
                onApplyWindowInsetsListener.a(view, windowInsetsCompat, relativePadding);
                return windowInsetsCompat;
            }
        });
    }

    public static float d(int i2, Context context) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup e(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl f(View view) {
        if (view == null) {
            return null;
        }
        return new ViewOverlayApi18(view);
    }

    public static void g(View view, boolean z) {
        WindowInsetsControllerCompat windowInsetsControllerCompatP;
        if (z && (windowInsetsControllerCompatP = ViewCompat.p(view)) != null) {
            windowInsetsControllerCompatP.b(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean h(View view) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return view.getLayoutDirection() == 1;
    }

    public static PorterDuff.Mode i(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
