package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Surface;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Rating;
import androidx.media3.common.util.Log;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaLibraryService;

/* loaded from: classes3.dex */
public interface IMediaSession extends IInterface {

    public static class Default implements IMediaSession {
        @Override // androidx.media3.session.IMediaSession
        public final void A6(IMediaController iMediaController, int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void B6(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Cb(IMediaController iMediaController, int i2, boolean z, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Da(IMediaController iMediaController, int i2, int i3, int i4, IBinder iBinder) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void E6(IMediaController iMediaController, int i2, float f2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void F1(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void F6(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Hb(IMediaController iMediaController, int i2, Bundle bundle, Bundle bundle2) {
            Bundle bundle3 = Bundle.EMPTY;
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Ia(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void K1(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Kb(IMediaController iMediaController, int i2, IBinder iBinder, int i3, long j2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void La(IMediaController iMediaController, int i2, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void M5(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void N6(IMediaController iMediaController, int i2, IBinder iBinder) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void O8(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Q3(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Qa(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Sb(IMediaController iMediaController, int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void T5(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Va(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void W7(IMediaController iMediaController, int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void Z3(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void a7(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaSession
        public final void b6(IMediaController iMediaController, int i2, Bundle bundle, long j2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void b7(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void c8(IMediaController iMediaController, int i2, int i3, int i4, int i5) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void d7(IMediaController iMediaController, int i2, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void ea(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void f5(IMediaController iMediaController, int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void g6(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void ga(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void h6(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void h7(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void i6(IMediaController iMediaController, int i2, long j2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void j4(IMediaController iMediaController, int i2, IBinder iBinder, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void j8(IMediaController iMediaController, int i2, Surface surface) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void l4(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void o3(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void q3(IMediaController iMediaController, int i2, boolean z) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void q7(IMediaController iMediaController, int i2, int i3, long j2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void q8(IMediaController iMediaController, int i2, int i3, IBinder iBinder) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void qb(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void s4(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void s9(IMediaController iMediaController) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void t7(IMediaController iMediaController, int i2, int i3) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void t8(IMediaController iMediaController, int i2, Bundle bundle) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void u2(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void u9(IMediaController iMediaController, int i2, int i3, int i4) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void v5(IMediaController iMediaController, int i2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void y6(IMediaController iMediaController, int i2, float f2) {
        }

        @Override // androidx.media3.session.IMediaSession
        public final void za(IMediaController iMediaController, int i2) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaSession {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f9937a = 0;

        public static class Proxy implements IMediaSession {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f9938a;

            @Override // androidx.media3.session.IMediaSession
            public final void A6(IMediaController iMediaController, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3014, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void B6(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    this.f9938a.transact(3022, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Cb(IMediaController iMediaController, int i2, boolean z, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3054, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Da(IMediaController iMediaController, int i2, int i3, int i4, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.f9938a.transact(3056, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void E6(IMediaController iMediaController, int i2, float f2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeFloat(f2);
                    this.f9938a.transact(3028, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void F1(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3004, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void F6(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3055, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Hb(IMediaController iMediaController, int i2, Bundle bundle, Bundle bundle2) {
                Bundle bundle3 = Bundle.EMPTY;
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    _Parcel.b(parcelObtain, bundle3);
                    this.f9938a.transact(3016, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Ia(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3024, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void K1(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3025, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Kb(IMediaController iMediaController, int i2, IBinder iBinder, int i3, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j2);
                    this.f9938a.transact(3012, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void La(IMediaController iMediaController, int i2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9938a.transact(3013, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void M5(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3036, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void N6(IMediaController iMediaController, int i2, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.f9938a.transact(3031, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void O8(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3026, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Q3(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9938a.transact(3057, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Qa(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3052, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Sb(IMediaController iMediaController, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3048, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void T5(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3053, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Va(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3040, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void W7(IMediaController iMediaController, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3027, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void Z3(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3003, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void a7(IMediaController iMediaController, int i2, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3030, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9938a;
            }

            @Override // androidx.media3.session.IMediaSession
            public final void b6(IMediaController iMediaController, int i2, Bundle bundle, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    parcelObtain.writeLong(j2);
                    this.f9938a.transact(3008, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void b7(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    this.f9938a.transact(3051, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void c8(IMediaController iMediaController, int i2, int i3, int i4, int i5) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    this.f9938a.transact(3023, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void d7(IMediaController iMediaController, int i2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9938a.transact(3006, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void ea(IMediaController iMediaController, int i2, Bundle bundle, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    parcelObtain.writeInt(1);
                    this.f9938a.transact(3009, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void f5(IMediaController iMediaController, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3015, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void g6(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3019, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void ga(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3034, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void h6(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3043, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void h7(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3037, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void i6(IMediaController iMediaController, int i2, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    this.f9938a.transact(3038, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void j4(IMediaController iMediaController, int i2, IBinder iBinder, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(1);
                    this.f9938a.transact(3011, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void j8(IMediaController iMediaController, int i2, Surface surface) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, surface);
                    this.f9938a.transact(3044, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void l4(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3042, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void o3(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3035, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void q3(IMediaController iMediaController, int i2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9938a.transact(3018, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void q7(IMediaController iMediaController, int i2, int i3, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j2);
                    this.f9938a.transact(3039, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void q8(IMediaController iMediaController, int i2, int i3, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.f9938a.transact(3032, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void qb(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3005, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void s4(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3047, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void s9(IMediaController iMediaController) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    this.f9938a.transact(3045, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void t7(IMediaController iMediaController, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f9938a.transact(3017, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void t8(IMediaController iMediaController, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    _Parcel.b(parcelObtain, bundle);
                    this.f9938a.transact(3033, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void u2(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3021, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void u9(IMediaController iMediaController, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    this.f9938a.transact(3020, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void v5(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3046, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void y6(IMediaController iMediaController, int i2, float f2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeFloat(f2);
                    this.f9938a.transact(3002, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public final void za(IMediaController iMediaController, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i2);
                    this.f9938a.transact(3041, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "androidx.media3.session.IMediaSession");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("androidx.media3.session.IMediaSession");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("androidx.media3.session.IMediaSession");
                return true;
            }
            switch (i2) {
                case 3002:
                    ((MediaSessionStub) this).y6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case 3003:
                    ((MediaSessionStub) this).Z3(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3004:
                    ((MediaSessionStub) this).F1(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3005:
                    ((MediaSessionStub) this).qb(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3006:
                    ((MediaSessionStub) this).d7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3007:
                    ((MediaSessionStub) this).ea(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), true);
                    return true;
                case 3008:
                    ((MediaSessionStub) this).b6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readLong());
                    return true;
                case 3009:
                    ((MediaSessionStub) this).ea(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    return true;
                case 3010:
                    ((MediaSessionStub) this).j4(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), true);
                    return true;
                case 3011:
                    ((MediaSessionStub) this).j4(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0);
                    return true;
                case 3012:
                    ((MediaSessionStub) this).Kb(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt(), parcel.readLong());
                    return true;
                case 3013:
                    ((MediaSessionStub) this).La(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3014:
                    ((MediaSessionStub) this).A6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3015:
                    ((MediaSessionStub) this).f5(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3016:
                    IMediaController iMediaControllerG = IMediaController.Stub.g(parcel.readStrongBinder());
                    int i4 = parcel.readInt();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    ((MediaSessionStub) this).Hb(iMediaControllerG, i4, (Bundle) _Parcel.a(parcel, creator), (Bundle) _Parcel.a(parcel, creator));
                    return true;
                case 3017:
                    ((MediaSessionStub) this).t7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3018:
                    ((MediaSessionStub) this).q3(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3019:
                    ((MediaSessionStub) this).g6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3020:
                    ((MediaSessionStub) this).u9(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3021:
                    ((MediaSessionStub) this).u2(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3022:
                    ((MediaSessionStub) this).B6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3023:
                    ((MediaSessionStub) this).c8(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3024:
                    ((MediaSessionStub) this).Ia(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3025:
                    ((MediaSessionStub) this).K1(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3026:
                    ((MediaSessionStub) this).O8(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3027:
                    ((MediaSessionStub) this).W7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3028:
                    ((MediaSessionStub) this).E6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case 3029:
                    IMediaController iMediaControllerG2 = IMediaController.Stub.g(parcel.readStrongBinder());
                    int i5 = parcel.readInt();
                    Bundle bundle = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                    MediaSessionStub mediaSessionStub = (MediaSessionStub) this;
                    if (iMediaControllerG2 != null && bundle != null) {
                        try {
                            mediaSessionStub.y3(iMediaControllerG2, i5, 20, new b2(new s(14, new q1(2, MediaItem.b(bundle)), new o0(20)), 1));
                        } catch (RuntimeException e2) {
                            Log.i("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e2);
                        }
                    }
                    return true;
                case 3030:
                    ((MediaSessionStub) this).a7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3031:
                    ((MediaSessionStub) this).N6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3032:
                    ((MediaSessionStub) this).q8(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3033:
                    ((MediaSessionStub) this).t8(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3034:
                    ((MediaSessionStub) this).ga(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3035:
                    ((MediaSessionStub) this).o3(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3036:
                    ((MediaSessionStub) this).M5(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3037:
                    ((MediaSessionStub) this).h7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3038:
                    ((MediaSessionStub) this).i6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                    return true;
                case 3039:
                    ((MediaSessionStub) this).q7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    return true;
                case 3040:
                    ((MediaSessionStub) this).Va(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3041:
                    ((MediaSessionStub) this).za(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3042:
                    ((MediaSessionStub) this).l4(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3043:
                    ((MediaSessionStub) this).h6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3044:
                    ((MediaSessionStub) this).j8(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Surface) _Parcel.a(parcel, Surface.CREATOR));
                    return true;
                case 3045:
                    ((MediaSessionStub) this).s9(IMediaController.Stub.g(parcel.readStrongBinder()));
                    return true;
                case 3046:
                    ((MediaSessionStub) this).v5(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3047:
                    ((MediaSessionStub) this).s4(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3048:
                    ((MediaSessionStub) this).Sb(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3049:
                    IMediaController iMediaControllerG3 = IMediaController.Stub.g(parcel.readStrongBinder());
                    int i6 = parcel.readInt();
                    String string = parcel.readString();
                    Bundle bundle2 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                    MediaSessionStub mediaSessionStub2 = (MediaSessionStub) this;
                    if (iMediaControllerG3 != null && string != null && bundle2 != null) {
                        if (TextUtils.isEmpty(string)) {
                            Log.h("MediaSessionStub", "setRatingWithMediaId(): Ignoring empty mediaId");
                        } else {
                            try {
                                mediaSessionStub2.z0(iMediaControllerG3, i6, null, 40010, new b2(new o0(string, Rating.a(bundle2), 17), 1));
                            } catch (RuntimeException e3) {
                                Log.i("MediaSessionStub", "Ignoring malformed Bundle for Rating", e3);
                            }
                        }
                    }
                    return true;
                case 3050:
                    IMediaController iMediaControllerG4 = IMediaController.Stub.g(parcel.readStrongBinder());
                    int i7 = parcel.readInt();
                    Bundle bundle3 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                    MediaSessionStub mediaSessionStub3 = (MediaSessionStub) this;
                    if (iMediaControllerG4 != null && bundle3 != null) {
                        try {
                            mediaSessionStub3.z0(iMediaControllerG4, i7, null, 40010, new b2(new o0(Rating.a(bundle3), 27), 1));
                        } catch (RuntimeException e4) {
                            Log.i("MediaSessionStub", "Ignoring malformed Bundle for Rating", e4);
                        }
                    }
                    return true;
                case 3051:
                    ((MediaSessionStub) this).b7(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3052:
                    ((MediaSessionStub) this).Qa(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3053:
                    ((MediaSessionStub) this).T5(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3054:
                    ((MediaSessionStub) this).Cb(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 3055:
                    ((MediaSessionStub) this).F6(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR));
                    return true;
                case 3056:
                    ((MediaSessionStub) this).Da(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3057:
                    ((MediaSessionStub) this).Q3(IMediaController.Stub.g(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.a(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    return true;
                default:
                    MediaLibraryService.LibraryParams libraryParamsA = null;
                    switch (i2) {
                        case 4001:
                            IMediaController iMediaControllerG5 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i8 = parcel.readInt();
                            Bundle bundle4 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                            MediaSessionStub mediaSessionStub4 = (MediaSessionStub) this;
                            if (iMediaControllerG5 != null) {
                                if (bundle4 == null) {
                                    mediaSessionStub4.z0(iMediaControllerG5, i8, null, 50000, new b2(new s0(libraryParamsA, 5), 0));
                                } else {
                                    try {
                                        libraryParamsA = MediaLibraryService.LibraryParams.a(bundle4);
                                        mediaSessionStub4.z0(iMediaControllerG5, i8, null, 50000, new b2(new s0(libraryParamsA, 5), 0));
                                    } catch (RuntimeException e5) {
                                        Log.i("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e5);
                                    }
                                }
                            }
                            return true;
                        case 4002:
                            IMediaController iMediaControllerG6 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i9 = parcel.readInt();
                            String string2 = parcel.readString();
                            MediaSessionStub mediaSessionStub5 = (MediaSessionStub) this;
                            if (iMediaControllerG6 != null) {
                                if (TextUtils.isEmpty(string2)) {
                                    Log.h("MediaSessionStub", "getItem(): Ignoring empty mediaId");
                                    return true;
                                }
                                mediaSessionStub5.z0(iMediaControllerG6, i9, null, 50004, new b2(new o0(string2, 14), 0));
                                return true;
                            }
                            return true;
                        case 4003:
                            IMediaController iMediaControllerG7 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i10 = parcel.readInt();
                            String string3 = parcel.readString();
                            int i11 = parcel.readInt();
                            int i12 = parcel.readInt();
                            Bundle bundle5 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                            MediaSessionStub mediaSessionStub6 = (MediaSessionStub) this;
                            if (iMediaControllerG7 != null) {
                                if (TextUtils.isEmpty(string3)) {
                                    Log.h("MediaSessionStub", "getChildren(): Ignoring empty parentId");
                                } else if (i11 < 0) {
                                    Log.h("MediaSessionStub", "getChildren(): Ignoring negative page");
                                } else if (i12 < 1) {
                                    Log.h("MediaSessionStub", "getChildren(): Ignoring pageSize less than 1");
                                } else if (bundle5 == null) {
                                    mediaSessionStub6.z0(iMediaControllerG7, i10, null, 50003, new b2(new p0(string3, i11, i12, libraryParamsA), 0));
                                } else {
                                    try {
                                        libraryParamsA = MediaLibraryService.LibraryParams.a(bundle5);
                                        mediaSessionStub6.z0(iMediaControllerG7, i10, null, 50003, new b2(new p0(string3, i11, i12, libraryParamsA), 0));
                                    } catch (RuntimeException e6) {
                                        Log.i("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e6);
                                    }
                                }
                            }
                            return true;
                        case 4004:
                            IMediaController iMediaControllerG8 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i13 = parcel.readInt();
                            String string4 = parcel.readString();
                            Bundle bundle6 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                            MediaSessionStub mediaSessionStub7 = (MediaSessionStub) this;
                            if (iMediaControllerG8 != null) {
                                if (TextUtils.isEmpty(string4)) {
                                    Log.h("MediaSessionStub", "search(): Ignoring empty query");
                                } else if (bundle6 == null) {
                                    mediaSessionStub7.z0(iMediaControllerG8, i13, null, 50005, new b2(new o0(string4, libraryParamsA, 25), 0));
                                } else {
                                    try {
                                        libraryParamsA = MediaLibraryService.LibraryParams.a(bundle6);
                                        mediaSessionStub7.z0(iMediaControllerG8, i13, null, 50005, new b2(new o0(string4, libraryParamsA, 25), 0));
                                    } catch (RuntimeException e7) {
                                        Log.i("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e7);
                                    }
                                }
                            }
                            return true;
                        case 4005:
                            IMediaController iMediaControllerG9 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i14 = parcel.readInt();
                            String string5 = parcel.readString();
                            int i15 = parcel.readInt();
                            int i16 = parcel.readInt();
                            Bundle bundle7 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                            MediaSessionStub mediaSessionStub8 = (MediaSessionStub) this;
                            if (iMediaControllerG9 != null) {
                                if (TextUtils.isEmpty(string5)) {
                                    Log.h("MediaSessionStub", "getSearchResult(): Ignoring empty query");
                                } else if (i15 < 0) {
                                    Log.h("MediaSessionStub", "getSearchResult(): Ignoring negative page");
                                } else if (i16 < 1) {
                                    Log.h("MediaSessionStub", "getSearchResult(): Ignoring pageSize less than 1");
                                } else if (bundle7 == null) {
                                    mediaSessionStub8.z0(iMediaControllerG9, i14, null, 50006, new b2(new r0(string5, i15, i16, libraryParamsA), 0));
                                } else {
                                    try {
                                        libraryParamsA = MediaLibraryService.LibraryParams.a(bundle7);
                                        mediaSessionStub8.z0(iMediaControllerG9, i14, null, 50006, new b2(new r0(string5, i15, i16, libraryParamsA), 0));
                                    } catch (RuntimeException e8) {
                                        Log.i("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e8);
                                    }
                                }
                            }
                            return true;
                        case 4006:
                            IMediaController iMediaControllerG10 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i17 = parcel.readInt();
                            String string6 = parcel.readString();
                            Bundle bundle8 = (Bundle) _Parcel.a(parcel, Bundle.CREATOR);
                            MediaSessionStub mediaSessionStub9 = (MediaSessionStub) this;
                            if (iMediaControllerG10 != null) {
                                if (TextUtils.isEmpty(string6)) {
                                    Log.h("MediaSessionStub", "subscribe(): Ignoring empty parentId");
                                } else if (bundle8 == null) {
                                    mediaSessionStub9.z0(iMediaControllerG10, i17, null, 50001, new b2(new s(12, string6, libraryParamsA), 0));
                                } else {
                                    try {
                                        libraryParamsA = MediaLibraryService.LibraryParams.a(bundle8);
                                        mediaSessionStub9.z0(iMediaControllerG10, i17, null, 50001, new b2(new s(12, string6, libraryParamsA), 0));
                                    } catch (RuntimeException e9) {
                                        Log.i("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e9);
                                    }
                                }
                            }
                            return true;
                        case 4007:
                            IMediaController iMediaControllerG11 = IMediaController.Stub.g(parcel.readStrongBinder());
                            int i18 = parcel.readInt();
                            String string7 = parcel.readString();
                            MediaSessionStub mediaSessionStub10 = (MediaSessionStub) this;
                            if (iMediaControllerG11 != null) {
                                if (TextUtils.isEmpty(string7)) {
                                    Log.h("MediaSessionStub", "unsubscribe(): Ignoring empty parentId");
                                    return true;
                                }
                                mediaSessionStub10.z0(iMediaControllerG11, i18, null, 50002, new b2(new s0(string7, 2), 0));
                                return true;
                            }
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
            }
        }
    }

    public static class _Parcel {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Parcelable parcelable) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, 0);
            }
        }
    }

    void A6(IMediaController iMediaController, int i2, Bundle bundle);

    void B6(IMediaController iMediaController, int i2, int i3, int i4);

    void Cb(IMediaController iMediaController, int i2, boolean z, int i3);

    void Da(IMediaController iMediaController, int i2, int i3, int i4, IBinder iBinder);

    void E6(IMediaController iMediaController, int i2, float f2);

    void F1(IMediaController iMediaController, int i2);

    void F6(IMediaController iMediaController, int i2, int i3, Bundle bundle);

    void Hb(IMediaController iMediaController, int i2, Bundle bundle, Bundle bundle2);

    void Ia(IMediaController iMediaController, int i2);

    void K1(IMediaController iMediaController, int i2);

    void Kb(IMediaController iMediaController, int i2, IBinder iBinder, int i3, long j2);

    void La(IMediaController iMediaController, int i2, boolean z);

    void M5(IMediaController iMediaController, int i2);

    void N6(IMediaController iMediaController, int i2, IBinder iBinder);

    void O8(IMediaController iMediaController, int i2);

    void Q3(IMediaController iMediaController, int i2, Bundle bundle, boolean z);

    void Qa(IMediaController iMediaController, int i2, int i3);

    void Sb(IMediaController iMediaController, int i2, Bundle bundle);

    void T5(IMediaController iMediaController, int i2, int i3);

    void Va(IMediaController iMediaController, int i2);

    void W7(IMediaController iMediaController, int i2, Bundle bundle);

    void Z3(IMediaController iMediaController, int i2, int i3);

    void a7(IMediaController iMediaController, int i2, int i3, Bundle bundle);

    void b6(IMediaController iMediaController, int i2, Bundle bundle, long j2);

    void b7(IMediaController iMediaController, int i2, int i3, int i4);

    void c8(IMediaController iMediaController, int i2, int i3, int i4, int i5);

    void d7(IMediaController iMediaController, int i2, boolean z);

    void ea(IMediaController iMediaController, int i2, Bundle bundle, boolean z);

    void f5(IMediaController iMediaController, int i2, Bundle bundle);

    void g6(IMediaController iMediaController, int i2, int i3);

    void ga(IMediaController iMediaController, int i2);

    void h6(IMediaController iMediaController, int i2);

    void h7(IMediaController iMediaController, int i2, int i3);

    void i6(IMediaController iMediaController, int i2, long j2);

    void j4(IMediaController iMediaController, int i2, IBinder iBinder, boolean z);

    void j8(IMediaController iMediaController, int i2, Surface surface);

    void l4(IMediaController iMediaController, int i2);

    void o3(IMediaController iMediaController, int i2);

    void q3(IMediaController iMediaController, int i2, boolean z);

    void q7(IMediaController iMediaController, int i2, int i3, long j2);

    void q8(IMediaController iMediaController, int i2, int i3, IBinder iBinder);

    void qb(IMediaController iMediaController, int i2);

    void s4(IMediaController iMediaController, int i2);

    void s9(IMediaController iMediaController);

    void t7(IMediaController iMediaController, int i2, int i3);

    void t8(IMediaController iMediaController, int i2, Bundle bundle);

    void u2(IMediaController iMediaController, int i2);

    void u9(IMediaController iMediaController, int i2, int i3, int i4);

    void v5(IMediaController iMediaController, int i2);

    void y6(IMediaController iMediaController, int i2, float f2);

    void za(IMediaController iMediaController, int i2);
}
