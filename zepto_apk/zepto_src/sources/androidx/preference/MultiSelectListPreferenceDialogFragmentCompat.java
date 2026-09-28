package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public final HashSet E0 = new HashSet();
    public boolean F0;
    public CharSequence[] G0;
    public CharSequence[] H0;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void B(boolean z) {
        if (z && this.F0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) z();
            multiSelectListPreference.getClass();
            HashSet hashSet = this.E0;
            HashSet hashSet2 = multiSelectListPreference.A;
            hashSet2.clear();
            hashSet2.addAll(hashSet);
            multiSelectListPreference.d();
        }
        this.F0 = false;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void C(AlertDialog.Builder builder) {
        int length = this.H0.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.E0.contains(this.H0[i2].toString());
        }
        CharSequence[] charSequenceArr = this.G0;
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i3, boolean z) {
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                if (z) {
                    multiSelectListPreferenceDialogFragmentCompat.F0 = multiSelectListPreferenceDialogFragmentCompat.E0.add(multiSelectListPreferenceDialogFragmentCompat.H0[i3].toString()) | multiSelectListPreferenceDialogFragmentCompat.F0;
                } else {
                    multiSelectListPreferenceDialogFragmentCompat.F0 = multiSelectListPreferenceDialogFragmentCompat.E0.remove(multiSelectListPreferenceDialogFragmentCompat.H0[i3].toString()) | multiSelectListPreferenceDialogFragmentCompat.F0;
                }
            }
        };
        AlertController.AlertParams alertParams = builder.f282a;
        alertParams.n = charSequenceArr;
        alertParams.v = onMultiChoiceClickListener;
        alertParams.r = zArr;
        alertParams.s = true;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashSet hashSet = this.E0;
        hashSet.clear();
        hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.F0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.G0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.H0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.E0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.F0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.G0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.H0);
    }
}
