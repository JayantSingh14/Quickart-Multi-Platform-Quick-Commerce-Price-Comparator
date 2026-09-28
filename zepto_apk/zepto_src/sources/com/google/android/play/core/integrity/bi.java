package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
class bi extends com.google.android.play.integrity.internal.j {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f41810a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bn f41811b;

    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        this.f41811b = bnVar;
        this.f41810a = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.k
    public final void M(Bundle bundle) {
        this.f41811b.f41821e.d(this.f41810a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public void P9(Bundle bundle) {
        this.f41811b.f41821e.d(this.f41810a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public final void d() {
        this.f41811b.f41821e.d(this.f41810a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public void s0(Bundle bundle) {
        this.f41811b.f41821e.d(this.f41810a);
    }
}
