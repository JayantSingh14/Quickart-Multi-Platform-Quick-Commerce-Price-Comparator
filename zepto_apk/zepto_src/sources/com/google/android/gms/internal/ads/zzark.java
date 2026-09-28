package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public abstract class zzark implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final zzarv f24213a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24214b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24215c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24216d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f24217e;

    /* renamed from: f, reason: collision with root package name */
    public final zzaro f24218f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f24219g;

    /* renamed from: h, reason: collision with root package name */
    public zzarn f24220h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f24221i;

    /* renamed from: j, reason: collision with root package name */
    public zzaqt f24222j;

    /* renamed from: k, reason: collision with root package name */
    public zzarx f24223k;

    /* renamed from: l, reason: collision with root package name */
    public final zzaqy f24224l;

    public zzark(int i2, String str, zzaro zzaroVar) {
        Uri uri;
        String host;
        this.f24213a = zzarv.f24243c ? new zzarv() : null;
        this.f24217e = new Object();
        int iHashCode = 0;
        this.f24221i = false;
        this.f24222j = null;
        this.f24214b = i2;
        this.f24215c = str;
        this.f24218f = zzaroVar;
        this.f24224l = new zzaqy();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.f24216d = iHashCode;
    }

    public final void a(String str) {
        if (zzarv.f24243c) {
            this.f24213a.a(Thread.currentThread().getId(), str);
        }
    }

    public final void b(String str) {
        zzarn zzarnVar = this.f24220h;
        if (zzarnVar != null) {
            HashSet hashSet = zzarnVar.f24226b;
            synchronized (hashSet) {
                hashSet.remove(this);
            }
            ArrayList arrayList = zzarnVar.f24233i;
            synchronized (arrayList) {
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((zzarm) it.next()).zza();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzarnVar.c();
        }
        if (zzarv.f24243c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzari(this, str, id));
                return;
            }
            zzarv zzarvVar = this.f24213a;
            zzarvVar.a(id, str);
            zzarvVar.b(toString());
        }
    }

    public final void c() {
        zzarn zzarnVar = this.f24220h;
        if (zzarnVar != null) {
            zzarnVar.c();
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f24219g.intValue() - ((zzark) obj).f24219g.intValue();
    }

    public final String d() {
        int i2 = this.f24214b;
        String str = this.f24215c;
        if (i2 == 0) {
            return str;
        }
        String string = Integer.toString(1);
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length()), string, "-", str);
    }

    public Map e() {
        return Collections.EMPTY_MAP;
    }

    public byte[] g() {
        return null;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.f24217e) {
            z = this.f24221i;
        }
        return z;
    }

    public abstract zzarq i(zzarg zzargVar);

    public abstract void l(Object obj);

    public final void n(zzarq zzarqVar) {
        zzarx zzarxVar;
        List list;
        synchronized (this.f24217e) {
            zzarxVar = this.f24223k;
        }
        if (zzarxVar != null) {
            zzaqt zzaqtVar = zzarqVar.f24237b;
            if (zzaqtVar != null) {
                if (zzaqtVar.f24177e >= System.currentTimeMillis()) {
                    String strD = d();
                    synchronized (zzarxVar) {
                        list = (List) zzarxVar.f24248a.remove(strD);
                    }
                    if (list != null) {
                        if (zzarw.f24246a) {
                            zzarw.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strD);
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            zzarxVar.f24251d.a((zzark) it.next(), zzarqVar, null);
                        }
                        return;
                    }
                    return;
                }
            }
            zzarxVar.a(this);
        }
    }

    public final void p() {
        zzarx zzarxVar;
        synchronized (this.f24217e) {
            zzarxVar = this.f24223k;
        }
        if (zzarxVar != null) {
            zzarxVar.a(this);
        }
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.f24216d));
        synchronized (this.f24217e) {
        }
        Integer num = this.f24219g;
        String str = this.f24215c;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(num).length();
        String strConcat = "0x".concat(strValueOf);
        StringBuilder sb = new StringBuilder(strConcat.length() + length + 5 + 8 + length2);
        android.support.v4.media.b.B(sb, "[ ] ", str, StringUtils.SPACE, strConcat);
        sb.append(" NORMAL ");
        sb.append(num);
        return sb.toString();
    }
}
