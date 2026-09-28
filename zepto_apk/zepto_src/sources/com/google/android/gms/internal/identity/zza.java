package com.google.android.gms.internal.identity;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f36616a;

    public zza(IBinder iBinder) {
        this.f36616a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f36616a;
    }
}
