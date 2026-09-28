package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
abstract class PickerFragment<S> extends Fragment {
    public final LinkedHashSet Q = new LinkedHashSet();

    public void y(OnSelectionChangedListener onSelectionChangedListener) {
        this.Q.add(onSelectionChangedListener);
    }
}
