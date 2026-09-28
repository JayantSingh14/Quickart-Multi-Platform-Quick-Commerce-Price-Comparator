package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import java.util.Comparator;

/* loaded from: classes3.dex */
final class AnimateLayoutChangeDetector {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f12374a;

    /* renamed from: androidx.viewpager2.widget.AnimateLayoutChangeDetector$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<int[]> {
        @Override // java.util.Comparator
        public final int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f12374a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
