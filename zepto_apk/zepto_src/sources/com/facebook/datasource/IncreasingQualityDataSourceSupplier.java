package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17178a;

    public IncreasingQualityDataSourceSupplier(ArrayList arrayList) {
        Preconditions.b(!arrayList.isEmpty(), "List of suppliers is empty!");
        this.f17178a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IncreasingQualityDataSourceSupplier) {
            return Objects.a(this.f17178a, ((IncreasingQualityDataSourceSupplier) obj).f17178a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        return new IncreasingQualityDataSource();
    }

    public final int hashCode() {
        return this.f17178a.hashCode();
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.c(this.f17178a, "list");
        return toStringHelperB.toString();
    }

    @ThreadSafe
    public class IncreasingQualityDataSource extends AbstractDataSource<T> {

        /* renamed from: h, reason: collision with root package name */
        public ArrayList f17179h;

        /* renamed from: i, reason: collision with root package name */
        public int f17180i;

        /* renamed from: j, reason: collision with root package name */
        public int f17181j;

        /* renamed from: k, reason: collision with root package name */
        public AtomicInteger f17182k;

        /* renamed from: l, reason: collision with root package name */
        public Throwable f17183l;

        /* renamed from: m, reason: collision with root package name */
        public Map f17184m;

        public IncreasingQualityDataSource() {
            IncreasingQualityDataSourceSupplier.this.getClass();
            if (this.f17182k != null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f17182k == null) {
                        this.f17182k = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.f17178a.size();
                        this.f17181j = size;
                        this.f17180i = size;
                        this.f17179h = new ArrayList(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            DataSource dataSource = (DataSource) ((Supplier) IncreasingQualityDataSourceSupplier.this.f17178a.get(i2)).get();
                            this.f17179h.add(dataSource);
                            dataSource.g(new InternalDataSubscriber(i2), CallerThreadExecutor.f17069a);
                            if (!dataSource.c()) {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public static void o(IncreasingQualityDataSource increasingQualityDataSource, int i2, DataSource dataSource) {
            DataSource dataSourceP;
            Throwable th;
            synchronized (increasingQualityDataSource) {
                dataSourceP = dataSource == increasingQualityDataSource.r() ? null : dataSource == increasingQualityDataSource.q(i2) ? increasingQualityDataSource.p(i2) : dataSource;
            }
            if (dataSourceP != null) {
                dataSourceP.close();
            }
            if (i2 == 0) {
                increasingQualityDataSource.f17183l = dataSource.d();
                increasingQualityDataSource.f17184m = dataSource.getExtras();
            }
            if (increasingQualityDataSource.f17182k.incrementAndGet() != increasingQualityDataSource.f17181j || (th = increasingQualityDataSource.f17183l) == null) {
                return;
            }
            increasingQualityDataSource.k(th, increasingQualityDataSource.f17184m);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized Object a() {
            DataSource dataSourceR;
            IncreasingQualityDataSourceSupplier.this.getClass();
            dataSourceR = r();
            return dataSourceR != null ? dataSourceR.a() : null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized boolean c() {
            /*
                r1 = this;
                monitor-enter(r1)
                com.facebook.datasource.IncreasingQualityDataSourceSupplier r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.this     // Catch: java.lang.Throwable -> L14
                r0.getClass()     // Catch: java.lang.Throwable -> L14
                com.facebook.datasource.DataSource r0 = r1.r()     // Catch: java.lang.Throwable -> L14
                if (r0 == 0) goto L16
                boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L14
                if (r0 == 0) goto L16
                r0 = 1
                goto L17
            L14:
                r0 = move-exception
                goto L19
            L16:
                r0 = 0
            L17:
                monitor-exit(r1)
                return r0
            L19:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L14
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.c():boolean");
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final boolean close() {
            IncreasingQualityDataSourceSupplier.this.getClass();
            synchronized (this) {
                try {
                    if (!super.close()) {
                        return false;
                    }
                    ArrayList arrayList = this.f17179h;
                    this.f17179h = null;
                    if (arrayList == null) {
                        return true;
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        DataSource dataSource = (DataSource) arrayList.get(i2);
                        if (dataSource != null) {
                            dataSource.close();
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final synchronized DataSource p(int i2) {
            DataSource dataSource;
            ArrayList arrayList = this.f17179h;
            dataSource = null;
            if (arrayList != null && i2 < arrayList.size()) {
                dataSource = (DataSource) this.f17179h.set(i2, null);
            }
            return dataSource;
        }

        public final synchronized DataSource q(int i2) {
            ArrayList arrayList;
            arrayList = this.f17179h;
            return (arrayList == null || i2 >= arrayList.size()) ? null : (DataSource) this.f17179h.get(i2);
        }

        public final synchronized DataSource r() {
            return q(this.f17180i);
        }

        public class InternalDataSubscriber implements DataSubscriber<T> {

            /* renamed from: a, reason: collision with root package name */
            public final int f17185a;

            public InternalDataSubscriber(int i2) {
                this.f17185a = i2;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void b(DataSource dataSource) {
                IncreasingQualityDataSource.o(IncreasingQualityDataSource.this, this.f17185a, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void c(DataSource dataSource) {
                Throwable th;
                int i2;
                if (!dataSource.c()) {
                    if (dataSource.b()) {
                        IncreasingQualityDataSource.o(IncreasingQualityDataSource.this, this.f17185a, dataSource);
                        return;
                    }
                    return;
                }
                IncreasingQualityDataSource increasingQualityDataSource = IncreasingQualityDataSource.this;
                int i3 = this.f17185a;
                boolean zB = dataSource.b();
                synchronized (increasingQualityDataSource) {
                    try {
                        int i4 = increasingQualityDataSource.f17180i;
                        if (dataSource == increasingQualityDataSource.q(i3) && i3 != increasingQualityDataSource.f17180i) {
                            if (increasingQualityDataSource.r() == null || (zB && i3 < increasingQualityDataSource.f17180i)) {
                                increasingQualityDataSource.f17180i = i3;
                                i2 = i3;
                            } else {
                                i2 = i4;
                            }
                            while (i4 > i2) {
                                DataSource dataSourceP = increasingQualityDataSource.p(i4);
                                if (dataSourceP != null) {
                                    dataSourceP.close();
                                }
                                i4--;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (dataSource == increasingQualityDataSource.r()) {
                    increasingQualityDataSource.m(null, i3 == 0 && dataSource.b(), dataSource.getExtras());
                }
                if (increasingQualityDataSource.f17182k.incrementAndGet() != increasingQualityDataSource.f17181j || (th = increasingQualityDataSource.f17183l) == null) {
                    return;
                }
                increasingQualityDataSource.k(th, increasingQualityDataSource.f17184m);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void d(DataSource dataSource) {
                if (this.f17185a == 0) {
                    IncreasingQualityDataSource.this.l(dataSource.e());
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void a() {
            }
        }
    }
}
