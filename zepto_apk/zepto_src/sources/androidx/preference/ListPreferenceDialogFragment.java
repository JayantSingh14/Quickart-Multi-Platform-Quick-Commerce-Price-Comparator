package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

@Deprecated
/* loaded from: classes3.dex */
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    public int f11068i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence[] f11069j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence[] f11070k;

    @Deprecated
    public ListPreferenceDialogFragment() {
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void c(boolean z) {
        int i2;
        ListPreference listPreference = (ListPreference) a();
        if (!z || (i2 = this.f11068i) < 0) {
            return;
        }
        String string = this.f11070k[i2].toString();
        listPreference.getClass();
        listPreference.s(string);
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void d(AlertDialog.Builder builder) {
        builder.setSingleChoiceItems(this.f11069j, this.f11068i, new DialogInterface.OnClickListener() { // from class: androidx.preference.ListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
                listPreferenceDialogFragment.f11068i = i2;
                listPreferenceDialogFragment.f11102h = -1;
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11068i = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f11069j = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f11070k = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) a();
        if (listPreference.A == null || (charSequenceArr = listPreference.B) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f11068i = listPreference.r(listPreference.C);
        this.f11069j = listPreference.A;
        this.f11070k = charSequenceArr;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f11068i);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f11069j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f11070k);
    }
}
