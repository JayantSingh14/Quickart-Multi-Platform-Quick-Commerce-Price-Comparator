package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

@SafeParcelable.Class(creator = "StreetViewPanoramaOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzaq();

    /* renamed from: a, reason: collision with root package name */
    public StreetViewPanoramaCamera f38420a;

    /* renamed from: b, reason: collision with root package name */
    public String f38421b;

    /* renamed from: c, reason: collision with root package name */
    public LatLng f38422c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f38423d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f38424e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f38425f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f38426g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f38427h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f38428i;

    /* renamed from: j, reason: collision with root package name */
    public StreetViewSource f38429j;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f38424e = bool;
        this.f38425f = bool;
        this.f38426g = bool;
        this.f38427h = bool;
        this.f38429j = StreetViewSource.f38549b;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("PanoramaId", this.f38421b).add("Position", this.f38422c).add("Radius", this.f38423d).add("Source", this.f38429j).add("StreetViewPanoramaCamera", this.f38420a).add("UserNavigationEnabled", this.f38424e).add("ZoomGesturesEnabled", this.f38425f).add("PanningGesturesEnabled", this.f38426g).add("StreetNamesEnabled", this.f38427h).add("UseViewLifecycleInFragment", this.f38428i).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38420a, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f38421b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f38422c, i2, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.f38423d, false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.a(this.f38424e));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.a(this.f38425f));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.a(this.f38426g));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.a(this.f38427h));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.a(this.f38428i));
        SafeParcelWriter.writeParcelable(parcel, 11, this.f38429j, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
