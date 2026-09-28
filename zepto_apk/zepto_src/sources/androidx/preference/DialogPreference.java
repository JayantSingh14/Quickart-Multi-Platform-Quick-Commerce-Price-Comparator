package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;

/* loaded from: classes3.dex */
public abstract class DialogPreference extends Preference {

    public interface TargetFragment {
        void s();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, i2, 0);
        int i4 = R.styleable.DialogPreference_dialogTitle;
        int i5 = R.styleable.DialogPreference_android_dialogTitle;
        if (typedArrayObtainStyledAttributes.getString(i4) == null) {
            typedArrayObtainStyledAttributes.getString(i5);
        }
        int i6 = R.styleable.DialogPreference_dialogMessage;
        int i7 = R.styleable.DialogPreference_android_dialogMessage;
        if (typedArrayObtainStyledAttributes.getString(i6) == null) {
            typedArrayObtainStyledAttributes.getString(i7);
        }
        int i8 = R.styleable.DialogPreference_dialogIcon;
        int i9 = R.styleable.DialogPreference_android_dialogIcon;
        if (typedArrayObtainStyledAttributes.getDrawable(i8) == null) {
            typedArrayObtainStyledAttributes.getDrawable(i9);
        }
        int i10 = R.styleable.DialogPreference_positiveButtonText;
        int i11 = R.styleable.DialogPreference_android_positiveButtonText;
        if (typedArrayObtainStyledAttributes.getString(i10) == null) {
            typedArrayObtainStyledAttributes.getString(i11);
        }
        int i12 = R.styleable.DialogPreference_negativeButtonText;
        int i13 = R.styleable.DialogPreference_android_negativeButtonText;
        if (typedArrayObtainStyledAttributes.getString(i12) == null) {
            typedArrayObtainStyledAttributes.getString(i13);
        }
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.DialogPreference_dialogLayout, typedArrayObtainStyledAttributes.getResourceId(R.styleable.DialogPreference_android_dialogLayout, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void h() {
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
