package com.google.firebase.sessions;

import com.google.firebase.sessions.InstallationId;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.InstallationId$Companion", f = "InstallationId.kt", l = {32, 40}, m = CLConstants.CRED_SUB_TYPE_MANDATE_CREATE)
/* loaded from: classes4.dex */
final class InstallationId$Companion$create$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f45016a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f45017b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InstallationId.Companion f45018c;

    /* renamed from: d, reason: collision with root package name */
    public int f45019d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallationId$Companion$create$1(InstallationId.Companion companion, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45018c = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45017b = obj;
        this.f45019d |= Integer.MIN_VALUE;
        return this.f45018c.a(null, this);
    }
}
