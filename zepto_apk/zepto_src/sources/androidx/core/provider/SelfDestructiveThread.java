package androidx.core.provider;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.RestrictTo;

@RestrictTo
@Deprecated
/* loaded from: classes3.dex */
public class SelfDestructiveThread {

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1, reason: invalid class name */
    public class AnonymousClass1 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                throw null;
            }
            if (i2 != 1) {
                return true;
            }
            throw null;
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: androidx.core.provider.SelfDestructiveThread$2$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Exception -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.AnonymousClass2.run():void");
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Exception -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.AnonymousClass3.run():void");
        }
    }

    public interface ReplyCallback<T> {
    }
}
