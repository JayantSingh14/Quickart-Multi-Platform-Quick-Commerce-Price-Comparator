package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@Metadata
/* loaded from: classes.dex */
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f12842f;

    /* renamed from: g, reason: collision with root package name */
    public final NetworkStateTracker24$networkCallback$1 f12843g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context context, WorkManagerTaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Object systemService = this.f12837b.getSystemService("connectivity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f12842f = (ConnectivityManager) systemService;
        this.f12843g = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                Logger.e().a(NetworkStateTrackerKt.f12845a, "Network capabilities changed: " + capabilities);
                NetworkStateTracker24 networkStateTracker24 = this.f12844a;
                networkStateTracker24.b(NetworkStateTrackerKt.a(networkStateTracker24.f12842f));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                Logger.e().a(NetworkStateTrackerKt.f12845a, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = this.f12844a;
                networkStateTracker24.b(NetworkStateTrackerKt.a(networkStateTracker24.f12842f));
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object a() {
        return NetworkStateTrackerKt.a(this.f12842f);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void c() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f12845a, "Registering network callback");
            NetworkApi24.a(this.f12842f, this.f12843g);
        } catch (IllegalArgumentException e2) {
            Logger.e().d(NetworkStateTrackerKt.f12845a, "Received exception while registering network callback", e2);
        } catch (SecurityException e3) {
            Logger.e().d(NetworkStateTrackerKt.f12845a, "Received exception while registering network callback", e3);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void d() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f12845a, "Unregistering network callback");
            NetworkApi21.c(this.f12842f, this.f12843g);
        } catch (IllegalArgumentException e2) {
            Logger.e().d(NetworkStateTrackerKt.f12845a, "Received exception while unregistering network callback", e2);
        } catch (SecurityException e3) {
            Logger.e().d(NetworkStateTrackerKt.f12845a, "Received exception while unregistering network callback", e3);
        }
    }
}
