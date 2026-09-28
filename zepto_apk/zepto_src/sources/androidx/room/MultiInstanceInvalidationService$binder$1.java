package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f11794b;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f11794b = multiInstanceInvalidationService;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public final void m6(int i2, String[] tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f11794b;
        synchronized (multiInstanceInvalidationService.f11792c) {
            String str = (String) multiInstanceInvalidationService.f11791b.get(Integer.valueOf(i2));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int iBeginBroadcast = multiInstanceInvalidationService.f11792c.beginBroadcast();
            for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f11792c.getBroadcastCookie(i3);
                    Intrinsics.d(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int iIntValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.f11791b.get(num);
                    if (i2 != iIntValue && str.equals(str2)) {
                        try {
                            multiInstanceInvalidationService.f11792c.getBroadcastItem(i3).q2(tables);
                        } catch (RemoteException e2) {
                            Log.w("ROOM", "Error invoking a remote callback", e2);
                        }
                    }
                } catch (Throwable th) {
                    multiInstanceInvalidationService.f11792c.finishBroadcast();
                    throw th;
                }
            }
            multiInstanceInvalidationService.f11792c.finishBroadcast();
            Unit unit = Unit.f53572a;
        }
    }
}
