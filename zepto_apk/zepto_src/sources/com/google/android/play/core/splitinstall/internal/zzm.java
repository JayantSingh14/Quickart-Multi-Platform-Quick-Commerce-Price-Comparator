package com.google.android.play.core.splitinstall.internal;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class zzm {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f41986a = 0;

    static {
        zzm.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel) {
        Parcelable.Creator creator = Bundle.CREATOR;
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
