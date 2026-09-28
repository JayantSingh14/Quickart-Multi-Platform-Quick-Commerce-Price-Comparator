package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;

@Nullsafe
/* loaded from: classes3.dex */
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {

    public class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        @Override // com.facebook.datasource.DataSubscriber
        public final void a() {
            throw null;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void b(DataSource dataSource) {
            throw null;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void c(DataSource dataSource) {
            if (dataSource.b()) {
                synchronized (this) {
                }
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void d(DataSource dataSource) {
            throw null;
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final Object a() {
        synchronized (this) {
            c();
        }
        return null;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final synchronized boolean c() {
        if (!i()) {
            throw null;
        }
        return false;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final boolean close() {
        if (super.close()) {
            throw null;
        }
        return false;
    }
}
