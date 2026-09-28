package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.preference.Preference;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class PreferenceGroup extends Preference {
    public final ArrayList A;

    /* renamed from: androidx.preference.PreferenceGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                throw null;
            }
        }
    }

    @RestrictTo
    public interface OnExpandButtonClickListener {
    }

    public interface PreferencePositionCallback {
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final int f11122a;

        /* renamed from: androidx.preference.PreferenceGroup$SavedState$1, reason: invalid class name */
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
            this.f11122a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f11122a);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, 0);
        new SimpleArrayMap();
        new Handler();
        this.A = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i2, 0);
        int i4 = R.styleable.PreferenceGroup_orderingFromXml;
        typedArrayObtainStyledAttributes.getBoolean(i4, typedArrayObtainStyledAttributes.getBoolean(i4, true));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            int i5 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
            if (typedArrayObtainStyledAttributes.getInt(i5, typedArrayObtainStyledAttributes.getInt(i5, Api.BaseClientBuilder.API_PRIORITY_OTHER)) != Integer.MAX_VALUE && TextUtils.isEmpty(this.f11086g)) {
                Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void e(boolean z) {
        super.e(z);
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            Preference preferenceR = r(i2);
            if (preferenceR.f11092m == z) {
                preferenceR.f11092m = !z;
                preferenceR.e(preferenceR.q());
                preferenceR.d();
            }
        }
    }

    public final Preference r(int i2) {
        return (Preference) this.A.get(i2);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
