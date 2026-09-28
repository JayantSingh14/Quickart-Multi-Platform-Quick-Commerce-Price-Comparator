package com.google.android.gms.fido.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.fido.common.Transport;

/* loaded from: classes4.dex */
final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) throws Transport.UnsupportedTransportException {
        String string = parcel.readString();
        try {
            for (Transport transport : Transport.values()) {
                if (string.equals(transport.f22340a)) {
                    return transport;
                }
            }
            if (string.equals("hybrid")) {
                return Transport.HYBRID;
            }
            throw new Transport.UnsupportedTransportException(b.D("Transport ", string, " not supported"));
        } catch (Transport.UnsupportedTransportException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Transport[i2];
    }
}
