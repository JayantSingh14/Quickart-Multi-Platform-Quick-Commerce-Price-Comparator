package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class be extends com.google.android.play.integrity.internal.t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f41800b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bn f41801c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f41800b = context;
        this.f41801c = bnVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        this.f41801c.f41819c.d(Integer.valueOf(com.google.android.play.integrity.internal.ai.a(this.f41800b)));
    }
}
