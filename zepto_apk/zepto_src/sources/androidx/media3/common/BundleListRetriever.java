package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class BundleListRetriever extends Binder {

    /* renamed from: b, reason: collision with root package name */
    public static final int f5162b;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f5163a;

    static {
        f5162b = Util.f5744a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public BundleListRetriever(List list) {
        this.f5163a = ImmutableList.o(list);
    }

    public static ImmutableList a(IBinder iBinder) {
        int i2;
        if (iBinder instanceof BundleListRetriever) {
            return ((BundleListRetriever) iBinder).f5163a;
        }
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i3 = 1;
        int i4 = 0;
        while (i3 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i4);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i2 = parcelObtain2.readInt();
                        if (i2 == 1) {
                            Bundle bundle = parcelObtain2.readBundle();
                            bundle.getClass();
                            builder.h(bundle);
                            i4++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i3 = i2;
                } catch (RemoteException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return builder.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        if (parcel2 == null) {
            return false;
        }
        ImmutableList immutableList = this.f5163a;
        int size = immutableList.size();
        int i4 = parcel.readInt();
        while (i4 < size && parcel2.dataSize() < f5162b) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) immutableList.get(i4));
            i4++;
        }
        parcel2.writeInt(i4 < size ? 2 : 0);
        return true;
    }
}
