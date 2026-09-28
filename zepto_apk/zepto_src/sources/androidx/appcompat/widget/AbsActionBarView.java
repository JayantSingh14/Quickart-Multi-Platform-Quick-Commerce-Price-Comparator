package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* loaded from: classes3.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final VisibilityAnimListener f672a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f673b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f674c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f675d;

    /* renamed from: e, reason: collision with root package name */
    public int f676e;

    /* renamed from: f, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f677f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f678g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f679h;

    /* renamed from: androidx.appcompat.widget.AbsActionBarView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f680a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f681b;

        public VisibilityAnimListener() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationCancel(View view) {
            this.f680a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd(View view) {
            if (this.f680a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f677f = null;
            AbsActionBarView.super.setVisibility(this.f681b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f680a = false;
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f672a = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f673b = context;
        } else {
            this.f673b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, i2 - view.getMeasuredWidth());
    }

    public static int d(int i2, int i3, int i4, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f675d;
        if (actionMenuPresenter != null) {
            Context context = actionMenuPresenter.f540b;
            ActionBarPolicy actionBarPolicy = new ActionBarPolicy();
            actionBarPolicy.f466a = context;
            actionMenuPresenter.q = actionBarPolicy.a();
            MenuBuilder menuBuilder = actionMenuPresenter.f541c;
            if (menuBuilder != null) {
                menuBuilder.q(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f679h = false;
        }
        if (!this.f679h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f679h = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f679h = false;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f678g = false;
        }
        if (!this.f678g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f678g = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f678g = false;
        return true;
    }

    public void setContentHeight(int i2) {
        this.f676e = i2;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f677f;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.b();
            }
            super.setVisibility(i2);
        }
    }
}
