package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.AbstractExecutorService;

/* loaded from: classes3.dex */
public interface DataSource<T> {
    Object a();

    boolean b();

    boolean c();

    boolean close();

    Throwable d();

    float e();

    boolean f();

    void g(DataSubscriber dataSubscriber, AbstractExecutorService abstractExecutorService);

    Map getExtras();
}
