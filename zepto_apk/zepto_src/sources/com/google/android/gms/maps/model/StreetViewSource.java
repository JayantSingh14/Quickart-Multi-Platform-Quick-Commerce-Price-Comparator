package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StreetViewSourceCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class StreetViewSource extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzy();

    /* renamed from: b, reason: collision with root package name */
    public static final StreetViewSource f38549b = new StreetViewSource(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f38550a;

    static {
        new StreetViewSource(1);
    }

    public StreetViewSource(int i2) {
        this.f38550a = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f38550a == ((StreetViewSource) obj).f38550a;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38550a));
    }

    public final String toString() {
        int i2 = this.f38550a;
        return "StreetViewSource:".concat(i2 != 0 ? i2 != 1 ? b.g(i2, "UNKNOWN(", ")") : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f38550a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
