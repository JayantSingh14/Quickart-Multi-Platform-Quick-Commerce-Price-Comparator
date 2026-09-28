package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes4.dex */
final class RightSheetDelegate extends SheetDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior f41089a;

    public RightSheetDelegate(SideSheetBehavior sideSheetBehavior) {
        this.f41089a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final float b(int i2) {
        float f2 = this.f41089a.f41111m;
        return (f2 - i2) / (f2 - d());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int d() {
        SideSheetBehavior sideSheetBehavior = this.f41089a;
        return Math.max(0, (sideSheetBehavior.f41111m - sideSheetBehavior.f41110l) - sideSheetBehavior.o);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int e() {
        return this.f41089a.f41111m;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int f() {
        return this.f41089a.f41111m;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int h(View view) {
        return view.getLeft() - this.f41089a.o;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean k(float f2) {
        return f2 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean l(View view) {
        return view.getLeft() > (this.f41089a.f41111m + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean m(float f2, float f3) {
        if (Math.abs(f2) <= Math.abs(f3)) {
            return false;
        }
        float fAbs = Math.abs(f2);
        this.f41089a.getClass();
        return fAbs > ((float) 500);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean n(View view, float f2) {
        float right = view.getRight();
        SideSheetBehavior sideSheetBehavior = this.f41089a;
        float fAbs = Math.abs((f2 * sideSheetBehavior.f41109k) + right);
        sideSheetBehavior.getClass();
        return fAbs > 0.5f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.rightMargin = i2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        int i4 = this.f41089a.f41111m;
        if (i2 <= i4) {
            marginLayoutParams.rightMargin = i4 - i2;
        }
    }
}
