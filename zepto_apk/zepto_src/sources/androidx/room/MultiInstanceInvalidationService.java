package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalRoomApi
@Metadata
/* loaded from: classes3.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f11790a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11791b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final MultiInstanceInvalidationService$callbackList$1 f11792c = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService$callbackList$1
        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IInterface iInterface, Object cookie) {
            IMultiInstanceInvalidationCallback callback = (IMultiInstanceInvalidationCallback) iInterface;
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.f11795a.f11791b.remove((Integer) cookie);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public final MultiInstanceInvalidationService$binder$1 f11793d = new MultiInstanceInvalidationService$binder$1(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.f11793d;
    }
}
