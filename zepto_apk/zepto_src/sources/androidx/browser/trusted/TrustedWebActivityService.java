package androidx.browser.trusted;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import android.util.Log;
import androidx.browser.trusted.PackageIdentityUtils;
import androidx.core.app.NotificationManagerCompat;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class TrustedWebActivityService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public NotificationManager f1363a;

    /* renamed from: b, reason: collision with root package name */
    public int f1364b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final ITrustedWebActivityService.Stub f1365c = new ITrustedWebActivityService.Stub() { // from class: androidx.browser.trusted.TrustedWebActivityService.1
        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final Bundle C4() {
            g();
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int iC = trustedWebActivityService.c();
            Bundle bundle = new Bundle();
            if (iC == -1) {
                return bundle;
            }
            bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(trustedWebActivityService.getResources(), iC));
            return bundle;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final int C9() {
            g();
            return TrustedWebActivityService.this.c();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final Bundle F9(Bundle bundle) {
            NotificationChannel notificationChannel;
            g();
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            String string = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.f1363a == null) {
                throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
            }
            boolean z = false;
            if (new NotificationManagerCompat(trustedWebActivityService).f2692b.areNotificationsEnabled() && (Build.VERSION.SDK_INT < 26 || (notificationChannel = trustedWebActivityService.f1363a.getNotificationChannel(TrustedWebActivityService.a(string))) == null || notificationChannel.getImportance() != 0)) {
                z = true;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z);
            return bundle2;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final void S6(IBinder iBinder) {
            g();
            if (iBinder == null) {
                return;
            }
            ITrustedWebActivityCallback.Stub.g(iBinder);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0078 A[PHI: r2
          0x0078: PHI (r2v3 android.app.Notification) = (r2v2 android.app.Notification), (r2v4 android.app.Notification), (r2v4 android.app.Notification) binds: [B:8:0x0042, B:15:0x0070, B:17:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.os.Bundle e5(android.os.Bundle r8) {
            /*
                r7 = this;
                r7.g()
                java.lang.String r0 = "android.support.customtabs.trusted.PLATFORM_TAG"
                androidx.browser.trusted.TrustedWebActivityServiceConnection.a(r8, r0)
                java.lang.String r1 = "android.support.customtabs.trusted.PLATFORM_ID"
                androidx.browser.trusted.TrustedWebActivityServiceConnection.a(r8, r1)
                java.lang.String r2 = "android.support.customtabs.trusted.NOTIFICATION"
                androidx.browser.trusted.TrustedWebActivityServiceConnection.a(r8, r2)
                java.lang.String r3 = "android.support.customtabs.trusted.CHANNEL_NAME"
                androidx.browser.trusted.TrustedWebActivityServiceConnection.a(r8, r3)
                java.lang.String r0 = r8.getString(r0)
                int r1 = r8.getInt(r1)
                android.os.Parcelable r2 = r8.getParcelable(r2)
                android.app.Notification r2 = (android.app.Notification) r2
                java.lang.String r8 = r8.getString(r3)
                androidx.browser.trusted.TrustedWebActivityService r3 = androidx.browser.trusted.TrustedWebActivityService.this
                android.app.NotificationManager r4 = r3.f1363a
                if (r4 == 0) goto L89
                androidx.core.app.NotificationManagerCompat r4 = new androidx.core.app.NotificationManagerCompat
                r4.<init>(r3)
                android.app.NotificationManager r4 = r4.f2692b
                boolean r4 = r4.areNotificationsEnabled()
                r5 = 0
                if (r4 != 0) goto L3e
                goto L7e
            L3e:
                int r4 = android.os.Build.VERSION.SDK_INT
                r6 = 26
                if (r4 < r6) goto L78
                java.lang.String r4 = androidx.browser.trusted.TrustedWebActivityService.a(r8)
                android.app.NotificationManager r6 = r3.f1363a
                android.app.NotificationChannel r8 = androidx.appcompat.app.c.e(r4, r8)
                androidx.appcompat.app.c.v(r6, r8)
                android.app.NotificationChannel r8 = androidx.appcompat.app.c.d(r6, r4)
                int r8 = androidx.appcompat.app.c.a(r8)
                if (r8 != 0) goto L5e
                r8 = 0
            L5c:
                r2 = r8
                goto L6a
            L5e:
                android.app.Notification$Builder r8 = android.app.Notification.Builder.recoverBuilder(r3, r2)
                androidx.appcompat.app.c.u(r8, r4)
                android.app.Notification r8 = r8.build()
                goto L5c
            L6a:
                android.app.NotificationManager r8 = r3.f1363a
                android.app.NotificationChannel r8 = androidx.appcompat.app.c.d(r8, r4)
                if (r8 == 0) goto L78
                int r8 = androidx.appcompat.app.c.a(r8)
                if (r8 == 0) goto L7e
            L78:
                android.app.NotificationManager r8 = r3.f1363a
                r8.notify(r0, r1, r2)
                r5 = 1
            L7e:
                android.os.Bundle r8 = new android.os.Bundle
                r8.<init>()
                java.lang.String r0 = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS"
                r8.putBoolean(r0, r5)
                return r8
            L89:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.browser.trusted.TrustedWebActivityService.AnonymousClass1.e5(android.os.Bundle):android.os.Bundle");
        }

        public final void g() {
            boolean zA;
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.f1364b == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token tokenA = trustedWebActivityService.b().a();
                PackageManager packageManager = trustedWebActivityService.getPackageManager();
                if (tokenA != null) {
                    int length = packagesForUid.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        try {
                            zA = (Build.VERSION.SDK_INT >= 28 ? new PackageIdentityUtils.Api28Implementation() : new PackageIdentityUtils.Pre28Implementation()).a(packageManager, packagesForUid[i2]);
                        } catch (PackageManager.NameNotFoundException | IOException e2) {
                            Log.e("PackageIdentity", "Could not check if package matches token.", e2);
                            zA = false;
                        }
                        if (zA) {
                            trustedWebActivityService.f1364b = Binder.getCallingUid();
                            break;
                        }
                        i2++;
                    }
                }
            }
            if (trustedWebActivityService.f1364b != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final void ma(Bundle bundle) {
            g();
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            String string = bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG");
            int i2 = bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID");
            NotificationManager notificationManager = TrustedWebActivityService.this.f1363a;
            if (notificationManager == null) {
                throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
            }
            notificationManager.cancel(string, i2);
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public final Bundle z7() {
            g();
            NotificationManager notificationManager = TrustedWebActivityService.this.f1363a;
            if (notificationManager == null) {
                throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
            }
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", activeNotifications);
            return bundle;
        }
    };

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public abstract TokenStore b();

    public final int c() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f1365c;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f1363a = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.f1364b = -1;
        return super.onUnbind(intent);
    }
}
