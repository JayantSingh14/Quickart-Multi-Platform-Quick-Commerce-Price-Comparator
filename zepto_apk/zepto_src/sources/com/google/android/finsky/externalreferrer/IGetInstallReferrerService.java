package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

/* loaded from: classes3.dex */
public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends b implements IGetInstallReferrerService {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f20978a = 0;

        public static class Proxy extends a implements IGetInstallReferrerService {
            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            public final Bundle s0(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                int i2 = c.f20508a;
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
                parcelObtain = Parcel.obtain();
                try {
                    this.f20507a.transact(1, parcelObtain, parcelObtain, 0);
                    parcelObtain.readException();
                    parcelObtain.recycle();
                    return (Bundle) (parcelObtain.readInt() == 0 ? null : (Parcelable) Bundle.CREATOR.createFromParcel(parcelObtain));
                } catch (RuntimeException e2) {
                    throw e2;
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        }

        @Override // com.google.android.a.b
        public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
            if (i2 != 1) {
                return false;
            }
            Parcelable.Creator creator = Bundle.CREATOR;
            int i3 = c.f20508a;
            Bundle bundleS0 = s0((Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel)));
            parcel2.writeNoException();
            if (bundleS0 == null) {
                parcel2.writeInt(0);
                return true;
            }
            parcel2.writeInt(1);
            bundleS0.writeToParcel(parcel2, 1);
            return true;
        }
    }

    Bundle s0(Bundle bundle);
}
