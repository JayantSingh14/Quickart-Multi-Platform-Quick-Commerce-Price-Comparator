package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.brentvatne.common.api.CMCDProps;
import com.brentvatne.exoplayer.CMCDConfig;
import com.brentvatne.exoplayer.CMCDConfig$createCmcdConfiguration$1;
import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

@UnstableApi
/* loaded from: classes3.dex */
public final class CmcdData {

    /* renamed from: f, reason: collision with root package name */
    public static final Joiner f8069f = new Joiner(",");

    /* renamed from: a, reason: collision with root package name */
    public final CmcdObject f8070a;

    /* renamed from: b, reason: collision with root package name */
    public final CmcdRequest f8071b;

    /* renamed from: c, reason: collision with root package name */
    public final CmcdSession f8072c;

    /* renamed from: d, reason: collision with root package name */
    public final CmcdStatus f8073d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8074e;

    public static final class CmcdObject {

        /* renamed from: a, reason: collision with root package name */
        public final int f8075a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8076b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8077c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8078d;

        /* renamed from: e, reason: collision with root package name */
        public final ImmutableList f8079e;

        public static final class Builder {

            /* renamed from: d, reason: collision with root package name */
            public String f8083d;

            /* renamed from: a, reason: collision with root package name */
            public int f8080a = -2147483647;

            /* renamed from: b, reason: collision with root package name */
            public int f8081b = -2147483647;

            /* renamed from: c, reason: collision with root package name */
            public long f8082c = -9223372036854775807L;

            /* renamed from: e, reason: collision with root package name */
            public ImmutableList f8084e = ImmutableList.r();
        }

        public CmcdObject(Builder builder) {
            this.f8075a = builder.f8080a;
            this.f8076b = builder.f8081b;
            this.f8077c = builder.f8082c;
            this.f8078d = builder.f8083d;
            this.f8079e = builder.f8084e;
        }
    }

    public static final class CmcdRequest {

        /* renamed from: a, reason: collision with root package name */
        public final long f8085a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8086b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8087c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8088d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8089e;

        /* renamed from: f, reason: collision with root package name */
        public final String f8090f;

        /* renamed from: g, reason: collision with root package name */
        public final ImmutableList f8091g;

        public static final class Builder {

            /* renamed from: d, reason: collision with root package name */
            public boolean f8095d;

            /* renamed from: e, reason: collision with root package name */
            public String f8096e;

            /* renamed from: f, reason: collision with root package name */
            public String f8097f;

            /* renamed from: a, reason: collision with root package name */
            public long f8092a = -9223372036854775807L;

            /* renamed from: b, reason: collision with root package name */
            public long f8093b = -2147483647L;

            /* renamed from: c, reason: collision with root package name */
            public long f8094c = -9223372036854775807L;

            /* renamed from: g, reason: collision with root package name */
            public ImmutableList f8098g = ImmutableList.r();
        }

        public CmcdRequest(Builder builder) {
            this.f8085a = builder.f8092a;
            this.f8086b = builder.f8093b;
            this.f8087c = builder.f8094c;
            this.f8088d = builder.f8095d;
            this.f8089e = builder.f8096e;
            this.f8090f = builder.f8097f;
            this.f8091g = builder.f8098g;
        }
    }

    public static final class CmcdSession {

        /* renamed from: a, reason: collision with root package name */
        public final String f8099a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8100b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8101c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8102d;

        /* renamed from: e, reason: collision with root package name */
        public final float f8103e;

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableList f8104f;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public String f8105a;

            /* renamed from: b, reason: collision with root package name */
            public String f8106b;

            /* renamed from: c, reason: collision with root package name */
            public String f8107c;

            /* renamed from: d, reason: collision with root package name */
            public String f8108d;

            /* renamed from: e, reason: collision with root package name */
            public float f8109e;

            /* renamed from: f, reason: collision with root package name */
            public ImmutableList f8110f = ImmutableList.r();
        }

        public CmcdSession(Builder builder) {
            this.f8099a = builder.f8105a;
            this.f8100b = builder.f8106b;
            this.f8101c = builder.f8107c;
            this.f8102d = builder.f8108d;
            this.f8103e = builder.f8109e;
            this.f8104f = builder.f8110f;
        }
    }

    public static final class CmcdStatus {

        /* renamed from: a, reason: collision with root package name */
        public final int f8111a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8112b;

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableList f8113c;

        public static final class Builder {

            /* renamed from: b, reason: collision with root package name */
            public boolean f8115b;

            /* renamed from: a, reason: collision with root package name */
            public int f8114a = -2147483647;

            /* renamed from: c, reason: collision with root package name */
            public ImmutableList f8116c = ImmutableList.r();
        }

        public CmcdStatus(Builder builder) {
            this.f8111a = builder.f8114a;
            this.f8112b = builder.f8115b;
            this.f8113c = builder.f8116c;
        }
    }

    public static final class Factory {

        /* renamed from: m, reason: collision with root package name */
        public static final Pattern f8117m = Pattern.compile(".*-.*");

        /* renamed from: a, reason: collision with root package name */
        public final CmcdConfiguration f8118a;

        /* renamed from: b, reason: collision with root package name */
        public final ExoTrackSelection f8119b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8120c;

        /* renamed from: d, reason: collision with root package name */
        public final float f8121d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8122e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f8123f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8124g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f8125h;

        /* renamed from: i, reason: collision with root package name */
        public long f8126i;

        /* renamed from: j, reason: collision with root package name */
        public String f8127j;

        /* renamed from: k, reason: collision with root package name */
        public String f8128k;

        /* renamed from: l, reason: collision with root package name */
        public String f8129l;

        public Factory(CmcdConfiguration cmcdConfiguration, ExoTrackSelection exoTrackSelection, long j2, float f2, String str, boolean z, boolean z2, boolean z3) {
            Assertions.a(j2 >= 0);
            Assertions.a(f2 == -3.4028235E38f || f2 > 0.0f);
            this.f8118a = cmcdConfiguration;
            this.f8119b = exoTrackSelection;
            this.f8120c = j2;
            this.f8121d = f2;
            this.f8122e = str;
            this.f8123f = z;
            this.f8124g = z2;
            this.f8125h = z3;
            this.f8126i = -9223372036854775807L;
        }

        public static String b(ExoTrackSelection exoTrackSelection) {
            Assertions.a(exoTrackSelection != null);
            int i2 = MimeTypes.i(exoTrackSelection.r().f5225m);
            if (i2 == -1) {
                i2 = MimeTypes.i(exoTrackSelection.r().f5224l);
            }
            if (i2 == 1) {
                return "a";
            }
            if (i2 == 2) {
                return "v";
            }
            return null;
        }

        public final CmcdData a() {
            ExoTrackSelection exoTrackSelection;
            CmcdConfiguration cmcdConfiguration = this.f8118a;
            CMCDConfig cMCDConfig = cmcdConfiguration.f8067c.f15520a;
            cMCDConfig.getClass();
            ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
            CMCDProps cMCDProps = cMCDConfig.f15519a;
            CMCDConfig.a(builder, "CMCD-Object", cMCDProps.f15363a);
            CMCDConfig.a(builder, "CMCD-Request", cMCDProps.f15364b);
            CMCDConfig.a(builder, "CMCD-Session", cMCDProps.f15365c);
            CMCDConfig.a(builder, "CMCD-Status", cMCDProps.f15366d);
            ImmutableListMultimap immutableListMultimapA = builder.a();
            Intrinsics.checkNotNullExpressionValue(immutableListMultimapA, "build(...)");
            ImmutableMap immutableMap = immutableListMultimapA.f42686e;
            UnmodifiableIterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                for (String str : immutableListMultimapA.get((String) it.next())) {
                    int i2 = Util.f5744a;
                    Assertions.g(f8117m.matcher(str.split("=", -1)[0]).matches());
                }
            }
            ExoTrackSelection exoTrackSelection2 = this.f8119b;
            int iG = Util.g(exoTrackSelection2.r().f5221i, 1000);
            CmcdObject.Builder builder2 = new CmcdObject.Builder();
            String str2 = this.f8127j;
            boolean z = str2 != null && str2.equals("i");
            boolean z2 = true;
            CMCDConfig$createCmcdConfiguration$1 cMCDConfig$createCmcdConfiguration$1 = cmcdConfiguration.f8067c;
            if (z) {
                exoTrackSelection = exoTrackSelection2;
            } else {
                cMCDConfig$createCmcdConfiguration$1.getClass();
                Assertions.a(iG >= 0 || iG == -2147483647);
                builder2.f8080a = iG;
                cMCDConfig$createCmcdConfiguration$1.getClass();
                TrackGroup trackGroupM = exoTrackSelection2.m();
                int iMax = exoTrackSelection2.r().f5221i;
                for (int i3 = 0; i3 < trackGroupM.f5501a; i3++) {
                    iMax = Math.max(iMax, trackGroupM.f5504d[i3].f5221i);
                }
                int iG2 = Util.g(iMax, 1000);
                Assertions.a(iG2 >= 0 || iG2 == -2147483647);
                builder2.f8081b = iG2;
                cMCDConfig$createCmcdConfiguration$1.getClass();
                exoTrackSelection = exoTrackSelection2;
                long jJ0 = Util.j0(this.f8126i);
                Assertions.a(jJ0 >= 0 || jJ0 == -9223372036854775807L);
                builder2.f8082c = jJ0;
            }
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder2.f8083d = this.f8127j;
            if (immutableMap.containsKey("CMCD-Object")) {
                builder2.f8084e = ImmutableList.o(immutableListMultimapA.get("CMCD-Object"));
            }
            CmcdRequest.Builder builder3 = new CmcdRequest.Builder();
            String str3 = this.f8127j;
            boolean z3 = str3 != null && str3.equals("i");
            long j2 = this.f8120c;
            if (!z3) {
                cMCDConfig$createCmcdConfiguration$1.getClass();
                long jJ02 = Util.j0(j2);
                Assertions.a(jJ02 >= 0 || jJ02 == -9223372036854775807L);
                builder3.f8092a = ((jJ02 + 50) / 100) * 100;
            }
            cMCDConfig$createCmcdConfiguration$1.getClass();
            if (exoTrackSelection.a() != -2147483647L) {
                long jA = (exoTrackSelection.a() + 999) / 1000;
                Assertions.a(jA >= 0 || jA == -2147483647L);
                builder3.f8093b = ((jA + 50) / 100) * 100;
            }
            cMCDConfig$createCmcdConfiguration$1.getClass();
            float f2 = this.f8121d;
            long jJ03 = Util.j0((long) (j2 / f2));
            Assertions.a(jJ03 >= 0 || jJ03 == -9223372036854775807L);
            builder3.f8094c = ((jJ03 + 50) / 100) * 100;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            boolean z4 = this.f8124g;
            builder3.f8095d = z4 || this.f8125h;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            String str4 = this.f8128k;
            builder3.f8096e = str4 == null ? null : Uri.encode(str4);
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder3.f8097f = this.f8129l;
            if (immutableMap.containsKey("CMCD-Request")) {
                builder3.f8098g = ImmutableList.o(immutableListMultimapA.get("CMCD-Request"));
            }
            CmcdSession.Builder builder4 = new CmcdSession.Builder();
            cMCDConfig$createCmcdConfiguration$1.getClass();
            String str5 = cmcdConfiguration.f8066b;
            Assertions.a(str5 == null || str5.length() <= 64);
            builder4.f8105a = str5;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            String str6 = cmcdConfiguration.f8065a;
            Assertions.a(str6 == null || str6.length() <= 64);
            builder4.f8106b = str6;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder4.f8107c = this.f8122e;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder4.f8108d = this.f8123f ? "l" : "v";
            cMCDConfig$createCmcdConfiguration$1.getClass();
            if (f2 <= 0.0f && f2 != -3.4028235E38f) {
                z2 = false;
            }
            Assertions.a(z2);
            builder4.f8109e = f2;
            if (immutableMap.containsKey("CMCD-Session")) {
                builder4.f8110f = ImmutableList.o(immutableListMultimapA.get("CMCD-Session"));
            }
            CmcdStatus.Builder builder5 = new CmcdStatus.Builder();
            cMCDConfig$createCmcdConfiguration$1.getClass();
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder5.f8114a = -2147483647;
            cMCDConfig$createCmcdConfiguration$1.getClass();
            builder5.f8115b = z4;
            if (immutableMap.containsKey("CMCD-Status")) {
                builder5.f8116c = ImmutableList.o(immutableListMultimapA.get("CMCD-Status"));
            }
            return new CmcdData(new CmcdObject(builder2), new CmcdRequest(builder3), new CmcdSession(builder4), new CmcdStatus(builder5), cmcdConfiguration.f8068d);
        }

        public final void c(long j2) {
            Assertions.a(j2 >= 0);
            this.f8126i = j2;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ObjectType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamingFormat {
    }

    public CmcdData(CmcdObject cmcdObject, CmcdRequest cmcdRequest, CmcdSession cmcdSession, CmcdStatus cmcdStatus, int i2) {
        this.f8070a = cmcdObject;
        this.f8071b = cmcdRequest;
        this.f8072c = cmcdSession;
        this.f8073d = cmcdStatus;
        this.f8074e = i2;
    }

    public final DataSpec a(DataSpec dataSpec) {
        ArrayListMultimap arrayListMultimap = new ArrayListMultimap();
        CmcdObject cmcdObject = this.f8070a;
        ArrayList arrayList = new ArrayList();
        int i2 = cmcdObject.f8075a;
        if (i2 != -2147483647) {
            arrayList.add("br=" + i2);
        }
        int i3 = cmcdObject.f8076b;
        if (i3 != -2147483647) {
            arrayList.add("tb=" + i3);
        }
        long j2 = cmcdObject.f8077c;
        if (j2 != -9223372036854775807L) {
            arrayList.add("d=" + j2);
        }
        String str = cmcdObject.f8078d;
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("ot=" + str);
        }
        arrayList.addAll(cmcdObject.f8079e);
        if (!arrayList.isEmpty()) {
            arrayListMultimap.t("CMCD-Object", arrayList);
        }
        CmcdRequest cmcdRequest = this.f8071b;
        ArrayList arrayList2 = new ArrayList();
        long j3 = cmcdRequest.f8085a;
        if (j3 != -9223372036854775807L) {
            arrayList2.add("bl=" + j3);
        }
        long j4 = cmcdRequest.f8086b;
        if (j4 != -2147483647L) {
            arrayList2.add("mtp=" + j4);
        }
        long j5 = cmcdRequest.f8087c;
        if (j5 != -9223372036854775807L) {
            arrayList2.add("dl=" + j5);
        }
        if (cmcdRequest.f8088d) {
            arrayList2.add("su");
        }
        String str2 = cmcdRequest.f8089e;
        if (!TextUtils.isEmpty(str2)) {
            int i4 = Util.f5744a;
            Locale locale = Locale.US;
            arrayList2.add("nor=\"" + str2 + "\"");
        }
        String str3 = cmcdRequest.f8090f;
        if (!TextUtils.isEmpty(str3)) {
            int i5 = Util.f5744a;
            Locale locale2 = Locale.US;
            arrayList2.add("nrr=\"" + str3 + "\"");
        }
        arrayList2.addAll(cmcdRequest.f8091g);
        if (!arrayList2.isEmpty()) {
            arrayListMultimap.t("CMCD-Request", arrayList2);
        }
        CmcdSession cmcdSession = this.f8072c;
        ArrayList arrayList3 = new ArrayList();
        String str4 = cmcdSession.f8099a;
        if (!TextUtils.isEmpty(str4)) {
            int i6 = Util.f5744a;
            Locale locale3 = Locale.US;
            arrayList3.add("cid=\"" + str4 + "\"");
        }
        String str5 = cmcdSession.f8100b;
        if (!TextUtils.isEmpty(str5)) {
            int i7 = Util.f5744a;
            Locale locale4 = Locale.US;
            arrayList3.add("sid=\"" + str5 + "\"");
        }
        String str6 = cmcdSession.f8101c;
        if (!TextUtils.isEmpty(str6)) {
            arrayList3.add("sf=" + str6);
        }
        String str7 = cmcdSession.f8102d;
        if (!TextUtils.isEmpty(str7)) {
            arrayList3.add("st=" + str7);
        }
        float f2 = cmcdSession.f8103e;
        if (f2 != -3.4028235E38f && f2 != 1.0f) {
            Object[] objArr = {"pr", Float.valueOf(f2)};
            int i8 = Util.f5744a;
            arrayList3.add(String.format(Locale.US, "%s=%.2f", objArr));
        }
        arrayList3.addAll(cmcdSession.f8104f);
        if (!arrayList3.isEmpty()) {
            arrayListMultimap.t("CMCD-Session", arrayList3);
        }
        CmcdStatus cmcdStatus = this.f8073d;
        ArrayList arrayList4 = new ArrayList();
        int i9 = cmcdStatus.f8111a;
        if (i9 != -2147483647) {
            arrayList4.add("rtp=" + i9);
        }
        if (cmcdStatus.f8112b) {
            arrayList4.add("bs");
        }
        arrayList4.addAll(cmcdStatus.f8113c);
        if (!arrayList4.isEmpty()) {
            arrayListMultimap.t("CMCD-Status", arrayList4);
        }
        Joiner joiner = f8069f;
        if (this.f8074e != 0) {
            ArrayList arrayList5 = new ArrayList();
            Iterator it = arrayListMultimap.asMap().values().iterator();
            while (it.hasNext()) {
                arrayList5.addAll((Collection) it.next());
            }
            Collections.sort(arrayList5);
            Uri.Builder builderAppendQueryParameter = dataSpec.f5851a.buildUpon().appendQueryParameter("CMCD", joiner.c(arrayList5));
            DataSpec.Builder builderA = dataSpec.a();
            builderA.f5860a = builderAppendQueryParameter.build();
            return builderA.a();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        for (String str8 : arrayListMultimap.keySet()) {
            List list = arrayListMultimap.l((Object) str8);
            Collections.sort(list);
            builder.c(str8, joiner.c(list));
        }
        ImmutableMap immutableMapA = builder.a(true);
        HashMap map = new HashMap(dataSpec.f5855e);
        map.putAll(immutableMapA);
        return new DataSpec(dataSpec.f5851a, dataSpec.f5852b, dataSpec.f5853c, dataSpec.f5854d, map, dataSpec.f5856f, dataSpec.f5857g, dataSpec.f5858h, dataSpec.f5859i);
    }
}
