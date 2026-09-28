package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PinConfigCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PinConfig extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PinConfig> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    public final int f38501a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38502b;

    /* renamed from: c, reason: collision with root package name */
    public final Glyph f38503c;

    public static class Builder {
        public Builder() {
            Glyph glyph = new Glyph();
            glyph.f38507d = -16777216;
            glyph.f38506c = -5041134;
        }
    }

    @SafeParcelable.Class(creator = "GlyphCreator")
    @SafeParcelable.Reserved({1})
    public static class Glyph extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<Glyph> CREATOR = new zzf();

        /* renamed from: a, reason: collision with root package name */
        public String f38504a;

        /* renamed from: b, reason: collision with root package name */
        public BitmapDescriptor f38505b;

        /* renamed from: c, reason: collision with root package name */
        public int f38506c;

        /* renamed from: d, reason: collision with root package name */
        public int f38507d;

        public final boolean equals(Object obj) {
            String str;
            String str2;
            Object objZ0;
            Object objZ02;
            if (this != obj) {
                if (obj instanceof Glyph) {
                    Glyph glyph = (Glyph) obj;
                    if (this.f38506c == glyph.f38506c && (((str = this.f38504a) == (str2 = glyph.f38504a) || (str != null && str.equals(str2))) && this.f38507d == glyph.f38507d)) {
                        BitmapDescriptor bitmapDescriptor = glyph.f38505b;
                        BitmapDescriptor bitmapDescriptor2 = this.f38505b;
                        if ((bitmapDescriptor2 != null || bitmapDescriptor == null) && (bitmapDescriptor2 == null || bitmapDescriptor != null)) {
                            if (bitmapDescriptor2 != null && bitmapDescriptor != null && (objZ0 = ObjectWrapper.z0(bitmapDescriptor2.f38433a)) != (objZ02 = ObjectWrapper.z0(bitmapDescriptor.f38433a)) && (objZ0 == null || !objZ0.equals(objZ02))) {
                                return false;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f38504a, this.f38505b, Integer.valueOf(this.f38506c)});
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.f38504a, false);
            BitmapDescriptor bitmapDescriptor = this.f38505b;
            SafeParcelWriter.writeIBinder(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.f38433a.asBinder(), false);
            SafeParcelWriter.writeInt(parcel, 4, this.f38506c);
            SafeParcelWriter.writeInt(parcel, 5, this.f38507d);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public PinConfig(int i2, int i3, Glyph glyph) {
        this.f38501a = i2;
        this.f38502b = i3;
        this.f38503c = glyph;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f38501a);
        SafeParcelWriter.writeInt(parcel, 3, this.f38502b);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f38503c, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
