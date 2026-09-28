package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.IPostMessageService;

/* loaded from: classes3.dex */
public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public IPostMessageService f1360a;

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1360a = IPostMessageService.Stub.g(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f1360a = null;
    }
}
