package com.google.maps.android.clustering.algo;

import com.google.maps.android.clustering.ClusterItem;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class GridBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    public GridBasedAlgorithm() {
        Collections.synchronizedSet(new HashSet());
    }
}
