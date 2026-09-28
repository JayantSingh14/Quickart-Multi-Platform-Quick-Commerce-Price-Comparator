package com.facebook.datasource;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
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
        try {
            ((Boolean) dataSource.a()).getClass();
            f();
        } finally {
            dataSource.close();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public final void d(DataSource dataSource) {
    }

    public abstract void e(DataSource dataSource);

    public abstract void f();

    @Override // com.facebook.datasource.DataSubscriber
    public final void a() {
    }
}
