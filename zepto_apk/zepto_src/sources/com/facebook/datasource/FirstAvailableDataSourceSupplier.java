package com.facebook.datasource;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return false;
        }
        ((FirstAvailableDataSourceSupplier) obj).getClass();
        return Objects.a(null, null);
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        return new FirstAvailableDataSource();
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.c(null, "list");
        return toStringHelperB.toString();
    }

    @ThreadSafe
    public class FirstAvailableDataSource extends AbstractDataSource<T> {

        /* renamed from: h, reason: collision with root package name */
        public int f17173h = 0;

        /* renamed from: i, reason: collision with root package name */
        public DataSource f17174i = null;

        /* renamed from: j, reason: collision with root package name */
        public DataSource f17175j = null;

        public FirstAvailableDataSource() {
            if (p()) {
                return;
            }
            k(new RuntimeException("No data source supplier or supplier returned null."), null);
        }

        public static void o(FirstAvailableDataSource firstAvailableDataSource, DataSource dataSource) {
            DataSource dataSource2;
            synchronized (firstAvailableDataSource) {
                if (!firstAvailableDataSource.i() && dataSource == firstAvailableDataSource.f17174i) {
                    firstAvailableDataSource.f17174i = null;
                    synchronized (firstAvailableDataSource) {
                        dataSource2 = firstAvailableDataSource.f17175j;
                    }
                    if (dataSource != dataSource2 && dataSource != null) {
                        dataSource.close();
                    }
                    if (firstAvailableDataSource.p()) {
                        return;
                    }
                    firstAvailableDataSource.k(dataSource.d(), dataSource.getExtras());
                }
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized Object a() {
            DataSource dataSource;
            synchronized (this) {
                dataSource = this.f17175j;
            }
            return dataSource != null ? dataSource.a() : null;
            return dataSource != null ? dataSource.a() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized boolean c() {
            DataSource dataSource;
            synchronized (this) {
                dataSource = this.f17175j;
            }
            return dataSource != null && dataSource.c();
            return dataSource != null && dataSource.c();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final boolean close() {
            synchronized (this) {
                try {
                    if (!super.close()) {
                        return false;
                    }
                    DataSource dataSource = this.f17174i;
                    this.f17174i = null;
                    DataSource dataSource2 = this.f17175j;
                    this.f17175j = null;
                    if (dataSource2 != null) {
                        dataSource2.close();
                    }
                    if (dataSource == null) {
                        return true;
                    }
                    dataSource.close();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean p() {
            synchronized (this) {
                if (!i()) {
                    throw null;
                }
            }
            synchronized (this) {
                if (i()) {
                    return false;
                }
                this.f17174i = null;
                return false;
            }
        }

        public class InternalDataSubscriber implements DataSubscriber<T> {
            public InternalDataSubscriber() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void b(DataSource dataSource) {
                FirstAvailableDataSource.o(FirstAvailableDataSource.this, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void c(DataSource dataSource) {
                DataSource dataSource2;
                DataSource dataSource3;
                if (!dataSource.c()) {
                    if (dataSource.b()) {
                        FirstAvailableDataSource.o(FirstAvailableDataSource.this, dataSource);
                        return;
                    }
                    return;
                }
                FirstAvailableDataSource firstAvailableDataSource = FirstAvailableDataSource.this;
                firstAvailableDataSource.getClass();
                boolean zB = dataSource.b();
                synchronized (firstAvailableDataSource) {
                    if (dataSource == firstAvailableDataSource.f17174i && dataSource != (dataSource3 = firstAvailableDataSource.f17175j)) {
                        if (dataSource3 == null || zB) {
                            firstAvailableDataSource.f17175j = dataSource;
                        } else {
                            dataSource3 = null;
                        }
                        if (dataSource3 != null) {
                            dataSource3.close();
                        }
                    }
                }
                synchronized (firstAvailableDataSource) {
                    dataSource2 = firstAvailableDataSource.f17175j;
                }
                if (dataSource == dataSource2) {
                    firstAvailableDataSource.m(null, dataSource.b(), dataSource.getExtras());
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void d(DataSource dataSource) {
                FirstAvailableDataSource firstAvailableDataSource = FirstAvailableDataSource.this;
                firstAvailableDataSource.l(Math.max(firstAvailableDataSource.e(), dataSource.e()));
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void a() {
            }
        }
    }
}
