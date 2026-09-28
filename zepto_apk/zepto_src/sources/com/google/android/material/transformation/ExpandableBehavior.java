package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;
import java.util.WeakHashMap;

@Deprecated
/* loaded from: classes4.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a, reason: collision with root package name */
    public int f41459a;

    public ExpandableBehavior() {
        this.f41459a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean h(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (expandableWidget.a()) {
            int i2 = this.f41459a;
            if (i2 != 0 && i2 != 2) {
                return false;
            }
        } else if (this.f41459a != 1) {
            return false;
        }
        this.f41459a = expandableWidget.a() ? 1 : 2;
        y((View) expandableWidget, view, expandableWidget.a(), true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean n(CoordinatorLayout coordinatorLayout, final View view, int i2) {
        final ExpandableWidget expandableWidget;
        int i3;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!view.isLaidOut()) {
            List listL = coordinatorLayout.l(view);
            int size = listL.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    expandableWidget = null;
                    break;
                }
                View view2 = (View) listL.get(i4);
                if (h(view, view2)) {
                    expandableWidget = (ExpandableWidget) view2;
                    break;
                }
                i4++;
            }
            if (expandableWidget != null && (!expandableWidget.a() ? this.f41459a == 1 : !((i3 = this.f41459a) != 0 && i3 != 2))) {
                final int i5 = expandableWidget.a() ? 1 : 2;
                this.f41459a = i5;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public final boolean onPreDraw() {
                        View view3 = view;
                        view3.getViewTreeObserver().removeOnPreDrawListener(this);
                        ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                        if (expandableBehavior.f41459a == i5) {
                            ExpandableWidget expandableWidget2 = expandableWidget;
                            expandableBehavior.y((View) expandableWidget2, view3, expandableWidget2.a(), false);
                        }
                        return false;
                    }
                });
            }
        }
        return false;
    }

    public abstract void y(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41459a = 0;
    }
}
