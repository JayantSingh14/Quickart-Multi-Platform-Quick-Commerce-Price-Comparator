package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableJob;

@Metadata
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {126}, m = "cleanup")
/* loaded from: classes.dex */
final class HttpStatement$cleanup$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CompletableJob f50077a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50078b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpStatement f50079c;

    /* renamed from: d, reason: collision with root package name */
    public int f50080d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$cleanup$1(HttpStatement httpStatement, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50079c = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50078b = obj;
        this.f50080d |= Integer.MIN_VALUE;
        return this.f50079c.a(null, this);
    }
}
