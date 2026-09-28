package com.google.android.material.sidesheet;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;

/* loaded from: classes4.dex */
public class SideSheetDialog extends SheetDialog<SideSheetCallback> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.sidesheet.SideSheetDialog$1] */
    @Override // com.google.android.material.sidesheet.SheetDialog
    public final void f(Sheet sheet) {
        sheet.a(new SideSheetCallback() { // from class: com.google.android.material.sidesheet.SideSheetDialog.1
            @Override // com.google.android.material.sidesheet.SheetCallback
            public final void a(int i2) {
                if (i2 == 5) {
                    SideSheetDialog.this.cancel();
                }
            }
        });
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public final Sheet h() {
        Sheet sheetH = super.h();
        if (sheetH instanceof SideSheetBehavior) {
            return (SideSheetBehavior) sheetH;
        }
        throw new IllegalStateException("The view is not associated with SideSheetBehavior");
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public final SideSheetBehavior i(FrameLayout frameLayout) {
        int i2 = SideSheetBehavior.x;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).f2560a;
        if (behavior instanceof SideSheetBehavior) {
            return (SideSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public final int j() {
        return R.id.m3_side_sheet;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public final int k() {
        return R.layout.m3_side_sheet_dialog;
    }
}
