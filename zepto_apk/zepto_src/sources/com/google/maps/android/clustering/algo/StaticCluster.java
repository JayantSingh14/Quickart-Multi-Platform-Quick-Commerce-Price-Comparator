package com.google.maps.android.clustering.algo;

import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;

/* loaded from: classes4.dex */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof StaticCluster)) {
            return false;
        }
        ((StaticCluster) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StaticCluster{mCenter=");
        sb.append((Object) null);
        sb.append(", mItems.size=");
        throw null;
    }
}
