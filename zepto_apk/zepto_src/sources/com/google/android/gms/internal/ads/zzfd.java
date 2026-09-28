package com.google.android.gms.internal.ads;

import android.os.Message;

/* loaded from: classes4.dex */
final class zzfd implements zzdw {

    /* renamed from: a, reason: collision with root package name */
    public Message f30868a;

    public final void a() {
        Message message = this.f30868a;
        message.getClass();
        message.sendToTarget();
        this.f30868a = null;
        zzfe.h(this);
    }
}
