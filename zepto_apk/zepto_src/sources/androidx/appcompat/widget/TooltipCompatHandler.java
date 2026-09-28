package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes3.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    public static TooltipCompatHandler f1241k;

    /* renamed from: l, reason: collision with root package name */
    public static TooltipCompatHandler f1242l;

    /* renamed from: a, reason: collision with root package name */
    public final View f1243a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f1244b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1245c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1246d;

    /* renamed from: e, reason: collision with root package name */
    public final f f1247e;

    /* renamed from: f, reason: collision with root package name */
    public int f1248f;

    /* renamed from: g, reason: collision with root package name */
    public int f1249g;

    /* renamed from: h, reason: collision with root package name */
    public TooltipPopup f1250h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1251i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1252j = true;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.f] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.f] */
    public TooltipCompatHandler(View view, CharSequence charSequence) {
        final int i2 = 0;
        this.f1246d = new Runnable(this) { // from class: androidx.appcompat.widget.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TooltipCompatHandler f1273b;

            {
                this.f1273b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                switch (i2) {
                    case 0:
                        this.f1273b.c(false);
                        break;
                    default:
                        this.f1273b.a();
                        break;
                }
            }
        };
        final int i3 = 1;
        this.f1247e = new Runnable(this) { // from class: androidx.appcompat.widget.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TooltipCompatHandler f1273b;

            {
                this.f1273b = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                switch (i3) {
                    case 0:
                        this.f1273b.c(false);
                        break;
                    default:
                        this.f1273b.a();
                        break;
                }
            }
        };
        this.f1243a = view;
        this.f1244b = charSequence;
        this.f1245c = ViewConfigurationCompat.c(ViewConfiguration.get(view.getContext()));
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f1241k;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.f1243a.removeCallbacks(tooltipCompatHandler2.f1246d);
        }
        f1241k = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.f1243a.postDelayed(tooltipCompatHandler.f1246d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        TooltipCompatHandler tooltipCompatHandler = f1242l;
        View view = this.f1243a;
        if (tooltipCompatHandler == this) {
            f1242l = null;
            TooltipPopup tooltipPopup = this.f1250h;
            if (tooltipPopup != null) {
                View view2 = tooltipPopup.f1254b;
                if (view2.getParent() != null) {
                    ((WindowManager) tooltipPopup.f1253a.getSystemService("window")).removeView(view2);
                }
                this.f1250h = null;
                this.f1252j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1241k == this) {
            b(null);
        }
        view.removeCallbacks(this.f1247e);
    }

    public final void c(boolean z) throws Resources.NotFoundException {
        int height;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long longPressTimeout;
        long j2;
        long j3;
        View view = this.f1243a;
        if (view.isAttachedToWindow()) {
            b(null);
            TooltipCompatHandler tooltipCompatHandler = f1242l;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.a();
            }
            f1242l = this;
            this.f1251i = z;
            TooltipPopup tooltipPopup = new TooltipPopup(view.getContext());
            this.f1250h = tooltipPopup;
            int width = this.f1248f;
            int i7 = this.f1249g;
            boolean z2 = this.f1251i;
            View view2 = tooltipPopup.f1254b;
            ViewParent parent = view2.getParent();
            Context context = tooltipPopup.f1253a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            tooltipPopup.f1255c.setText(this.f1244b);
            WindowManager.LayoutParams layoutParams = tooltipPopup.f1256d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i7 + dimensionPixelOffset2;
                i2 = i7 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i2 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i6 = 1;
            } else {
                Rect rect = tooltipPopup.f1257e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i3 = width;
                    i4 = i2;
                    i5 = 0;
                    i6 = 1;
                } else {
                    Resources resources = context.getResources();
                    i6 = 1;
                    i3 = width;
                    i4 = i2;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", LogSubCategory.LifeCycle.ANDROID);
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i5 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = tooltipPopup.f1259g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = tooltipPopup.f1258f;
                view.getLocationOnScreen(iArr2);
                int i8 = iArr2[i5] - iArr[i5];
                iArr2[i5] = i8;
                iArr2[i6] = iArr2[i6] - iArr[i6];
                layoutParams.x = (i8 + i3) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, i5);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i9 = iArr2[i6];
                int i10 = ((i9 + i4) - dimensionPixelOffset3) - measuredHeight;
                int i11 = i9 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i10 >= 0) {
                        layoutParams.y = i10;
                    } else {
                        layoutParams.y = i11;
                    }
                } else if (measuredHeight + i11 <= rect.height()) {
                    layoutParams.y = i11;
                } else {
                    layoutParams.y = i10;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.f1251i) {
                j3 = 2500;
            } else {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if ((view.getWindowSystemUiVisibility() & 1) == i6) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 15000;
                }
                j3 = j2 - longPressTimeout;
            }
            f fVar = this.f1247e;
            view.removeCallbacks(fVar);
            view.postDelayed(fVar, j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.widget.TooltipPopup r4 = r3.f1250h
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f1251i
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f1243a
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f1252j = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            androidx.appcompat.widget.TooltipPopup r4 = r3.f1250h
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f1252j
            if (r1 != 0) goto L66
            int r1 = r3.f1248f
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f1245c
            if (r1 > r2) goto L66
            int r1 = r3.f1249g
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f1248f = r4
            r3.f1249g = r5
            r3.f1252j = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TooltipCompatHandler.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f1248f = view.getWidth() / 2;
        this.f1249g = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
