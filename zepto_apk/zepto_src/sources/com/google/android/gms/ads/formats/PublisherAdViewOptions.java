package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21059a;

    /* renamed from: b, reason: collision with root package name */
    public final zzco f21060b;

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f21061c;

    @Deprecated
    public static final class Builder {
    }

    public PublisherAdViewOptions(boolean z, IBinder iBinder, IBinder iBinder2) {
        zzco zzcmVar;
        this.f21059a = z;
        if (iBinder != null) {
            int i2 = zzcn.f21158a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(iBinder);
        } else {
            zzcmVar = null;
        }
        this.f21060b = zzcmVar;
        this.f21061c = iBinder2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f21059a);
        zzco zzcoVar = this.f21060b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcoVar == null ? null : zzcoVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.f21061c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
