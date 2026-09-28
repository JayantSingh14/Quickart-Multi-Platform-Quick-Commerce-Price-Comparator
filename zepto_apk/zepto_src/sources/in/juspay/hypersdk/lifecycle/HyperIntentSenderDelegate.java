package in.juspay.hypersdk.lifecycle;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v4.media.a;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class HyperIntentSenderDelegate implements IntentSenderDelegate {

    @NotNull
    private final Queue<IntentQueueData> intentSenderQueue;

    @NotNull
    private final JuspayServices juspayServices;

    @Metadata
    public static final class IntentQueueData {
        private final int extraFlags;

        @Nullable
        private final Intent fillInIntent;
        private final int flagMask;
        private final int flagValues;

        @NotNull
        private final IntentSender intentSender;

        @Nullable
        private final Bundle options;
        private final int requestCode;

        public IntentQueueData(@NotNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
            this.intentSender = intentSender;
            this.requestCode = i2;
            this.fillInIntent = intent;
            this.flagMask = i3;
            this.flagValues = i4;
            this.extraFlags = i5;
            this.options = bundle;
        }

        public static /* synthetic */ IntentQueueData copy$default(IntentQueueData intentQueueData, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                intentSender = intentQueueData.intentSender;
            }
            if ((i6 & 2) != 0) {
                i2 = intentQueueData.requestCode;
            }
            if ((i6 & 4) != 0) {
                intent = intentQueueData.fillInIntent;
            }
            if ((i6 & 8) != 0) {
                i3 = intentQueueData.flagMask;
            }
            if ((i6 & 16) != 0) {
                i4 = intentQueueData.flagValues;
            }
            if ((i6 & 32) != 0) {
                i5 = intentQueueData.extraFlags;
            }
            if ((i6 & 64) != 0) {
                bundle = intentQueueData.options;
            }
            int i7 = i5;
            Bundle bundle2 = bundle;
            int i8 = i4;
            Intent intent2 = intent;
            return intentQueueData.copy(intentSender, i2, intent2, i3, i8, i7, bundle2);
        }

        @NotNull
        public final IntentSender component1() {
            return this.intentSender;
        }

        public final int component2() {
            return this.requestCode;
        }

        @Nullable
        public final Intent component3() {
            return this.fillInIntent;
        }

        public final int component4() {
            return this.flagMask;
        }

        public final int component5() {
            return this.flagValues;
        }

        public final int component6() {
            return this.extraFlags;
        }

        @Nullable
        public final Bundle component7() {
            return this.options;
        }

        @NotNull
        public final IntentQueueData copy(@NotNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
            return new IntentQueueData(intentSender, i2, intent, i3, i4, i5, bundle);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntentQueueData)) {
                return false;
            }
            IntentQueueData intentQueueData = (IntentQueueData) obj;
            return Intrinsics.b(this.intentSender, intentQueueData.intentSender) && this.requestCode == intentQueueData.requestCode && Intrinsics.b(this.fillInIntent, intentQueueData.fillInIntent) && this.flagMask == intentQueueData.flagMask && this.flagValues == intentQueueData.flagValues && this.extraFlags == intentQueueData.extraFlags && Intrinsics.b(this.options, intentQueueData.options);
        }

        public final int getExtraFlags() {
            return this.extraFlags;
        }

        @Nullable
        public final Intent getFillInIntent() {
            return this.fillInIntent;
        }

        public final int getFlagMask() {
            return this.flagMask;
        }

        public final int getFlagValues() {
            return this.flagValues;
        }

        @NotNull
        public final IntentSender getIntentSender() {
            return this.intentSender;
        }

        @Nullable
        public final Bundle getOptions() {
            return this.options;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public int hashCode() {
            int iB = a.b(this.requestCode, this.intentSender.hashCode() * 31, 31);
            Intent intent = this.fillInIntent;
            int iB2 = a.b(this.extraFlags, a.b(this.flagValues, a.b(this.flagMask, (iB + (intent == null ? 0 : intent.hashCode())) * 31, 31), 31), 31);
            Bundle bundle = this.options;
            return iB2 + (bundle != null ? bundle.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "IntentQueueData(intentSender=" + this.intentSender + ", requestCode=" + this.requestCode + ", fillInIntent=" + this.fillInIntent + ", flagMask=" + this.flagMask + ", flagValues=" + this.flagValues + ", extraFlags=" + this.extraFlags + ", options=" + this.options + ')';
        }
    }

    public HyperIntentSenderDelegate(@NotNull JuspayServices juspayServices) {
        Intrinsics.checkNotNullParameter(juspayServices, "juspayServices");
        this.juspayServices = juspayServices;
        this.intentSenderQueue = new ConcurrentLinkedQueue();
    }

    public final void clearQueue() {
        this.intentSenderQueue.clear();
    }

    public final void fragmentAttached() {
        for (IntentQueueData intentQueueData : this.intentSenderQueue) {
            startIntentSenderForResult(intentQueueData.getIntentSender(), intentQueueData.getRequestCode(), intentQueueData.getFillInIntent(), intentQueueData.getFlagMask(), intentQueueData.getFlagValues(), intentQueueData.getExtraFlags(), intentQueueData.getOptions());
        }
    }

    @Override // in.juspay.hypersdk.ui.IntentSenderDelegate
    public void startIntentSenderForResult(@NotNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        try {
            HyperFragment fragment = this.juspayServices.getFragment();
            if (fragment == null || !fragment.isAdded()) {
                this.intentSenderQueue.add(new IntentQueueData(intentSender, i2, intent, i3, i4, i5, bundle));
            } else {
                fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
            }
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackException("lifecycle", LogSubCategory.LifeCycle.ANDROID, Labels.Android.START_INTENT_SENDER_FOR_RESULT, "Exception in startIntentSenderForResult", e2);
        }
    }
}
