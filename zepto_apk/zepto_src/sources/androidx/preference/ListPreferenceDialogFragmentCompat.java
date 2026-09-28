package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;

/* loaded from: classes3.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public int E0;
    public CharSequence[] F0;
    public CharSequence[] G0;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void B(boolean z) {
        int i2;
        if (!z || (i2 = this.E0) < 0) {
            return;
        }
        String string = this.G0[i2].toString();
        ListPreference listPreference = (ListPreference) z();
        listPreference.getClass();
        listPreference.s(string);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void C(AlertDialog.Builder builder) {
        CharSequence[] charSequenceArr = this.F0;
        int i2 = this.E0;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: androidx.preference.ListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = ListPreferenceDialogFragmentCompat.this;
                listPreferenceDialogFragmentCompat.E0 = i3;
                listPreferenceDialogFragmentCompat.D0 = -1;
                dialogInterface.dismiss();
            }
        };
        AlertController.AlertParams alertParams = builder.f282a;
        alertParams.n = charSequenceArr;
        alertParams.p = onClickListener;
        alertParams.u = i2;
        alertParams.t = true;
        builder.d(null, null);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.E0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.F0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.G0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) z();
        if (listPreference.A == null || (charSequenceArr = listPreference.B) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.E0 = listPreference.r(listPreference.C);
        this.F0 = listPreference.A;
        this.G0 = charSequenceArr;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.E0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.F0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.G0);
    }
}
