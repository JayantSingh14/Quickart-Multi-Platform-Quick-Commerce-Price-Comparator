package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes4.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: f, reason: collision with root package name */
    public BottomSheetBehavior f40040f;

    /* renamed from: g, reason: collision with root package name */
    public FrameLayout f40041g;

    /* renamed from: h, reason: collision with root package name */
    public CoordinatorLayout f40042h;

    /* renamed from: i, reason: collision with root package name */
    public FrameLayout f40043i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40044j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40045k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f40046l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f40047m;
    public EdgeToEdgeCallback n;
    public boolean o;
    public MaterialBackOrchestrator p;
    public final BottomSheetBehavior.BottomSheetCallback q;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f40052a;

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsetsCompat f40053b;

        /* renamed from: c, reason: collision with root package name */
        public Window f40054c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f40055d;

        public EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat) {
            this.f40053b = windowInsetsCompat;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.F(view).f40015i;
            ColorStateList colorStateListH = materialShapeDrawable != null ? materialShapeDrawable.f40974a.f40991c : ViewCompat.h(view);
            if (colorStateListH != null) {
                this.f40052a = Boolean.valueOf(MaterialColors.f(colorStateListH.getDefaultColor()));
                return;
            }
            ColorStateList colorStateListD = DrawableUtils.d(view.getBackground());
            Integer numValueOf = colorStateListD != null ? Integer.valueOf(colorStateListD.getDefaultColor()) : null;
            if (numValueOf != null) {
                this.f40052a = Boolean.valueOf(MaterialColors.f(numValueOf.intValue()));
            } else {
                this.f40052a = null;
            }
        }

        public final void a(View view) {
            int top = view.getTop();
            WindowInsetsCompat windowInsetsCompat = this.f40053b;
            if (top < windowInsetsCompat.j()) {
                Window window = this.f40054c;
                if (window != null) {
                    Boolean bool = this.f40052a;
                    new WindowInsetsControllerCompat(window, window.getDecorView()).e(bool == null ? this.f40055d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.j() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f40054c;
                if (window2 != null) {
                    new WindowInsetsControllerCompat(window2, window2.getDecorView()).e(this.f40055d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public final void b(Window window) {
            if (this.f40054c == window) {
                return;
            }
            this.f40054c = window;
            if (window != null) {
                this.f40055d = new WindowInsetsControllerCompat(window, window.getDecorView()).c();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onLayout(View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View view, float f2) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View view, int i2) {
            a(view);
        }
    }

    public BottomSheetDialog(Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            i2 = context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
        }
        super(context, i2);
        this.f40045k = true;
        this.f40046l = true;
        this.q = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view, float f2) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int i3) throws Resources.NotFoundException {
                if (i3 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        c().w(1);
        this.o = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() throws Resources.NotFoundException {
        if (this.f40040f == null) {
            f();
        }
        BottomSheetBehavior bottomSheetBehavior = this.f40040f;
        if (!this.f40044j || bottomSheetBehavior.L == 5) {
            super.cancel();
        } else {
            bottomSheetBehavior.f(5);
        }
    }

    public final void f() throws Resources.NotFoundException {
        if (this.f40041g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f40041g = frameLayout;
            this.f40042h = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f40041g.findViewById(R.id.design_bottom_sheet);
            this.f40043i = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorF = BottomSheetBehavior.F(frameLayout2);
            this.f40040f = bottomSheetBehaviorF;
            bottomSheetBehaviorF.y(this.q);
            this.f40040f.R(this.f40045k);
            this.p = new MaterialBackOrchestrator(this.f40040f, this.f40043i);
        }
    }

    public final FrameLayout g(View view, int i2, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        f();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f40041g.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        if (this.o) {
            ViewCompat.H(this.f40043i, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat b(View view2, WindowInsetsCompat windowInsetsCompat) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    EdgeToEdgeCallback edgeToEdgeCallback = bottomSheetDialog.n;
                    if (edgeToEdgeCallback != null) {
                        bottomSheetDialog.f40040f.M(edgeToEdgeCallback);
                    }
                    EdgeToEdgeCallback edgeToEdgeCallback2 = new EdgeToEdgeCallback(bottomSheetDialog.f40043i, windowInsetsCompat);
                    bottomSheetDialog.n = edgeToEdgeCallback2;
                    edgeToEdgeCallback2.b(bottomSheetDialog.getWindow());
                    bottomSheetDialog.f40040f.y(bottomSheetDialog.n);
                    return windowInsetsCompat;
                }
            });
        }
        this.f40043i.removeAllViews();
        if (layoutParams == null) {
            this.f40043i.addView(view);
        } else {
            this.f40043i.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f40045k && bottomSheetDialog.isShowing()) {
                    if (!bottomSheetDialog.f40047m) {
                        TypedArray typedArrayObtainStyledAttributes = bottomSheetDialog.getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
                        bottomSheetDialog.f40046l = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                        bottomSheetDialog.f40047m = true;
                    }
                    if (bottomSheetDialog.f40046l) {
                        bottomSheetDialog.cancel();
                    }
                }
            }
        });
        ViewCompat.z(this.f40043i, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                boolean z = BottomSheetDialog.this.f40045k;
                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
                if (!z) {
                    accessibilityNodeInfo.setDismissable(false);
                } else {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfo.setDismissable(true);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view2, int i3, Bundle bundle) throws Resources.NotFoundException {
                if (i3 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.f40045k) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i3, bundle);
            }
        });
        this.f40043i.setOnTouchListener(new AnonymousClass4());
        return this.f40041g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.o && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f40041g;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.f40042h;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            WindowCompat.b(window, !z);
            EdgeToEdgeCallback edgeToEdgeCallback = this.n;
            if (edgeToEdgeCallback != null) {
                edgeToEdgeCallback.b(window);
            }
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.p;
        if (materialBackOrchestrator == null) {
            return;
        }
        if (this.f40045k) {
            materialBackOrchestrator.a(false);
        } else {
            materialBackOrchestrator.b();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        EdgeToEdgeCallback edgeToEdgeCallback = this.n;
        if (edgeToEdgeCallback != null) {
            edgeToEdgeCallback.b(null);
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.p;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.b();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStart() throws Resources.NotFoundException {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f40040f;
        if (bottomSheetBehavior == null || bottomSheetBehavior.L != 5) {
            return;
        }
        bottomSheetBehavior.f(4);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) throws Resources.NotFoundException {
        MaterialBackOrchestrator materialBackOrchestrator;
        super.setCancelable(z);
        if (this.f40045k != z) {
            this.f40045k = z;
            BottomSheetBehavior bottomSheetBehavior = this.f40040f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.R(z);
            }
            if (getWindow() == null || (materialBackOrchestrator = this.p) == null) {
                return;
            }
            if (this.f40045k) {
                materialBackOrchestrator.a(false);
            } else {
                materialBackOrchestrator.b();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f40045k) {
            this.f40045k = true;
        }
        this.f40046l = z;
        this.f40047m = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int i2) {
        super.setContentView(g(null, i2, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(g(view, 0, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(g(view, 0, layoutParams));
    }
}
