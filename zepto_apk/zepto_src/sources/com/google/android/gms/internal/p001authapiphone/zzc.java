package com.google.android.gms.internal.p001authapiphone;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class zzc {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36250a = 0;

    static {
        zzc.class.getClassLoader();
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
}
