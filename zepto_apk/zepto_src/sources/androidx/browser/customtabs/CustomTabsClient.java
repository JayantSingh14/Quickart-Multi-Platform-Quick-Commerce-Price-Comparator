package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomTabsClient {

    /* renamed from: a, reason: collision with root package name */
    public final ICustomTabsService f1304a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f1305b;

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$1, reason: invalid class name */
    class AnonymousClass1 extends CustomTabsServiceConnection {
        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public final void a(CustomTabsClient customTabsClient) {
            try {
                customTabsClient.f1304a.U8(0L);
            } catch (RemoteException unused) {
            }
            throw null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.f1304a = iCustomTabsService;
        this.f1305b = componentName;
    }

    public static String a(Context context, List list) {
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList() : list;
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 0);
        if (resolveInfoResolveActivity != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent.setPackage(str2);
            if (packageManager.resolveService(intent, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    public final CustomTabsSession b(final CustomTabsCallback customTabsCallback) {
        ICustomTabsCallback.Stub stub = new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.CustomTabsClient.2

            /* renamed from: a, reason: collision with root package name */
            public final Handler f1306a = new Handler(Looper.getMainLooper());

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void B9(final int i2, final int i3, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.d(i2, i3, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void C6(final Bundle bundle, final String str) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.a(bundle, str);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void Ca(final int i2, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.g(i2, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void X6(final Bundle bundle, final String str) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.h(bundle, str);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void a9(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.f(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final Bundle f6(Bundle bundle, String str) {
                CustomTabsCallback customTabsCallback2 = customTabsCallback;
                if (customTabsCallback2 == null) {
                    return null;
                }
                return customTabsCallback2.b(bundle, str);
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void j5(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.k(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void l2(final int i2, final int i3, final int i4, final int i5, final int i6, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.c(i2, i3, i4, i5, i6, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void p9(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.j(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void sb(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.e(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public final void yb(final int i2, final Uri uri, final boolean z, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f1306a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        customTabsCallback.i(i2, uri, z, bundle);
                    }
                });
            }
        };
        ICustomTabsService iCustomTabsService = this.f1304a;
        try {
            if (iCustomTabsService.Z9(stub)) {
                return new CustomTabsSession(iCustomTabsService, stub, this.f1305b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
