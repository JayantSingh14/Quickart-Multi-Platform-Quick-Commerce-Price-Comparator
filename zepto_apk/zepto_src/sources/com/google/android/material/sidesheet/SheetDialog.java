package com.google.android.material.sidesheet;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {

    /* renamed from: l, reason: collision with root package name */
    public static final int f41090l = R.id.coordinator;

    /* renamed from: m, reason: collision with root package name */
    public static final int f41091m = R.id.touch_outside;

    /* renamed from: f, reason: collision with root package name */
    public Sheet f41092f;

    /* renamed from: g, reason: collision with root package name */
    public FrameLayout f41093g;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f41094h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41095i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41096j;

    /* renamed from: k, reason: collision with root package name */
    public MaterialBackOrchestrator f41097k;

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        h();
        super.cancel();
    }

    public abstract void f(Sheet sheet);

    public final void g() {
        if (this.f41093g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), k(), null);
            this.f41093g = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(j());
            this.f41094h = frameLayout2;
            SideSheetBehavior sideSheetBehaviorI = i(frameLayout2);
            this.f41092f = sideSheetBehaviorI;
            f(sideSheetBehaviorI);
            this.f41097k = new MaterialBackOrchestrator(this.f41092f, this.f41094h);
        }
    }

    public Sheet h() {
        if (this.f41092f == null) {
            g();
        }
        return this.f41092f;
    }

    public abstract SideSheetBehavior i(FrameLayout frameLayout);

    public abstract int j();

    public abstract int k();

    public final FrameLayout l(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        g();
        if (this.f41093g == null) {
            g();
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f41093g.findViewById(f41090l);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f41094h == null) {
            g();
        }
        FrameLayout frameLayout = this.f41094h;
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f41091m).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.sidesheet.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SheetDialog sheetDialog = this.f41120a;
                if (sheetDialog.f41095i && sheetDialog.isShowing() && sheetDialog.f41096j) {
                    sheetDialog.cancel();
                }
            }
        });
        if (this.f41094h == null) {
            g();
        }
        ViewCompat.z(this.f41094h, new AccessibilityDelegateCompat() { // from class: com.google.android.material.sidesheet.SheetDialog.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                boolean z = SheetDialog.this.f41095i;
                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
                if (!z) {
                    accessibilityNodeInfo.setDismissable(false);
                } else {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfo.setDismissable(true);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view2, int i3, Bundle bundle) {
                if (i3 == 1048576) {
                    SheetDialog sheetDialog = SheetDialog.this;
                    if (sheetDialog.f41095i) {
                        sheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i3, bundle);
            }
        });
        return this.f41093g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        FrameLayout frameLayout;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null && (frameLayout = this.f41094h) != null && (frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            int i2 = ((CoordinatorLayout.LayoutParams) this.f41094h.getLayoutParams()).f2562c;
            FrameLayout frameLayout2 = this.f41094h;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            window.setWindowAnimations(Gravity.getAbsoluteGravity(i2, frameLayout2.getLayoutDirection()) == 3 ? R.style.Animation_Material3_SideSheetDialog_Left : R.style.Animation_Material3_SideSheetDialog_Right);
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.f41097k;
        if (this.f41095i) {
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
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator materialBackOrchestrator = this.f41097k;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.b();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Sheet sheet = this.f41092f;
        if (sheet == null || sheet.getState() != 5) {
            return;
        }
        this.f41092f.f(3);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f41095i != z) {
            this.f41095i = z;
        }
        if (getWindow() != null) {
            MaterialBackOrchestrator materialBackOrchestrator = this.f41097k;
            if (this.f41095i) {
                materialBackOrchestrator.a(false);
            } else {
                materialBackOrchestrator.b();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f41095i) {
            this.f41095i = true;
        }
        this.f41096j = z;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(l(null, i2, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(l(view, 0, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(l(view, 0, layoutParams));
    }
}
