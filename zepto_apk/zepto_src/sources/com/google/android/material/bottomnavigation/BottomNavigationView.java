package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class BottomNavigationView extends NavigationBarView {

    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$1, reason: invalid class name */
    class AnonymousClass1 implements ViewUtils.OnApplyWindowInsetsListener {
        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            relativePadding.f40663d = windowInsetsCompat.g() + relativePadding.f40663d;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            boolean z = view.getLayoutDirection() == 1;
            int iH = windowInsetsCompat.h();
            int i2 = windowInsetsCompat.i();
            int i3 = relativePadding.f40660a + (z ? i2 : iH);
            relativePadding.f40660a = i3;
            int i4 = relativePadding.f40662c;
            if (!z) {
                iH = i2;
            }
            int i5 = i4 + iH;
            relativePadding.f40662c = i5;
            view.setPaddingRelative(i3, relativePadding.f40661b, i5, relativePadding.f40663d);
            return windowInsetsCompat;
        }
    }

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView a(Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i3) != 1073741824 && suggestedMinimumHeight > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.L != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().j(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = R.style.Widget_Design_BottomNavigationView;
        super(context, attributeSet, i2, i3);
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(getContext(), attributeSet, R.styleable.BottomNavigationView, i2, i3, new int[0]);
        int i4 = R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(i4, true));
        if (typedArray.hasValue(R.styleable.BottomNavigationView_android_minHeight)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_android_minHeight, 0));
        }
        typedArray.getBoolean(R.styleable.BottomNavigationView_compatShadowEnabled, true);
        tintTypedArrayE.g();
        ViewUtils.b(this, new AnonymousClass1());
    }
}
