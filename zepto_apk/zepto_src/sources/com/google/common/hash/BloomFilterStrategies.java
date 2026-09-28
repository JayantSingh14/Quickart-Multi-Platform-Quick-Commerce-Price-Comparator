package com.google.common.hash;

import com.google.common.hash.BloomFilter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class BloomFilterStrategies implements BloomFilter.Strategy {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BloomFilterStrategies[] f43201a = {new BloomFilterStrategies() { // from class: com.google.common.hash.BloomFilterStrategies.1
    }, new BloomFilterStrategies() { // from class: com.google.common.hash.BloomFilterStrategies.2
    }};

    /* JADX INFO: Fake field, exist only in values array */
    BloomFilterStrategies EF2;

    public static final class LockFreeBitArray {
        public final boolean equals(Object obj) {
            if (obj instanceof LockFreeBitArray) {
                throw null;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }
    }

    public static BloomFilterStrategies valueOf(String str) {
        return (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, str);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) f43201a.clone();
    }
}
