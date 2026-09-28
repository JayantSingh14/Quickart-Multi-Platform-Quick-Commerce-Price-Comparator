package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.R;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BlendModeHelper;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.zeptoconsumerapp.BuildConfig;
import java.util.HashSet;
import java.util.Set;

@Nullsafe
/* loaded from: classes.dex */
public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup, ReactOverflowViewWithInset {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);

    @Nullable
    private View[] mAllChildren;
    private int mAllChildrenCount;
    private float mBackfaceOpacity;
    private boolean mBackfaceVisible;

    @Nullable
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;

    @Nullable
    private Set<Integer> mChildrenRemovedWhileTransitioning;

    @Nullable
    private Rect mClippingRect;

    @Nullable
    private ViewGroupDrawingOrderHelper mDrawingOrderHelper;

    @Nullable
    private Rect mHitSlopRect;
    private volatile boolean mInSubviewClippingLoop;
    private boolean mNeedsOffscreenAlphaCompositing;

    @Nullable
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private Overflow mOverflow;
    private final Rect mOverflowInset;
    private PointerEvents mPointerEvents;
    private int mRecycleCount;
    private boolean mRemoveClippedSubviews;

    /* renamed from: com.facebook.react.views.view.ReactViewGroup$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20239a;

        static {
            int[] iArr = new int[Overflow.values().length];
            f20239a = iArr;
            try {
                Overflow.Companion companion = Overflow.f19917a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f20239a;
                Overflow.Companion companion2 = Overflow.f19917a;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f20239a;
                Overflow.Companion companion3 = Overflow.f19917a;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public ReactViewGroup f20240a;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.f20240a = reactViewGroup;
        }

        public final void a() {
            this.f20240a = null;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            ReactViewGroup reactViewGroup = this.f20240a;
            if (reactViewGroup == null || !reactViewGroup.getRemoveClippedSubviews()) {
                return;
            }
            ReactViewGroup.b(this.f20240a, view);
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        this.mOverflowInset = new Rect();
        this.mRecycleCount = 0;
        this.mPointerEvents = PointerEvents.f19428e;
        f();
    }

    public static void b(ReactViewGroup reactViewGroup, View view) {
        if (!reactViewGroup.mRemoveClippedSubviews || reactViewGroup.getParent() == null) {
            return;
        }
        Assertions.c(reactViewGroup.mClippingRect);
        Assertions.c(reactViewGroup.mAllChildren);
        if (reactViewGroup.mClippingRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != (!reactViewGroup.g(view, null))) {
            reactViewGroup.mInSubviewClippingLoop = true;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= reactViewGroup.mAllChildrenCount) {
                    break;
                }
                View view2 = reactViewGroup.mAllChildren[i2];
                if (view2 == view) {
                    reactViewGroup.i(reactViewGroup.mClippingRect, i2, i3);
                    break;
                } else {
                    if (reactViewGroup.g(view2, Integer.valueOf(i2))) {
                        i3++;
                    }
                    i2++;
                }
            }
            reactViewGroup.mInSubviewClippingLoop = false;
        }
    }

    private ViewGroupDrawingOrderHelper getDrawingOrderHelper() {
        if (this.mDrawingOrderHelper == null) {
            this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
        }
        return this.mDrawingOrderHelper;
    }

    public void addViewWithSubviewClippingEnabled(View view, int i2) {
        addViewWithSubviewClippingEnabled(view, i2, sDefaultLayoutParam);
    }

    public final void c(View view, Boolean bool) {
        if (this.mInSubviewClippingLoop) {
            Object tag = view.getTag(R.id.view_clipped);
            if (!bool.equals(tag)) {
                ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_ON_VIEW_REMOVED, new ReactNoCrashSoftException("View clipping tag mismatch: tag=" + tag + " expected=" + bool));
            }
        }
        if (this.mRemoveClippedSubviews) {
            view.setTag(R.id.view_clipped, bool);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.mOverflow != Overflow.f19918b || getTag(R.id.filter) != null) {
            BackgroundStyleApplicator.a(this, canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (PointerEvents.b(this.mPointerEvents)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e2) {
            FLog.h("ReactNative", "NullPointerException when executing dispatchProvideStructure", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 29 || ViewUtil.b(this) != 2 || !BlendModeHelper.a(this)) {
            super.draw(canvas);
            return;
        }
        Rect overflowInset = getOverflowInset();
        canvas.saveLayer(overflowInset.left, overflowInset.top, getWidth() + (-overflowInset.right), getHeight() + (-overflowInset.bottom), null);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Canvas canvas2;
        BlendMode blendModeD;
        boolean z = view.getElevation() > 0.0f;
        if (z) {
            CanvasUtil.a(canvas, true);
        }
        if (Build.VERSION.SDK_INT >= 29 && ViewUtil.b(this) == 2 && BlendModeHelper.a(this)) {
            blendModeD = androidx.appcompat.widget.a.d(view.getTag(R.id.mix_blend_mode));
            if (blendModeD != null) {
                Paint paint = new Paint();
                paint.setBlendMode(blendModeD);
                Rect overflowInset = getOverflowInset();
                float f2 = overflowInset.left;
                float f3 = overflowInset.top;
                float width = getWidth() + (-overflowInset.right);
                float height = getHeight() + (-overflowInset.bottom);
                canvas2 = canvas;
                canvas2.saveLayer(f2, f3, width, height, paint);
            } else {
                canvas2 = canvas;
            }
        } else {
            canvas2 = canvas;
            blendModeD = null;
        }
        boolean zDrawChild = super.drawChild(canvas2, view, j2);
        if (blendModeD != null) {
            canvas2.restore();
        }
        if (z) {
            CanvasUtil.a(canvas2, false);
        }
        return zDrawChild;
    }

    public final boolean e() {
        return getId() != -1 && ViewUtil.a(getId()) == 2;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        super.endViewTransition(view);
        Set<Integer> set = this.mChildrenRemovedWhileTransitioning;
        if (set != null) {
            set.remove(Integer.valueOf(view.getId()));
        }
    }

    public final void f() {
        setClipChildren(false);
        this.mRemoveClippedSubviews = false;
        this.mInSubviewClippingLoop = false;
        this.mAllChildren = null;
        this.mAllChildrenCount = 0;
        this.mClippingRect = null;
        this.mHitSlopRect = null;
        this.mOverflow = Overflow.f19918b;
        this.mPointerEvents = PointerEvents.f19428e;
        this.mChildrenLayoutChangeListener = null;
        this.mOnInterceptTouchEventListener = null;
        this.mNeedsOffscreenAlphaCompositing = false;
        this.mDrawingOrderHelper = null;
        this.mBackfaceOpacity = 1.0f;
        this.mBackfaceVisible = true;
        this.mChildrenRemovedWhileTransitioning = null;
    }

    public final boolean g(View view, Integer num) {
        Object tag = view.getTag(R.id.view_clipped);
        if (tag != null) {
            return ((Boolean) tag).booleanValue();
        }
        ViewParent parent = view.getParent();
        Set<Integer> set = this.mChildrenRemovedWhileTransitioning;
        boolean z = set != null && set.contains(Integer.valueOf(view.getId()));
        if (num != null) {
            StringBuilder sb = new StringBuilder("View missing clipping tag: index=");
            sb.append(num);
            sb.append(" parentNull=");
            sb.append(parent == null);
            sb.append(" parentThis=");
            sb.append(parent == this);
            sb.append(" transitioning=");
            sb.append(z);
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_IS_VIEW_CLIPPED, new ReactNoCrashSoftException(sb.toString()));
        }
        if (parent == null || z) {
            return true;
        }
        Assertions.a(parent == this);
        return false;
    }

    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    @Nullable
    public View getChildAtWithSubviewClippingEnabled(int i2) {
        if (i2 < 0 || i2 >= this.mAllChildrenCount) {
            return null;
        }
        View[] viewArr = this.mAllChildren;
        Assertions.c(viewArr);
        return viewArr[i2];
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        return !e() ? getDrawingOrderHelper().a(i2, i3) : i3;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    @Override // com.facebook.react.touch.ReactHitSlopView
    @Nullable
    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    @Override // com.facebook.react.uimanager.ReactOverflowView
    @Nullable
    public String getOverflow() {
        int iOrdinal = this.mOverflow.ordinal();
        if (iOrdinal == 0) {
            return "visible";
        }
        if (iOrdinal == 1) {
            return "hidden";
        }
        if (iOrdinal != 2) {
            return null;
        }
        return "scroll";
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public Rect getOverflowInset() {
        return this.mOverflowInset;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public int getZIndexMappedChildIndex(int i2) {
        UiThreadUtil.assertOnUiThread();
        return (e() || getDrawingOrderHelper().f19595b <= 0) ? i2 : getDrawingOrderHelper().a(getChildCount(), i2);
    }

    public final void h(Rect rect) {
        Assertions.c(this.mAllChildren);
        this.mInSubviewClippingLoop = true;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mAllChildrenCount; i3++) {
            try {
                i(rect, i3, i2);
                if (g(this.mAllChildren[i3], Integer.valueOf(i3))) {
                    i2++;
                }
            } catch (IndexOutOfBoundsException e2) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    i4 += g(this.mAllChildren[i5], null) ? 1 : 0;
                    hashSet.add(this.mAllChildren[i5]);
                }
                StringBuilder sbT = android.support.v4.media.b.t(i3, i2, "Invalid clipping state. i=", " clippedSoFar=", " count=");
                sbT.append(getChildCount());
                sbT.append(" allChildrenCount=");
                sbT.append(this.mAllChildrenCount);
                sbT.append(" recycleCount=");
                android.support.v4.media.a.q(this.mRecycleCount, i4, " realClippedSoFar=", " uniqueViewsCount=", sbT);
                sbT.append(hashSet.size());
                throw new IllegalStateException(sbT.toString(), e2);
            }
        }
        this.mInSubviewClippingLoop = false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Rect rect, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        View[] viewArr = this.mAllChildren;
        Assertions.c(viewArr);
        GLSurfaceView gLSurfaceView = viewArr[i2];
        boolean zIntersects = rect.intersects(gLSurfaceView.getLeft(), gLSurfaceView.getTop(), gLSurfaceView.getRight(), gLSurfaceView.getBottom());
        Animation animation = gLSurfaceView.getAnimation();
        boolean z = (animation == null || animation.hasEnded()) ? false : true;
        if (!zIntersects && !g(gLSurfaceView, Integer.valueOf(i2)) && !z) {
            gLSurfaceView.setTag(R.id.view_clipped, Boolean.TRUE);
            removeViewInLayout(gLSurfaceView);
        } else if (zIntersects && g(gLSurfaceView, Integer.valueOf(i2))) {
            int i4 = i2 - i3;
            Assertions.a(i4 >= 0);
            gLSurfaceView.setTag(R.id.view_clipped, Boolean.FALSE);
            addViewInLayout(gLSurfaceView, i4, sDefaultLayoutParam, true);
            invalidate();
        } else if (!zIntersects) {
            return;
        }
        if (gLSurfaceView instanceof ReactClippingViewGroup) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) gLSurfaceView;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return ReactFeatureFlags.dispatchPointerEvents ? PointerEvents.a(this.mPointerEvents) : super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if ((onInterceptTouchEventListener == null || !onInterceptTouchEventListener.a(this, motionEvent)) && PointerEvents.b(this.mPointerEvents)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        MeasureSpecAssertions.a(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return PointerEvents.a(this.mPointerEvents);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        UiThreadUtil.assertOnUiThread();
        c(view, Boolean.FALSE);
        if (e()) {
            setChildrenDrawingOrderEnabled(false);
        } else {
            ViewGroupDrawingOrderHelper drawingOrderHelper = getDrawingOrderHelper();
            drawingOrderHelper.getClass();
            if (ViewGroupManager.getViewZIndex(view) != null) {
                drawingOrderHelper.f19595b++;
            }
            drawingOrderHelper.f19596c = null;
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().f19595b > 0);
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        UiThreadUtil.assertOnUiThread();
        c(view, Boolean.TRUE);
        if (e()) {
            setChildrenDrawingOrderEnabled(false);
        } else {
            ViewGroupDrawingOrderHelper drawingOrderHelper = getDrawingOrderHelper();
            drawingOrderHelper.getClass();
            if (ViewGroupManager.getViewZIndex(view) != null) {
                drawingOrderHelper.f19595b--;
            }
            drawingOrderHelper.f19596c = null;
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().f19595b > 0);
        }
        if (view.getParent() != null) {
            int id = view.getId();
            if (this.mChildrenRemovedWhileTransitioning == null) {
                this.mChildrenRemovedWhileTransitioning = new HashSet();
            }
            this.mChildrenRemovedWhileTransitioning.add(Integer.valueOf(id));
        }
        super.onViewRemoved(view);
    }

    public void recycleView() {
        ChildrenLayoutChangeListener childrenLayoutChangeListener;
        this.mRecycleCount++;
        if (this.mAllChildren != null && (childrenLayoutChangeListener = this.mChildrenLayoutChangeListener) != null) {
            childrenLayoutChangeListener.a();
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
        }
        f();
        this.mOverflowInset.setEmpty();
        removeAllViews();
        updateBackgroundDrawable(null);
        resetPointerEvents();
    }

    public void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.a(this.mRemoveClippedSubviews);
        View[] viewArr = this.mAllChildren;
        Assertions.c(viewArr);
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            viewArr[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        Assertions.a(this.mRemoveClippedSubviews);
        Assertions.c(this.mClippingRect);
        View[] viewArr = this.mAllChildren;
        Assertions.c(viewArr);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int i2 = this.mAllChildrenCount;
        View[] viewArr2 = this.mAllChildren;
        Assertions.c(viewArr2);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                i3 = -1;
                break;
            } else if (viewArr2[i3] == view) {
                break;
            } else {
                i3++;
            }
        }
        if (!g(viewArr[i3], Integer.valueOf(i3))) {
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                if (g(viewArr[i5], Integer.valueOf(i5))) {
                    i4++;
                }
            }
            removeViewsInLayout(i3 - i4, 1);
            invalidate();
        }
        View[] viewArr3 = this.mAllChildren;
        Assertions.c(viewArr3);
        int i6 = this.mAllChildrenCount;
        int i7 = i6 - 1;
        if (i3 == i7) {
            this.mAllChildrenCount = i7;
            viewArr3[i7] = null;
        } else {
            if (i3 < 0 || i3 >= i6) {
                throw new IndexOutOfBoundsException();
            }
            System.arraycopy(viewArr3, i3 + 1, viewArr3, i3, (i6 - i3) - 1);
            int i8 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i8;
            viewArr3[i8] = null;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public void resetPointerEvents() {
        this.mPointerEvents = PointerEvents.f19428e;
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisible = "visible".equals(str);
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisible) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX < -90.0f || rotationX >= 90.0f || rotationY < -90.0f || rotationY >= 90.0f) {
            setAlpha(0.0f);
        } else {
            setAlpha(this.mBackfaceOpacity);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        BackgroundStyleApplicator.i(this, Integer.valueOf(i2));
    }

    public void setBorderColor(int i2, @Nullable Integer num) {
        BackgroundStyleApplicator.k(this, LogicalEdge.values()[i2], num);
    }

    @Deprecated(forRemoval = BuildConfig.IS_HERMES_ENABLED, since = "0.75.0")
    public void setBorderRadius(float f2) {
        BorderRadiusProp borderRadiusProp = BorderRadiusProp.f19836a;
        setBorderRadius(f2, 0);
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.m(this, str == null ? null : BorderStyle.a(str));
    }

    public void setBorderWidth(int i2, float f2) {
        BackgroundStyleApplicator.n(this, LogicalEdge.values()[i2], Float.valueOf(PixelUtil.a(f2)));
    }

    public void setHitSlopRect(@Nullable Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    @Override // com.facebook.react.touch.ReactInterceptingViewGroup
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public void setOpacityIfPossible(float f2) {
        this.mBackfaceOpacity = f2;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.mOverflow = Overflow.f19918b;
        } else {
            Overflow overflowA = Overflow.a(str);
            if (overflowA == null) {
                overflowA = Overflow.f19918b;
            }
            this.mOverflow = overflowA;
        }
        invalidate();
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public void setOverflowInset(int i2, int i3, int i4, int i5) {
        if (BlendModeHelper.a(this)) {
            Rect rect = this.mOverflowInset;
            if (rect.left != i2 || rect.top != i3 || rect.right != i4 || rect.bottom != i5) {
                invalidate();
            }
        }
        this.mOverflowInset.set(i2, i3, i4, i5);
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z == this.mRemoveClippedSubviews) {
            return;
        }
        this.mRemoveClippedSubviews = z;
        this.mChildrenRemovedWhileTransitioning = null;
        if (!z) {
            Assertions.c(this.mClippingRect);
            Assertions.c(this.mAllChildren);
            Assertions.c(this.mChildrenLayoutChangeListener);
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            h(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
            return;
        }
        Rect rect = new Rect();
        this.mClippingRect = rect;
        ReactClippingViewGroupHelper.a(this, rect);
        int childCount = getChildCount();
        this.mAllChildrenCount = childCount;
        this.mAllChildren = new View[Math.max(12, childCount)];
        this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener(this);
        for (int i3 = 0; i3 < this.mAllChildrenCount; i3++) {
            View childAt = getChildAt(i3);
            this.mAllChildren[i3] = childAt;
            childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            childAt.setTag(R.id.view_clipped, Boolean.FALSE);
        }
        updateClippingRect();
    }

    @Deprecated(forRemoval = BuildConfig.IS_HERMES_ENABLED, since = "0.76.0")
    public void setTranslucentBackgroundDrawable(@Nullable Drawable drawable) {
        BackgroundStyleApplicator.p(this, drawable);
    }

    public void updateBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.c(this.mClippingRect);
            Assertions.c(this.mAllChildren);
            ReactClippingViewGroupHelper.a(this, this.mClippingRect);
            h(this.mClippingRect);
        }
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public void updateDrawingOrder() {
        if (e()) {
            return;
        }
        getDrawingOrderHelper().b();
        setChildrenDrawingOrderEnabled(getDrawingOrderHelper().f19595b > 0);
        invalidate();
    }

    public void addViewWithSubviewClippingEnabled(final View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Assertions.a(this.mRemoveClippedSubviews);
        view.setTag(R.id.view_clipped, Boolean.TRUE);
        View[] viewArr = this.mAllChildren;
        Assertions.c(viewArr);
        int i3 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i2 == i3) {
            if (length == i3) {
                View[] viewArr2 = new View[length + 12];
                this.mAllChildren = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.mAllChildren;
            }
            int i4 = this.mAllChildrenCount;
            this.mAllChildrenCount = i4 + 1;
            viewArr[i4] = view;
        } else {
            if (i2 >= i3) {
                throw new IndexOutOfBoundsException(android.support.v4.media.b.d(i2, i3, "index=", " count="));
            }
            if (length == i3) {
                View[] viewArr3 = new View[length + 12];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i2);
                System.arraycopy(viewArr, i2, this.mAllChildren, i2 + 1, i3 - i2);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i2, viewArr, i2 + 1, i3 - i2);
            }
            viewArr[i2] = view;
            this.mAllChildrenCount++;
        }
        Rect rect = this.mClippingRect;
        Assertions.c(rect);
        View[] viewArr4 = this.mAllChildren;
        Assertions.c(viewArr4);
        this.mInSubviewClippingLoop = true;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            if (g(viewArr4[i6], Integer.valueOf(i6))) {
                i5++;
            }
        }
        i(rect, i2, i5);
        this.mInSubviewClippingLoop = false;
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.views.view.ReactViewGroup.1
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = view;
                    if (view2.isShown()) {
                        return;
                    }
                    ReactSoftExceptionLogger.logSoftException("ReactNative", new ReactNoCrashSoftException("Child view has been added to Parent view in which it is clipped and not visible. This is not legal for this particular child view. Child: [" + view2.getId() + "] " + view2.toString() + " Parent: [" + ReactViewGroup.this.getId() + "] " + toString()));
                }
            });
        }
    }

    @Deprecated(forRemoval = BuildConfig.IS_HERMES_ENABLED, since = "0.75.0")
    public void setBorderRadius(float f2, int i2) {
        BackgroundStyleApplicator.l(this, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    public void setBorderRadius(BorderRadiusProp borderRadiusProp, @Nullable LengthPercentage lengthPercentage) {
        BackgroundStyleApplicator.l(this, borderRadiusProp, lengthPercentage);
    }
}
