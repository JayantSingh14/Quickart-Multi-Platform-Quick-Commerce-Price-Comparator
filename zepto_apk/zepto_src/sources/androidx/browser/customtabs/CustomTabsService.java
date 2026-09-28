package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.support.customtabs.IEngagementSignalsCallback;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabsService;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class CustomTabsService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f1348a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public final ICustomTabsService.Stub f1349b = new AnonymousClass1();

    /* renamed from: androidx.browser.customtabs.CustomTabsService$1, reason: invalid class name */
    public class AnonymousClass1 extends ICustomTabsService.Stub {
        public AnonymousClass1() {
        }

        public static PendingIntent z0(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean C2(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            return CustomTabsService.this.h();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean D3(int i2, Uri uri, Bundle bundle, ICustomTabsCallback iCustomTabsCallback) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            return CustomTabsService.this.e();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final int G9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            return CustomTabsService.this.d();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final void Gb(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean J4(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                }
            }
            return CustomTabsService.this.f();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean N4(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return j1(iCustomTabsCallback, z0(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Oa(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            new CustomTabsSessionToken(iCustomTabsCallback, null);
            new Bundle();
            return CustomTabsService.this.f();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean U8(long j2) {
            return CustomTabsService.this.i();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final Bundle X3(Bundle bundle, String str) {
            return CustomTabsService.this.a();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean Z9(ICustomTabsCallback iCustomTabsCallback) {
            return j1(iCustomTabsCallback, null);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final void b5(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle) {
            IEngagementSignalsCallback.Stub.g(iBinder);
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
        }

        public final boolean j1(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.a
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        CustomTabsService.AnonymousClass1 anonymousClass1 = this.f1361a;
                        CustomTabsSessionToken customTabsSessionToken2 = customTabsSessionToken;
                        CustomTabsService customTabsService = CustomTabsService.this;
                        customTabsService.getClass();
                        try {
                            synchronized (customTabsService.f1348a) {
                                try {
                                    ICustomTabsCallback iCustomTabsCallback2 = customTabsSessionToken2.f1356a;
                                    IBinder iBinderAsBinder = iCustomTabsCallback2 == null ? null : iCustomTabsCallback2.asBinder();
                                    if (iBinderAsBinder == null) {
                                        return;
                                    }
                                    iBinderAsBinder.unlinkToDeath((IBinder.DeathRecipient) customTabsService.f1348a.get(iBinderAsBinder), 0);
                                    customTabsService.f1348a.remove(iBinderAsBinder);
                                } finally {
                                }
                            }
                        } catch (NoSuchElementException unused) {
                        }
                    }
                };
                synchronized (CustomTabsService.this.f1348a) {
                    iCustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f1348a.put(iCustomTabsCallback.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.c();
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean o5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            return CustomTabsService.this.g();
        }

        @Override // android.support.customtabs.ICustomTabsService
        public final boolean oa(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, ArrayList arrayList) {
            new CustomTabsSessionToken(iCustomTabsCallback, z0(bundle));
            return CustomTabsService.this.b();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    public abstract Bundle a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract int d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f1349b;
    }
}
