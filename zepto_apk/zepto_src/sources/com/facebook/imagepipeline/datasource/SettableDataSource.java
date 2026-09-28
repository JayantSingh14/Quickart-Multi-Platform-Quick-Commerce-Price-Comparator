package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;

@ThreadSafe
@Metadata
/* loaded from: classes3.dex */
public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final Object a() {
        return CloseableReference.c((CloseableReference) super.a());
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public final void h(Object obj) {
        CloseableReference.e((CloseableReference) obj);
    }
}
