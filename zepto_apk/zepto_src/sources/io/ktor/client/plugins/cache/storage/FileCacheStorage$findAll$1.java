package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {77}, m = "findAll")
/* loaded from: classes3.dex */
final class FileCacheStorage$findAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileCacheStorage f49780b;

    /* renamed from: c, reason: collision with root package name */
    public int f49781c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$findAll$1(FileCacheStorage fileCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49780b = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49779a = obj;
        this.f49781c |= Integer.MIN_VALUE;
        return this.f49780b.a(null, this);
    }
}
