package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final HashSet A;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f11073a;

        /* renamed from: androidx.preference.MultiSelectListPreference$SavedState$1, reason: invalid class name */
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
            int i2 = parcel.readInt();
            this.f11073a = new HashSet();
            String[] strArr = new String[i2];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f11073a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f11073a.size());
            HashSet hashSet = this.f11073a;
            parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.A = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MultiSelectListPreference, i2, 0);
        int i3 = R.styleable.MultiSelectListPreference_entries;
        int i4 = R.styleable.MultiSelectListPreference_android_entries;
        if (typedArrayObtainStyledAttributes.getTextArray(i3) == null) {
            typedArrayObtainStyledAttributes.getTextArray(i4);
        }
        int i5 = R.styleable.MultiSelectListPreference_entryValues;
        int i6 = R.styleable.MultiSelectListPreference_android_entryValues;
        if (typedArrayObtainStyledAttributes.getTextArray(i5) == null) {
            typedArrayObtainStyledAttributes.getTextArray(i6);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object i(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
