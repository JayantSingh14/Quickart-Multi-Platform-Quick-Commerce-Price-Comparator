package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public abstract class q extends b implements r {
    public q() {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
    }

    @Override // com.google.android.play.integrity.internal.b
    public final boolean g(int i2, Parcel parcel) {
        if (i2 != 2) {
            return false;
        }
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) c.a(parcel);
        c.b(parcel);
        M(bundle);
        throw null;
    }
}
