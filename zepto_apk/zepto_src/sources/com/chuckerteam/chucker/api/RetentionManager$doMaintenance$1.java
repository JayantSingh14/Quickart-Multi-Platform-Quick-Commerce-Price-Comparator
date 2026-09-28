package com.chuckerteam.chucker.api;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.api.RetentionManager", f = "RetentionManager.kt", l = {116, 55}, m = "doMaintenance$com_github_ChuckerTeam_Chucker_library")
/* loaded from: classes3.dex */
final class RetentionManager$doMaintenance$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public RetentionManager f16640a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f16641b;

    /* renamed from: c, reason: collision with root package name */
    public long f16642c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f16643d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RetentionManager f16644e;

    /* renamed from: f, reason: collision with root package name */
    public int f16645f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetentionManager$doMaintenance$1(RetentionManager retentionManager, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f16644e = retentionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16643d = obj;
        this.f16645f |= Integer.MIN_VALUE;
        return this.f16644e.a(this);
    }
}
