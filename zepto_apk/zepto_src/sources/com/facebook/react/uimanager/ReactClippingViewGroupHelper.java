package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class ReactClippingViewGroupHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Rect f19454a = new Rect();

    public static void a(ViewGroup viewGroup, Rect rect) {
        ViewParent parent = viewGroup.getParent();
        if (parent == null) {
            rect.setEmpty();
            return;
        }
        if (parent instanceof ReactClippingViewGroup) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) parent;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                Rect rect2 = f19454a;
                reactClippingViewGroup.getClippingRect(rect2);
                if (!rect2.intersect(viewGroup.getLeft(), viewGroup.getTop() + ((int) viewGroup.getTranslationY()), viewGroup.getRight(), viewGroup.getBottom() + ((int) viewGroup.getTranslationY()))) {
                    rect.setEmpty();
                    return;
                }
                rect2.offset(-viewGroup.getLeft(), -viewGroup.getTop());
                rect2.offset(-((int) viewGroup.getTranslationX()), -((int) viewGroup.getTranslationY()));
                rect2.offset(viewGroup.getScrollX(), viewGroup.getScrollY());
                rect.set(rect2);
                return;
            }
        }
        viewGroup.getDrawingRect(rect);
    }
}
