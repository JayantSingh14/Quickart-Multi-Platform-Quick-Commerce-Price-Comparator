package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes3.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public EditText E0;
    public CharSequence F0;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void A(View view) {
        super.A(view);
        EditText editText = (EditText) view.findViewById(android.R.id.edit);
        this.E0 = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.E0.setText(this.F0);
        EditText editText2 = this.E0;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) z()).getClass();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void B(boolean z) {
        if (z) {
            String string = this.E0.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) z();
            editTextPreference.getClass();
            editTextPreference.r(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.F0 = ((EditTextPreference) z()).A;
        } else {
            this.F0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.F0);
    }
}
