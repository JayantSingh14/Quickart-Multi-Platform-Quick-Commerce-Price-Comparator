package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
/* loaded from: classes3.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public IResultReceiver f115a;

    /* renamed from: android.support.v4.os.ResultReceiver$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public final ResultReceiver createFromParcel(Parcel parcel) {
            IResultReceiver iResultReceiver;
            ResultReceiver resultReceiver = new ResultReceiver();
            IBinder strongBinder = parcel.readStrongBinder();
            int i2 = IResultReceiver.Stub.f113a;
            if (strongBinder == null) {
                iResultReceiver = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IResultReceiver.W);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IResultReceiver)) {
                    IResultReceiver.Stub.Proxy proxy = new IResultReceiver.Stub.Proxy();
                    proxy.f114a = strongBinder;
                    iResultReceiver = proxy;
                } else {
                    iResultReceiver = (IResultReceiver) iInterfaceQueryLocalInterface;
                }
            }
            resultReceiver.f115a = iResultReceiver;
            return resultReceiver;
        }

        @Override // android.os.Parcelable.Creator
        public final ResultReceiver[] newArray(int i2) {
            return new ResultReceiver[i2];
        }
    }

    public class MyResultReceiver extends IResultReceiver.Stub {
        public MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public final void K6(int i2, Bundle bundle) {
            ResultReceiver.this.a(i2, bundle);
        }
    }

    public class MyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public void a(int i2, Bundle bundle) {
    }

    public final void b(int i2, Bundle bundle) {
        IResultReceiver iResultReceiver = this.f115a;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.K6(i2, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            try {
                if (this.f115a == null) {
                    this.f115a = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.f115a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
