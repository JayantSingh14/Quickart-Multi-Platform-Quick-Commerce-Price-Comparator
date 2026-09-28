package com.facebook.datasource;

import android.util.Pair;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.facebook.datasource.RetainingDataSourceSupplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {

    /* renamed from: a, reason: collision with root package name */
    public Map f17155a;

    /* renamed from: d, reason: collision with root package name */
    public Object f17158d = null;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f17159e = null;

    /* renamed from: f, reason: collision with root package name */
    public float f17160f = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17157c = false;

    /* renamed from: b, reason: collision with root package name */
    public DataSourceStatus f17156b = DataSourceStatus.f17168a;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedQueue f17161g = new ConcurrentLinkedQueue();

    /* renamed from: com.facebook.datasource.AbstractDataSource$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17162a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataSubscriber f17163b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f17164c;

        public AnonymousClass1(boolean z, DataSubscriber dataSubscriber, boolean z2) {
            this.f17162a = z;
            this.f17163b = dataSubscriber;
            this.f17164c = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = this.f17162a;
            AbstractDataSource abstractDataSource = AbstractDataSource.this;
            DataSubscriber dataSubscriber = this.f17163b;
            if (z) {
                dataSubscriber.b(abstractDataSource);
            } else if (this.f17164c) {
                dataSubscriber.a();
            } else {
                dataSubscriber.c(abstractDataSource);
            }
        }
    }

    public interface DataSourceInstrumenter {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class DataSourceStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final DataSourceStatus f17168a;

        /* renamed from: b, reason: collision with root package name */
        public static final DataSourceStatus f17169b;

        /* renamed from: c, reason: collision with root package name */
        public static final DataSourceStatus f17170c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ DataSourceStatus[] f17171d;

        static {
            DataSourceStatus dataSourceStatus = new DataSourceStatus("IN_PROGRESS", 0);
            f17168a = dataSourceStatus;
            DataSourceStatus dataSourceStatus2 = new DataSourceStatus(MerchantConstants.SUCCESS, 1);
            f17169b = dataSourceStatus2;
            DataSourceStatus dataSourceStatus3 = new DataSourceStatus("FAILURE", 2);
            f17170c = dataSourceStatus3;
            f17171d = new DataSourceStatus[]{dataSourceStatus, dataSourceStatus2, dataSourceStatus3};
        }

        public static DataSourceStatus valueOf(String str) {
            return (DataSourceStatus) Enum.valueOf(DataSourceStatus.class, str);
        }

        public static DataSourceStatus[] values() {
            return (DataSourceStatus[]) f17171d.clone();
        }
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Object a() {
        return this.f17158d;
    }

    @Override // com.facebook.datasource.DataSource
    public final synchronized boolean b() {
        return this.f17156b != DataSourceStatus.f17168a;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean c() {
        return this.f17158d != null;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            try {
                if (this.f17157c) {
                    return false;
                }
                this.f17157c = true;
                Object obj = this.f17158d;
                this.f17158d = null;
                if (obj != null) {
                    h(obj);
                }
                if (!b()) {
                    j();
                }
                synchronized (this) {
                    this.f17161g.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.datasource.DataSource
    public final synchronized Throwable d() {
        return this.f17159e;
    }

    @Override // com.facebook.datasource.DataSource
    public final synchronized float e() {
        return this.f17160f;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean f() {
        return this instanceof RetainingDataSourceSupplier.RetainingDataSource;
    }

    @Override // com.facebook.datasource.DataSource
    public final void g(DataSubscriber dataSubscriber, AbstractExecutorService abstractExecutorService) {
        boolean z;
        abstractExecutorService.getClass();
        synchronized (this) {
            try {
                if (this.f17157c) {
                    return;
                }
                if (this.f17156b == DataSourceStatus.f17168a) {
                    this.f17161g.add(Pair.create(dataSubscriber, abstractExecutorService));
                }
                boolean z2 = c() || b() || n();
                if (z2) {
                    synchronized (this) {
                        z = this.f17156b == DataSourceStatus.f17170c;
                    }
                    abstractExecutorService.execute(new AnonymousClass1(z, dataSubscriber, n()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.datasource.DataSource
    public final Map getExtras() {
        return this.f17155a;
    }

    public void h(Object obj) {
    }

    public final synchronized boolean i() {
        return this.f17157c;
    }

    public final void j() {
        boolean z;
        synchronized (this) {
            z = this.f17156b == DataSourceStatus.f17170c;
        }
        boolean zN = n();
        Iterator it = this.f17161g.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((Executor) pair.second).execute(new AnonymousClass1(z, (DataSubscriber) pair.first, zN));
        }
    }

    public final boolean k(Throwable th, Map map) {
        boolean z;
        synchronized (this) {
            if (this.f17157c || this.f17156b != DataSourceStatus.f17168a) {
                z = false;
            } else {
                this.f17156b = DataSourceStatus.f17170c;
                this.f17159e = th;
                this.f17155a = map;
                z = true;
            }
        }
        if (z) {
            j();
        }
        return z;
    }

    public final boolean l(float f2) {
        boolean z;
        synchronized (this) {
            z = false;
            if (!this.f17157c && this.f17156b == DataSourceStatus.f17168a && f2 >= this.f17160f) {
                this.f17160f = f2;
                z = true;
            }
        }
        if (z) {
            Iterator it = this.f17161g.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final DataSubscriber dataSubscriber = (DataSubscriber) pair.first;
                ((Executor) pair.second).execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        dataSubscriber.d(AbstractDataSource.this);
                    }
                });
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002c A[DONT_GENERATE, PHI: r3 r4
      0x002c: PHI (r3v7 java.lang.Object) = (r3v0 java.lang.Object), (r3v10 java.lang.Object) binds: [B:28:0x0036, B:22:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x002c: PHI (r4v4 boolean) = (r4v2 boolean), (r4v6 boolean) binds: [B:28:0x0036, B:22:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x001b -> B:33:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(java.lang.Object r3, boolean r4, java.util.Map r5) {
        /*
            r2 = this;
            r2.f17155a = r5
            r5 = 0
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r2.f17157c     // Catch: java.lang.Throwable -> L1a
            if (r0 != 0) goto L34
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r0 = r2.f17156b     // Catch: java.lang.Throwable -> L1a
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r1 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.f17168a     // Catch: java.lang.Throwable -> L1a
            if (r0 == r1) goto Lf
            goto L34
        Lf:
            if (r4 == 0) goto L1c
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r4 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.f17169b     // Catch: java.lang.Throwable -> L1a
            r2.f17156b = r4     // Catch: java.lang.Throwable -> L1a
            r4 = 1065353216(0x3f800000, float:1.0)
            r2.f17160f = r4     // Catch: java.lang.Throwable -> L1a
            goto L1c
        L1a:
            r3 = move-exception
            goto L3f
        L1c:
            java.lang.Object r4 = r2.f17158d     // Catch: java.lang.Throwable -> L1a
            if (r4 == r3) goto L27
            r2.f17158d = r3     // Catch: java.lang.Throwable -> L24
            r3 = r4
            goto L28
        L24:
            r3 = move-exception
            r5 = r4
            goto L3f
        L27:
            r3 = r5
        L28:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L30
            r4 = 1
            if (r3 == 0) goto L39
        L2c:
            r2.h(r3)
            goto L39
        L30:
            r4 = move-exception
            r5 = r3
            r3 = r4
            goto L3f
        L34:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L30
            r4 = 0
            if (r3 == 0) goto L39
            goto L2c
        L39:
            if (r4 == 0) goto L3e
            r2.j()
        L3e:
            return r4
        L3f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r3     // Catch: java.lang.Throwable -> L41
        L41:
            r3 = move-exception
            if (r5 == 0) goto L47
            r2.h(r5)
        L47:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.m(java.lang.Object, boolean, java.util.Map):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean n() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.i()     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L11
            boolean r0 = r1.b()     // Catch: java.lang.Throwable -> Lf
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        Lf:
            r0 = move-exception
            goto L14
        L11:
            r0 = 0
        L12:
            monitor-exit(r1)
            return r0
        L14:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.n():boolean");
    }
}
