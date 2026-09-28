package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes4.dex */
final class w implements aw {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ax f41846a;

    public w(Context context) {
        if (context == null) {
            throw new NullPointerException("instance cannot be null");
        }
        com.google.android.play.integrity.internal.az azVar = new com.google.android.play.integrity.internal.az(context);
        com.google.android.play.integrity.internal.ax axVarB = com.google.android.play.integrity.internal.ax.b(new bp(azVar, com.google.android.play.integrity.internal.ax.b(bb.f41799a), new au(azVar, n.f41844a)));
        this.f41846a = com.google.android.play.integrity.internal.ax.b(new ba(axVarB, com.google.android.play.integrity.internal.ax.b(new bu(axVarB))));
    }

    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f41846a.a();
    }
}
