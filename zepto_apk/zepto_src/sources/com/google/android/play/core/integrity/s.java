package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes4.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ax f41845a;

    public s(Context context) {
        if (context == null) {
            throw new NullPointerException("instance cannot be null");
        }
        com.google.android.play.integrity.internal.az azVar = new com.google.android.play.integrity.internal.az(context);
        this.f41845a = com.google.android.play.integrity.internal.ax.b(new ab(com.google.android.play.integrity.internal.ax.b(new al(azVar, com.google.android.play.integrity.internal.ax.b(ac.f41766a), new au(azVar, l.f41839a)))));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f41845a.a();
    }
}
