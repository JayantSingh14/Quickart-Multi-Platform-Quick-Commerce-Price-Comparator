package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbkt {

    /* renamed from: a, reason: collision with root package name */
    public final zzbks f25285a;

    public zzbkt(zzbks zzbksVar) {
        Context context;
        this.f25285a = zzbksVar;
        try {
            context = (Context) ObjectWrapper.z0(zzbksVar.T9());
        } catch (RemoteException | NullPointerException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            context = null;
        }
        if (context != null) {
            try {
                this.f25285a.J(new ObjectWrapper(new MediaView(context)));
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            }
        }
    }
}
