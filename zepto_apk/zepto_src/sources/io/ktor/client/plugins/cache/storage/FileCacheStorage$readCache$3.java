package io.ktor.client.plugins.cache.storage;

import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {159, 160, 160, 161, 162, 165, 166, 169, 170, 171, 172, 175, 176, 180, 182}, m = "readCache")
/* loaded from: classes3.dex */
final class FileCacheStorage$readCache$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49794a;

    /* renamed from: b, reason: collision with root package name */
    public Comparable f49795b;

    /* renamed from: c, reason: collision with root package name */
    public Object f49796c;

    /* renamed from: d, reason: collision with root package name */
    public Object f49797d;

    /* renamed from: e, reason: collision with root package name */
    public Object f49798e;

    /* renamed from: f, reason: collision with root package name */
    public Comparable f49799f;

    /* renamed from: g, reason: collision with root package name */
    public GMTDate f49800g;

    /* renamed from: h, reason: collision with root package name */
    public Object f49801h;

    /* renamed from: i, reason: collision with root package name */
    public Object f49802i;

    /* renamed from: j, reason: collision with root package name */
    public Map f49803j;

    /* renamed from: k, reason: collision with root package name */
    public String f49804k;

    /* renamed from: l, reason: collision with root package name */
    public int f49805l;

    /* renamed from: m, reason: collision with root package name */
    public int f49806m;
    public /* synthetic */ Object n;
    public final /* synthetic */ FileCacheStorage o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$readCache$3(FileCacheStorage fileCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.o = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= Integer.MIN_VALUE;
        return this.o.e(null, this);
    }
}
