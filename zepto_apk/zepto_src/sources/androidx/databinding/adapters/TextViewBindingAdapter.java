package androidx.databinding.adapters;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class TextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TextViewBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements TextWatcher {
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public interface AfterTextChanged {
    }

    public interface BeforeTextChanged {
    }

    public interface OnTextChanged {
    }
}
