package in.juspay.hypersdk.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.a;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class HyperActivityLaunchDelegate implements ActivityLaunchDelegate {

    @NotNull
    private final JuspayServices juspayServices;

    @NotNull
    private final Queue<IntentQueueData> startActivityQueue;

    @Metadata
    public static final class IntentQueueData {

        @Nullable
        private final Bundle bundle;

        @NotNull
        private final Intent intent;
        private final int requestCode;

        public IntentQueueData(@NotNull Intent intent, int i2, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.intent = intent;
            this.requestCode = i2;
            this.bundle = bundle;
        }

        public static /* synthetic */ IntentQueueData copy$default(IntentQueueData intentQueueData, Intent intent, int i2, Bundle bundle, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                intent = intentQueueData.intent;
            }
            if ((i3 & 2) != 0) {
                i2 = intentQueueData.requestCode;
            }
            if ((i3 & 4) != 0) {
                bundle = intentQueueData.bundle;
            }
            return intentQueueData.copy(intent, i2, bundle);
        }

        @NotNull
        public final Intent component1() {
            return this.intent;
        }

        public final int component2() {
            return this.requestCode;
        }

        @Nullable
        public final Bundle component3() {
            return this.bundle;
        }

        @NotNull
        public final IntentQueueData copy(@NotNull Intent intent, int i2, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return new IntentQueueData(intent, i2, bundle);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntentQueueData)) {
                return false;
            }
            IntentQueueData intentQueueData = (IntentQueueData) obj;
            return Intrinsics.b(this.intent, intentQueueData.intent) && this.requestCode == intentQueueData.requestCode && Intrinsics.b(this.bundle, intentQueueData.bundle);
        }

        @Nullable
        public final Bundle getBundle() {
            return this.bundle;
        }

        @NotNull
        public final Intent getIntent() {
            return this.intent;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public int hashCode() {
            int iB = a.b(this.requestCode, this.intent.hashCode() * 31, 31);
            Bundle bundle = this.bundle;
            return iB + (bundle == null ? 0 : bundle.hashCode());
        }

        @NotNull
        public String toString() {
            return "IntentQueueData(intent=" + this.intent + ", requestCode=" + this.requestCode + ", bundle=" + this.bundle + ')';
        }
    }

    public HyperActivityLaunchDelegate(@NotNull JuspayServices juspayServices) {
        Intrinsics.checkNotNullParameter(juspayServices, "juspayServices");
        this.juspayServices = juspayServices;
        this.startActivityQueue = new ConcurrentLinkedQueue();
    }

    public final void clearQueue() {
        this.startActivityQueue.clear();
    }

    public final void fragmentAttached() {
        for (IntentQueueData intentQueueData : this.startActivityQueue) {
            startActivityForResult(intentQueueData.getIntent(), intentQueueData.getRequestCode(), intentQueueData.getBundle());
        }
    }

    @Override // in.juspay.hypersdk.ui.ActivityLaunchDelegate
    public void startActivityForResult(@NotNull Intent intent, int i2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        HyperFragment fragment = this.juspayServices.getFragment();
        if (fragment == null || !fragment.isAdded()) {
            this.startActivityQueue.add(new IntentQueueData(intent, i2, bundle));
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
        }
    }
}
