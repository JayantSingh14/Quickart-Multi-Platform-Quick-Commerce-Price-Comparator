package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class DataSources {

    /* renamed from: com.facebook.datasource.DataSources$2, reason: invalid class name */
    class AnonymousClass2 implements DataSubscriber<Object> {
        @Override // com.facebook.datasource.DataSubscriber
        public final void a() {
            throw null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
        
            throw null;
         */
        @Override // com.facebook.datasource.DataSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(com.facebook.datasource.DataSource r2) {
            /*
                r1 = this;
                r0 = 0
                r2.d()     // Catch: java.lang.Throwable -> L5
                throw r0     // Catch: java.lang.Throwable -> L5
            L5:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.DataSources.AnonymousClass2.b(com.facebook.datasource.DataSource):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            throw null;
         */
        @Override // com.facebook.datasource.DataSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(com.facebook.datasource.DataSource r2) {
            /*
                r1 = this;
                boolean r0 = r2.b()
                if (r0 != 0) goto L7
                return
            L7:
                r0 = 0
                r2.a()     // Catch: java.lang.Throwable -> Lc
                throw r0     // Catch: java.lang.Throwable -> Lc
            Lc:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.DataSources.AnonymousClass2.c(com.facebook.datasource.DataSource):void");
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void d(DataSource dataSource) {
        }
    }

    /* renamed from: com.facebook.datasource.DataSources$3, reason: invalid class name */
    class AnonymousClass3 implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static class ValueHolder<T> {
    }

    public static Supplier a(final NullPointerException nullPointerException) {
        return new Supplier<DataSource<Object>>() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            public final Object get() {
                return DataSources.b(nullPointerException);
            }
        };
    }

    public static SimpleDataSource b(Exception exc) {
        SimpleDataSource simpleDataSource = new SimpleDataSource();
        exc.getClass();
        simpleDataSource.k(exc, null);
        return simpleDataSource;
    }
}
