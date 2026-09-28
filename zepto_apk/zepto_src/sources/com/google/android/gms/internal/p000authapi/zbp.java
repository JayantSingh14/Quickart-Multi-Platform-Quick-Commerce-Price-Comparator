package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* loaded from: classes4.dex */
public abstract class zbp extends zbb implements zbq {
    public zbp() {
        super("com.google.android.gms.auth.api.identity.internal.IGetSignInIntentCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        Status status = (Status) zbc.a(parcel, Status.CREATOR);
        PendingIntent pendingIntent = (PendingIntent) zbc.a(parcel, PendingIntent.CREATOR);
        zbc.b(parcel);
        TaskUtil.setResultOrApiException(status, pendingIntent, ((zban) this).f36263a);
        return true;
    }
}
