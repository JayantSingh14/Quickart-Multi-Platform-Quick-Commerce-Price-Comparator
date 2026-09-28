package com.google.android.gms.internal.p000authapi;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class zbc {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36271a = 0;

    static {
        zbc.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(b.f(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    public static void c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
