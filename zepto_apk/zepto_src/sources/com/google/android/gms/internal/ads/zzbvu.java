package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbvu extends zzbwd {

    /* renamed from: c, reason: collision with root package name */
    public final Map f25608c;

    /* renamed from: d, reason: collision with root package name */
    public final Activity f25609d;

    /* renamed from: e, reason: collision with root package name */
    public final String f25610e;

    /* renamed from: f, reason: collision with root package name */
    public final long f25611f;

    /* renamed from: g, reason: collision with root package name */
    public final long f25612g;

    /* renamed from: h, reason: collision with root package name */
    public final String f25613h;

    /* renamed from: i, reason: collision with root package name */
    public final String f25614i;

    public zzbvu(zzcir zzcirVar, Map map) throws NumberFormatException {
        long j2;
        super(zzcirVar, "createCalendarEvent");
        this.f25608c = map;
        this.f25609d = zzcirVar.zzj();
        this.f25610e = f("description");
        this.f25613h = f("summary");
        String str = (String) map.get("start_ticks");
        long j3 = -1;
        if (str == null) {
            j2 = -1;
        } else {
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        }
        this.f25611f = j2;
        String str2 = (String) this.f25608c.get("end_ticks");
        if (str2 != null) {
            try {
                j3 = Long.parseLong(str2);
            } catch (NumberFormatException unused2) {
            }
        }
        this.f25612g = j3;
        this.f25614i = f("location");
    }

    public final String f(String str) {
        Map map = this.f25608c;
        return TextUtils.isEmpty((CharSequence) map.get(str)) ? "" : (String) map.get(str);
    }
}
