package com.facebook.imagepipeline.core;

import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class CloseableReferenceFactory {

    /* renamed from: a, reason: collision with root package name */
    public final CloseableReference.LeakHandler f17793a;

    public CloseableReferenceFactory(final CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        this.f17793a = new CloseableReference.LeakHandler() { // from class: com.facebook.imagepipeline.core.CloseableReferenceFactory.1
            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public final void a(SharedReference sharedReference, Throwable th) {
                closeableReferenceLeakTracker.a(sharedReference);
                Object objB = sharedReference.b();
                FLog.s("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), objB != null ? objB.getClass().getName() : "<value is null>", th == null ? "" : Log.getStackTraceString(th));
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public final boolean b() {
                closeableReferenceLeakTracker.getClass();
                return false;
            }
        };
    }
}
