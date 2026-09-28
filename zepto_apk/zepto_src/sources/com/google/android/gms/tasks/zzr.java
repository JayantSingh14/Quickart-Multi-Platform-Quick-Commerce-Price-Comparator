package com.google.android.gms.tasks;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
final class zzr {

    /* renamed from: a, reason: collision with root package name */
    public final Object f39799a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f39800b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39801c;

    public final void a(zzq zzqVar) {
        synchronized (this.f39799a) {
            try {
                if (this.f39800b == null) {
                    this.f39800b = new ArrayDeque();
                }
                this.f39800b.add(zzqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Task task) {
        zzq zzqVar;
        synchronized (this.f39799a) {
            if (this.f39800b != null && !this.f39801c) {
                this.f39801c = true;
                while (true) {
                    synchronized (this.f39799a) {
                        try {
                            zzqVar = (zzq) this.f39800b.poll();
                            if (zzqVar == null) {
                                this.f39801c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    zzqVar.b(task);
                }
            }
        }
    }
}
