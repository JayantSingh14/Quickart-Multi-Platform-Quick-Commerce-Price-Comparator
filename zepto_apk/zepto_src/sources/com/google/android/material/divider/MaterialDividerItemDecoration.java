package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes4.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: i, reason: collision with root package name */
    public static final int f40410i = R.style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a, reason: collision with root package name */
    public final ShapeDrawable f40411a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40412b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40413c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40414d;

    /* renamed from: e, reason: collision with root package name */
    public final int f40415e;

    /* renamed from: f, reason: collision with root package name */
    public final int f40416f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f40417g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f40418h;

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = R.attr.materialDividerStyle;
        this.f40418h = new Rect();
        TypedArray typedArrayD = ThemeEnforcement.d(context, attributeSet, R.styleable.MaterialDivider, i3, f40410i, new int[0]);
        this.f40413c = MaterialResources.a(context, typedArrayD, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.f40412b = typedArrayD.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f40415e = typedArrayD.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f40416f = typedArrayD.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        this.f40417g = typedArrayD.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
        typedArrayD.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        int i4 = this.f40413c;
        this.f40413c = i4;
        this.f40411a = shapeDrawable;
        shapeDrawable.setTint(i4);
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(b.g(i2, "Invalid orientation: ", ". It should be either HORIZONTAL or VERTICAL"));
        }
        this.f40414d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void f(Rect rect, View view, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
        if (i(view, recyclerView)) {
            int i2 = this.f40414d;
            int i3 = this.f40412b;
            if (i2 == 1) {
                rect.bottom = i3;
            } else if (ViewUtils.h(recyclerView)) {
                rect.left = i3;
            } else {
                rect.right = i3;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        int i2;
        int i3;
        int width;
        int paddingLeft;
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        int i4 = this.f40414d;
        int i5 = this.f40412b;
        int i6 = this.f40416f;
        int i7 = this.f40415e;
        Rect rect = this.f40418h;
        int i8 = 0;
        if (i4 == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                paddingLeft = 0;
            }
            boolean zH = ViewUtils.h(recyclerView);
            int i9 = paddingLeft + (zH ? i6 : i7);
            if (zH) {
                i6 = i7;
            }
            int i10 = width - i6;
            int childCount = recyclerView.getChildCount();
            while (i8 < childCount) {
                View childAt = recyclerView.getChildAt(i8);
                if (i(childAt, recyclerView)) {
                    recyclerView.getLayoutManager().z(rect, childAt);
                    int iRound = Math.round(childAt.getTranslationY()) + rect.bottom;
                    this.f40411a.setBounds(i9, iRound - i5, i10, iRound);
                    this.f40411a.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                    this.f40411a.draw(canvas);
                }
                i8++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int i11 = paddingTop + i7;
        int i12 = height - i6;
        boolean zH2 = ViewUtils.h(recyclerView);
        int childCount2 = recyclerView.getChildCount();
        while (i8 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i8);
            if (i(childAt2, recyclerView)) {
                recyclerView.getLayoutManager().z(rect, childAt2);
                int iRound2 = Math.round(childAt2.getTranslationX());
                if (zH2) {
                    i3 = rect.left + iRound2;
                    i2 = i3 + i5;
                } else {
                    i2 = iRound2 + rect.right;
                    i3 = i2 - i5;
                }
                this.f40411a.setBounds(i3, i11, i2, i12);
                this.f40411a.setAlpha(Math.round(childAt2.getAlpha() * 255.0f));
                this.f40411a.draw(canvas);
            }
            i8++;
        }
        canvas.restore();
    }

    public final boolean i(View view, RecyclerView recyclerView) {
        RecyclerView recyclerView2;
        recyclerView.getClass();
        RecyclerView.ViewHolder viewHolderN = RecyclerView.N(view);
        int iK = (viewHolderN == null || (recyclerView2 = viewHolderN.r) == null) ? -1 : recyclerView2.K(viewHolderN);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return iK != -1 && (!(adapter != null && iK == adapter.d() - 1) || this.f40417g);
    }
}
