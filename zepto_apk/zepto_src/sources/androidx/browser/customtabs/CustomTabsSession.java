package androidx.browser.customtabs;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.support.customtabs.IEngagementSignalsCallback;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class CustomTabsSession {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1352a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ICustomTabsService f1353b;

    /* renamed from: c, reason: collision with root package name */
    public final ICustomTabsCallback f1354c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentName f1355d;

    /* renamed from: androidx.browser.customtabs.CustomTabsSession$1, reason: invalid class name */
    class AnonymousClass1 extends IEngagementSignalsCallback.Stub {
        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void Pb() {
            throw null;
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void S5() {
            throw null;
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void o7() {
            throw null;
        }
    }

    /* renamed from: androidx.browser.customtabs.CustomTabsSession$2, reason: invalid class name */
    class AnonymousClass2 extends IEngagementSignalsCallback.Stub {
        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void Pb() {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                throw null;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void S5() {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                throw null;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public final void o7() {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                throw null;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        }
    }

    @RestrictTo
    public static class PendingSession {
    }

    public CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.f1353b = iCustomTabsService;
        this.f1354c = iCustomTabsCallback;
        this.f1355d = componentName;
    }

    public final void a(String str) {
        Bundle bundle = new Bundle();
        synchronized (this.f1352a) {
            try {
                try {
                    this.f1353b.G9(this.f1354c, str, bundle);
                } catch (RemoteException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static class MockSession extends ICustomTabsService.Stub {
        @Override // android.support.customtabs.ICustomTabsService
        public final boolean C2(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean D3(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final int G9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean J4(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean N4(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Oa(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean U8(long j2) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final Bundle X3(Bundle bundle, String str) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Z9(ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean o5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean oa(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, ArrayList arrayList) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final void Gb(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final void b5(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle) {
        }
    }
}
