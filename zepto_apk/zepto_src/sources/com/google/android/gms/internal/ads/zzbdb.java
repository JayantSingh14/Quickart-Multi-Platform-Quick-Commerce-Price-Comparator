package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbdb {

    /* renamed from: b, reason: collision with root package name */
    public int f24757b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f24756a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList f24758c = new LinkedList();

    public final void a(zzbda zzbdaVar) {
        synchronized (this.f24756a) {
            try {
                Iterator it = this.f24758c.iterator();
                while (it.hasNext()) {
                    zzbda zzbdaVar2 = (zzbda) it.next();
                    com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                    if (zztVar.f21684h.g().g()) {
                        if (!zztVar.f21684h.g().h() && !zzbdaVar.equals(zzbdaVar2) && zzbdaVar2.q.equals(zzbdaVar.q)) {
                            it.remove();
                            return;
                        }
                    } else if (!zzbdaVar.equals(zzbdaVar2) && zzbdaVar2.o.equals(zzbdaVar.o)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(zzbda zzbdaVar) {
        synchronized (this.f24756a) {
            try {
                LinkedList linkedList = this.f24758c;
                if (linkedList.size() >= 10) {
                    int size = linkedList.size();
                    StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 30);
                    sb.append("Queue is full, current size = ");
                    sb.append(size);
                    String string = sb.toString();
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a(string);
                    linkedList.remove(0);
                }
                int i3 = this.f24757b;
                this.f24757b = i3 + 1;
                zzbdaVar.f24754l = i3;
                synchronized (zzbdaVar.f24749g) {
                    try {
                        int i4 = zzbdaVar.f24753k;
                        int i5 = zzbdaVar.f24754l;
                        boolean z = zzbdaVar.f24746d;
                        int i6 = zzbdaVar.f24744b;
                        if (!z) {
                            i6 = (i5 * i6) + (i4 * zzbdaVar.f24743a);
                        }
                        if (i6 > zzbdaVar.n) {
                            zzbdaVar.n = i6;
                        }
                    } finally {
                    }
                }
                linkedList.add(zzbdaVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
