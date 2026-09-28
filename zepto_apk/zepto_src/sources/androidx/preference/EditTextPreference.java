package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

/* loaded from: classes3.dex */
public class EditTextPreference extends DialogPreference {
    public String A;

    public interface OnBindEditTextListener {
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final String f11062a;

        /* renamed from: androidx.preference.EditTextPreference$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11062a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f11062a);
        }
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static SimpleSummaryProvider f11063a;

        @Override // androidx.preference.Preference.SummaryProvider
        public final CharSequence a(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            if (!TextUtils.isEmpty(editTextPreference.A)) {
                return editTextPreference.A;
            }
            return editTextPreference.f11080a.getString(R.string.not_set);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i2, 0);
        int i3 = R.styleable.EditTextPreference_useSimpleSummaryProvider;
        if (typedArrayObtainStyledAttributes.getBoolean(i3, typedArrayObtainStyledAttributes.getBoolean(i3, false))) {
            if (SimpleSummaryProvider.f11063a == null) {
                SimpleSummaryProvider.f11063a = new SimpleSummaryProvider();
            }
            this.y = SimpleSummaryProvider.f11063a;
            d();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object i(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    public final boolean q() {
        return TextUtils.isEmpty(this.A) || super.q();
    }

    public final void r(String str) {
        boolean zQ = q();
        this.A = str;
        boolean zQ2 = q();
        if (zQ2 != zQ) {
            e(zQ2);
        }
        d();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }
}
