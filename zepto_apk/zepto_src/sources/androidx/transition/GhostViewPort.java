package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
class GhostViewPort extends ViewGroup implements GhostView {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f12090g = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f12091a;

    /* renamed from: b, reason: collision with root package name */
    public View f12092b;

    /* renamed from: c, reason: collision with root package name */
    public final View f12093c;

    /* renamed from: d, reason: collision with root package name */
    public int f12094d;

    /* renamed from: e, reason: collision with root package name */
    public Matrix f12095e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f12096f;

    public GhostViewPort(View view) {
        super(view.getContext());
        this.f12096f = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                View view2;
                GhostViewPort ghostViewPort = GhostViewPort.this;
                ghostViewPort.postInvalidateOnAnimation();
                ViewGroup viewGroup = ghostViewPort.f12091a;
                if (viewGroup == null || (view2 = ghostViewPort.f12092b) == null) {
                    return true;
                }
                viewGroup.endViewTransition(view2);
                ghostViewPort.f12091a.postInvalidateOnAnimation();
                ghostViewPort.f12091a = null;
                ghostViewPort.f12092b = null;
                return true;
            }
        };
        this.f12093c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    @Override // androidx.transition.GhostView
    public final void a(View view, ViewGroup viewGroup) {
        this.f12091a = viewGroup;
        this.f12092b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.onAttachedToWindow();
        int i2 = R.id.ghost_view;
        View view = this.f12093c;
        view.setTag(i2, this);
        view.getViewTreeObserver().addOnPreDrawListener(this.f12096f);
        ViewUtils.c(view, 4);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        View view = this.f12093c;
        view.getViewTreeObserver().removeOnPreDrawListener(this.f12096f);
        ViewUtils.c(view, 0);
        view.setTag(R.id.ghost_view, null);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.f12095e);
        View view = this.f12093c;
        ViewUtils.c(view, 0);
        view.invalidate();
        ViewUtils.c(view, 4);
        drawChild(canvas, view, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View, androidx.transition.GhostView
    public final void setVisibility(int i2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.setVisibility(i2);
        int i3 = R.id.ghost_view;
        View view = this.f12093c;
        if (((GhostViewPort) view.getTag(i3)) == this) {
            ViewUtils.c(view, i2 == 0 ? 4 : 0);
        }
    }
}
