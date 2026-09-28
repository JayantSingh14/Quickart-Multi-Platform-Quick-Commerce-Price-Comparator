package com.zeptoconsumerapp.apiprefetch.base;

import coil3.decode.b;
import com.zeptoconsumerapp.apiprefetch.base.Options;
import com.zeptoconsumerapp.apiprefetch.homepage.HomePageOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public abstract class ApiPrefetch<T extends Options> {

    /* renamed from: a, reason: collision with root package name */
    public final HomePageOptions f47580a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f47581b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f47582c;

    public ApiPrefetch(HomePageOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.f47580a = options;
        this.f47581b = LazyKt.b(new b(14));
        this.f47582c = LazyKt.b(new b(15));
    }
}
