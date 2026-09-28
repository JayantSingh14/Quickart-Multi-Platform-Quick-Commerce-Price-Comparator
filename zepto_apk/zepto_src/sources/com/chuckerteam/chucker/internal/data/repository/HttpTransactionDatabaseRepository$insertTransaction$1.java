package com.chuckerteam.chucker.internal.data.repository;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository", f = "HttpTransactionDatabaseRepository.kt", l = {42}, m = "insertTransaction")
/* loaded from: classes3.dex */
final class HttpTransactionDatabaseRepository$insertTransaction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpTransaction f16718a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16719b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpTransactionDatabaseRepository f16720c;

    /* renamed from: d, reason: collision with root package name */
    public int f16721d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTransactionDatabaseRepository$insertTransaction$1(HttpTransactionDatabaseRepository httpTransactionDatabaseRepository, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f16720c = httpTransactionDatabaseRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16719b = obj;
        this.f16721d |= Integer.MIN_VALUE;
        return this.f16720c.d(null, this);
    }
}
