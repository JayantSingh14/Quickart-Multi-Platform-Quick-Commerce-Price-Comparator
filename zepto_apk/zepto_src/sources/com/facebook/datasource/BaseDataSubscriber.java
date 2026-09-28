package com.facebook.datasource;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    @Override // com.facebook.datasource.DataSubscriber
    public final void b(DataSource dataSource) {
        try {
            e(dataSource);
        } finally {
            dataSource.close();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public final void c(DataSource dataSource) {
        boolean zB = dataSource.b();
        try {
            f(dataSource);
        } finally {
            if (zB) {
                dataSource.close();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void d(DataSource dataSource) {
    }

    public abstract void e(DataSource dataSource);

    public abstract void f(DataSource dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public final void a() {
    }
}
