package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {47, 50, Type.TLSA, Type.TLSA}, m = "execute")
/* loaded from: classes.dex */
final class HttpStatement$execute$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f50081a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50082b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50083c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpStatement f50084d;

    /* renamed from: e, reason: collision with root package name */
    public int f50085e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$execute$1(HttpStatement httpStatement, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50084d = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50083c = obj;
        this.f50085e |= Integer.MIN_VALUE;
        return this.f50084d.c(null, this);
    }
}
