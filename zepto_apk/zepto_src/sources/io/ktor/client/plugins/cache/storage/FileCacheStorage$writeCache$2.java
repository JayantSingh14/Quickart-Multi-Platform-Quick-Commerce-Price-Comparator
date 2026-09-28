package io.ktor.client.plugins.cache.storage;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2", f = "FileCacheStorage.kt", l = {202, 102}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FileCacheStorage$writeCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49812a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileCacheStorage f49813b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f49814c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f49815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCache$2(FileCacheStorage fileCacheStorage, String str, ArrayList arrayList, Continuation continuation) {
        super(2, continuation);
        this.f49813b = fileCacheStorage;
        this.f49814c = str;
        this.f49815d = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileCacheStorage$writeCache$2 fileCacheStorage$writeCache$2 = new FileCacheStorage$writeCache$2(this.f49813b, this.f49814c, this.f49815d, continuation);
        fileCacheStorage$writeCache$2.f49812a = obj;
        return fileCacheStorage$writeCache$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileCacheStorage$writeCache$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        this.f49813b.getClass();
        throw null;
    }
}
