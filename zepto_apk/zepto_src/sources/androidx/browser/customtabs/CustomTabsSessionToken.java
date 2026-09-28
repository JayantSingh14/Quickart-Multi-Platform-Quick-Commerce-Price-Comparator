package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

/* loaded from: classes3.dex */
public class CustomTabsSessionToken {

    /* renamed from: a, reason: collision with root package name */
    public final ICustomTabsCallback f1356a;

    /* renamed from: b, reason: collision with root package name */
    public final PendingIntent f1357b;

    public CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f1356a = iCustomTabsCallback;
        this.f1357b = pendingIntent;
        if (iCustomTabsCallback == null) {
            return;
        }
        new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void a(Bundle bundle, String str) {
                try {
                    CustomTabsSessionToken.this.f1356a.C6(bundle, str);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final Bundle b(Bundle bundle, String str) {
                try {
                    return CustomTabsSessionToken.this.f1356a.f6(bundle, str);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void c(int i2, int i3, int i4, int i5, int i6, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.l2(i2, i3, i4, i5, i6, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void d(int i2, int i3, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.B9(i2, i3, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void e(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.sb(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void f(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.a9(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void g(int i2, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.Ca(i2, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void h(Bundle bundle, String str) {
                try {
                    CustomTabsSessionToken.this.f1356a.X6(bundle, str);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void i(int i2, Uri uri, boolean z, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.yb(i2, uri, z, bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void j(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.p9(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void k(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.f1356a.j5(bundle);
                } catch (RemoteException unused) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CustomTabsSessionToken) {
            CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
            PendingIntent pendingIntent = customTabsSessionToken.f1357b;
            PendingIntent pendingIntent2 = this.f1357b;
            if ((pendingIntent2 == null) == (pendingIntent == null)) {
                if (pendingIntent2 != null) {
                    return pendingIntent2.equals(pendingIntent);
                }
                ICustomTabsCallback iCustomTabsCallback = this.f1356a;
                if (iCustomTabsCallback == null) {
                    throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
                }
                IBinder iBinderAsBinder = iCustomTabsCallback.asBinder();
                ICustomTabsCallback iCustomTabsCallback2 = customTabsSessionToken.f1356a;
                if (iCustomTabsCallback2 != null) {
                    return iBinderAsBinder.equals(iCustomTabsCallback2.asBinder());
                }
                throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
            }
        }
        return false;
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.f1357b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        ICustomTabsCallback iCustomTabsCallback = this.f1356a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder().hashCode();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public static class MockCallback extends ICustomTabsCallback.Stub {
        @Override // android.support.customtabs.ICustomTabsCallback
        public final void B9(int i2, int i3, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void Ca(int i2, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void a9(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final Bundle f6(Bundle bundle, String str) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void j5(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void l2(int i2, int i3, int i4, int i5, int i6, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void p9(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void sb(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void yb(int i2, Uri uri, boolean z, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void C6(Bundle bundle, String str) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public final void X6(Bundle bundle, String str) {
        }
    }
}
