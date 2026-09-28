package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes4.dex */
public class RNTimePickerDialogFragment extends DialogFragment {
    public RNDismissableTimePickerDialog Q;
    public TimePickerDialog.OnTimeSetListener X;
    public DialogInterface.OnDismissListener Y;
    public DialogInterface.OnClickListener Z;

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    @Override // androidx.fragment.app.DialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.app.Dialog onCreateDialog(android.os.Bundle r15) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactcommunity.rndatetimepicker.RNTimePickerDialogFragment.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.Y;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
