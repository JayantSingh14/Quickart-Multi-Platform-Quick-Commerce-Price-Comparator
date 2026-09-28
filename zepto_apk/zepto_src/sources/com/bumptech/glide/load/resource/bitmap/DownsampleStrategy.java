package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* loaded from: classes3.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f16267a;

    /* renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f16268b;

    /* renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f16269c;

    /* renamed from: d, reason: collision with root package name */
    public static final Option f16270d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f16271e;

    public static class AtLeast extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.f16273b;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    public static class AtMost extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.f16272a;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            int iCeil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    public static class CenterInside extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? SampleSizeRounding.f16273b : DownsampleStrategy.f16267a.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.f16267a.b(i2, i3, i4, i5));
        }
    }

    public static class CenterOutside extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.f16273b;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    public static class FitCenter extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return DownsampleStrategy.f16271e ? SampleSizeRounding.f16273b : SampleSizeRounding.f16272a;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f16271e) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    public static class None extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.f16273b;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SampleSizeRounding {

        /* renamed from: a, reason: collision with root package name */
        public static final SampleSizeRounding f16272a;

        /* renamed from: b, reason: collision with root package name */
        public static final SampleSizeRounding f16273b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ SampleSizeRounding[] f16274c;

        static {
            SampleSizeRounding sampleSizeRounding = new SampleSizeRounding("MEMORY", 0);
            f16272a = sampleSizeRounding;
            SampleSizeRounding sampleSizeRounding2 = new SampleSizeRounding("QUALITY", 1);
            f16273b = sampleSizeRounding2;
            f16274c = new SampleSizeRounding[]{sampleSizeRounding, sampleSizeRounding2};
        }

        public static SampleSizeRounding valueOf(String str) {
            return (SampleSizeRounding) Enum.valueOf(SampleSizeRounding.class, str);
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) f16274c.clone();
        }
    }

    static {
        new AtLeast();
        new AtMost();
        f16267a = new FitCenter();
        new CenterInside();
        CenterOutside centerOutside = new CenterOutside();
        f16268b = new None();
        f16269c = centerOutside;
        f16270d = Option.a(centerOutside, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f16271e = true;
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
