package org.shadow.apache.commons.lang3.builder;

import android.support.v4.media.b;
import org.apache.commons.lang3.StringUtils;
import org.shadow.apache.commons.lang3.ClassUtils;
import org.shadow.apache.commons.lang3.SystemUtils;

/* loaded from: classes5.dex */
class MultilineRecursiveToStringStyle extends RecursiveToStringStyle {
    public final int t = 2;
    public int u = 2;

    public MultilineRecursiveToStringStyle() {
        w();
    }

    public static StringBuilder x(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(StringUtils.SPACE);
        }
        return sb;
    }

    @Override // org.shadow.apache.commons.lang3.builder.RecursiveToStringStyle, org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void c(StringBuffer stringBuffer, String str, Object obj) {
        if (ClassUtils.f57703b.containsKey(obj.getClass()) || String.class.equals(obj.getClass())) {
            super.c(stringBuffer, str, obj);
            return;
        }
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        stringBuffer.append(new ReflectionToStringBuilder(obj, this).toString());
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void e(StringBuffer stringBuffer, String str, byte[] bArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.e(stringBuffer, str, bArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void f(StringBuffer stringBuffer, String str, char[] cArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.f(stringBuffer, str, cArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void g(StringBuffer stringBuffer, String str, double[] dArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.g(stringBuffer, str, dArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void h(StringBuffer stringBuffer, String str, float[] fArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.h(stringBuffer, str, fArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void i(StringBuffer stringBuffer, String str, int[] iArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.i(stringBuffer, str, iArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void j(StringBuffer stringBuffer, String str, long[] jArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.j(stringBuffer, str, jArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void k(StringBuffer stringBuffer, String str, Object[] objArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.k(stringBuffer, str, objArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void l(StringBuffer stringBuffer, String str, short[] sArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.l(stringBuffer, str, sArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void m(StringBuffer stringBuffer, String str, boolean[] zArr) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.m(stringBuffer, str, zArr);
        this.u -= i3;
        w();
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void t(StringBuffer stringBuffer, Object obj) {
        int i2 = this.u;
        int i3 = this.t;
        this.u = i2 + i3;
        w();
        super.c(stringBuffer, null, obj);
        this.u -= i3;
        w();
    }

    public final void w() {
        StringBuilder sb = new StringBuilder("{");
        String str = SystemUtils.f57727c;
        sb.append(str);
        sb.append((Object) x(this.u));
        String string = sb.toString();
        if (string == null) {
            string = "";
        }
        this.f57744j = string;
        String str2 = "," + str + ((Object) x(this.u));
        if (str2 == null) {
            str2 = "";
        }
        this.f57745k = str2;
        StringBuilder sbW = b.w(str);
        int i2 = this.u;
        int i3 = this.t;
        sbW.append((Object) x(i2 - i3));
        sbW.append("}");
        String string2 = sbW.toString();
        if (string2 == null) {
            string2 = "";
        }
        this.f57746l = string2;
        String str3 = "[" + str + ((Object) x(this.u));
        if (str3 == null) {
            str3 = "";
        }
        this.f57739e = str3;
        String str4 = "," + str + ((Object) x(this.u));
        if (str4 == null) {
            str4 = "";
        }
        this.f57743i = str4;
        StringBuilder sbW2 = b.w(str);
        sbW2.append((Object) x(this.u - i3));
        sbW2.append("]");
        String string3 = sbW2.toString();
        this.f57740f = string3 != null ? string3 : "";
    }
}
