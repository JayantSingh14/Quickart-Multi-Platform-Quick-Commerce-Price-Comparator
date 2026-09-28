package com.google.android.gms.internal.pal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzfs extends zzfj implements IInterface {
    public final IBinder w1(ObjectWrapper objectWrapper) {
        Parcel parcelG = g();
        parcelG.writeString("h.3.2.2/n.android.3.2.2");
        zzfl.b(parcelG, objectWrapper);
        Parcel parcelZ0 = z0(2, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        parcelZ0.recycle();
        return strongBinder;
    }
}
