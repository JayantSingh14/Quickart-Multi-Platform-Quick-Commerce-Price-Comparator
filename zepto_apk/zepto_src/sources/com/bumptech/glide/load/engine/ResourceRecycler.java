package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
class ResourceRecycler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16036a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f16037b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    public static final class ResourceRecyclerCallback implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    public final synchronized void a(Resource resource, boolean z) {
        try {
            if (this.f16036a || z) {
                this.f16037b.obtainMessage(1, resource).sendToTarget();
            } else {
                this.f16036a = true;
                resource.recycle();
                this.f16036a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
