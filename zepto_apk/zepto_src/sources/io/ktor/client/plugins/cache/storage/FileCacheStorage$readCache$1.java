package io.ktor.client.plugins.cache.storage;

import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {202, WKSRecord.Service.NNTP, 122, 124}, m = "readCache")
/* loaded from: classes3.dex */
final class FileCacheStorage$readCache$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49782a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49783b;

    /* renamed from: c, reason: collision with root package name */
    public Object f49784c;

    /* renamed from: d, reason: collision with root package name */
    public ByteReadChannel f49785d;

    /* renamed from: e, reason: collision with root package name */
    public Set f49786e;

    /* renamed from: f, reason: collision with root package name */
    public Set f49787f;

    /* renamed from: g, reason: collision with root package name */
    public int f49788g;

    /* renamed from: h, reason: collision with root package name */
    public int f49789h;

    /* renamed from: i, reason: collision with root package name */
    public int f49790i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f49791j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ FileCacheStorage f49792k;

    /* renamed from: l, reason: collision with root package name */
    public int f49793l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$readCache$1(FileCacheStorage fileCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49792k = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49791j = obj;
        this.f49793l |= Integer.MIN_VALUE;
        return this.f49792k.f(this);
    }
}
