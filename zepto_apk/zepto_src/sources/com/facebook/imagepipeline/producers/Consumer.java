package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Nullsafe
/* loaded from: classes3.dex */
public interface Consumer<T> {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    void a();

    void b(int i2, Object obj);

    void c(float f2);

    void onFailure(Throwable th);
}
