package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: m, reason: collision with root package name */
    public static final int f40057m = R.style.Widget_Material3_BottomSheet_DragHandle;

    /* renamed from: d, reason: collision with root package name */
    public final AccessibilityManager f40058d;

    /* renamed from: e, reason: collision with root package name */
    public BottomSheetBehavior f40059e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40060f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40061g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40062h;

    /* renamed from: i, reason: collision with root package name */
    public final String f40063i;

    /* renamed from: j, reason: collision with root package name */
    public final String f40064j;

    /* renamed from: k, reason: collision with root package name */
    public final String f40065k;

    /* renamed from: l, reason: collision with root package name */
    public final BottomSheetBehavior.BottomSheetCallback f40066l;

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior) throws Resources.NotFoundException {
        BottomSheetBehavior bottomSheetBehavior2 = this.f40059e;
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.f40066l;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.M(bottomSheetCallback);
            this.f40059e.N(null);
        }
        this.f40059e = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.N(this);
            d(this.f40059e.L);
            this.f40059e.y(bottomSheetCallback);
        }
        e();
    }

    public final boolean c() throws Resources.NotFoundException {
        if (!this.f40061g) {
            return false;
        }
        AccessibilityManager accessibilityManager = this.f40058d;
        if (accessibilityManager != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
            accessibilityEventObtain.getText().add(this.f40065k);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
        BottomSheetBehavior bottomSheetBehavior = this.f40059e;
        boolean z = bottomSheetBehavior.f40008b;
        int i2 = bottomSheetBehavior.L;
        int i3 = 6;
        int i4 = 3;
        if (i2 == 4) {
            if (z) {
                i3 = i4;
            }
        } else if (i2 != 3) {
            if (!this.f40062h) {
                i4 = 4;
            }
            i3 = i4;
        } else if (z) {
            i3 = 4;
        }
        bottomSheetBehavior.f(i3);
        return true;
    }

    public final void d(int i2) {
        if (i2 == 4) {
            this.f40062h = true;
        } else if (i2 == 3) {
            this.f40062h = false;
        }
        ViewCompat.w(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3189g, this.f40062h ? this.f40063i : this.f40064j, new l(this, 11));
    }

    public final void e() {
        this.f40061g = this.f40060f && this.f40059e != null;
        int i2 = this.f40059e == null ? 2 : 1;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(i2);
        setClickable(this.f40061g);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this.f40060f = z;
        e();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() throws Resources.NotFoundException {
        BottomSheetBehavior<?> bottomSheetBehavior;
        super.onAttachedToWindow();
        View view = this;
        while (true) {
            Object parent = view.getParent();
            bottomSheetBehavior = null;
            view = parent instanceof View ? (View) parent : null;
            if (view == null) {
                break;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).f2560a;
                if (behavior instanceof BottomSheetBehavior) {
                    bottomSheetBehavior = (BottomSheetBehavior) behavior;
                    break;
                }
            }
        }
        setBottomSheetBehavior(bottomSheetBehavior);
        AccessibilityManager accessibilityManager = this.f40058d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(accessibilityManager.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() throws Resources.NotFoundException {
        AccessibilityManager accessibilityManager = this.f40058d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.a(context, attributeSet, i2, f40057m), attributeSet, i2);
        this.f40063i = getResources().getString(R.string.bottomsheet_action_expand);
        this.f40064j = getResources().getString(R.string.bottomsheet_action_collapse);
        this.f40065k = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.f40066l = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDragHandleView.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view, float f2) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int i3) {
                int i4 = BottomSheetDragHandleView.f40057m;
                BottomSheetDragHandleView.this.d(i3);
            }
        };
        this.f40058d = (AccessibilityManager) getContext().getSystemService("accessibility");
        e();
        ViewCompat.z(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDragHandleView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) throws Resources.NotFoundException {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    int i3 = BottomSheetDragHandleView.f40057m;
                    BottomSheetDragHandleView.this.c();
                }
            }
        });
    }
}
