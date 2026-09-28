package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class SignedBytes {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LexicographicalComparator implements Comparator<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f43327a = {new LexicographicalComparator("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LexicographicalComparator EF5;

        public static LexicographicalComparator valueOf(String str) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f43327a.clone();
        }

        @Override // java.util.Comparator
        public final int compare(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            int iMin = Math.min(bArr3.length, bArr4.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                int i3 = bArr3[i2] - bArr4[i2];
                if (i3 != 0) {
                    return i3;
                }
            }
            return bArr3.length - bArr4.length;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }
}
