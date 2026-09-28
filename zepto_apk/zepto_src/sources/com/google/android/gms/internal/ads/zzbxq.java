package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NativeAdLayoutInfoParcelCreator")
/* loaded from: classes4.dex */
public final class zzbxq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbxq> CREATOR = new zzbxr();

    /* renamed from: a, reason: collision with root package name */
    public final View f25669a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f25670b;

    public zzbxq(IBinder iBinder, IBinder iBinder2) {
        this.f25669a = (View) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder));
        this.f25670b = (Map) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, new ObjectWrapper(this.f25669a).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, new ObjectWrapper(this.f25670b).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
