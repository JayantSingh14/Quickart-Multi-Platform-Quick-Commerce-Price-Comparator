package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class MediaItem {

    /* renamed from: g, reason: collision with root package name */
    public static final MediaItem f5250g = new Builder().a();

    /* renamed from: h, reason: collision with root package name */
    public static final String f5251h = Integer.toString(0, 36);

    /* renamed from: i, reason: collision with root package name */
    public static final String f5252i = Integer.toString(1, 36);

    /* renamed from: j, reason: collision with root package name */
    public static final String f5253j = Integer.toString(2, 36);

    /* renamed from: k, reason: collision with root package name */
    public static final String f5254k = Integer.toString(3, 36);

    /* renamed from: l, reason: collision with root package name */
    public static final String f5255l = Integer.toString(4, 36);

    /* renamed from: m, reason: collision with root package name */
    public static final String f5256m = Integer.toString(5, 36);

    /* renamed from: a, reason: collision with root package name */
    public final String f5257a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalConfiguration f5258b;

    /* renamed from: c, reason: collision with root package name */
    public final LiveConfiguration f5259c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaMetadata f5260d;

    /* renamed from: e, reason: collision with root package name */
    public final ClippingProperties f5261e;

    /* renamed from: f, reason: collision with root package name */
    public final RequestMetadata f5262f;

    public static final class AdsConfiguration {

        /* renamed from: b, reason: collision with root package name */
        public static final String f5263b;

        /* renamed from: a, reason: collision with root package name */
        public final Uri f5264a;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final Uri f5265a;

            public Builder(Uri uri) {
                this.f5265a = uri;
            }

            public final AdsConfiguration a() {
                return new AdsConfiguration(this);
            }
        }

        static {
            int i2 = Util.f5744a;
            f5263b = Integer.toString(0, 36);
        }

        public AdsConfiguration(Builder builder) {
            this.f5264a = builder.f5265a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration) || !this.f5264a.equals(((AdsConfiguration) obj).f5264a)) {
                return false;
            }
            int i2 = Util.f5744a;
            return true;
        }

        public final int hashCode() {
            return this.f5264a.hashCode() * 31;
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f5266a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f5267b;

        /* renamed from: c, reason: collision with root package name */
        public String f5268c;

        /* renamed from: g, reason: collision with root package name */
        public String f5272g;

        /* renamed from: i, reason: collision with root package name */
        public AdsConfiguration f5274i;

        /* renamed from: k, reason: collision with root package name */
        public MediaMetadata f5276k;

        /* renamed from: d, reason: collision with root package name */
        public ClippingConfiguration.Builder f5269d = new ClippingConfiguration.Builder();

        /* renamed from: e, reason: collision with root package name */
        public DrmConfiguration.Builder f5270e = new DrmConfiguration.Builder();

        /* renamed from: f, reason: collision with root package name */
        public List f5271f = Collections.EMPTY_LIST;

        /* renamed from: h, reason: collision with root package name */
        public ImmutableList f5273h = ImmutableList.r();

        /* renamed from: l, reason: collision with root package name */
        public LiveConfiguration.Builder f5277l = new LiveConfiguration.Builder();

        /* renamed from: m, reason: collision with root package name */
        public RequestMetadata f5278m = RequestMetadata.f5347d;

        /* renamed from: j, reason: collision with root package name */
        public long f5275j = -9223372036854775807L;

        public final MediaItem a() {
            LocalConfiguration localConfiguration;
            DrmConfiguration.Builder builder = this.f5270e;
            Assertions.g(builder.f5311b == null || builder.f5310a != null);
            Uri uri = this.f5267b;
            if (uri != null) {
                String str = this.f5268c;
                DrmConfiguration.Builder builder2 = this.f5270e;
                localConfiguration = new LocalConfiguration(uri, str, builder2.f5310a != null ? new DrmConfiguration(builder2) : null, this.f5274i, this.f5271f, this.f5272g, this.f5273h, this.f5275j);
            } else {
                localConfiguration = null;
            }
            String str2 = this.f5266a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingConfiguration.Builder builder3 = this.f5269d;
            builder3.getClass();
            ClippingProperties clippingProperties = new ClippingProperties(builder3);
            LiveConfiguration.Builder builder4 = this.f5277l;
            builder4.getClass();
            LiveConfiguration liveConfiguration = new LiveConfiguration(builder4);
            MediaMetadata mediaMetadata = this.f5276k;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.J;
            }
            return new MediaItem(str3, clippingProperties, localConfiguration, liveConfiguration, mediaMetadata, this.f5278m);
        }

        public final void b(AdsConfiguration adsConfiguration) {
            this.f5274i = adsConfiguration;
        }

        public final void c(LiveConfiguration liveConfiguration) {
            this.f5277l = liveConfiguration.a();
        }

        public final void d(MediaMetadata mediaMetadata) {
            this.f5276k = mediaMetadata;
        }

        public final void e(List list) {
            this.f5271f = (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
        }

        public final void f(ArrayList arrayList) {
            this.f5273h = ImmutableList.o(arrayList);
        }

        public final void g(Uri uri) {
            this.f5267b = uri;
        }
    }

    public static class ClippingConfiguration {

        /* renamed from: h, reason: collision with root package name */
        public static final ClippingConfiguration f5279h = new ClippingConfiguration(new Builder());

        /* renamed from: i, reason: collision with root package name */
        public static final String f5280i = Integer.toString(0, 36);

        /* renamed from: j, reason: collision with root package name */
        public static final String f5281j = Integer.toString(1, 36);

        /* renamed from: k, reason: collision with root package name */
        public static final String f5282k = Integer.toString(2, 36);

        /* renamed from: l, reason: collision with root package name */
        public static final String f5283l = Integer.toString(3, 36);

        /* renamed from: m, reason: collision with root package name */
        public static final String f5284m = Integer.toString(4, 36);
        public static final String n = Integer.toString(5, 36);
        public static final String o = Integer.toString(6, 36);

        /* renamed from: a, reason: collision with root package name */
        public final long f5285a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5286b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5287c;

        /* renamed from: d, reason: collision with root package name */
        public final long f5288d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f5289e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f5290f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f5291g;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public long f5292a;

            /* renamed from: b, reason: collision with root package name */
            public long f5293b = Long.MIN_VALUE;

            /* renamed from: c, reason: collision with root package name */
            public boolean f5294c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f5295d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f5296e;
        }

        public ClippingConfiguration(Builder builder) {
            this.f5285a = Util.j0(builder.f5292a);
            this.f5287c = Util.j0(builder.f5293b);
            this.f5286b = builder.f5292a;
            this.f5288d = builder.f5293b;
            this.f5289e = builder.f5294c;
            this.f5290f = builder.f5295d;
            this.f5291g = builder.f5296e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            return this.f5286b == clippingConfiguration.f5286b && this.f5288d == clippingConfiguration.f5288d && this.f5289e == clippingConfiguration.f5289e && this.f5290f == clippingConfiguration.f5290f && this.f5291g == clippingConfiguration.f5291g;
        }

        public final int hashCode() {
            long j2 = this.f5286b;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            long j3 = this.f5288d;
            return ((((((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.f5289e ? 1 : 0)) * 31) + (this.f5290f ? 1 : 0)) * 31) + (this.f5291g ? 1 : 0);
        }
    }

    @UnstableApi
    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties p = new ClippingProperties(new ClippingConfiguration.Builder());
    }

    public static final class DrmConfiguration {

        /* renamed from: i, reason: collision with root package name */
        public static final String f5297i;

        /* renamed from: j, reason: collision with root package name */
        public static final String f5298j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5299k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5300l;

        /* renamed from: m, reason: collision with root package name */
        public static final String f5301m;
        public static final String n;
        public static final String o;
        public static final String p;

        /* renamed from: a, reason: collision with root package name */
        public final UUID f5302a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f5303b;

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableMap f5304c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f5305d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f5306e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f5307f;

        /* renamed from: g, reason: collision with root package name */
        public final ImmutableList f5308g;

        /* renamed from: h, reason: collision with root package name */
        public final byte[] f5309h;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public UUID f5310a;

            /* renamed from: b, reason: collision with root package name */
            public Uri f5311b;

            /* renamed from: d, reason: collision with root package name */
            public boolean f5313d;

            /* renamed from: f, reason: collision with root package name */
            public boolean f5315f;

            /* renamed from: h, reason: collision with root package name */
            public byte[] f5317h;

            /* renamed from: c, reason: collision with root package name */
            public ImmutableMap f5312c = ImmutableMap.j();

            /* renamed from: e, reason: collision with root package name */
            public boolean f5314e = true;

            /* renamed from: g, reason: collision with root package name */
            public ImmutableList f5316g = ImmutableList.r();
        }

        static {
            int i2 = Util.f5744a;
            f5297i = Integer.toString(0, 36);
            f5298j = Integer.toString(1, 36);
            f5299k = Integer.toString(2, 36);
            f5300l = Integer.toString(3, 36);
            f5301m = Integer.toString(4, 36);
            n = Integer.toString(5, 36);
            o = Integer.toString(6, 36);
            p = Integer.toString(7, 36);
        }

        public DrmConfiguration(Builder builder) {
            Assertions.g((builder.f5315f && builder.f5311b == null) ? false : true);
            UUID uuid = builder.f5310a;
            uuid.getClass();
            this.f5302a = uuid;
            this.f5303b = builder.f5311b;
            this.f5304c = builder.f5312c;
            this.f5305d = builder.f5313d;
            this.f5307f = builder.f5315f;
            this.f5306e = builder.f5314e;
            this.f5308g = builder.f5316g;
            byte[] bArr = builder.f5317h;
            this.f5309h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public final Builder a() {
            Builder builder = new Builder();
            builder.f5310a = this.f5302a;
            builder.f5311b = this.f5303b;
            builder.f5312c = this.f5304c;
            builder.f5313d = this.f5305d;
            builder.f5314e = this.f5306e;
            builder.f5315f = this.f5307f;
            builder.f5316g = this.f5308g;
            builder.f5317h = this.f5309h;
            return builder;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.f5302a.equals(drmConfiguration.f5302a) && Util.a(this.f5303b, drmConfiguration.f5303b) && Util.a(this.f5304c, drmConfiguration.f5304c) && this.f5305d == drmConfiguration.f5305d && this.f5307f == drmConfiguration.f5307f && this.f5306e == drmConfiguration.f5306e && this.f5308g.equals(drmConfiguration.f5308g) && Arrays.equals(this.f5309h, drmConfiguration.f5309h);
        }

        public final int hashCode() {
            int iHashCode = this.f5302a.hashCode() * 31;
            Uri uri = this.f5303b;
            return Arrays.hashCode(this.f5309h) + ((this.f5308g.hashCode() + ((((((((this.f5304c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.f5305d ? 1 : 0)) * 31) + (this.f5307f ? 1 : 0)) * 31) + (this.f5306e ? 1 : 0)) * 31)) * 31);
        }
    }

    public static final class LiveConfiguration {

        /* renamed from: f, reason: collision with root package name */
        public static final LiveConfiguration f5318f = new LiveConfiguration(new Builder());

        /* renamed from: g, reason: collision with root package name */
        public static final String f5319g;

        /* renamed from: h, reason: collision with root package name */
        public static final String f5320h;

        /* renamed from: i, reason: collision with root package name */
        public static final String f5321i;

        /* renamed from: j, reason: collision with root package name */
        public static final String f5322j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5323k;

        /* renamed from: a, reason: collision with root package name */
        public final long f5324a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5325b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5326c;

        /* renamed from: d, reason: collision with root package name */
        public final float f5327d;

        /* renamed from: e, reason: collision with root package name */
        public final float f5328e;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public long f5329a = -9223372036854775807L;

            /* renamed from: b, reason: collision with root package name */
            public long f5330b = -9223372036854775807L;

            /* renamed from: c, reason: collision with root package name */
            public long f5331c = -9223372036854775807L;

            /* renamed from: d, reason: collision with root package name */
            public float f5332d = -3.4028235E38f;

            /* renamed from: e, reason: collision with root package name */
            public float f5333e = -3.4028235E38f;

            public final LiveConfiguration a() {
                return new LiveConfiguration(this);
            }
        }

        static {
            int i2 = Util.f5744a;
            f5319g = Integer.toString(0, 36);
            f5320h = Integer.toString(1, 36);
            f5321i = Integer.toString(2, 36);
            f5322j = Integer.toString(3, 36);
            f5323k = Integer.toString(4, 36);
        }

        public LiveConfiguration(Builder builder) {
            long j2 = builder.f5329a;
            long j3 = builder.f5330b;
            long j4 = builder.f5331c;
            float f2 = builder.f5332d;
            float f3 = builder.f5333e;
            this.f5324a = j2;
            this.f5325b = j3;
            this.f5326c = j4;
            this.f5327d = f2;
            this.f5328e = f3;
        }

        public static LiveConfiguration b(Bundle bundle) {
            Builder builder = new Builder();
            LiveConfiguration liveConfiguration = f5318f;
            builder.f5329a = bundle.getLong(f5319g, liveConfiguration.f5324a);
            builder.f5330b = bundle.getLong(f5320h, liveConfiguration.f5325b);
            builder.f5331c = bundle.getLong(f5321i, liveConfiguration.f5326c);
            builder.f5332d = bundle.getFloat(f5322j, liveConfiguration.f5327d);
            builder.f5333e = bundle.getFloat(f5323k, liveConfiguration.f5328e);
            return new LiveConfiguration(builder);
        }

        public final Builder a() {
            Builder builder = new Builder();
            builder.f5329a = this.f5324a;
            builder.f5330b = this.f5325b;
            builder.f5331c = this.f5326c;
            builder.f5332d = this.f5327d;
            builder.f5333e = this.f5328e;
            return builder;
        }

        public final Bundle c() {
            Bundle bundle = new Bundle();
            LiveConfiguration liveConfiguration = f5318f;
            long j2 = liveConfiguration.f5324a;
            long j3 = this.f5324a;
            if (j3 != j2) {
                bundle.putLong(f5319g, j3);
            }
            long j4 = liveConfiguration.f5325b;
            long j5 = this.f5325b;
            if (j5 != j4) {
                bundle.putLong(f5320h, j5);
            }
            long j6 = liveConfiguration.f5326c;
            long j7 = this.f5326c;
            if (j7 != j6) {
                bundle.putLong(f5321i, j7);
            }
            float f2 = liveConfiguration.f5327d;
            float f3 = this.f5327d;
            if (f3 != f2) {
                bundle.putFloat(f5322j, f3);
            }
            float f4 = liveConfiguration.f5328e;
            float f5 = this.f5328e;
            if (f5 != f4) {
                bundle.putFloat(f5323k, f5);
            }
            return bundle;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            return this.f5324a == liveConfiguration.f5324a && this.f5325b == liveConfiguration.f5325b && this.f5326c == liveConfiguration.f5326c && this.f5327d == liveConfiguration.f5327d && this.f5328e == liveConfiguration.f5328e;
        }

        public final int hashCode() {
            long j2 = this.f5324a;
            long j3 = this.f5325b;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f5326c;
            int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
            float f2 = this.f5327d;
            int iFloatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.f5328e;
            return iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
        }
    }

    public static final class LocalConfiguration {

        /* renamed from: i, reason: collision with root package name */
        public static final String f5334i;

        /* renamed from: j, reason: collision with root package name */
        public static final String f5335j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5336k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5337l;

        /* renamed from: m, reason: collision with root package name */
        public static final String f5338m;
        public static final String n;
        public static final String o;
        public static final String p;

        /* renamed from: a, reason: collision with root package name */
        public final Uri f5339a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5340b;

        /* renamed from: c, reason: collision with root package name */
        public final DrmConfiguration f5341c;

        /* renamed from: d, reason: collision with root package name */
        public final AdsConfiguration f5342d;

        /* renamed from: e, reason: collision with root package name */
        public final List f5343e;

        /* renamed from: f, reason: collision with root package name */
        public final String f5344f;

        /* renamed from: g, reason: collision with root package name */
        public final ImmutableList f5345g;

        /* renamed from: h, reason: collision with root package name */
        public final long f5346h;

        static {
            int i2 = Util.f5744a;
            f5334i = Integer.toString(0, 36);
            f5335j = Integer.toString(1, 36);
            f5336k = Integer.toString(2, 36);
            f5337l = Integer.toString(3, 36);
            f5338m = Integer.toString(4, 36);
            n = Integer.toString(5, 36);
            o = Integer.toString(6, 36);
            p = Integer.toString(7, 36);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List list, String str2, ImmutableList immutableList, long j2) {
            this.f5339a = uri;
            this.f5340b = MimeTypes.p(str);
            this.f5341c = drmConfiguration;
            this.f5342d = adsConfiguration;
            this.f5343e = list;
            this.f5344f = str2;
            this.f5345g = immutableList;
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) immutableList.get(i2);
                SubtitleConfiguration.Builder builder2 = new SubtitleConfiguration.Builder();
                builder2.f5370a = subtitleConfiguration.f5363a;
                builder2.f5371b = subtitleConfiguration.f5364b;
                builder2.f5372c = subtitleConfiguration.f5365c;
                builder2.f5373d = subtitleConfiguration.f5366d;
                builder2.f5374e = subtitleConfiguration.f5367e;
                builder2.f5375f = subtitleConfiguration.f5368f;
                builder2.f5376g = subtitleConfiguration.f5369g;
                builder.h(new Subtitle(builder2));
            }
            builder.j();
            this.f5346h = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            return this.f5339a.equals(localConfiguration.f5339a) && Util.a(this.f5340b, localConfiguration.f5340b) && Util.a(this.f5341c, localConfiguration.f5341c) && Util.a(this.f5342d, localConfiguration.f5342d) && this.f5343e.equals(localConfiguration.f5343e) && Util.a(this.f5344f, localConfiguration.f5344f) && this.f5345g.equals(localConfiguration.f5345g) && Long.valueOf(this.f5346h).equals(Long.valueOf(localConfiguration.f5346h));
        }

        public final int hashCode() {
            int iHashCode = this.f5339a.hashCode() * 31;
            String str = this.f5340b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.f5341c;
            int iHashCode3 = (iHashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31;
            AdsConfiguration adsConfiguration = this.f5342d;
            int iHashCode4 = (this.f5343e.hashCode() + ((iHashCode3 + (adsConfiguration == null ? 0 : adsConfiguration.hashCode())) * 31)) * 31;
            return (int) (((this.f5345g.hashCode() + ((iHashCode4 + (this.f5344f != null ? r0.hashCode() : 0)) * 31)) * 31 * 31) + this.f5346h);
        }
    }

    public static final class RequestMetadata {

        /* renamed from: d, reason: collision with root package name */
        public static final RequestMetadata f5347d = new RequestMetadata(new Builder());

        /* renamed from: e, reason: collision with root package name */
        public static final String f5348e;

        /* renamed from: f, reason: collision with root package name */
        public static final String f5349f;

        /* renamed from: g, reason: collision with root package name */
        public static final String f5350g;

        /* renamed from: a, reason: collision with root package name */
        public final Uri f5351a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5352b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f5353c;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public Uri f5354a;

            /* renamed from: b, reason: collision with root package name */
            public String f5355b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f5356c;
        }

        static {
            int i2 = Util.f5744a;
            f5348e = Integer.toString(0, 36);
            f5349f = Integer.toString(1, 36);
            f5350g = Integer.toString(2, 36);
        }

        public RequestMetadata(Builder builder) {
            this.f5351a = builder.f5354a;
            this.f5352b = builder.f5355b;
            this.f5353c = builder.f5356c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Util.a(this.f5351a, requestMetadata.f5351a) && Util.a(this.f5352b, requestMetadata.f5352b)) {
                if ((this.f5353c == null) == (requestMetadata.f5353c == null)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Uri uri = this.f5351a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f5352b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f5353c != null ? 1 : 0);
        }
    }

    @UnstableApi
    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
    }

    public static class SubtitleConfiguration {

        /* renamed from: h, reason: collision with root package name */
        public static final String f5357h;

        /* renamed from: i, reason: collision with root package name */
        public static final String f5358i;

        /* renamed from: j, reason: collision with root package name */
        public static final String f5359j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5360k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5361l;

        /* renamed from: m, reason: collision with root package name */
        public static final String f5362m;
        public static final String n;

        /* renamed from: a, reason: collision with root package name */
        public final Uri f5363a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5364b;

        /* renamed from: c, reason: collision with root package name */
        public final String f5365c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5366d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5367e;

        /* renamed from: f, reason: collision with root package name */
        public final String f5368f;

        /* renamed from: g, reason: collision with root package name */
        public final String f5369g;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public Uri f5370a;

            /* renamed from: b, reason: collision with root package name */
            public String f5371b;

            /* renamed from: c, reason: collision with root package name */
            public String f5372c;

            /* renamed from: d, reason: collision with root package name */
            public int f5373d;

            /* renamed from: e, reason: collision with root package name */
            public int f5374e;

            /* renamed from: f, reason: collision with root package name */
            public String f5375f;

            /* renamed from: g, reason: collision with root package name */
            public String f5376g;

            public Builder(Uri uri) {
                this.f5370a = uri;
            }

            public final SubtitleConfiguration a() {
                return new SubtitleConfiguration(this);
            }

            public final void b(String str) {
                this.f5375f = str;
            }

            public final void c(String str) {
                this.f5372c = str;
            }

            public final void d(String str) {
                this.f5371b = MimeTypes.p(str);
            }

            public final void e() {
                this.f5374e = 128;
            }

            public final void f() {
                this.f5373d = 1;
            }
        }

        static {
            int i2 = Util.f5744a;
            f5357h = Integer.toString(0, 36);
            f5358i = Integer.toString(1, 36);
            f5359j = Integer.toString(2, 36);
            f5360k = Integer.toString(3, 36);
            f5361l = Integer.toString(4, 36);
            f5362m = Integer.toString(5, 36);
            n = Integer.toString(6, 36);
        }

        public SubtitleConfiguration(Builder builder) {
            this.f5363a = builder.f5370a;
            this.f5364b = builder.f5371b;
            this.f5365c = builder.f5372c;
            this.f5366d = builder.f5373d;
            this.f5367e = builder.f5374e;
            this.f5368f = builder.f5375f;
            this.f5369g = builder.f5376g;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            return this.f5363a.equals(subtitleConfiguration.f5363a) && Util.a(this.f5364b, subtitleConfiguration.f5364b) && Util.a(this.f5365c, subtitleConfiguration.f5365c) && this.f5366d == subtitleConfiguration.f5366d && this.f5367e == subtitleConfiguration.f5367e && Util.a(this.f5368f, subtitleConfiguration.f5368f) && Util.a(this.f5369g, subtitleConfiguration.f5369g);
        }

        public final int hashCode() {
            int iHashCode = this.f5363a.hashCode() * 31;
            String str = this.f5364b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f5365c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f5366d) * 31) + this.f5367e) * 31;
            String str3 = this.f5368f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f5369g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public MediaItem(String str, ClippingProperties clippingProperties, LocalConfiguration localConfiguration, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.f5257a = str;
        this.f5258b = localConfiguration;
        this.f5259c = liveConfiguration;
        this.f5260d = mediaMetadata;
        this.f5261e = clippingProperties;
        this.f5262f = requestMetadata;
    }

    public static MediaItem b(Bundle bundle) {
        ClippingProperties clippingProperties;
        RequestMetadata requestMetadata;
        ImmutableMap immutableMapA;
        DrmConfiguration drmConfiguration;
        AdsConfiguration adsConfiguration;
        ImmutableList immutableListJ;
        LocalConfiguration localConfiguration;
        String string = bundle.getString(f5251h, "");
        string.getClass();
        Bundle bundle2 = bundle.getBundle(f5252i);
        LiveConfiguration liveConfigurationB = bundle2 == null ? LiveConfiguration.f5318f : LiveConfiguration.b(bundle2);
        Bundle bundle3 = bundle.getBundle(f5253j);
        MediaMetadata mediaMetadataB = bundle3 == null ? MediaMetadata.J : MediaMetadata.b(bundle3);
        Bundle bundle4 = bundle.getBundle(f5254k);
        if (bundle4 == null) {
            clippingProperties = ClippingProperties.p;
        } else {
            ClippingConfiguration.Builder builder = new ClippingConfiguration.Builder();
            ClippingConfiguration clippingConfiguration = ClippingConfiguration.f5279h;
            long jT = Util.T(bundle4.getLong(ClippingConfiguration.f5280i, clippingConfiguration.f5285a));
            Assertions.a(jT >= 0);
            builder.f5292a = jT;
            long jT2 = Util.T(bundle4.getLong(ClippingConfiguration.f5281j, clippingConfiguration.f5287c));
            Assertions.a(jT2 == Long.MIN_VALUE || jT2 >= 0);
            builder.f5293b = jT2;
            builder.f5294c = bundle4.getBoolean(ClippingConfiguration.f5282k, clippingConfiguration.f5289e);
            builder.f5295d = bundle4.getBoolean(ClippingConfiguration.f5283l, clippingConfiguration.f5290f);
            builder.f5296e = bundle4.getBoolean(ClippingConfiguration.f5284m, clippingConfiguration.f5291g);
            String str = ClippingConfiguration.n;
            long j2 = clippingConfiguration.f5286b;
            long j3 = bundle4.getLong(str, j2);
            if (j3 != j2) {
                Assertions.a(j3 >= 0);
                builder.f5292a = j3;
            }
            String str2 = ClippingConfiguration.o;
            long j4 = clippingConfiguration.f5288d;
            long j5 = bundle4.getLong(str2, j4);
            if (j5 != j4) {
                Assertions.a(j5 == Long.MIN_VALUE || j5 >= 0);
                builder.f5293b = j5;
            }
            clippingProperties = new ClippingProperties(builder);
        }
        ClippingProperties clippingProperties2 = clippingProperties;
        Bundle bundle5 = bundle.getBundle(f5255l);
        if (bundle5 == null) {
            requestMetadata = RequestMetadata.f5347d;
        } else {
            RequestMetadata requestMetadata2 = RequestMetadata.f5347d;
            RequestMetadata.Builder builder2 = new RequestMetadata.Builder();
            builder2.f5354a = (Uri) bundle5.getParcelable(RequestMetadata.f5348e);
            builder2.f5355b = bundle5.getString(RequestMetadata.f5349f);
            builder2.f5356c = bundle5.getBundle(RequestMetadata.f5350g);
            requestMetadata = new RequestMetadata(builder2);
        }
        RequestMetadata requestMetadata3 = requestMetadata;
        Bundle bundle6 = bundle.getBundle(f5256m);
        if (bundle6 == null) {
            localConfiguration = null;
        } else {
            Bundle bundle7 = bundle6.getBundle(LocalConfiguration.f5336k);
            if (bundle7 == null) {
                drmConfiguration = null;
            } else {
                String string2 = bundle7.getString(DrmConfiguration.f5297i);
                string2.getClass();
                UUID uuidFromString = UUID.fromString(string2);
                Uri uri = (Uri) bundle7.getParcelable(DrmConfiguration.f5298j);
                Bundle bundle8 = Bundle.EMPTY;
                Bundle bundle9 = bundle7.getBundle(DrmConfiguration.f5299k);
                if (bundle9 == null) {
                    bundle9 = bundle8;
                }
                if (bundle9 == bundle8) {
                    immutableMapA = ImmutableMap.j();
                } else {
                    HashMap map = new HashMap();
                    if (bundle9 != bundle8) {
                        for (String str3 : bundle9.keySet()) {
                            String string3 = bundle9.getString(str3);
                            if (string3 != null) {
                                map.put(str3, string3);
                            }
                        }
                    }
                    immutableMapA = ImmutableMap.a(map);
                }
                boolean z = bundle7.getBoolean(DrmConfiguration.f5300l, false);
                boolean z2 = bundle7.getBoolean(DrmConfiguration.f5301m, false);
                boolean z3 = bundle7.getBoolean(DrmConfiguration.n, false);
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> integerArrayList = bundle7.getIntegerArrayList(DrmConfiguration.o);
                if (integerArrayList != null) {
                    arrayList = integerArrayList;
                }
                ImmutableList immutableListO = ImmutableList.o(arrayList);
                byte[] byteArray = bundle7.getByteArray(DrmConfiguration.p);
                DrmConfiguration.Builder builder3 = new DrmConfiguration.Builder();
                builder3.f5310a = uuidFromString;
                builder3.f5311b = uri;
                builder3.f5312c = ImmutableMap.a(immutableMapA);
                builder3.f5313d = z;
                builder3.f5315f = z3;
                builder3.f5314e = z2;
                builder3.f5316g = ImmutableList.o(immutableListO);
                builder3.f5317h = byteArray != null ? Arrays.copyOf(byteArray, byteArray.length) : null;
                drmConfiguration = new DrmConfiguration(builder3);
            }
            Bundle bundle10 = bundle6.getBundle(LocalConfiguration.f5337l);
            if (bundle10 == null) {
                adsConfiguration = null;
            } else {
                Uri uri2 = (Uri) bundle10.getParcelable(AdsConfiguration.f5263b);
                uri2.getClass();
                adsConfiguration = new AdsConfiguration(new AdsConfiguration.Builder(uri2));
            }
            ArrayList parcelableArrayList = bundle6.getParcelableArrayList(LocalConfiguration.f5338m);
            if (parcelableArrayList == null) {
                immutableListJ = ImmutableList.r();
            } else {
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder4 = new ImmutableList.Builder();
                for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                    Bundle bundle11 = (Bundle) parcelableArrayList.get(i2);
                    bundle11.getClass();
                    builder4.h(new StreamKey(bundle11.getInt(StreamKey.f5456d, 0), bundle11.getInt(StreamKey.f5457e, 0), bundle11.getInt(StreamKey.f5458f, 0)));
                }
                immutableListJ = builder4.j();
            }
            ImmutableList immutableList = immutableListJ;
            ArrayList parcelableArrayList2 = bundle6.getParcelableArrayList(LocalConfiguration.o);
            ImmutableList immutableListR = parcelableArrayList2 == null ? ImmutableList.r() : BundleCollectionUtil.a(new b(2), parcelableArrayList2);
            long j6 = bundle6.getLong(LocalConfiguration.p, -9223372036854775807L);
            Uri uri3 = (Uri) bundle6.getParcelable(LocalConfiguration.f5334i);
            uri3.getClass();
            localConfiguration = new LocalConfiguration(uri3, bundle6.getString(LocalConfiguration.f5335j), drmConfiguration, adsConfiguration, immutableList, bundle6.getString(LocalConfiguration.n), immutableListR, j6);
        }
        return new MediaItem(string, clippingProperties2, localConfiguration, liveConfigurationB, mediaMetadataB, requestMetadata3);
    }

    public final Builder a() {
        Builder builder = new Builder();
        ClippingConfiguration.Builder builder2 = new ClippingConfiguration.Builder();
        ClippingProperties clippingProperties = this.f5261e;
        builder2.f5292a = clippingProperties.f5286b;
        builder2.f5293b = clippingProperties.f5288d;
        builder2.f5294c = clippingProperties.f5289e;
        builder2.f5295d = clippingProperties.f5290f;
        builder2.f5296e = clippingProperties.f5291g;
        builder.f5269d = builder2;
        builder.f5266a = this.f5257a;
        builder.f5276k = this.f5260d;
        builder.f5277l = this.f5259c.a();
        builder.f5278m = this.f5262f;
        LocalConfiguration localConfiguration = this.f5258b;
        if (localConfiguration != null) {
            builder.f5272g = localConfiguration.f5344f;
            builder.f5268c = localConfiguration.f5340b;
            builder.f5267b = localConfiguration.f5339a;
            builder.f5271f = localConfiguration.f5343e;
            builder.f5273h = localConfiguration.f5345g;
            DrmConfiguration drmConfiguration = localConfiguration.f5341c;
            builder.f5270e = drmConfiguration != null ? drmConfiguration.a() : new DrmConfiguration.Builder();
            builder.f5274i = localConfiguration.f5342d;
            builder.f5275j = localConfiguration.f5346h;
        }
        return builder;
    }

    public final Bundle c(boolean z) {
        LocalConfiguration localConfiguration;
        Bundle bundle = new Bundle();
        String str = this.f5257a;
        if (!str.equals("")) {
            bundle.putString(f5251h, str);
        }
        LiveConfiguration liveConfiguration = LiveConfiguration.f5318f;
        LiveConfiguration liveConfiguration2 = this.f5259c;
        if (!liveConfiguration2.equals(liveConfiguration)) {
            bundle.putBundle(f5252i, liveConfiguration2.c());
        }
        MediaMetadata mediaMetadata = MediaMetadata.J;
        MediaMetadata mediaMetadata2 = this.f5260d;
        if (!mediaMetadata2.equals(mediaMetadata)) {
            bundle.putBundle(f5253j, mediaMetadata2.c());
        }
        ClippingConfiguration clippingConfiguration = ClippingConfiguration.f5279h;
        ClippingProperties clippingProperties = this.f5261e;
        if (!clippingProperties.equals(clippingConfiguration)) {
            Bundle bundle2 = new Bundle();
            long j2 = clippingConfiguration.f5285a;
            long j3 = clippingProperties.f5285a;
            if (j3 != j2) {
                bundle2.putLong(ClippingConfiguration.f5280i, j3);
            }
            long j4 = clippingConfiguration.f5287c;
            long j5 = clippingProperties.f5287c;
            if (j5 != j4) {
                bundle2.putLong(ClippingConfiguration.f5281j, j5);
            }
            long j6 = clippingConfiguration.f5286b;
            long j7 = clippingProperties.f5286b;
            if (j7 != j6) {
                bundle2.putLong(ClippingConfiguration.n, j7);
            }
            long j8 = clippingConfiguration.f5288d;
            long j9 = clippingProperties.f5288d;
            if (j9 != j8) {
                bundle2.putLong(ClippingConfiguration.o, j9);
            }
            boolean z2 = clippingConfiguration.f5289e;
            boolean z3 = clippingProperties.f5289e;
            if (z3 != z2) {
                bundle2.putBoolean(ClippingConfiguration.f5282k, z3);
            }
            boolean z4 = clippingConfiguration.f5290f;
            boolean z5 = clippingProperties.f5290f;
            if (z5 != z4) {
                bundle2.putBoolean(ClippingConfiguration.f5283l, z5);
            }
            boolean z6 = clippingConfiguration.f5291g;
            boolean z7 = clippingProperties.f5291g;
            if (z7 != z6) {
                bundle2.putBoolean(ClippingConfiguration.f5284m, z7);
            }
            bundle.putBundle(f5254k, bundle2);
        }
        RequestMetadata requestMetadata = RequestMetadata.f5347d;
        RequestMetadata requestMetadata2 = this.f5262f;
        if (!requestMetadata2.equals(requestMetadata)) {
            Bundle bundle3 = new Bundle();
            Uri uri = requestMetadata2.f5351a;
            if (uri != null) {
                bundle3.putParcelable(RequestMetadata.f5348e, uri);
            }
            String str2 = requestMetadata2.f5352b;
            if (str2 != null) {
                bundle3.putString(RequestMetadata.f5349f, str2);
            }
            Bundle bundle4 = requestMetadata2.f5353c;
            if (bundle4 != null) {
                bundle3.putBundle(RequestMetadata.f5350g, bundle4);
            }
            bundle.putBundle(f5255l, bundle3);
        }
        if (z && (localConfiguration = this.f5258b) != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putParcelable(LocalConfiguration.f5334i, localConfiguration.f5339a);
            String str3 = localConfiguration.f5340b;
            if (str3 != null) {
                bundle5.putString(LocalConfiguration.f5335j, str3);
            }
            DrmConfiguration drmConfiguration = localConfiguration.f5341c;
            if (drmConfiguration != null) {
                Bundle bundle6 = new Bundle();
                bundle6.putString(DrmConfiguration.f5297i, drmConfiguration.f5302a.toString());
                Uri uri2 = drmConfiguration.f5303b;
                if (uri2 != null) {
                    bundle6.putParcelable(DrmConfiguration.f5298j, uri2);
                }
                ImmutableMap immutableMap = drmConfiguration.f5304c;
                if (!immutableMap.isEmpty()) {
                    Bundle bundle7 = new Bundle();
                    Iterator it = immutableMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        bundle7.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                    bundle6.putBundle(DrmConfiguration.f5299k, bundle7);
                }
                boolean z8 = drmConfiguration.f5305d;
                if (z8) {
                    bundle6.putBoolean(DrmConfiguration.f5300l, z8);
                }
                boolean z9 = drmConfiguration.f5306e;
                if (z9) {
                    bundle6.putBoolean(DrmConfiguration.f5301m, z9);
                }
                boolean z10 = drmConfiguration.f5307f;
                if (z10) {
                    bundle6.putBoolean(DrmConfiguration.n, z10);
                }
                ImmutableList immutableList = drmConfiguration.f5308g;
                if (!immutableList.isEmpty()) {
                    bundle6.putIntegerArrayList(DrmConfiguration.o, new ArrayList<>(immutableList));
                }
                byte[] bArr = drmConfiguration.f5309h;
                if (bArr != null) {
                    bundle6.putByteArray(DrmConfiguration.p, bArr);
                }
                bundle5.putBundle(LocalConfiguration.f5336k, bundle6);
            }
            AdsConfiguration adsConfiguration = localConfiguration.f5342d;
            if (adsConfiguration != null) {
                Bundle bundle8 = new Bundle();
                bundle8.putParcelable(AdsConfiguration.f5263b, adsConfiguration.f5264a);
                bundle5.putBundle(LocalConfiguration.f5337l, bundle8);
            }
            List list = localConfiguration.f5343e;
            if (!list.isEmpty()) {
                bundle5.putParcelableArrayList(LocalConfiguration.f5338m, BundleCollectionUtil.b(list, new b(0)));
            }
            String str4 = localConfiguration.f5344f;
            if (str4 != null) {
                bundle5.putString(LocalConfiguration.n, str4);
            }
            ImmutableList immutableList2 = localConfiguration.f5345g;
            if (!immutableList2.isEmpty()) {
                bundle5.putParcelableArrayList(LocalConfiguration.o, BundleCollectionUtil.b(immutableList2, new b(1)));
            }
            long j10 = localConfiguration.f5346h;
            if (j10 != -9223372036854775807L) {
                bundle5.putLong(LocalConfiguration.p, j10);
            }
            bundle.putBundle(f5256m, bundle5);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Util.a(this.f5257a, mediaItem.f5257a) && this.f5261e.equals(mediaItem.f5261e) && Util.a(this.f5258b, mediaItem.f5258b) && Util.a(this.f5259c, mediaItem.f5259c) && Util.a(this.f5260d, mediaItem.f5260d) && Util.a(this.f5262f, mediaItem.f5262f);
    }

    public final int hashCode() {
        int iHashCode = this.f5257a.hashCode() * 31;
        LocalConfiguration localConfiguration = this.f5258b;
        return this.f5262f.hashCode() + ((this.f5260d.hashCode() + ((this.f5261e.hashCode() + ((this.f5259c.hashCode() + ((iHashCode + (localConfiguration != null ? localConfiguration.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }
}
