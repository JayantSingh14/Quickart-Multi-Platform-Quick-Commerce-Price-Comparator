package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo
/* loaded from: classes3.dex */
public interface ITrustedWebActivityService extends IInterface {
    public static final String T = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements ITrustedWebActivityService {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {

        public static class Proxy implements ITrustedWebActivityService {
            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }
        }

        public Stub() {
            attachInterface(this, ITrustedWebActivityService.T);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str = ITrustedWebActivityService.T;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i2) {
                case 2:
                    Bundle bundleE5 = e5((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundleE5.writeToParcel(parcel2, 1);
                    return true;
                case 3:
                    ma((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int iC9 = C9();
                    parcel2.writeNoException();
                    parcel2.writeInt(iC9);
                    return true;
                case 5:
                    Bundle bundleZ7 = z7();
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundleZ7.writeToParcel(parcel2, 1);
                    return true;
                case 6:
                    Bundle bundleF9 = F9((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundleF9.writeToParcel(parcel2, 1);
                    return true;
                case 7:
                    Bundle bundleC4 = C4();
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundleC4.writeToParcel(parcel2, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
                case 9:
                    parcel.readString();
                    S6(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
            }
        }
    }

    public static class _Parcel {
    }

    Bundle C4();

    int C9();

    Bundle F9(Bundle bundle);

    void S6(IBinder iBinder);

    Bundle e5(Bundle bundle);

    void ma(Bundle bundle);

    Bundle z7();
}
