package io.ktor.client.plugins.cache;

import io.ktor.http.HeaderValue;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata
/* loaded from: classes3.dex */
public final class CacheControl {

    /* renamed from: a, reason: collision with root package name */
    public static final HeaderValue f49682a;

    /* renamed from: b, reason: collision with root package name */
    public static final HeaderValue f49683b;

    /* renamed from: c, reason: collision with root package name */
    public static final HeaderValue f49684c;

    /* renamed from: d, reason: collision with root package name */
    public static final HeaderValue f49685d;

    /* renamed from: e, reason: collision with root package name */
    public static final HeaderValue f49686e;

    static {
        EmptyList emptyList = EmptyList.f53609a;
        f49682a = new HeaderValue("no-store", emptyList);
        f49683b = new HeaderValue("no-cache", emptyList);
        f49684c = new HeaderValue("private", emptyList);
        f49685d = new HeaderValue("only-if-cached", emptyList);
        f49686e = new HeaderValue("must-revalidate", emptyList);
    }
}
