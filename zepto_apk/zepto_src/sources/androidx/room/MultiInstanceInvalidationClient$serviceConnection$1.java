package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        IInterface iInterfaceQueryLocalInterface;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        int i2 = IMultiInstanceInvalidationService.Stub.f11758a;
        if (service != null && (iInterfaceQueryLocalInterface = service.queryLocalInterface(IMultiInstanceInvalidationService.i0)) != null && (iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationService)) {
        }
        throw null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        throw null;
    }
}
