package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.e;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import in.juspay.hypersdk.analytics.LogConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.UUID;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public final class Format {
    public static final Format L = new Format(new Builder());
    public static final String M = Integer.toString(0, 36);
    public static final String N = Integer.toString(1, 36);
    public static final String O = Integer.toString(2, 36);
    public static final String P = Integer.toString(3, 36);
    public static final String Q = Integer.toString(4, 36);
    public static final String R = Integer.toString(5, 36);
    public static final String S = Integer.toString(6, 36);
    public static final String T = Integer.toString(7, 36);
    public static final String U = Integer.toString(8, 36);
    public static final String V = Integer.toString(9, 36);
    public static final String W = Integer.toString(10, 36);
    public static final String X = Integer.toString(11, 36);
    public static final String Y = Integer.toString(12, 36);
    public static final String Z = Integer.toString(13, 36);
    public static final String a0 = Integer.toString(14, 36);
    public static final String b0 = Integer.toString(15, 36);
    public static final String c0 = Integer.toString(16, 36);
    public static final String d0 = Integer.toString(17, 36);
    public static final String e0 = Integer.toString(18, 36);
    public static final String f0 = Integer.toString(19, 36);
    public static final String g0 = Integer.toString(20, 36);
    public static final String h0 = Integer.toString(21, 36);
    public static final String i0 = Integer.toString(22, 36);
    public static final String j0 = Integer.toString(23, 36);
    public static final String k0 = Integer.toString(24, 36);
    public static final String l0 = Integer.toString(25, 36);
    public static final String m0 = Integer.toString(26, 36);
    public static final String n0 = Integer.toString(27, 36);
    public static final String o0 = Integer.toString(28, 36);
    public static final String p0 = Integer.toString(29, 36);
    public static final String q0 = Integer.toString(30, 36);
    public static final String r0 = Integer.toString(31, 36);
    public static final String s0 = Integer.toString(32, 36);
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public int K;

    /* renamed from: a, reason: collision with root package name */
    public final String f5213a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5214b;

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableList f5215c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5216d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5217e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5218f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5219g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5220h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5221i;

    /* renamed from: j, reason: collision with root package name */
    public final String f5222j;

    /* renamed from: k, reason: collision with root package name */
    public final Metadata f5223k;

    /* renamed from: l, reason: collision with root package name */
    public final String f5224l;

    /* renamed from: m, reason: collision with root package name */
    public final String f5225m;
    public final int n;
    public final int o;
    public final List p;
    public final DrmInitData q;
    public final long r;
    public final int s;
    public final int t;
    public final float u;
    public final int v;
    public final float w;
    public final byte[] x;
    public final int y;
    public final ColorInfo z;

    @UnstableApi
    public static final class Builder {
        public int C;
        public int D;

        /* renamed from: a, reason: collision with root package name */
        public String f5226a;

        /* renamed from: b, reason: collision with root package name */
        public String f5227b;

        /* renamed from: d, reason: collision with root package name */
        public String f5229d;

        /* renamed from: e, reason: collision with root package name */
        public int f5230e;

        /* renamed from: f, reason: collision with root package name */
        public int f5231f;

        /* renamed from: i, reason: collision with root package name */
        public String f5234i;

        /* renamed from: j, reason: collision with root package name */
        public Metadata f5235j;

        /* renamed from: k, reason: collision with root package name */
        public String f5236k;

        /* renamed from: l, reason: collision with root package name */
        public String f5237l;
        public List o;
        public DrmInitData p;
        public int u;
        public byte[] w;
        public ColorInfo y;

        /* renamed from: c, reason: collision with root package name */
        public ImmutableList f5228c = ImmutableList.r();

        /* renamed from: g, reason: collision with root package name */
        public int f5232g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f5233h = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f5238m = -1;
        public int n = -1;
        public long q = Long.MAX_VALUE;
        public int r = -1;
        public int s = -1;
        public float t = -1.0f;
        public float v = 1.0f;
        public int x = -1;
        public int z = -1;
        public int A = -1;
        public int B = -1;
        public int E = -1;
        public int F = 1;
        public int G = -1;
        public int H = -1;
        public int I = 0;

        public final Format a() {
            return new Format(this);
        }

        public final void b(int i2) {
            this.z = i2;
        }

        public final void c(int i2) {
            this.B = i2;
        }

        public final void d(String str) {
            this.f5237l = MimeTypes.p(str);
        }

        public final void e(int i2) {
            this.A = i2;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface CueReplacementBehavior {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Format(Builder builder) throws MissingResourceException {
        boolean z;
        String str;
        this.f5213a = builder.f5226a;
        String strU = Util.U(builder.f5229d);
        this.f5216d = strU;
        if (builder.f5228c.isEmpty() && builder.f5227b != null) {
            this.f5215c = ImmutableList.t(new Label(strU, builder.f5227b));
            this.f5214b = builder.f5227b;
        } else if (!builder.f5228c.isEmpty() && builder.f5227b == null) {
            ImmutableList immutableList = builder.f5228c;
            this.f5215c = immutableList;
            Iterator<E> it = immutableList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((Label) immutableList.get(0)).f5249b;
                    break;
                }
                Label label = (Label) it.next();
                if (TextUtils.equals(label.f5248a, strU)) {
                    str = label.f5249b;
                    break;
                }
            }
            this.f5214b = str;
        } else if (builder.f5228c.isEmpty() && builder.f5227b == null) {
            z = true;
            Assertions.g(z);
            this.f5215c = builder.f5228c;
            this.f5214b = builder.f5227b;
        } else {
            for (int i2 = 0; i2 < builder.f5228c.size(); i2++) {
                if (((Label) builder.f5228c.get(i2)).f5249b.equals(builder.f5227b)) {
                    z = true;
                    break;
                }
            }
            z = false;
            Assertions.g(z);
            this.f5215c = builder.f5228c;
            this.f5214b = builder.f5227b;
        }
        this.f5217e = builder.f5230e;
        this.f5218f = builder.f5231f;
        int i3 = builder.f5232g;
        this.f5219g = i3;
        int i4 = builder.f5233h;
        this.f5220h = i4;
        this.f5221i = i4 != -1 ? i4 : i3;
        this.f5222j = builder.f5234i;
        this.f5223k = builder.f5235j;
        this.f5224l = builder.f5236k;
        this.f5225m = builder.f5237l;
        this.n = builder.f5238m;
        this.o = builder.n;
        List list = builder.o;
        this.p = list == null ? Collections.EMPTY_LIST : list;
        DrmInitData drmInitData = builder.p;
        this.q = drmInitData;
        this.r = builder.q;
        this.s = builder.r;
        this.t = builder.s;
        this.u = builder.t;
        int i5 = builder.u;
        this.v = i5 == -1 ? 0 : i5;
        float f2 = builder.v;
        this.w = f2 == -1.0f ? 1.0f : f2;
        this.x = builder.w;
        this.y = builder.x;
        this.z = builder.y;
        this.A = builder.z;
        this.B = builder.A;
        this.C = builder.B;
        int i6 = builder.C;
        this.D = i6 == -1 ? 0 : i6;
        int i7 = builder.D;
        this.E = i7 != -1 ? i7 : 0;
        this.F = builder.E;
        this.G = builder.F;
        this.H = builder.G;
        this.I = builder.H;
        int i8 = builder.I;
        if (i8 != 0 || drmInitData == null) {
            this.J = i8;
        } else {
            this.J = 1;
        }
    }

    public static String d(Format format) {
        String str;
        int i2;
        if (format == null) {
            return "null";
        }
        StringBuilder sbW = android.support.v4.media.b.w("id=");
        sbW.append(format.f5213a);
        sbW.append(", mimeType=");
        sbW.append(format.f5225m);
        String str2 = format.f5224l;
        if (str2 != null) {
            sbW.append(", container=");
            sbW.append(str2);
        }
        int i3 = format.f5221i;
        if (i3 != -1) {
            sbW.append(", bitrate=");
            sbW.append(i3);
        }
        String str3 = format.f5222j;
        if (str3 != null) {
            sbW.append(", codecs=");
            sbW.append(str3);
        }
        DrmInitData drmInitData = format.q;
        if (drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i4 = 0; i4 < drmInitData.f5204d; i4++) {
                UUID uuid = drmInitData.f5201a[i4].f5206b;
                if (uuid.equals(C.f5165b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.f5166c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.f5168e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.f5167d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.f5164a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
            }
            sbW.append(", drm=[");
            Joiner.d(',').b(linkedHashSet.iterator(), sbW);
            sbW.append(']');
        }
        int i5 = format.s;
        if (i5 != -1 && (i2 = format.t) != -1) {
            e.w(i5, i2, ", res=", "x", sbW);
        }
        ColorInfo colorInfo = format.z;
        if (colorInfo != null) {
            int i6 = colorInfo.f5180f;
            int i7 = colorInfo.f5179e;
            if ((i7 != -1 && i6 != -1) || colorInfo.d()) {
                sbW.append(", color=");
                if (colorInfo.d()) {
                    String strB = ColorInfo.b(colorInfo.f5175a);
                    String strA = ColorInfo.a(colorInfo.f5176b);
                    String strC = ColorInfo.c(colorInfo.f5177c);
                    int i8 = Util.f5744a;
                    Locale locale = Locale.US;
                    str = strB + "/" + strA + "/" + strC;
                } else {
                    str = "NA/NA/NA";
                }
                sbW.append(str + "/" + ((i7 == -1 || i6 == -1) ? "NA/NA" : i7 + "/" + i6));
            }
        }
        float f2 = format.u;
        if (f2 != -1.0f) {
            sbW.append(", fps=");
            sbW.append(f2);
        }
        int i9 = format.A;
        if (i9 != -1) {
            sbW.append(", channels=");
            sbW.append(i9);
        }
        int i10 = format.B;
        if (i10 != -1) {
            sbW.append(", sample_rate=");
            sbW.append(i10);
        }
        String str4 = format.f5216d;
        if (str4 != null) {
            sbW.append(", language=");
            sbW.append(str4);
        }
        ImmutableList immutableList = format.f5215c;
        if (!immutableList.isEmpty()) {
            sbW.append(", labels=[");
            Joiner.d(',').b(immutableList.iterator(), sbW);
            sbW.append("]");
        }
        int i11 = format.f5217e;
        if (i11 != 0) {
            sbW.append(", selectionFlags=[");
            Joiner joinerD = Joiner.d(',');
            int i12 = Util.f5744a;
            ArrayList arrayList = new ArrayList();
            if ((i11 & 4) != 0) {
                arrayList.add("auto");
            }
            if ((i11 & 1) != 0) {
                arrayList.add(LogConstants.DEFAULT_CHANNEL);
            }
            if ((i11 & 2) != 0) {
                arrayList.add("forced");
            }
            joinerD.b(arrayList.iterator(), sbW);
            sbW.append("]");
        }
        int i13 = format.f5218f;
        if (i13 != 0) {
            sbW.append(", roleFlags=[");
            Joiner joinerD2 = Joiner.d(',');
            int i14 = Util.f5744a;
            ArrayList arrayList2 = new ArrayList();
            if ((i13 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i13 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i13 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i13 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i13 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i13 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i13 & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((i13 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i13 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i13 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i13 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i13 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i13 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i13 & KEYRecord.Flags.FLAG2) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i13 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            joinerD2.b(arrayList2.iterator(), sbW);
            sbW.append("]");
        }
        return sbW.toString();
    }

    public final Builder a() {
        Builder builder = new Builder();
        builder.f5226a = this.f5213a;
        builder.f5227b = this.f5214b;
        builder.f5228c = this.f5215c;
        builder.f5229d = this.f5216d;
        builder.f5230e = this.f5217e;
        builder.f5231f = this.f5218f;
        builder.f5232g = this.f5219g;
        builder.f5233h = this.f5220h;
        builder.f5234i = this.f5222j;
        builder.f5235j = this.f5223k;
        builder.f5236k = this.f5224l;
        builder.f5237l = this.f5225m;
        builder.f5238m = this.n;
        builder.n = this.o;
        builder.o = this.p;
        builder.p = this.q;
        builder.q = this.r;
        builder.r = this.s;
        builder.s = this.t;
        builder.t = this.u;
        builder.u = this.v;
        builder.v = this.w;
        builder.w = this.x;
        builder.x = this.y;
        builder.y = this.z;
        builder.z = this.A;
        builder.A = this.B;
        builder.B = this.C;
        builder.C = this.D;
        builder.D = this.E;
        builder.E = this.F;
        builder.F = this.G;
        builder.G = this.H;
        builder.H = this.I;
        builder.I = this.J;
        return builder;
    }

    public final boolean b(Format format) {
        List list = this.p;
        if (list.size() != format.p.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) format.p.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public final Bundle c(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(M, this.f5213a);
        bundle.putString(N, this.f5214b);
        ImmutableList<Label> immutableList = this.f5215c;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableList.size());
        for (Label label : immutableList) {
            label.getClass();
            Bundle bundle2 = new Bundle();
            String str = label.f5248a;
            if (str != null) {
                bundle2.putString(Label.f5246c, str);
            }
            bundle2.putString(Label.f5247d, label.f5249b);
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(s0, arrayList);
        bundle.putString(O, this.f5216d);
        bundle.putInt(P, this.f5217e);
        bundle.putInt(Q, this.f5218f);
        bundle.putInt(R, this.f5219g);
        bundle.putInt(S, this.f5220h);
        bundle.putString(T, this.f5222j);
        if (!z) {
            bundle.putParcelable(U, this.f5223k);
        }
        bundle.putString(V, this.f5224l);
        bundle.putString(W, this.f5225m);
        bundle.putInt(X, this.n);
        int i2 = 0;
        while (true) {
            List list = this.p;
            if (i2 >= list.size()) {
                break;
            }
            bundle.putByteArray(Y + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + Integer.toString(i2, 36), (byte[]) list.get(i2));
            i2++;
        }
        bundle.putParcelable(Z, this.q);
        bundle.putLong(a0, this.r);
        bundle.putInt(b0, this.s);
        bundle.putInt(c0, this.t);
        bundle.putFloat(d0, this.u);
        bundle.putInt(e0, this.v);
        bundle.putFloat(f0, this.w);
        bundle.putByteArray(g0, this.x);
        bundle.putInt(h0, this.y);
        ColorInfo colorInfo = this.z;
        if (colorInfo != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(ColorInfo.f5170i, colorInfo.f5175a);
            bundle3.putInt(ColorInfo.f5171j, colorInfo.f5176b);
            bundle3.putInt(ColorInfo.f5172k, colorInfo.f5177c);
            bundle3.putByteArray(ColorInfo.f5173l, colorInfo.f5178d);
            bundle3.putInt(ColorInfo.f5174m, colorInfo.f5179e);
            bundle3.putInt(ColorInfo.n, colorInfo.f5180f);
            bundle.putBundle(i0, bundle3);
        }
        bundle.putInt(j0, this.A);
        bundle.putInt(k0, this.B);
        bundle.putInt(l0, this.C);
        bundle.putInt(m0, this.D);
        bundle.putInt(n0, this.E);
        bundle.putInt(o0, this.F);
        bundle.putInt(q0, this.H);
        bundle.putInt(r0, this.I);
        bundle.putInt(p0, this.J);
        return bundle;
    }

    public final Format e(Format format) {
        String str;
        ImmutableList immutableList;
        String str2;
        DrmInitData.SchemeData[] schemeDataArr;
        if (this == format) {
            return this;
        }
        int i2 = MimeTypes.i(this.f5225m);
        String str3 = format.f5213a;
        String str4 = format.f5214b;
        if (str4 == null) {
            str4 = this.f5214b;
        }
        ImmutableList immutableList2 = format.f5215c;
        if (immutableList2.isEmpty()) {
            immutableList2 = this.f5215c;
        }
        if ((i2 != 3 && i2 != 1) || (str = format.f5216d) == null) {
            str = this.f5216d;
        }
        int i3 = this.f5219g;
        if (i3 == -1) {
            i3 = format.f5219g;
        }
        int i4 = this.f5220h;
        if (i4 == -1) {
            i4 = format.f5220h;
        }
        String str5 = this.f5222j;
        if (str5 == null) {
            String strU = Util.u(i2, format.f5222j);
            if (Util.f0(strU).length == 1) {
                str5 = strU;
            }
        }
        Metadata metadataB = format.f5223k;
        Metadata metadata = this.f5223k;
        if (metadata != null) {
            metadataB = metadata.b(metadataB);
        }
        float f2 = this.u;
        if (f2 == -1.0f && i2 == 2) {
            f2 = format.u;
        }
        int i5 = this.f5217e | format.f5217e;
        int i6 = this.f5218f | format.f5218f;
        ArrayList arrayList = new ArrayList();
        DrmInitData drmInitData = format.q;
        if (drmInitData != null) {
            DrmInitData.SchemeData[] schemeDataArr2 = drmInitData.f5201a;
            immutableList = immutableList2;
            int length = schemeDataArr2.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = length;
                DrmInitData.SchemeData schemeData = schemeDataArr2[i7];
                int i9 = i7;
                if (schemeData.f5209e != null) {
                    arrayList.add(schemeData);
                }
                i7 = i9 + 1;
                length = i8;
            }
            str2 = drmInitData.f5203c;
        } else {
            immutableList = immutableList2;
            str2 = null;
        }
        DrmInitData drmInitData2 = this.q;
        if (drmInitData2 != null) {
            if (str2 == null) {
                str2 = drmInitData2.f5203c;
            }
            int size = arrayList.size();
            DrmInitData.SchemeData[] schemeDataArr3 = drmInitData2.f5201a;
            int length2 = schemeDataArr3.length;
            String str6 = str2;
            int i10 = 0;
            while (i10 < length2) {
                int i11 = length2;
                DrmInitData.SchemeData schemeData2 = schemeDataArr3[i10];
                int i12 = i10;
                if (schemeData2.f5209e != null) {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= size) {
                            schemeDataArr = schemeDataArr3;
                            arrayList.add(schemeData2);
                            break;
                        }
                        int i14 = i13;
                        schemeDataArr = schemeDataArr3;
                        if (((DrmInitData.SchemeData) arrayList.get(i13)).f5206b.equals(schemeData2.f5206b)) {
                            break;
                        }
                        i13 = i14 + 1;
                        schemeDataArr3 = schemeDataArr;
                    }
                } else {
                    schemeDataArr = schemeDataArr3;
                }
                i10 = i12 + 1;
                length2 = i11;
                schemeDataArr3 = schemeDataArr;
            }
            str2 = str6;
        }
        DrmInitData drmInitData3 = arrayList.isEmpty() ? null : new DrmInitData(str2, arrayList);
        Builder builderA = a();
        builderA.f5226a = str3;
        builderA.f5227b = str4;
        builderA.f5228c = ImmutableList.o(immutableList);
        builderA.f5229d = str;
        builderA.f5230e = i5;
        builderA.f5231f = i6;
        builderA.f5232g = i3;
        builderA.f5233h = i4;
        builderA.f5234i = str5;
        builderA.f5235j = metadataB;
        builderA.p = drmInitData3;
        builderA.t = f2;
        builderA.G = format.H;
        builderA.H = format.I;
        return new Format(builderA);
    }

    public final boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i3 = this.K;
        return (i3 == 0 || (i2 = format.K) == 0 || i3 == i2) && this.f5217e == format.f5217e && this.f5218f == format.f5218f && this.f5219g == format.f5219g && this.f5220h == format.f5220h && this.n == format.n && this.r == format.r && this.s == format.s && this.t == format.t && this.v == format.v && this.y == format.y && this.A == format.A && this.B == format.B && this.C == format.C && this.D == format.D && this.E == format.E && this.F == format.F && this.H == format.H && this.I == format.I && this.J == format.J && Float.compare(this.u, format.u) == 0 && Float.compare(this.w, format.w) == 0 && Objects.equals(this.f5213a, format.f5213a) && Objects.equals(this.f5214b, format.f5214b) && this.f5215c.equals(format.f5215c) && Objects.equals(this.f5222j, format.f5222j) && Objects.equals(this.f5224l, format.f5224l) && Objects.equals(this.f5225m, format.f5225m) && Objects.equals(this.f5216d, format.f5216d) && Arrays.equals(this.x, format.x) && Objects.equals(this.f5223k, format.f5223k) && Objects.equals(this.z, format.z) && Objects.equals(this.q, format.q) && b(format);
    }

    public final int hashCode() {
        if (this.K == 0) {
            String str = this.f5213a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f5214b;
            int iHashCode2 = (this.f5215c.hashCode() + ((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            String str3 = this.f5216d;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f5217e) * 31) + this.f5218f) * 31) + this.f5219g) * 31) + this.f5220h) * 31;
            String str4 = this.f5222j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f5223k;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 961;
            String str5 = this.f5224l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f5225m;
            this.K = ((((((((((((((((((((Float.floatToIntBits(this.w) + ((((Float.floatToIntBits(this.u) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.n) * 31) + ((int) this.r)) * 31) + this.s) * 31) + this.t) * 31)) * 31) + this.v) * 31)) * 31) + this.y) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.H) * 31) + this.I) * 31) + this.J;
        }
        return this.K;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.f5213a);
        sb.append(", ");
        sb.append(this.f5214b);
        sb.append(", ");
        sb.append(this.f5224l);
        sb.append(", ");
        sb.append(this.f5225m);
        sb.append(", ");
        sb.append(this.f5222j);
        sb.append(", ");
        sb.append(this.f5221i);
        sb.append(", ");
        sb.append(this.f5216d);
        sb.append(", [");
        sb.append(this.s);
        sb.append(", ");
        sb.append(this.t);
        sb.append(", ");
        sb.append(this.u);
        sb.append(", ");
        sb.append(this.z);
        sb.append("], [");
        sb.append(this.A);
        sb.append(", ");
        return android.support.v4.media.b.o(sb, this.B, "])");
    }
}
