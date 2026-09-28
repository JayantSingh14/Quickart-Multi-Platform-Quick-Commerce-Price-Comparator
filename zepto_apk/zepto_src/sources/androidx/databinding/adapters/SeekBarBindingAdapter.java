package androidx.databinding.adapters;

import android.widget.SeekBar;
import androidx.annotation.RestrictTo;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class SeekBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements SeekBar.OnSeekBarChangeListener {
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public interface OnProgressChanged {
    }

    public interface OnStartTrackingTouch {
    }

    public interface OnStopTrackingTouch {
    }
}
