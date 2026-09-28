package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {

    /* renamed from: a, reason: collision with root package name */
    public final Set f17187a = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        RetainingDataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.f17188h = null;
        if (!retainingDataSource.i()) {
            synchronized (retainingDataSource) {
                try {
                    if (!retainingDataSource.i()) {
                        DataSource dataSource = retainingDataSource.f17188h;
                        retainingDataSource.f17188h = null;
                        RetainingDataSource.o(dataSource);
                    }
                } finally {
                }
            }
        }
        this.f17187a.add(retainingDataSource);
        return retainingDataSource;
    }

    public static class RetainingDataSource<T> extends AbstractDataSource<T> {

        /* renamed from: h, reason: collision with root package name */
        public DataSource f17188h;

        public static void o(DataSource dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized Object a() {
            DataSource dataSource;
            dataSource = this.f17188h;
            return dataSource != null ? dataSource.a() : null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized boolean c() {
            /*
                r1 = this;
                monitor-enter(r1)
                com.facebook.datasource.DataSource r0 = r1.f17188h     // Catch: java.lang.Throwable -> Ld
                if (r0 == 0) goto Lf
                boolean r0 = r0.c()     // Catch: java.lang.Throwable -> Ld
                if (r0 == 0) goto Lf
                r0 = 1
                goto L10
            Ld:
                r0 = move-exception
                goto L12
            Lf:
                r0 = 0
            L10:
                monitor-exit(r1)
                return r0
            L12:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.c():boolean");
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final boolean close() {
            synchronized (this) {
                try {
                    if (!super.close()) {
                        return false;
                    }
                    DataSource dataSource = this.f17188h;
                    this.f17188h = null;
                    o(dataSource);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public class InternalDataSubscriber implements DataSubscriber<T> {
            @Override // com.facebook.datasource.DataSubscriber
            public final void b(DataSource dataSource) {
                throw null;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void c(DataSource dataSource) {
                dataSource.c();
                throw null;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void d(DataSource dataSource) {
                throw null;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void a() {
            }
        }
    }
}
