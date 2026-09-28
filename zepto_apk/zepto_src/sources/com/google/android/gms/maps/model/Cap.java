package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CapCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class Cap extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f38443a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapDescriptor f38444b;

    /* renamed from: c, reason: collision with root package name */
    public final Float f38445c;

    public Cap(int i2, BitmapDescriptor bitmapDescriptor, Float f2) {
        boolean z = f2 != null && f2.floatValue() > 0.0f;
        if (i2 == 3) {
            z = bitmapDescriptor != null && z;
            i2 = 3;
        }
        Preconditions.checkArgument(z, "Invalid Cap: type=" + i2 + " bitmapDescriptor=" + bitmapDescriptor + " bitmapRefWidth=" + f2);
        this.f38443a = i2;
        this.f38444b = bitmapDescriptor;
        this.f38445c = f2;
    }

    public final Cap b() {
        int i2 = this.f38443a;
        if (i2 == 0) {
            return new ButtCap();
        }
        if (i2 == 1) {
            return new SquareCap();
        }
        if (i2 == 2) {
            return new RoundCap();
        }
        if (i2 != 3) {
            Log.w("Cap", "Unknown Cap type: " + i2);
            return this;
        }
        BitmapDescriptor bitmapDescriptor = this.f38444b;
        Preconditions.checkState(bitmapDescriptor != null, "bitmapDescriptor must not be null");
        Float f2 = this.f38445c;
        Preconditions.checkState(f2 != null, "bitmapRefWidth must not be null");
        return new CustomCap(bitmapDescriptor, f2.floatValue());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f38443a == cap.f38443a && Objects.equal(this.f38444b, cap.f38444b) && Objects.equal(this.f38445c, cap.f38445c);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38443a), this.f38444b, this.f38445c);
    }

    public String toString() {
        return b.o(new StringBuilder("[Cap: type="), this.f38443a, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f38443a);
        BitmapDescriptor bitmapDescriptor = this.f38444b;
        SafeParcelWriter.writeIBinder(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.f38433a.asBinder(), false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.f38445c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
