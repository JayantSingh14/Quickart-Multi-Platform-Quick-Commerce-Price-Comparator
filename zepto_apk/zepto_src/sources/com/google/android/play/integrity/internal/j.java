package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public abstract class j extends b implements k {
    public j() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    @Override // com.google.android.play.integrity.internal.b
    public final boolean g(int i2, Parcel parcel) {
        if (i2 == 2) {
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) c.a(parcel);
            c.b(parcel);
            P9(bundle);
            return true;
        }
        if (i2 == 3) {
            Parcelable.Creator creator2 = Bundle.CREATOR;
            Bundle bundle2 = (Bundle) c.a(parcel);
            c.b(parcel);
            s0(bundle2);
            return true;
        }
        if (i2 == 4) {
            Parcelable.Creator creator3 = Bundle.CREATOR;
            c.b(parcel);
            d();
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        Parcelable.Creator creator4 = Bundle.CREATOR;
        Bundle bundle3 = (Bundle) c.a(parcel);
        c.b(parcel);
        M(bundle3);
        return true;
    }
}
