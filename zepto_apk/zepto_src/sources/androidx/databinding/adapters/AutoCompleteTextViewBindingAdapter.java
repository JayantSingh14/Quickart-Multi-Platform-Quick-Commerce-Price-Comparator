package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethods;

@BindingMethods
@RestrictTo
/* loaded from: classes3.dex */
public class AutoCompleteTextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements AutoCompleteTextView.Validator {
        @Override // android.widget.AutoCompleteTextView.Validator
        public final CharSequence fixText(CharSequence charSequence) {
            return charSequence;
        }

        @Override // android.widget.AutoCompleteTextView.Validator
        public final boolean isValid(CharSequence charSequence) {
            return true;
        }
    }

    public interface FixText {
    }

    public interface IsValid {
    }
}
