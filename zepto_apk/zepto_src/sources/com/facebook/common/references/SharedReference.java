package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;
import java.util.IdentityHashMap;

@Nullsafe
/* loaded from: classes3.dex */
public class SharedReference<T> {

    /* renamed from: d, reason: collision with root package name */
    public static final IdentityHashMap f17116d = new IdentityHashMap();

    /* renamed from: a, reason: collision with root package name */
    public Object f17117a;

    /* renamed from: b, reason: collision with root package name */
    public int f17118b;

    /* renamed from: c, reason: collision with root package name */
    public final ResourceReleaser f17119c;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(Object obj, ResourceReleaser resourceReleaser, boolean z) {
        obj.getClass();
        this.f17117a = obj;
        this.f17119c = resourceReleaser;
        this.f17118b = 1;
        if (z) {
            IdentityHashMap identityHashMap = f17116d;
            synchronized (identityHashMap) {
                try {
                    Integer num = (Integer) identityHashMap.get(obj);
                    if (num == null) {
                        identityHashMap.put(obj, 1);
                    } else {
                        identityHashMap.put(obj, Integer.valueOf(num.intValue() + 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0065 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r5 = this;
            monitor-enter(r5)
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L66
            int r0 = r5.f17118b     // Catch: java.lang.Throwable -> L74
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto La
            r3 = r2
            goto Lb
        La:
            r3 = r1
        Lb:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L6e
            if (r0 <= 0) goto L11
            r1 = r2
        L11:
            if (r1 == 0) goto L68
            int r0 = r5.f17118b     // Catch: java.lang.Throwable -> L66
            int r0 = r0 - r2
            r5.f17118b = r0     // Catch: java.lang.Throwable -> L66
            monitor-exit(r5)
            if (r0 != 0) goto L65
            monitor-enter(r5)
            java.lang.Object r0 = r5.f17117a     // Catch: java.lang.Throwable -> L62
            r1 = 0
            r5.f17117a = r1     // Catch: java.lang.Throwable -> L62
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L65
            com.facebook.common.references.ResourceReleaser r1 = r5.f17119c
            if (r1 == 0) goto L2b
            r1.a(r0)
        L2b:
            java.util.IdentityHashMap r1 = com.facebook.common.references.SharedReference.f17116d
            monitor-enter(r1)
            java.lang.Object r3 = r1.get(r0)     // Catch: java.lang.Throwable -> L46
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L46
            if (r3 != 0) goto L48
            java.lang.String r2 = "SharedReference"
            java.lang.String r3 = "No entry in sLiveObjects for value of type %s"
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L46
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L46
            com.facebook.common.logging.FLog.v(r2, r3, r0)     // Catch: java.lang.Throwable -> L46
            goto L5e
        L46:
            r0 = move-exception
            goto L60
        L48:
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L46
            if (r4 != r2) goto L52
            r1.remove(r0)     // Catch: java.lang.Throwable -> L46
            goto L5e
        L52:
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L46
            int r3 = r3 - r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L46
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L46
        L5e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L46
            return
        L60:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L46
            throw r0
        L62:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L62
            throw r0
        L65:
            return
        L66:
            r0 = move-exception
            goto L77
        L68:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L66
            r0.<init>()     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L66
        L6e:
            com.facebook.common.references.SharedReference$NullReferenceException r0 = new com.facebook.common.references.SharedReference$NullReferenceException     // Catch: java.lang.Throwable -> L66
            r0.<init>()     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L66
        L74:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L74
            throw r0     // Catch: java.lang.Throwable -> L66
        L77:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L66
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.references.SharedReference.a():void");
    }

    public final synchronized Object b() {
        return this.f17117a;
    }
}
