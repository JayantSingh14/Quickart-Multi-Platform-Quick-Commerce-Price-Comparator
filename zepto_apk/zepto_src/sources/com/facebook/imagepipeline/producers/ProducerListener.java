package com.facebook.imagepipeline.producers;

import java.util.Map;

/* loaded from: classes.dex */
public interface ProducerListener {
    void b(String str, String str2);

    boolean d(String str);

    void e(String str, String str2, Map map);

    void f(String str, String str2, Throwable th, Map map);

    void g(String str, String str2);

    void h(String str, String str2, boolean z);

    void i(String str);
}
