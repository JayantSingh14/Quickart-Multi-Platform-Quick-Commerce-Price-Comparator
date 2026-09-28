package com.facebook.imagepipeline.memory;

import android.support.v4.media.b;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;

@Nullsafe
@ThreadSafe
/* loaded from: classes3.dex */
public class BucketMap<T> {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f18006a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public LinkedEntry f18007b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedEntry f18008c;

    @VisibleForTesting
    public static class LinkedEntry<I> {

        /* renamed from: a, reason: collision with root package name */
        public LinkedEntry f18009a;

        /* renamed from: b, reason: collision with root package name */
        public int f18010b;

        /* renamed from: c, reason: collision with root package name */
        public LinkedList f18011c;

        /* renamed from: d, reason: collision with root package name */
        public LinkedEntry f18012d;

        public final String toString() {
            return b.o(new StringBuilder("LinkedEntry(key: "), this.f18010b, ")");
        }
    }

    public final synchronized void a(LinkedEntry linkedEntry) {
        try {
            LinkedEntry linkedEntry2 = linkedEntry.f18009a;
            LinkedEntry linkedEntry3 = linkedEntry.f18012d;
            if (linkedEntry2 != null) {
                linkedEntry2.f18012d = linkedEntry3;
            }
            if (linkedEntry3 != null) {
                linkedEntry3.f18009a = linkedEntry2;
            }
            linkedEntry.f18009a = null;
            linkedEntry.f18012d = null;
            if (linkedEntry == this.f18007b) {
                this.f18007b = linkedEntry3;
            }
            if (linkedEntry == this.f18008c) {
                this.f18008c = linkedEntry2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
