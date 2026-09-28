package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzq extends com.google.android.gms.internal.common.zza implements IInterface {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper g(ObjectWrapper objectWrapper, String str, int i2, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i2);
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper2);
        return android.support.v4.media.a.f(zzB(2, parcelZza));
    }

    public final IObjectWrapper z0(ObjectWrapper objectWrapper, String str, int i2, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i2);
        com.google.android.gms.internal.common.zzc.d(parcelZza, objectWrapper2);
        return android.support.v4.media.a.f(zzB(3, parcelZza));
    }
}
