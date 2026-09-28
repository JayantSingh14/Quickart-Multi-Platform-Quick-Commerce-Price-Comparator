package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class GapWorker implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f11473e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static final Comparator f11474f = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11475a;

    /* renamed from: b, reason: collision with root package name */
    public long f11476b;

    /* renamed from: c, reason: collision with root package name */
    public long f11477c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f11478d;

    /* renamed from: androidx.recyclerview.widget.GapWorker$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Task> {
        @Override // java.util.Comparator
        public final int compare(Task task, Task task2) {
            Task task3 = task;
            Task task4 = task2;
            RecyclerView recyclerView = task3.f11486d;
            if ((recyclerView == null) == (task4.f11486d == null)) {
                boolean z = task3.f11483a;
                if (z == task4.f11483a) {
                    int i2 = task4.f11484b - task3.f11484b;
                    if (i2 != 0) {
                        return i2;
                    }
                    int i3 = task3.f11485c - task4.f11485c;
                    if (i3 != 0) {
                        return i3;
                    }
                    return 0;
                }
                if (z) {
                    return -1;
                }
            } else if (recyclerView != null) {
                return -1;
            }
            return 1;
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a, reason: collision with root package name */
        public int f11479a;

        /* renamed from: b, reason: collision with root package name */
        public int f11480b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f11481c;

        /* renamed from: d, reason: collision with root package name */
        public int f11482d;

        public final void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i4 = this.f11482d;
            int i5 = i4 * 2;
            int[] iArr = this.f11481c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f11481c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i5 >= iArr.length) {
                int[] iArr3 = new int[i4 * 4];
                this.f11481c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f11481c;
            iArr4[i5] = i2;
            iArr4[i5 + 1] = i3;
            this.f11482d++;
        }

        public final void b(RecyclerView recyclerView, boolean z) {
            this.f11482d = 0;
            int[] iArr = this.f11481c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.n;
            if (recyclerView.f11556m == null || layoutManager == null || !layoutManager.f11585i) {
                return;
            }
            if (z) {
                if (!recyclerView.f11548e.g()) {
                    layoutManager.i(recyclerView.f11556m.d(), this);
                }
            } else if (!recyclerView.Q()) {
                layoutManager.h(this.f11479a, this.f11480b, recyclerView.R0, this);
            }
            int i2 = this.f11482d;
            if (i2 > layoutManager.f11586j) {
                layoutManager.f11586j = i2;
                layoutManager.f11587k = z;
                recyclerView.f11546c.m();
            }
        }
    }

    public static class Task {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11483a;

        /* renamed from: b, reason: collision with root package name */
        public int f11484b;

        /* renamed from: c, reason: collision with root package name */
        public int f11485c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f11486d;

        /* renamed from: e, reason: collision with root package name */
        public int f11487e;
    }

    public static RecyclerView.ViewHolder c(RecyclerView recyclerView, int i2, long j2) {
        int childCount = RecyclerView.this.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.ViewHolder viewHolderN = RecyclerView.N(RecyclerView.this.getChildAt(i3));
            if (viewHolderN.f11655c == i2 && !viewHolderN.f()) {
                return null;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.f11546c;
        try {
            recyclerView.W();
            RecyclerView.ViewHolder viewHolderK = recycler.k(i2, j2);
            if (viewHolderK != null) {
                if (!viewHolderK.e() || viewHolderK.f()) {
                    recycler.a(viewHolderK, false);
                } else {
                    recycler.h(viewHolderK.f11653a);
                }
            }
            recyclerView.X(false);
            return viewHolderK;
        } catch (Throwable th) {
            recyclerView.X(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.t) {
            if (RecyclerView.l1 && !this.f11475a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f11476b == 0) {
                this.f11476b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.Q0;
        layoutPrefetchRegistryImpl.f11479a = i2;
        layoutPrefetchRegistryImpl.f11480b = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r17) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GapWorker.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i2 = TraceCompat.f2887a;
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.f11475a;
            if (arrayList.isEmpty()) {
                this.f11476b = 0L;
                Trace.endSection();
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i3);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.f11476b = 0L;
                Trace.endSection();
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f11477c);
                this.f11476b = 0L;
                Trace.endSection();
            }
        } catch (Throwable th) {
            this.f11476b = 0L;
            int i4 = TraceCompat.f2887a;
            Trace.endSection();
            throw th;
        }
    }
}
