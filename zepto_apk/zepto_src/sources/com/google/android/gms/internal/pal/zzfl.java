package com.google.android.gms.internal.pal;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzfl {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37734a = 0;

    static {
        zzfl.class.getClassLoader();
    }

    public static void a(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(android.support.v4.media.b.f(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
