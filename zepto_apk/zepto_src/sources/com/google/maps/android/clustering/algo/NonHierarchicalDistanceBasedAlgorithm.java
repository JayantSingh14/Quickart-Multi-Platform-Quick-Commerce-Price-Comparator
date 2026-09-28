package com.google.maps.android.clustering.algo;

import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {

    public static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public final Point a() {
            return null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof QuadItem)) {
                return false;
            }
            ((QuadItem) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    public NonHierarchicalDistanceBasedAlgorithm() {
        new LinkedHashSet();
    }
}
