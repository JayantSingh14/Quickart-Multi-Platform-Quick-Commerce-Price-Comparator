package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class BitmapDescriptorFactory {

    /* renamed from: a, reason: collision with root package name */
    public static com.google.android.gms.internal.maps.zzi f38434a;

    public static BitmapDescriptor a() {
        try {
            return new BitmapDescriptor(((com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(f38434a, "IBitmapDescriptorFactory is not initialized")).zzd());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor b(float f2) {
        try {
            return new BitmapDescriptor(((com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(f38434a, "IBitmapDescriptorFactory is not initialized")).Z1(f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor c(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap, "image must not be null");
        try {
            return new BitmapDescriptor(((com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(f38434a, "IBitmapDescriptorFactory is not initialized")).J2(bitmap));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor d(int i2) {
        try {
            return new BitmapDescriptor(((com.google.android.gms.internal.maps.zzi) Preconditions.checkNotNull(f38434a, "IBitmapDescriptorFactory is not initialized")).r(i2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
