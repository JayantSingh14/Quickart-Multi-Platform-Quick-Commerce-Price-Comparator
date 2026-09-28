package com.facebook.react.bridge;

import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

@DoNotStrip
/* loaded from: classes.dex */
public class ReactMarker {
    private static Queue<ReactMarkerRecord> sNativeReactMarkerQueue = new ConcurrentLinkedQueue();
    private static final List<MarkerListener> sListeners = new CopyOnWriteArrayList();
    private static final List<FabricMarkerListener> sFabricMarkerListeners = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface FabricMarkerListener {
        void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2, long j2);

        default void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2, long j2, int i3) {
            logFabricMarker(reactMarkerConstants, str, i2, j2);
        }
    }

    /* loaded from: classes3.dex */
    public interface MarkerListener {
        void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2);
    }

    public static class ReactMarkerRecord {
        private final String mMarkerName;
        private final long mMarkerTime;

        public ReactMarkerRecord(String str, long j2) {
            this.mMarkerName = str;
            this.mMarkerTime = j2;
        }

        public String getMarkerName() {
            return this.mMarkerName;
        }

        public long getMarkerTime() {
            return this.mMarkerTime;
        }
    }

    @DoNotStrip
    public static void addFabricListener(FabricMarkerListener fabricMarkerListener) {
        List<FabricMarkerListener> list = sFabricMarkerListeners;
        if (list.contains(fabricMarkerListener)) {
            return;
        }
        list.add(fabricMarkerListener);
    }

    @DoNotStrip
    public static void addListener(MarkerListener markerListener) {
        List<MarkerListener> list = sListeners;
        if (list.contains(markerListener)) {
            return;
        }
        list.add(markerListener);
    }

    @DoNotStrip
    public static void clearFabricMarkerListeners() {
        sFabricMarkerListeners.clear();
    }

    @DoNotStrip
    public static void clearMarkerListeners() {
        sListeners.clear();
    }

    @DoNotStrip
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2, long j2, int i3) {
        Iterator<FabricMarkerListener> it = sFabricMarkerListeners.iterator();
        while (it.hasNext()) {
            it.next().logFabricMarker(reactMarkerConstants, str, i2, j2, i3);
        }
    }

    @DoNotStrip
    public static void logMarker(String str) {
        logMarker(str, (String) null);
    }

    @DoNotStrip
    private static native void nativeLogMarker(String str, long j2);

    @DoNotStrip
    private static void notifyNativeMarker(ReactMarkerConstants reactMarkerConstants, @Nullable Long l2) {
        if (!reactMarkerConstants.hasMatchingNameMarker()) {
            return;
        }
        if (l2 == null) {
            l2 = Long.valueOf(SystemClock.uptimeMillis());
        }
        if (!ReactBridge.isInitialized()) {
            sNativeReactMarkerQueue.add(new ReactMarkerRecord(reactMarkerConstants.name(), l2.longValue()));
            return;
        }
        nativeLogMarker(reactMarkerConstants.name(), l2.longValue());
        while (true) {
            ReactMarkerRecord reactMarkerRecordPoll = sNativeReactMarkerQueue.poll();
            if (reactMarkerRecordPoll == null) {
                return;
            } else {
                nativeLogMarker(reactMarkerRecordPoll.getMarkerName(), reactMarkerRecordPoll.getMarkerTime());
            }
        }
    }

    @DoNotStrip
    public static void removeFabricListener(FabricMarkerListener fabricMarkerListener) {
        sFabricMarkerListeners.remove(fabricMarkerListener);
    }

    @DoNotStrip
    public static void removeListener(MarkerListener markerListener) {
        sListeners.remove(markerListener);
    }

    @DoNotStrip
    public static void logMarker(String str, int i2) {
        logMarker(str, (String) null, i2);
    }

    @DoNotStrip
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2, long j2) {
        Iterator<FabricMarkerListener> it = sFabricMarkerListeners.iterator();
        while (it.hasNext()) {
            it.next().logFabricMarker(reactMarkerConstants, str, i2, j2, 0);
        }
    }

    @DoNotStrip
    public static void logMarker(String str, @Nullable String str2) {
        logMarker(str, str2, 0);
    }

    @DoNotStrip
    public static void logMarker(String str, @Nullable String str2, int i2) {
        logMarker(ReactMarkerConstants.valueOf(str), str2, i2);
    }

    @DoNotStrip
    public static void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2) {
        logFabricMarker(reactMarkerConstants, str, i2, SystemClock.uptimeMillis(), 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants) {
        logMarker(reactMarkerConstants, (String) null, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, int i2) {
        logMarker(reactMarkerConstants, (String) null, i2);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str) {
        logMarker(reactMarkerConstants, str, 0);
    }

    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, long j2) {
        logMarker(reactMarkerConstants, null, 0, Long.valueOf(j2));
    }

    @AnyThread
    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2) {
        logMarker(reactMarkerConstants, str, i2, null);
    }

    @AnyThread
    @DoNotStrip
    public static void logMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i2, @Nullable Long l2) {
        logFabricMarker(reactMarkerConstants, str, i2);
        Iterator<MarkerListener> it = sListeners.iterator();
        while (it.hasNext()) {
            it.next().logMarker(reactMarkerConstants, str, i2);
        }
        notifyNativeMarker(reactMarkerConstants, l2);
    }
}
