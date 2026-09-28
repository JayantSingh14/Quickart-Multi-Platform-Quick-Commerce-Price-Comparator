package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import com.google.android.gms.common.api.Api;

@RestrictTo
/* loaded from: classes3.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f684a;

    /* renamed from: b, reason: collision with root package name */
    public ScrollingTabContainerView f685b;

    /* renamed from: c, reason: collision with root package name */
    public View f686c;

    /* renamed from: d, reason: collision with root package name */
    public View f687d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f688e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f689f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f690g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f691h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f692i;

    /* renamed from: j, reason: collision with root package name */
    public final int f693j;

    @RequiresApi
    public static class Api21Impl {
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new ActionBarBackgroundDrawable(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f688e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f689f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f693j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.f691h = true;
            this.f690g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f691h ? this.f688e != null || this.f689f != null : this.f690g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f688e;
        if (drawable != null && drawable.isStateful()) {
            this.f688e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f689f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f689f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f690g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f690g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f685b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f688e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f689f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f690g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f686c = findViewById(R.id.action_bar);
        this.f687d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f684a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[PHI: r1
      0x0049: PHI (r1v8 boolean) = (r1v1 boolean), (r1v1 boolean), (r1v0 boolean) binds: [B:31:0x00a6, B:33:0x00aa, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            r6 = r5
            androidx.appcompat.widget.ScrollingTabContainerView r8 = r6.f685b
            r10 = 8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L14
            int r2 = r8.getVisibility()
            if (r2 == r10) goto L14
            r2 = r0
            goto L15
        L14:
            r2 = r1
        L15:
            if (r8 == 0) goto L34
            int r3 = r8.getVisibility()
            if (r3 == r10) goto L34
            int r10 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r4 = r8.getMeasuredHeight()
            int r4 = r10 - r4
            int r3 = r3.bottomMargin
            int r4 = r4 - r3
            int r10 = r10 - r3
            r8.layout(r7, r4, r9, r10)
        L34:
            boolean r7 = r6.f691h
            if (r7 == 0) goto L4c
            android.graphics.drawable.Drawable r7 = r6.f690g
            if (r7 == 0) goto L49
            int r8 = r5.getMeasuredWidth()
            int r9 = r5.getMeasuredHeight()
            r7.setBounds(r1, r1, r8, r9)
            goto Lbf
        L49:
            r0 = r1
            goto Lbf
        L4c:
            android.graphics.drawable.Drawable r7 = r6.f688e
            if (r7 == 0) goto La4
            android.view.View r7 = r6.f686c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L76
            android.graphics.drawable.Drawable r7 = r6.f688e
            android.view.View r9 = r6.f686c
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f686c
            int r10 = r10.getTop()
            android.view.View r1 = r6.f686c
            int r1 = r1.getRight()
            android.view.View r3 = r6.f686c
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L76:
            android.view.View r7 = r6.f687d
            if (r7 == 0) goto L9e
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9e
            android.graphics.drawable.Drawable r7 = r6.f688e
            android.view.View r9 = r6.f687d
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f687d
            int r10 = r10.getTop()
            android.view.View r1 = r6.f687d
            int r1 = r1.getRight()
            android.view.View r3 = r6.f687d
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L9e:
            android.graphics.drawable.Drawable r7 = r6.f688e
            r7.setBounds(r1, r1, r1, r1)
        La3:
            r1 = r0
        La4:
            r6.f692i = r2
            if (r2 == 0) goto L49
            android.graphics.drawable.Drawable r7 = r6.f689f
            if (r7 == 0) goto L49
            int r9 = r8.getLeft()
            int r10 = r8.getTop()
            int r1 = r8.getRight()
            int r8 = r8.getBottom()
            r7.setBounds(r9, r10, r1, r8)
        Lbf:
            if (r0 == 0) goto Lc4
            r5.invalidate()
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int iA;
        int i4;
        if (this.f686c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f693j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f686c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        ScrollingTabContainerView scrollingTabContainerView = this.f685b;
        if (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f686c;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f687d;
            iA = (view2 == null || view2.getVisibility() == 8 || view2.getMeasuredHeight() == 0) ? 0 : a(this.f687d);
        } else {
            iA = a(this.f686c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f685b) + iA, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Api.BaseClientBuilder.API_PRIORITY_OTHER));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f688e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f688e);
        }
        this.f688e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f686c;
            if (view != null) {
                this.f688e.setBounds(view.getLeft(), this.f686c.getTop(), this.f686c.getRight(), this.f686c.getBottom());
            }
        }
        boolean z = false;
        if (!this.f691h ? !(this.f688e != null || this.f689f != null) : this.f690g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f690g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f690g);
        }
        this.f690g = drawable;
        boolean z = this.f691h;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.f690g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.f688e != null || this.f689f != null) : this.f690g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f689f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f689f);
        }
        this.f689f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f692i && (drawable2 = this.f689f) != null) {
                drawable2.setBounds(this.f685b.getLeft(), this.f685b.getTop(), this.f685b.getRight(), this.f685b.getBottom());
            }
        }
        boolean z = false;
        if (!this.f691h ? !(this.f688e != null || this.f689f != null) : this.f690g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f685b;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f685b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f684a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f688e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f689f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f690g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f688e;
        boolean z = this.f691h;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.f689f && this.f692i) {
            return true;
        }
        return (drawable == this.f690g && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }
}
