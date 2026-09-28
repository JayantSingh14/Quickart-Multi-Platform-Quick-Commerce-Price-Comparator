package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes3.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void c(Exception exc);

        void f(Object obj);
    }

    Class a();

    void b();

    void cancel();

    DataSource d();

    void e(Priority priority, DataCallback dataCallback);
}
