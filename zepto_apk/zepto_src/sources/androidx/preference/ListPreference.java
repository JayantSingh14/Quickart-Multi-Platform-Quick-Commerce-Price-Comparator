package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

/* loaded from: classes3.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] A;
    public final CharSequence[] B;
    public String C;
    public final String D;
    public boolean E;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final String f11066a;

        /* renamed from: androidx.preference.ListPreference$SavedState$1, reason: invalid class name */
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
            this.f11066a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f11066a);
        }
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        public static SimpleSummaryProvider f11067a;

        @Override // androidx.preference.Preference.SummaryProvider
        public final CharSequence a(Preference preference) {
            CharSequence[] charSequenceArr;
            CharSequence[] charSequenceArr2;
            ListPreference listPreference = (ListPreference) preference;
            int iR = listPreference.r(listPreference.C);
            if (TextUtils.isEmpty((iR < 0 || (charSequenceArr2 = listPreference.A) == null) ? null : charSequenceArr2[iR])) {
                return listPreference.f11080a.getString(R.string.not_set);
            }
            int iR2 = listPreference.r(listPreference.C);
            if (iR2 < 0 || (charSequenceArr = listPreference.A) == null) {
                return null;
            }
            return charSequenceArr[iR2];
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i2, 0);
        int i4 = R.styleable.ListPreference_entries;
        int i5 = R.styleable.ListPreference_android_entries;
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(i4);
        this.A = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(i5) : textArray;
        int i6 = R.styleable.ListPreference_entryValues;
        int i7 = R.styleable.ListPreference_android_entryValues;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(i6);
        this.B = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(i7) : textArray2;
        int i8 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (typedArrayObtainStyledAttributes.getBoolean(i8, typedArrayObtainStyledAttributes.getBoolean(i8, false))) {
            if (SimpleSummaryProvider.f11067a == null) {
                SimpleSummaryProvider.f11067a = new SimpleSummaryProvider();
            }
            this.y = SimpleSummaryProvider.f11067a;
            d();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, 0);
        int i9 = R.styleable.Preference_summary;
        int i10 = R.styleable.Preference_android_summary;
        String string = typedArrayObtainStyledAttributes2.getString(i9);
        this.D = string == null ? typedArrayObtainStyledAttributes2.getString(i10) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence b() {
        CharSequence[] charSequenceArr;
        Preference.SummaryProvider summaryProvider = this.y;
        if (summaryProvider != null) {
            return summaryProvider.a(this);
        }
        int iR = r(this.C);
        CharSequence charSequence = (iR < 0 || (charSequenceArr = this.A) == null) ? null : charSequenceArr[iR];
        CharSequence charSequenceB = super.b();
        String str = this.D;
        if (str != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            String str2 = String.format(str, charSequence);
            if (!TextUtils.equals(str2, charSequenceB)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceB;
    }

    @Override // androidx.preference.Preference
    public final Object i(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    public final int r(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.B) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (charSequenceArr[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public final void s(String str) {
        boolean zEquals = TextUtils.equals(this.C, str);
        if (zEquals && this.E) {
            return;
        }
        this.C = str;
        this.E = true;
        if (zEquals) {
            return;
        }
        d();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
