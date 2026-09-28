package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;

@RestrictTo
/* loaded from: classes3.dex */
public class DocumentData {

    /* renamed from: a, reason: collision with root package name */
    public String f14442a;

    /* renamed from: b, reason: collision with root package name */
    public String f14443b;

    /* renamed from: c, reason: collision with root package name */
    public float f14444c;

    /* renamed from: d, reason: collision with root package name */
    public Justification f14445d;

    /* renamed from: e, reason: collision with root package name */
    public int f14446e;

    /* renamed from: f, reason: collision with root package name */
    public float f14447f;

    /* renamed from: g, reason: collision with root package name */
    public float f14448g;

    /* renamed from: h, reason: collision with root package name */
    public int f14449h;

    /* renamed from: i, reason: collision with root package name */
    public int f14450i;

    /* renamed from: j, reason: collision with root package name */
    public float f14451j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14452k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f14453l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f14454m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Justification {

        /* renamed from: a, reason: collision with root package name */
        public static final Justification f14455a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Justification[] f14456b;

        /* JADX INFO: Fake field, exist only in values array */
        Justification EF0;

        static {
            Justification justification = new Justification("LEFT_ALIGN", 0);
            Justification justification2 = new Justification("RIGHT_ALIGN", 1);
            Justification justification3 = new Justification("CENTER", 2);
            f14455a = justification3;
            f14456b = new Justification[]{justification, justification2, justification3};
        }

        public static Justification valueOf(String str) {
            return (Justification) Enum.valueOf(Justification.class, str);
        }

        public static Justification[] values() {
            return (Justification[]) f14456b.clone();
        }
    }

    public final int hashCode() {
        int iOrdinal = ((this.f14445d.ordinal() + (((int) (e.e(this.f14442a.hashCode() * 31, 31, this.f14443b) + this.f14444c)) * 31)) * 31) + this.f14446e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f14447f);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f14449h;
    }
}
