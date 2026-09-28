package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@Deprecated
/* loaded from: classes3.dex */
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    public EditText f11064i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f11065j;

    @Deprecated
    public EditTextPreferenceDialogFragment() {
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void b(View view) {
        super.b(view);
        EditText editText = (EditText) view.findViewById(android.R.id.edit);
        this.f11064i = editText;
        editText.requestFocus();
        EditText editText2 = this.f11064i;
        if (editText2 == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText2.setText(this.f11065j);
        EditText editText3 = this.f11064i;
        editText3.setSelection(editText3.getText().length());
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void c(boolean z) {
        if (z) {
            String string = this.f11064i.getText().toString();
            ((EditTextPreference) a()).getClass();
            ((EditTextPreference) a()).r(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f11065j = ((EditTextPreference) a()).A;
        } else {
            this.f11065j = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f11065j);
    }
}
