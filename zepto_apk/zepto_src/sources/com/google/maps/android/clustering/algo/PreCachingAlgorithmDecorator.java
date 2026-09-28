package com.google.maps.android.clustering.algo;

import com.google.maps.android.clustering.ClusterItem;

/* loaded from: classes4.dex */
public class PreCachingAlgorithmDecorator<T extends ClusterItem> extends AbstractAlgorithm<T> {

    public class PrecacheRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() throws InterruptedException {
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException unused) {
            }
            throw null;
        }
    }
}
