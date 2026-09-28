package com.google.maps.android.clustering.algo;

import com.google.maps.android.clustering.ClusterItem;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public abstract class AbstractAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public AbstractAlgorithm() {
        new ReentrantReadWriteLock();
    }
}
