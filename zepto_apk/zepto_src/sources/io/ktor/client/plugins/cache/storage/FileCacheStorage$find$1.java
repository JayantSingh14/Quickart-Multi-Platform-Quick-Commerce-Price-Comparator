package io.ktor.client.plugins.cache.storage;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {WKSRecord.Service.HOSTS2_NS}, m = "find")
/* loaded from: classes3.dex */
final class FileCacheStorage$find$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Map f49775a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49776b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileCacheStorage f49777c;

    /* renamed from: d, reason: collision with root package name */
    public int f49778d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$find$1(FileCacheStorage fileCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49777c = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49776b = obj;
        this.f49778d |= Integer.MIN_VALUE;
        return this.f49777c.c(null, null, this);
    }
}
