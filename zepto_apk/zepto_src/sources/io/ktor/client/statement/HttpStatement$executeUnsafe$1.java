package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {Type.EUI48}, m = "executeUnsafe")
/* loaded from: classes.dex */
final class HttpStatement$executeUnsafe$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpStatement f50089b;

    /* renamed from: c, reason: collision with root package name */
    public int f50090c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$executeUnsafe$1(HttpStatement httpStatement, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50089b = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50088a = obj;
        this.f50090c |= Integer.MIN_VALUE;
        return this.f50089b.d(this);
    }
}
