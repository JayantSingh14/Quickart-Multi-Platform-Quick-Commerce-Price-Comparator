package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes4.dex */
final class LeftSheetDelegate extends SheetDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior f41088a;

    public LeftSheetDelegate(SideSheetBehavior sideSheetBehavior) {
        this.f41088a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final float b(int i2) {
        float fE = e();
        return (i2 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int d() {
        SideSheetBehavior sideSheetBehavior = this.f41088a;
        return Math.max(0, sideSheetBehavior.n + sideSheetBehavior.o);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int e() {
        SideSheetBehavior sideSheetBehavior = this.f41088a;
        return (-sideSheetBehavior.f41110l) - sideSheetBehavior.o;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int f() {
        return this.f41088a.o;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int g() {
        return -this.f41088a.f41110l;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int h(View view) {
        return view.getRight() + this.f41088a.o;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean k(float f2) {
        return f2 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean m(float f2, float f3) {
        if (Math.abs(f2) <= Math.abs(f3)) {
            return false;
        }
        float fAbs = Math.abs(f2);
        this.f41088a.getClass();
        return fAbs > ((float) 500);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final boolean n(View view, float f2) {
        float left = view.getLeft();
        SideSheetBehavior sideSheetBehavior = this.f41088a;
        float fAbs = Math.abs((f2 * sideSheetBehavior.f41109k) + left);
        sideSheetBehavior.getClass();
        return fAbs > 0.5f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.leftMargin = i2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        if (i2 <= this.f41088a.f41111m) {
            marginLayoutParams.leftMargin = i3;
        }
    }
}
