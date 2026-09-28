package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    public final int f38306a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38307b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38308c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38309d;

    /* renamed from: e, reason: collision with root package name */
    public final zzac[] f38310e;

    static {
        new LocationAvailability(0, 1, 1, 0L, null);
        new LocationAvailability(1000, 1, 1, 0L, null);
        CREATOR = new zzw();
    }

    public LocationAvailability(int i2, int i3, int i4, long j2, zzac[] zzacVarArr) {
        this.f38309d = i2 < 1000 ? 0 : 1000;
        this.f38306a = i3;
        this.f38307b = i4;
        this.f38308c = j2;
        this.f38310e = zzacVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f38306a == locationAvailability.f38306a && this.f38307b == locationAvailability.f38307b && this.f38308c == locationAvailability.f38308c && this.f38309d == locationAvailability.f38309d && Arrays.equals(this.f38310e, locationAvailability.f38310e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38309d));
    }

    public final String toString() {
        return "LocationAvailability[" + (this.f38309d < 1000) + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38306a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38307b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38308c);
        SafeParcelWriter.writeInt(parcel, 4, this.f38309d);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.f38310e, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f38309d < 1000);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
