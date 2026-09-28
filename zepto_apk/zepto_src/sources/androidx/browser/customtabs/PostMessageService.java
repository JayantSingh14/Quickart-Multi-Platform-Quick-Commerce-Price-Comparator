package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

/* loaded from: classes3.dex */
public class PostMessageService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final IPostMessageService.Stub f1359a = new AnonymousClass1();

    /* renamed from: androidx.browser.customtabs.PostMessageService$1, reason: invalid class name */
    public class AnonymousClass1 extends IPostMessageService.Stub {
        @Override // android.support.customtabs.IPostMessageService
        public final void s3(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            iCustomTabsCallback.sb(bundle);
        }

        @Override // android.support.customtabs.IPostMessageService
        public final void t9(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            iCustomTabsCallback.X6(bundle, str);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f1359a;
    }
}
