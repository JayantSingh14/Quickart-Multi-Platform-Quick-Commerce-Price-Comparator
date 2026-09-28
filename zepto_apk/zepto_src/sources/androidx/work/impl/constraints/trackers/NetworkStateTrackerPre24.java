package androidx.work.impl.constraints.trackers;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NetworkStateTrackerPre24 extends BroadcastReceiverConstraintTracker<NetworkState> {
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object a() {
        NetworkStateTrackerKt.a(null);
        throw null;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter e() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void f(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.b(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            Logger.e().a(NetworkStateTrackerKt.f12845a, "Network broadcast received");
            NetworkStateTrackerKt.a(null);
            throw null;
        }
    }
}
