package com.google.android.play.core.appupdate.internal;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;

/* loaded from: classes4.dex */
public abstract class zzg extends zzb implements zzh {
    public zzg() {
        attachInterface(this, "com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.appupdate.internal.zzb
    public final boolean g(int i2, Parcel parcel) {
        if (i2 == 2) {
            Parcelable.Creator creator = Bundle.CREATOR;
            int i3 = zzc.f41678a;
            Bundle bundle = (Bundle) (parcel.readInt() != 0 ? (Parcelable) creator.createFromParcel(parcel) : null);
            int iDataAvail = parcel.dataAvail();
            if (iDataAvail > 0) {
                throw new BadParcelableException(b.f(iDataAvail, "Parcel data not fully consumed, unread size: "));
            }
            zzc(bundle);
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        Parcelable.Creator creator2 = Bundle.CREATOR;
        int i4 = zzc.f41678a;
        Bundle bundle2 = (Bundle) (parcel.readInt() != 0 ? (Parcelable) creator2.createFromParcel(parcel) : null);
        int iDataAvail2 = parcel.dataAvail();
        if (iDataAvail2 > 0) {
            throw new BadParcelableException(b.f(iDataAvail2, "Parcel data not fully consumed, unread size: "));
        }
        b0(bundle2);
        return true;
    }
}
