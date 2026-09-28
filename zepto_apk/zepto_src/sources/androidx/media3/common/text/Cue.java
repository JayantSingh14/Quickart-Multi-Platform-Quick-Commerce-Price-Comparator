package androidx.media3.common.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Cue {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f5612a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f5613b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f5614c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f5615d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5616e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5617f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5618g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5619h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5620i;

    /* renamed from: j, reason: collision with root package name */
    public final float f5621j;

    /* renamed from: k, reason: collision with root package name */
    public final float f5622k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f5623l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5624m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @UnstableApi
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f5625a = null;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f5626b = null;

        /* renamed from: c, reason: collision with root package name */
        public Layout.Alignment f5627c = null;

        /* renamed from: d, reason: collision with root package name */
        public Layout.Alignment f5628d = null;

        /* renamed from: e, reason: collision with root package name */
        public float f5629e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f5630f = Integer.MIN_VALUE;

        /* renamed from: g, reason: collision with root package name */
        public int f5631g = Integer.MIN_VALUE;

        /* renamed from: h, reason: collision with root package name */
        public float f5632h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f5633i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public int f5634j = Integer.MIN_VALUE;

        /* renamed from: k, reason: collision with root package name */
        public float f5635k = -3.4028235E38f;

        /* renamed from: l, reason: collision with root package name */
        public float f5636l = -3.4028235E38f;

        /* renamed from: m, reason: collision with root package name */
        public float f5637m = -3.4028235E38f;
        public boolean n = false;
        public int o = -16777216;
        public int p = Integer.MIN_VALUE;
        public float q;

        public final Cue a() {
            return new Cue(this.f5625a, this.f5627c, this.f5628d, this.f5626b, this.f5629e, this.f5630f, this.f5631g, this.f5632h, this.f5633i, this.f5634j, this.f5635k, this.f5636l, this.f5637m, this.n, this.o, this.p, this.q);
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    static {
        Builder builder = new Builder();
        builder.f5625a = "";
        builder.a();
        int i2 = Util.f5744a;
        r = Integer.toString(0, 36);
        s = Integer.toString(17, 36);
        t = Integer.toString(1, 36);
        u = Integer.toString(2, 36);
        v = Integer.toString(3, 36);
        w = Integer.toString(18, 36);
        x = Integer.toString(4, 36);
        y = Integer.toString(5, 36);
        z = Integer.toString(6, 36);
        A = Integer.toString(7, 36);
        B = Integer.toString(8, 36);
        C = Integer.toString(9, 36);
        D = Integer.toString(10, 36);
        E = Integer.toString(11, 36);
        F = Integer.toString(12, 36);
        G = Integer.toString(13, 36);
        H = Integer.toString(14, 36);
        I = Integer.toString(15, 36);
        J = Integer.toString(16, 36);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z2, int i6, int i7, float f7) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            Assertions.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f5612a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f5612a = charSequence.toString();
        } else {
            this.f5612a = null;
        }
        this.f5613b = alignment;
        this.f5614c = alignment2;
        this.f5615d = bitmap;
        this.f5616e = f2;
        this.f5617f = i2;
        this.f5618g = i3;
        this.f5619h = f3;
        this.f5620i = i4;
        this.f5621j = f5;
        this.f5622k = f6;
        this.f5623l = z2;
        this.f5624m = i6;
        this.n = i5;
        this.o = f4;
        this.p = i7;
        this.q = f7;
    }

    public static Cue b(Bundle bundle) {
        Builder builder = new Builder();
        CharSequence charSequence = bundle.getCharSequence(r);
        if (charSequence != null) {
            builder.f5625a = charSequence;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(s);
            if (parcelableArrayList != null) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    Bundle bundle2 = (Bundle) it.next();
                    int i2 = bundle2.getInt(CustomSpanBundler.f5643a);
                    int i3 = bundle2.getInt(CustomSpanBundler.f5644b);
                    int i4 = bundle2.getInt(CustomSpanBundler.f5645c);
                    int i5 = bundle2.getInt(CustomSpanBundler.f5646d, -1);
                    Bundle bundle3 = bundle2.getBundle(CustomSpanBundler.f5647e);
                    if (i5 == 1) {
                        bundle3.getClass();
                        String string = bundle3.getString(RubySpan.f5648c);
                        string.getClass();
                        spannableStringValueOf.setSpan(new RubySpan(string, bundle3.getInt(RubySpan.f5649d)), i2, i3, i4);
                    } else if (i5 == 2) {
                        bundle3.getClass();
                        spannableStringValueOf.setSpan(new TextEmphasisSpan(bundle3.getInt(TextEmphasisSpan.f5652d), bundle3.getInt(TextEmphasisSpan.f5653e), bundle3.getInt(TextEmphasisSpan.f5654f)), i2, i3, i4);
                    } else if (i5 == 3) {
                        spannableStringValueOf.setSpan(new HorizontalTextInVerticalContextSpan(), i2, i3, i4);
                    }
                }
                builder.f5625a = spannableStringValueOf;
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(t);
        if (alignment != null) {
            builder.f5627c = alignment;
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(u);
        if (alignment2 != null) {
            builder.f5628d = alignment2;
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(v);
        if (bitmap != null) {
            builder.f5626b = bitmap;
        } else {
            byte[] byteArray = bundle.getByteArray(w);
            if (byteArray != null) {
                builder.f5626b = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
        }
        String str = x;
        if (bundle.containsKey(str)) {
            String str2 = y;
            if (bundle.containsKey(str2)) {
                float f2 = bundle.getFloat(str);
                int i6 = bundle.getInt(str2);
                builder.f5629e = f2;
                builder.f5630f = i6;
            }
        }
        String str3 = z;
        if (bundle.containsKey(str3)) {
            builder.f5631g = bundle.getInt(str3);
        }
        String str4 = A;
        if (bundle.containsKey(str4)) {
            builder.f5632h = bundle.getFloat(str4);
        }
        String str5 = B;
        if (bundle.containsKey(str5)) {
            builder.f5633i = bundle.getInt(str5);
        }
        String str6 = D;
        if (bundle.containsKey(str6)) {
            String str7 = C;
            if (bundle.containsKey(str7)) {
                float f3 = bundle.getFloat(str6);
                int i7 = bundle.getInt(str7);
                builder.f5635k = f3;
                builder.f5634j = i7;
            }
        }
        String str8 = E;
        if (bundle.containsKey(str8)) {
            builder.f5636l = bundle.getFloat(str8);
        }
        String str9 = F;
        if (bundle.containsKey(str9)) {
            builder.f5637m = bundle.getFloat(str9);
        }
        String str10 = G;
        if (bundle.containsKey(str10)) {
            builder.o = bundle.getInt(str10);
            builder.n = true;
        }
        if (!bundle.getBoolean(H, false)) {
            builder.n = false;
        }
        String str11 = I;
        if (bundle.containsKey(str11)) {
            builder.p = bundle.getInt(str11);
        }
        String str12 = J;
        if (bundle.containsKey(str12)) {
            builder.q = bundle.getFloat(str12);
        }
        return builder.a();
    }

    public final Builder a() {
        Builder builder = new Builder();
        builder.f5625a = this.f5612a;
        builder.f5626b = this.f5615d;
        builder.f5627c = this.f5613b;
        builder.f5628d = this.f5614c;
        builder.f5629e = this.f5616e;
        builder.f5630f = this.f5617f;
        builder.f5631g = this.f5618g;
        builder.f5632h = this.f5619h;
        builder.f5633i = this.f5620i;
        builder.f5634j = this.n;
        builder.f5635k = this.o;
        builder.f5636l = this.f5621j;
        builder.f5637m = this.f5622k;
        builder.n = this.f5623l;
        builder.o = this.f5624m;
        builder.p = this.p;
        builder.q = this.q;
        return builder;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f5612a;
        if (charSequence != null) {
            bundle.putCharSequence(r, charSequence);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                String str = CustomSpanBundler.f5643a;
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (RubySpan rubySpan : (RubySpan[]) spanned.getSpans(0, spanned.length(), RubySpan.class)) {
                    rubySpan.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(RubySpan.f5648c, rubySpan.f5650a);
                    bundle2.putInt(RubySpan.f5649d, rubySpan.f5651b);
                    arrayList.add(CustomSpanBundler.a(spanned, rubySpan, 1, bundle2));
                }
                for (TextEmphasisSpan textEmphasisSpan : (TextEmphasisSpan[]) spanned.getSpans(0, spanned.length(), TextEmphasisSpan.class)) {
                    textEmphasisSpan.getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(TextEmphasisSpan.f5652d, textEmphasisSpan.f5655a);
                    bundle3.putInt(TextEmphasisSpan.f5653e, textEmphasisSpan.f5656b);
                    bundle3.putInt(TextEmphasisSpan.f5654f, textEmphasisSpan.f5657c);
                    arrayList.add(CustomSpanBundler.a(spanned, textEmphasisSpan, 2, bundle3));
                }
                for (HorizontalTextInVerticalContextSpan horizontalTextInVerticalContextSpan : (HorizontalTextInVerticalContextSpan[]) spanned.getSpans(0, spanned.length(), HorizontalTextInVerticalContextSpan.class)) {
                    arrayList.add(CustomSpanBundler.a(spanned, horizontalTextInVerticalContextSpan, 3, null));
                }
                if (!arrayList.isEmpty()) {
                    bundle.putParcelableArrayList(s, arrayList);
                }
            }
        }
        bundle.putSerializable(t, this.f5613b);
        bundle.putSerializable(u, this.f5614c);
        bundle.putFloat(x, this.f5616e);
        bundle.putInt(y, this.f5617f);
        bundle.putInt(z, this.f5618g);
        bundle.putFloat(A, this.f5619h);
        bundle.putInt(B, this.f5620i);
        bundle.putInt(C, this.n);
        bundle.putFloat(D, this.o);
        bundle.putFloat(E, this.f5621j);
        bundle.putFloat(F, this.f5622k);
        bundle.putBoolean(H, this.f5623l);
        bundle.putInt(G, this.f5624m);
        bundle.putInt(I, this.p);
        bundle.putFloat(J, this.q);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        if (!TextUtils.equals(this.f5612a, cue.f5612a) || this.f5613b != cue.f5613b || this.f5614c != cue.f5614c) {
            return false;
        }
        Bitmap bitmap = cue.f5615d;
        Bitmap bitmap2 = this.f5615d;
        if (bitmap2 == null) {
            if (bitmap != null) {
                return false;
            }
        } else if (bitmap == null || !bitmap2.sameAs(bitmap)) {
            return false;
        }
        return this.f5616e == cue.f5616e && this.f5617f == cue.f5617f && this.f5618g == cue.f5618g && this.f5619h == cue.f5619h && this.f5620i == cue.f5620i && this.f5621j == cue.f5621j && this.f5622k == cue.f5622k && this.f5623l == cue.f5623l && this.f5624m == cue.f5624m && this.n == cue.n && this.o == cue.o && this.p == cue.p && this.q == cue.q;
    }

    public final int hashCode() {
        Float fValueOf = Float.valueOf(this.f5616e);
        Integer numValueOf = Integer.valueOf(this.f5617f);
        Integer numValueOf2 = Integer.valueOf(this.f5618g);
        Float fValueOf2 = Float.valueOf(this.f5619h);
        Integer numValueOf3 = Integer.valueOf(this.f5620i);
        Float fValueOf3 = Float.valueOf(this.f5621j);
        Float fValueOf4 = Float.valueOf(this.f5622k);
        Boolean boolValueOf = Boolean.valueOf(this.f5623l);
        Integer numValueOf4 = Integer.valueOf(this.f5624m);
        Integer numValueOf5 = Integer.valueOf(this.n);
        Float fValueOf5 = Float.valueOf(this.o);
        Integer numValueOf6 = Integer.valueOf(this.p);
        Float fValueOf6 = Float.valueOf(this.q);
        return Arrays.hashCode(new Object[]{this.f5612a, this.f5613b, this.f5614c, this.f5615d, fValueOf, numValueOf, numValueOf2, fValueOf2, numValueOf3, fValueOf3, fValueOf4, boolValueOf, numValueOf4, numValueOf5, fValueOf5, numValueOf6, fValueOf6});
    }
}
