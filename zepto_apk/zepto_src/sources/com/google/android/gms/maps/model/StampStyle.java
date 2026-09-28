package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator = "StampStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class StampStyle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StampStyle> CREATOR = new zzt();

    /* renamed from: a, reason: collision with root package name */
    public final BitmapDescriptor f38536a;

    public static abstract class Builder<T extends Builder<T>> {
    }

    public StampStyle(IBinder iBinder) {
        this.f38536a = new BitmapDescriptor(IObjectWrapper.Stub.g(iBinder));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f38536a.f38433a.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
