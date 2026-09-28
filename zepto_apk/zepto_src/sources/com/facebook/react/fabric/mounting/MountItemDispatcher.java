package com.facebook.react.fabric.mounting;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.constraintlayout.helper.widget.a;
import androidx.tracing.Trace;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class MountItemDispatcher {
    private static final long FRAME_TIME_NS = 16666666;
    private static final String TAG = "MountItemDispatcher";
    private final ItemDispatchListener mItemDispatchListener;
    private final MountingManager mMountingManager;

    @NonNull
    private final ConcurrentLinkedQueue<DispatchCommandMountItem> mViewCommandMountItems = new ConcurrentLinkedQueue<>();

    @NonNull
    private final ConcurrentLinkedQueue<MountItem> mMountItems = new ConcurrentLinkedQueue<>();

    @NonNull
    private final ConcurrentLinkedQueue<MountItem> mPreMountItems = new ConcurrentLinkedQueue<>();
    private boolean mInDispatch = false;
    private long mBatchedExecutionTime = 0;
    private long mRunStartTime = 0;
    private long mLastFrameTimeNanos = 0;
    private boolean mIsPremountScheduled = false;
    private final Runnable mPremountRunnable = new a(this, 13);

    public interface ItemDispatchListener {
        void didDispatchMountItems();

        void didMountItems(@Nullable List<MountItem> list);

        void willMountItems(@Nullable List<MountItem> list);
    }

    public MountItemDispatcher(MountingManager mountingManager, ItemDispatchListener itemDispatchListener) {
        this.mMountingManager = mountingManager;
        this.mItemDispatchListener = itemDispatchListener;
    }

    /* JADX WARN: Finally extract failed */
    private void dispatchPreMountItemsImpl(long j2) {
        MountItem mountItemPoll;
        Intrinsics.checkNotNullParameter("MountItemDispatcher::premountViews", "sectionName");
        Trace.b("MountItemDispatcher::premountViews");
        this.mInDispatch = true;
        while (System.nanoTime() <= j2 && (mountItemPoll = this.mPreMountItems.poll()) != null) {
            try {
                if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
                    printMountItem(mountItemPoll, "dispatchPreMountItems");
                }
                executeOrEnqueue(mountItemPoll);
            } catch (Throwable th) {
                this.mInDispatch = false;
                throw th;
            }
        }
        this.mInDispatch = false;
        android.os.Trace.endSection();
    }

    @Nullable
    private static <E> List<E> drainConcurrentItemQueue(ConcurrentLinkedQueue<E> concurrentLinkedQueue) {
        if (concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        do {
            E ePoll = concurrentLinkedQueue.poll();
            if (ePoll != null) {
                arrayList.add(ePoll);
            }
        } while (!concurrentLinkedQueue.isEmpty());
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    private void executeOrEnqueue(MountItem mountItem) {
        if (!this.mMountingManager.isWaitingForViewAttach(mountItem.getSurfaceId())) {
            mountItem.execute(this.mMountingManager);
            return;
        }
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.i(TAG, "executeOrEnqueue: Item execution delayed, surface %s is not ready yet", Integer.valueOf(mountItem.getSurfaceId()));
        }
        this.mMountingManager.getSurfaceManager(mountItem.getSurfaceId()).scheduleMountItemOnViewAttach(mountItem);
    }

    @Nullable
    @ThreadConfined
    @UiThread
    private List<MountItem> getAndResetMountItems() {
        return drainConcurrentItemQueue(this.mMountItems);
    }

    @Nullable
    @ThreadConfined
    @UiThread
    private List<MountItem> getAndResetPreMountItems() {
        return drainConcurrentItemQueue(this.mPreMountItems);
    }

    @Nullable
    @ThreadConfined
    @UiThread
    private List<DispatchCommandMountItem> getAndResetViewCommandMountItems() {
        return drainConcurrentItemQueue(this.mViewCommandMountItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mIsPremountScheduled = false;
        if (this.mPreMountItems.isEmpty()) {
            return;
        }
        dispatchPreMountItemsImpl(this.mLastFrameTimeNanos + 8333333);
    }

    private static void printMountItem(MountItem mountItem, String str) {
        for (String str2 : mountItem.toString().split(StringUtils.LF)) {
            FLog.g(TAG, str + ": " + str2);
        }
    }

    public void addMountItem(MountItem mountItem) {
        this.mMountItems.add(mountItem);
    }

    public void addPreAllocateMountItem(MountItem mountItem) {
        if (!this.mMountingManager.surfaceIsStopped(mountItem.getSurfaceId())) {
            this.mPreMountItems.add(mountItem);
        } else if (FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT) {
            FLog.i(TAG, "Not queueing PreAllocateMountItem: surfaceId stopped: [%d] - %s", Integer.valueOf(mountItem.getSurfaceId()), mountItem.toString());
        }
    }

    public void addViewCommandMountItem(DispatchCommandMountItem dispatchCommandMountItem) {
        this.mViewCommandMountItems.add(dispatchCommandMountItem);
    }

    @ThreadConfined
    @UiThread
    public void dispatchMountItems(Queue<MountItem> queue) {
        while (!queue.isEmpty()) {
            MountItem mountItemPoll = queue.poll();
            try {
                mountItemPoll.execute(this.mMountingManager);
            } catch (RetryableMountingLayerException e2) {
                if (mountItemPoll instanceof DispatchCommandMountItem) {
                    DispatchCommandMountItem dispatchCommandMountItem = (DispatchCommandMountItem) mountItemPoll;
                    if (dispatchCommandMountItem.getRetries() == 0) {
                        dispatchCommandMountItem.incrementRetries();
                        addViewCommandMountItem(dispatchCommandMountItem);
                    }
                } else {
                    printMountItem(mountItemPoll, "dispatchExternalMountItems: mounting failed with " + e2.getMessage());
                }
            }
        }
    }

    @ThreadConfined
    @UiThread
    public void dispatchPreMountItems(long j2) {
        this.mLastFrameTimeNanos = j2;
        if (this.mPreMountItems.isEmpty()) {
            return;
        }
        if (!ReactNativeFeatureFlags.f18968a.enablePreciseSchedulingForPremountItemsOnAndroid()) {
            dispatchPreMountItemsImpl(this.mLastFrameTimeNanos + 8333333);
        } else {
            if (this.mIsPremountScheduled) {
                return;
            }
            this.mIsPremountScheduled = true;
            UiThreadUtil.getUiThreadHandler().post(this.mPremountRunnable);
        }
    }

    public long getBatchedExecutionTime() {
        return this.mBatchedExecutionTime;
    }

    public long getRunStartTime() {
        return this.mRunStartTime;
    }

    @ThreadConfined
    @UiThread
    public void tryDispatchMountItems() {
        if (this.mInDispatch) {
            return;
        }
        this.mInDispatch = true;
        try {
            dispatchMountItems();
            this.mInDispatch = false;
            this.mItemDispatchListener.didDispatchMountItems();
        } catch (Throwable th) {
            this.mInDispatch = false;
            throw th;
        }
    }

    @ThreadConfined
    @UiThread
    private void dispatchMountItems() {
        boolean zIsIgnorable;
        this.mBatchedExecutionTime = 0L;
        this.mRunStartTime = SystemClock.uptimeMillis();
        List<DispatchCommandMountItem> andResetViewCommandMountItems = getAndResetViewCommandMountItems();
        List<MountItem> andResetMountItems = getAndResetMountItems();
        if (andResetMountItems == null && andResetViewCommandMountItems == null) {
            return;
        }
        this.mItemDispatchListener.willMountItems(andResetMountItems);
        if (andResetViewCommandMountItems != null) {
            Intrinsics.checkNotNullParameter("MountItemDispatcher::mountViews viewCommandMountItems", "sectionName");
            android.os.Trace.beginSection(Trace.g("MountItemDispatcher::mountViews viewCommandMountItems"));
            for (DispatchCommandMountItem dispatchCommandMountItem : andResetViewCommandMountItems) {
                if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
                    printMountItem(dispatchCommandMountItem, "dispatchMountItems: Executing viewCommandMountItem");
                }
                try {
                    executeOrEnqueue(dispatchCommandMountItem);
                } catch (RetryableMountingLayerException e2) {
                    if (dispatchCommandMountItem.getRetries() == 0) {
                        dispatchCommandMountItem.incrementRetries();
                        addViewCommandMountItem(dispatchCommandMountItem);
                    } else {
                        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Caught exception executing ViewCommand: " + dispatchCommandMountItem.toString(), e2));
                    }
                } catch (Throwable th) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("Caught exception executing ViewCommand: " + dispatchCommandMountItem.toString(), th));
                }
            }
            android.os.Trace.endSection();
        }
        List<MountItem> andResetPreMountItems = getAndResetPreMountItems();
        if (andResetPreMountItems != null) {
            Intrinsics.checkNotNullParameter("MountItemDispatcher::mountViews preMountItems", "sectionName");
            android.os.Trace.beginSection(Trace.g("MountItemDispatcher::mountViews preMountItems"));
            for (MountItem mountItem : andResetPreMountItems) {
                if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
                    printMountItem(mountItem, "dispatchMountItems: Executing preMountItem");
                }
                executeOrEnqueue(mountItem);
            }
            android.os.Trace.endSection();
        }
        if (andResetMountItems != null) {
            Intrinsics.checkNotNullParameter("MountItemDispatcher::mountViews mountItems to execute", "sectionName");
            android.os.Trace.beginSection(Trace.g("MountItemDispatcher::mountViews mountItems to execute"));
            long jUptimeMillis = SystemClock.uptimeMillis();
            Iterator<MountItem> it = andResetMountItems.iterator();
            while (it.hasNext()) {
                MountItem next = it.next();
                if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
                    printMountItem(next, "dispatchMountItems: Executing mountItem");
                }
                try {
                    executeOrEnqueue(next);
                } finally {
                    if (zIsIgnorable) {
                    }
                }
            }
            this.mBatchedExecutionTime = (SystemClock.uptimeMillis() - jUptimeMillis) + this.mBatchedExecutionTime;
            android.os.Trace.endSection();
        }
        this.mItemDispatchListener.didMountItems(andResetMountItems);
    }
}
