package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Array;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "ActivityRecognitionResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f38269a;

    /* renamed from: b, reason: collision with root package name */
    public long f38270b;

    /* renamed from: c, reason: collision with root package name */
    public long f38271c;

    /* renamed from: d, reason: collision with root package name */
    public int f38272d;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f38273e;

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!b(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i2 = 0; i2 < length; i2++) {
                            if (Objects.equal(Array.get(obj, i2), Array.get(obj2, i2))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f38270b == activityRecognitionResult.f38270b && this.f38271c == activityRecognitionResult.f38271c && this.f38272d == activityRecognitionResult.f38272d && Objects.equal(this.f38269a, activityRecognitionResult.f38269a) && b(this.f38273e, activityRecognitionResult.f38273e);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f38270b), Long.valueOf(this.f38271c), Integer.valueOf(this.f38272d), this.f38269a, this.f38273e);
    }

    public final String toString() {
        StringBuilder sbY = b.y("ActivityRecognitionResult [probableActivities=", String.valueOf(this.f38269a), ", timeMillis=");
        sbY.append(this.f38270b);
        sbY.append(", elapsedRealtimeMillis=");
        return b.p(sbY, this.f38271c, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f38269a, false);
        SafeParcelWriter.writeLong(parcel, 2, this.f38270b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38271c);
        SafeParcelWriter.writeInt(parcel, 4, this.f38272d);
        SafeParcelWriter.writeBundle(parcel, 5, this.f38273e, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
