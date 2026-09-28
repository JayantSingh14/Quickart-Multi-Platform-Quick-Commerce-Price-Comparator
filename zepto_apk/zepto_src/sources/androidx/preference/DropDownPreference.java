package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes3.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter F;
    public Spinner G;
    public final AdapterView.OnItemSelectedListener H;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    public final void d() {
        super.d();
        ArrayAdapter arrayAdapter = this.F;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) {
        int length;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) preferenceViewHolder.f11653a.findViewById(R.id.spinner);
        this.G = spinner;
        spinner.setAdapter((SpinnerAdapter) this.F);
        this.G.setOnItemSelectedListener(this.H);
        Spinner spinner2 = this.G;
        String str = this.C;
        if (str == null || (charSequenceArr = this.B) == null) {
            length = -1;
        } else {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (charSequenceArr[length].equals(str)) {
                    break;
                } else {
                    length--;
                }
            }
            length = -1;
        }
        spinner2.setSelection(length);
        super.g(preferenceViewHolder);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void h() {
        this.G.performClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.H = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView adapterView, View view, int i3, long j2) {
                if (i3 >= 0) {
                    DropDownPreference dropDownPreference = DropDownPreference.this;
                    String string = dropDownPreference.B[i3].toString();
                    if (string.equals(dropDownPreference.C)) {
                        return;
                    }
                    dropDownPreference.getClass();
                    dropDownPreference.s(string);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView adapterView) {
            }
        };
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.F = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.A;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }
}
