package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzts extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zztu f35602a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzts(zztu zztuVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zztuVar);
        this.f35602a = zztuVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws MediaCodec.CryptoException {
        zztu zztuVar = this.f35602a;
        zztuVar.getClass();
        int i2 = message.what;
        zztt zzttVar = null;
        if (i2 == 1) {
            zztt zzttVar2 = (zztt) message.obj;
            try {
                zztuVar.f35610a.queueInputBuffer(zzttVar2.f35603a, 0, zzttVar2.f35604b, zzttVar2.f35606d, zzttVar2.f35607e);
            } catch (RuntimeException e2) {
                AtomicReference atomicReference = zztuVar.f35613d;
                while (!atomicReference.compareAndSet(null, e2) && atomicReference.get() == null) {
                }
            }
            zzttVar = zzttVar2;
        } else if (i2 == 2) {
            zztt zzttVar3 = (zztt) message.obj;
            int i3 = zzttVar3.f35603a;
            MediaCodec.CryptoInfo cryptoInfo = zzttVar3.f35605c;
            long j2 = zzttVar3.f35606d;
            int i4 = zzttVar3.f35607e;
            try {
                synchronized (zztu.f35609h) {
                    zztuVar.f35610a.queueSecureInputBuffer(i3, 0, cryptoInfo, j2, i4);
                }
            } catch (RuntimeException e3) {
                AtomicReference atomicReference2 = zztuVar.f35613d;
                while (!atomicReference2.compareAndSet(null, e3) && atomicReference2.get() == null) {
                }
            }
            zzttVar = zzttVar3;
        } else if (i2 == 3) {
            zztuVar.f35614e.a();
        } else if (i2 != 4) {
            AtomicReference atomicReference3 = zztuVar.f35613d;
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(message.what));
            while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
            }
        } else {
            try {
                zztuVar.f35610a.setParameters((Bundle) message.obj);
            } catch (RuntimeException e4) {
                AtomicReference atomicReference4 = zztuVar.f35613d;
                while (!atomicReference4.compareAndSet(null, e4) && atomicReference4.get() == null) {
                }
            }
        }
        if (zzttVar != null) {
            ArrayDeque arrayDeque = zztu.f35608g;
            synchronized (arrayDeque) {
                arrayDeque.add(zzttVar);
            }
        }
    }
}
