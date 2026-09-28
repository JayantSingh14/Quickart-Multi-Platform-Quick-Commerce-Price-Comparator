package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbda {

    /* renamed from: a, reason: collision with root package name */
    public final int f24743a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24744b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24745c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f24746d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbdp f24747e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbdw f24748f;
    public int n;

    /* renamed from: g, reason: collision with root package name */
    public final Object f24749g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f24750h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f24751i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f24752j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f24753k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f24754l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f24755m = 0;
    public String o = "";
    public String p = "";
    public String q = "";

    public zzbda(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.f24743a = i2;
        this.f24744b = i3;
        this.f24745c = i4;
        this.f24746d = z;
        this.f24747e = new zzbdp(i5);
        this.f24748f = new zzbdw(i6, i7, i8);
    }

    public static final String d(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append((String) arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final void a(String str, boolean z, float f2, float f3, float f4, float f5) {
        c(str, z, f2, f3, f4, f5);
        synchronized (this.f24749g) {
            try {
                if (this.f24755m < 0) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("ActivityContent: negative number of WebViews.");
                }
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f24749g) {
            try {
                int i2 = this.f24753k;
                int i3 = this.f24754l;
                boolean z = this.f24746d;
                int i4 = this.f24744b;
                if (!z) {
                    i4 = (i3 * i4) + (i2 * this.f24743a);
                }
                if (i4 > this.n) {
                    this.n = i4;
                    com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                    if (!zztVar.f21684h.g().g()) {
                        zzbdp zzbdpVar = this.f24747e;
                        this.o = zzbdpVar.a(this.f24750h);
                        this.p = zzbdpVar.a(this.f24751i);
                    }
                    if (!zztVar.f21684h.g().h()) {
                        this.q = this.f24748f.a(this.f24751i, this.f24752j);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str, boolean z, float f2, float f3, float f4, float f5) {
        if (str != null) {
            if (str.length() < this.f24745c) {
                return;
            }
            synchronized (this.f24749g) {
                try {
                    this.f24750h.add(str);
                    this.f24753k += str.length();
                    if (z) {
                        this.f24751i.add(str);
                        this.f24752j.add(new zzbdl(f2, f3, f4, f5, r10.size() - 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbda)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzbda) obj).o;
        return str != null && str.equals(this.o);
    }

    public final int hashCode() {
        return this.o.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.f24750h;
        int i2 = this.f24754l;
        int i3 = this.n;
        int i4 = this.f24753k;
        String strD = d(arrayList);
        String strD2 = d(this.f24751i);
        String str = this.o;
        String str2 = this.p;
        String str3 = this.q;
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i3).length();
        int length3 = String.valueOf(i4).length();
        int length4 = String.valueOf(strD).length();
        int length5 = String.valueOf(strD2).length();
        int length6 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 14 + length3 + 8 + length4 + 14 + length5 + 12 + length6 + 20 + String.valueOf(str2).length() + 32 + String.valueOf(str3).length());
        androidx.fragment.app.e.w(i2, i3, "ActivityContent fetchId: ", " score:", sb);
        sb.append(" total_length:");
        sb.append(i4);
        sb.append("\n text: ");
        sb.append(strD);
        android.support.v4.media.b.B(sb, "\n viewableText", strD2, "\n signture: ", str);
        return android.support.v4.media.a.n(sb, "\n viewableSignture: ", str2, "\n viewableSignatureForVertical: ", str3);
    }
}
