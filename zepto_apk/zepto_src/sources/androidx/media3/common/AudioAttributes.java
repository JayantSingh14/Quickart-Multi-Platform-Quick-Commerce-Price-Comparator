package androidx.media3.common;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
public final class AudioAttributes {

    /* renamed from: g, reason: collision with root package name */
    public static final AudioAttributes f5143g = new Builder().a();

    /* renamed from: h, reason: collision with root package name */
    public static final String f5144h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f5145i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f5146j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f5147k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f5148l;

    /* renamed from: a, reason: collision with root package name */
    public final int f5149a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5150b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5151c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5152d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5153e;

    /* renamed from: f, reason: collision with root package name */
    public AudioAttributesV21 f5154f;

    @RequiresApi
    public static final class Api29 {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i2) {
            builder.setAllowedCapturePolicy(i2);
        }
    }

    @RequiresApi
    public static final class Api32 {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i2) {
            builder.setSpatializationBehavior(i2);
        }
    }

    @RequiresApi
    public static final class AudioAttributesV21 {

        /* renamed from: a, reason: collision with root package name */
        public final android.media.AudioAttributes f5155a;

        public AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.f5149a).setFlags(audioAttributes.f5150b).setUsage(audioAttributes.f5151c);
            int i2 = Util.f5744a;
            if (i2 >= 29) {
                Api29.a(usage, audioAttributes.f5152d);
            }
            if (i2 >= 32) {
                Api32.a(usage, audioAttributes.f5153e);
            }
            this.f5155a = usage.build();
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f5156a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f5157b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f5158c = 1;

        /* renamed from: d, reason: collision with root package name */
        public int f5159d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f5160e = 0;

        public final AudioAttributes a() {
            return new AudioAttributes(this.f5156a, this.f5157b, this.f5158c, this.f5159d, this.f5160e);
        }

        public final void b(int i2) {
            this.f5156a = i2;
        }

        public final void c(int i2) {
            this.f5158c = i2;
        }
    }

    static {
        int i2 = Util.f5744a;
        f5144h = Integer.toString(0, 36);
        f5145i = Integer.toString(1, 36);
        f5146j = Integer.toString(2, 36);
        f5147k = Integer.toString(3, 36);
        f5148l = Integer.toString(4, 36);
    }

    public AudioAttributes(int i2, int i3, int i4, int i5, int i6) {
        this.f5149a = i2;
        this.f5150b = i3;
        this.f5151c = i4;
        this.f5152d = i5;
        this.f5153e = i6;
    }

    public static AudioAttributes a(Bundle bundle) {
        Builder builder = new Builder();
        String str = f5144h;
        if (bundle.containsKey(str)) {
            builder.f5156a = bundle.getInt(str);
        }
        String str2 = f5145i;
        if (bundle.containsKey(str2)) {
            builder.f5157b = bundle.getInt(str2);
        }
        String str3 = f5146j;
        if (bundle.containsKey(str3)) {
            builder.f5158c = bundle.getInt(str3);
        }
        String str4 = f5147k;
        if (bundle.containsKey(str4)) {
            builder.f5159d = bundle.getInt(str4);
        }
        String str5 = f5148l;
        if (bundle.containsKey(str5)) {
            builder.f5160e = bundle.getInt(str5);
        }
        return builder.a();
    }

    public final AudioAttributesV21 b() {
        if (this.f5154f == null) {
            this.f5154f = new AudioAttributesV21(this);
        }
        return this.f5154f;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(f5144h, this.f5149a);
        bundle.putInt(f5145i, this.f5150b);
        bundle.putInt(f5146j, this.f5151c);
        bundle.putInt(f5147k, this.f5152d);
        bundle.putInt(f5148l, this.f5153e);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioAttributes.class == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            if (this.f5149a == audioAttributes.f5149a && this.f5150b == audioAttributes.f5150b && this.f5151c == audioAttributes.f5151c && this.f5152d == audioAttributes.f5152d && this.f5153e == audioAttributes.f5153e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((527 + this.f5149a) * 31) + this.f5150b) * 31) + this.f5151c) * 31) + this.f5152d) * 31) + this.f5153e;
    }
}
