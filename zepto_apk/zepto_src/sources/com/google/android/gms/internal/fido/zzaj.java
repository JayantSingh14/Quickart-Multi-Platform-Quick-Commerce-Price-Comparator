package com.google.android.gms.internal.fido;

import java.util.Arrays;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzaj {

    /* renamed from: a, reason: collision with root package name */
    public final String f36574a;

    /* renamed from: b, reason: collision with root package name */
    public final zzah f36575b;

    /* renamed from: c, reason: collision with root package name */
    public zzah f36576c;

    public /* synthetic */ zzaj(String str) {
        zzah zzahVar = new zzah();
        this.f36575b = zzahVar;
        this.f36576c = zzahVar;
        this.f36574a = str;
    }

    public final void a(int i2) {
        String strValueOf = String.valueOf(i2);
        zzaf zzafVar = new zzaf();
        this.f36576c.f36573c = zzafVar;
        this.f36576c = zzafVar;
        zzafVar.f36572b = strValueOf;
        zzafVar.f36571a = CLConstants.FIELD_ERROR_CODE;
    }

    public final void b(Object obj, String str) {
        zzah zzahVar = new zzah();
        this.f36576c.f36573c = zzahVar;
        this.f36576c = zzahVar;
        zzahVar.f36572b = obj;
        zzahVar.f36571a = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f36574a);
        sb.append('{');
        zzah zzahVar = this.f36575b.f36573c;
        String str = "";
        while (zzahVar != null) {
            Object obj = zzahVar.f36572b;
            boolean z = zzahVar instanceof zzaf;
            sb.append(str);
            String str2 = zzahVar.f36571a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzahVar = zzahVar.f36573c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
