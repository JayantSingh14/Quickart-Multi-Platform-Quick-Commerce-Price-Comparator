package androidx.databinding.adapters;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingMethods;

@BindingMethods
@InverseBindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class AdapterViewBindingAdapter {

    public interface OnItemSelected {
    }

    public static class OnItemSelectedComponentListener implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView adapterView) {
        }
    }

    public interface OnNothingSelected {
    }
}
