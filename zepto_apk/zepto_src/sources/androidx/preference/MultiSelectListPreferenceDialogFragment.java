package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;

@Deprecated
/* loaded from: classes3.dex */
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f11074i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public boolean f11075j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence[] f11076k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence[] f11077l;

    @Deprecated
    public MultiSelectListPreferenceDialogFragment() {
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void c(boolean z) {
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) a();
        if (z && this.f11075j) {
            HashSet hashSet = this.f11074i;
            multiSelectListPreference.getClass();
            HashSet hashSet2 = multiSelectListPreference.A;
            hashSet2.clear();
            hashSet2.addAll(hashSet);
            multiSelectListPreference.d();
        }
        this.f11075j = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public final void d(AlertDialog.Builder builder) {
        int length = this.f11077l.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.f11074i.contains(this.f11077l[i2].toString());
        }
        builder.setMultiChoiceItems(this.f11076k, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i3, boolean z) {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                if (z) {
                    multiSelectListPreferenceDialogFragment.f11075j = multiSelectListPreferenceDialogFragment.f11074i.add(multiSelectListPreferenceDialogFragment.f11077l[i3].toString()) | multiSelectListPreferenceDialogFragment.f11075j;
                } else {
                    multiSelectListPreferenceDialogFragment.f11075j = multiSelectListPreferenceDialogFragment.f11074i.remove(multiSelectListPreferenceDialogFragment.f11077l[i3].toString()) | multiSelectListPreferenceDialogFragment.f11075j;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashSet hashSet = this.f11074i;
        hashSet.clear();
        hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
        this.f11075j = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
        this.f11076k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
        this.f11077l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.f11074i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.f11075j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.f11076k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.f11077l);
    }
}
