package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {

    /* renamed from: com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements EntryEvictionComparator {
        @Override // java.util.Comparator
        public final int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            long timestamp = entry.getTimestamp();
            long timestamp2 = entry2.getTimestamp();
            if (timestamp < timestamp2) {
                return -1;
            }
            return timestamp2 == timestamp ? 0 : 1;
        }
    }
}
