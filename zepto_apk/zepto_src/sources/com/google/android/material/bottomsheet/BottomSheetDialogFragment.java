package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes4.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public boolean Q;

    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        public BottomSheetDismissCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialogFragment.this.z();
            }
        }
    }

    public final boolean A(boolean z) throws Resources.NotFoundException {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        if (bottomSheetDialog.f40040f == null) {
            bottomSheetDialog.f();
        }
        BottomSheetBehavior bottomSheetBehavior = bottomSheetDialog.f40040f;
        if (!bottomSheetBehavior.I || !bottomSheetDialog.f40044j) {
            return false;
        }
        this.Q = z;
        if (bottomSheetBehavior.L == 5) {
            z();
            return true;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog2 = (BottomSheetDialog) getDialog();
            bottomSheetDialog2.f40040f.M(bottomSheetDialog2.q);
        }
        bottomSheetBehavior.y(new BottomSheetDismissCallback());
        bottomSheetBehavior.f(5);
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (A(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        if (A(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }

    public final void z() {
        if (this.Q) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }
}
