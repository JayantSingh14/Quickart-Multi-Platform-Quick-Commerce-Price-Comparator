package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* loaded from: classes3.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public Context f1351a;

    /* renamed from: androidx.browser.customtabs.CustomTabsServiceConnection$1, reason: invalid class name */
    class AnonymousClass1 extends CustomTabsClient {
    }

    public abstract void a(CustomTabsClient customTabsClient);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f1351a == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        a(new AnonymousClass1(ICustomTabsService.Stub.g(iBinder), componentName));
    }
}
