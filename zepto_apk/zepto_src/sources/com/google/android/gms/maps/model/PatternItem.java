package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PatternItem extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final int f38499a;

    /* renamed from: b, reason: collision with root package name */
    public final Float f38500b;

    public PatternItem(int i2, Float f2) {
        boolean z = true;
        if (i2 != 1 && (f2 == null || f2.floatValue() < 0.0f)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid PatternItem: type=" + i2 + " length=" + f2);
        this.f38499a = i2;
        this.f38500b = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f38499a == patternItem.f38499a && Objects.equal(this.f38500b, patternItem.f38500b);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38499a), this.f38500b);
    }

    public String toString() {
        return "[PatternItem: type=" + this.f38499a + " length=" + this.f38500b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f38499a);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.f38500b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
