package in.juspay.hypersdk.lifecycle;

import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class HyperRequestPermissionDelegate implements RequestPermissionDelegate {

    @NotNull
    private final JuspayServices juspayServices;

    @NotNull
    private final Queue<RequestQueueData> requestQueue;

    @Metadata
    public static final class RequestQueueData {
        private final int requestCode;

        @NotNull
        private final String[] requests;

        public RequestQueueData(@NotNull String[] requests, int i2) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            this.requests = requests;
            this.requestCode = i2;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        @NotNull
        public final String[] getRequests() {
            return this.requests;
        }
    }

    public HyperRequestPermissionDelegate(@NotNull JuspayServices juspayServices) {
        Intrinsics.checkNotNullParameter(juspayServices, "juspayServices");
        this.juspayServices = juspayServices;
        this.requestQueue = new ConcurrentLinkedQueue();
    }

    public final void clearQueue() {
        this.requestQueue.clear();
    }

    public final void fragmentAttached() {
        for (RequestQueueData requestQueueData : this.requestQueue) {
            requestPermission(requestQueueData.getRequests(), requestQueueData.getRequestCode());
        }
    }

    @Override // in.juspay.hypersdk.ui.RequestPermissionDelegate
    public void requestPermission(@NotNull String[] permissions, int i2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        HyperFragment fragment = this.juspayServices.getFragment();
        if (fragment == null || !fragment.isAdded()) {
            this.requestQueue.add(new RequestQueueData(permissions, i2));
        } else {
            fragment.requestPermissions(permissions, i2);
        }
    }
}
