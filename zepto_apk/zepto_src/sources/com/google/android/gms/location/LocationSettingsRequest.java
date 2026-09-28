package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;

@SafeParcelable.Class(creator = "LocationSettingsRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes4.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzz();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38340a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f38341b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38342c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f38343a = new ArrayList();
    }

    public LocationSettingsRequest(ArrayList arrayList, boolean z, boolean z2) {
        this.f38340a = arrayList;
        this.f38341b = z;
        this.f38342c = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.f38340a), false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f38341b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f38342c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
