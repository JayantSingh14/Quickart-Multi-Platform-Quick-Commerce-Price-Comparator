package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultTrackSelector extends MappingTrackSelector implements RendererCapabilities.Listener {

    /* renamed from: k, reason: collision with root package name */
    public static final Ordering f7974k = Ordering.b(new b(7));

    /* renamed from: d, reason: collision with root package name */
    public final Object f7975d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f7976e;

    /* renamed from: f, reason: collision with root package name */
    public final AdaptiveTrackSelection.Factory f7977f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7978g;

    /* renamed from: h, reason: collision with root package name */
    public Parameters f7979h;

    /* renamed from: i, reason: collision with root package name */
    public final SpatializerWrapperV32 f7980i;

    /* renamed from: j, reason: collision with root package name */
    public AudioAttributes f7981j;

    public static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {

        /* renamed from: e, reason: collision with root package name */
        public final int f7982e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f7983f;

        /* renamed from: g, reason: collision with root package name */
        public final String f7984g;

        /* renamed from: h, reason: collision with root package name */
        public final Parameters f7985h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f7986i;

        /* renamed from: j, reason: collision with root package name */
        public final int f7987j;

        /* renamed from: k, reason: collision with root package name */
        public final int f7988k;

        /* renamed from: l, reason: collision with root package name */
        public final int f7989l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f7990m;
        public final boolean n;
        public final int o;
        public final int p;
        public final boolean q;
        public final int r;
        public final int s;
        public final int t;
        public final int u;
        public final boolean v;
        public final boolean w;

        /* JADX WARN: Multi-variable type inference failed */
        public AudioTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, boolean z, e eVar, int i5) {
            int i6;
            int iM;
            int iM2;
            boolean z2;
            super(i2, trackGroup, i3);
            this.f7985h = parameters;
            int i7 = parameters.l0 ? 24 : 16;
            int i8 = 0;
            this.f7990m = false;
            this.f7984g = DefaultTrackSelector.p(this.f8015d.f5216d);
            this.f7986i = RendererCapabilities.e(i4, false);
            int i9 = 0;
            while (true) {
                ImmutableList immutableList = parameters.n;
                int size = immutableList.size();
                i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i9 >= size) {
                    iM = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM = DefaultTrackSelector.m(this.f8015d, (String) immutableList.get(i9), false);
                    if (iM > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.f7988k = i9;
            this.f7987j = iM;
            int i10 = this.f8015d.f5218f;
            int i11 = parameters.o;
            this.f7989l = (i10 == 0 || i10 != i11) ? Integer.bitCount(i10 & i11) : Integer.MAX_VALUE;
            Format format = this.f8015d;
            int i12 = format.f5218f;
            this.n = i12 == 0 || (i12 & 1) != 0;
            this.q = (format.f5217e & 1) != 0;
            int i13 = format.A;
            this.r = i13;
            this.s = format.B;
            int i14 = format.f5221i;
            this.t = i14;
            this.f7983f = (i14 == -1 || i14 <= parameters.q) && (i13 == -1 || i13 <= parameters.p) && eVar.apply(format);
            String[] strArrF = Util.F();
            int i15 = 0;
            while (true) {
                if (i15 >= strArrF.length) {
                    iM2 = 0;
                    i15 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM2 = DefaultTrackSelector.m(this.f8015d, strArrF[i15], false);
                    if (iM2 > 0) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.o = i15;
            this.p = iM2;
            int i16 = 0;
            while (true) {
                ImmutableList immutableList2 = parameters.r;
                if (i16 < immutableList2.size()) {
                    String str = this.f8015d.f5225m;
                    if (str != null && str.equals(immutableList2.get(i16))) {
                        i6 = i16;
                        break;
                    }
                    i16++;
                } else {
                    break;
                }
            }
            this.u = i6;
            this.v = (i4 & 384) == 128;
            this.w = (i4 & 64) == 64;
            Parameters parameters2 = this.f7985h;
            if (RendererCapabilities.e(i4, parameters2.n0) && ((z2 = this.f7983f) || parameters2.k0)) {
                TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences = parameters2.s;
                int i17 = audioOffloadPreferences.f5527a;
                Format format2 = this.f8015d;
                if (i17 != 2 || DefaultTrackSelector.q(parameters2, i4, format2)) {
                    i8 = (!RendererCapabilities.e(i4, false) || !z2 || format2.f5221i == -1 || parameters2.z || parameters2.y || (!parameters2.o0 && z) || audioOffloadPreferences.f5527a == 2 || (i7 & i4) == 0) ? 1 : 2;
                }
            }
            this.f7982e = i8;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int a() {
            return this.f7982e;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final boolean b(TrackInfo trackInfo) {
            int i2;
            String str;
            AudioTrackInfo audioTrackInfo = (AudioTrackInfo) trackInfo;
            this.f7985h.getClass();
            Format format = this.f8015d;
            int i3 = format.A;
            if (i3 == -1) {
                return false;
            }
            Format format2 = audioTrackInfo.f8015d;
            if (i3 != format2.A) {
                return false;
            }
            if ((this.f7990m || ((str = format.f5225m) != null && TextUtils.equals(str, format2.f5225m))) && (i2 = format.B) != -1 && i2 == format2.B) {
                return this.v == audioTrackInfo.v && this.w == audioTrackInfo.w;
            }
            return false;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final int compareTo(AudioTrackInfo audioTrackInfo) {
            boolean z = this.f7986i;
            boolean z2 = this.f7983f;
            Ordering orderingG = (z2 && z) ? DefaultTrackSelector.f7974k : DefaultTrackSelector.f7974k.g();
            ComparisonChain comparisonChainC = ComparisonChain.f42583a.d(z, audioTrackInfo.f7986i).c(Integer.valueOf(this.f7988k), Integer.valueOf(audioTrackInfo.f7988k), Ordering.c().g()).a(this.f7987j, audioTrackInfo.f7987j).a(this.f7989l, audioTrackInfo.f7989l).d(this.q, audioTrackInfo.q).d(this.n, audioTrackInfo.n).c(Integer.valueOf(this.o), Integer.valueOf(audioTrackInfo.o), Ordering.c().g()).a(this.p, audioTrackInfo.p).d(z2, audioTrackInfo.f7983f).c(Integer.valueOf(this.u), Integer.valueOf(audioTrackInfo.u), Ordering.c().g());
            boolean z3 = this.f7985h.y;
            int i2 = this.t;
            int i3 = audioTrackInfo.t;
            if (z3) {
                comparisonChainC = comparisonChainC.c(Integer.valueOf(i2), Integer.valueOf(i3), DefaultTrackSelector.f7974k.g());
            }
            ComparisonChain comparisonChainC2 = comparisonChainC.d(this.v, audioTrackInfo.v).d(this.w, audioTrackInfo.w).c(Integer.valueOf(this.r), Integer.valueOf(audioTrackInfo.r), orderingG).c(Integer.valueOf(this.s), Integer.valueOf(audioTrackInfo.s), orderingG);
            if (Util.a(this.f7984g, audioTrackInfo.f7984g)) {
                comparisonChainC2 = comparisonChainC2.c(Integer.valueOf(i2), Integer.valueOf(i3), orderingG);
            }
            return comparisonChainC2.f();
        }
    }

    public static final class ImageTrackInfo extends TrackInfo<ImageTrackInfo> implements Comparable<ImageTrackInfo> {

        /* renamed from: e, reason: collision with root package name */
        public final int f7991e;

        /* renamed from: f, reason: collision with root package name */
        public final int f7992f;

        public ImageTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4) {
            int i5;
            super(i2, trackGroup, i3);
            this.f7991e = RendererCapabilities.e(i4, parameters.n0) ? 1 : 0;
            Format format = this.f8015d;
            int i6 = format.s;
            int i7 = -1;
            if (i6 != -1 && (i5 = format.t) != -1) {
                i7 = i6 * i5;
            }
            this.f7992f = i7;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int a() {
            return this.f7991e;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final /* bridge */ /* synthetic */ boolean b(TrackInfo trackInfo) {
            return false;
        }

        @Override // java.lang.Comparable
        public final int compareTo(ImageTrackInfo imageTrackInfo) {
            return Integer.compare(this.f7992f, imageTrackInfo.f7992f);
        }
    }

    public static final class OtherTrackScore implements Comparable<OtherTrackScore> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f7993a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7994b;

        public OtherTrackScore(Format format, int i2) {
            this.f7993a = (format.f5217e & 1) != 0;
            this.f7994b = RendererCapabilities.e(i2, false);
        }

        @Override // java.lang.Comparable
        public final int compareTo(OtherTrackScore otherTrackScore) {
            OtherTrackScore otherTrackScore2 = otherTrackScore;
            return ComparisonChain.f42583a.d(this.f7994b, otherTrackScore2.f7994b).d(this.f7993a, otherTrackScore2.f7993a).f();
        }
    }

    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        public final Parameters.Builder C = new Parameters.Builder();

        @Deprecated
        public ParametersBuilder() {
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final void a(TrackSelectionOverride trackSelectionOverride) {
            this.C.A.put(trackSelectionOverride.f5508a, trackSelectionOverride);
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters b() {
            Parameters.Builder builder = this.C;
            builder.getClass();
            return new Parameters(builder);
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters.Builder c() {
            this.C.m();
            return this;
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters.Builder d(int i2) {
            this.C.n(i2);
            return this;
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters.Builder g() {
            this.C.v = -3;
            return this;
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters.Builder h(TrackSelectionOverride trackSelectionOverride) {
            this.C.t(trackSelectionOverride);
            return this;
        }

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        public final TrackSelectionParameters.Builder i(int i2) {
            this.C.v(i2);
            return this;
        }
    }

    public static final class SelectionOverride {

        /* renamed from: a, reason: collision with root package name */
        public static final String f7995a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f7996b;

        /* renamed from: c, reason: collision with root package name */
        public static final String f7997c;

        static {
            int i2 = Util.f5744a;
            f7995a = Integer.toString(0, 36);
            f7996b = Integer.toString(1, 36);
            f7997c = Integer.toString(2, 36);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SelectionOverride.class == obj.getClass()) {
                if (Arrays.equals((int[]) null, (int[]) null)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode((int[]) null) * 31;
        }
    }

    @RequiresApi
    public static class SpatializerWrapperV32 {

        /* renamed from: a, reason: collision with root package name */
        public final Spatializer f7998a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7999b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f8000c;

        /* renamed from: d, reason: collision with root package name */
        public Spatializer$OnSpatializerStateChangedListener f8001d;

        public SpatializerWrapperV32(Spatializer spatializer) {
            this.f7998a = spatializer;
            this.f7999b = spatializer.getImmersiveAudioLevel() != 0;
        }

        public final boolean a(AudioAttributes audioAttributes, Format format) throws IllegalArgumentException {
            boolean zEquals = "audio/eac3-joc".equals(format.f5225m);
            int i2 = format.A;
            if (zEquals && i2 == 16) {
                i2 = 12;
            }
            int iS = Util.s(i2);
            if (iS == 0) {
                return false;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iS);
            int i3 = format.B;
            if (i3 != -1) {
                channelMask.setSampleRate(i3);
            }
            return this.f7998a.canBeSpatialized(audioAttributes.b().f5155a, channelMask.build());
        }
    }

    public static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {

        /* renamed from: e, reason: collision with root package name */
        public final int f8003e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f8004f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8005g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f8006h;

        /* renamed from: i, reason: collision with root package name */
        public final int f8007i;

        /* renamed from: j, reason: collision with root package name */
        public final int f8008j;

        /* renamed from: k, reason: collision with root package name */
        public final int f8009k;

        /* renamed from: l, reason: collision with root package name */
        public final int f8010l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f8011m;

        /* JADX WARN: Multi-variable type inference failed */
        public TextTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, String str) {
            int iBitCount;
            int iM;
            super(i2, trackGroup, i3);
            int i5 = 0;
            this.f8004f = RendererCapabilities.e(i4, false);
            int i6 = this.f8015d.f5217e & (~parameters.v);
            this.f8005g = (i6 & 1) != 0;
            this.f8006h = (i6 & 2) != 0;
            ImmutableList immutableList = parameters.t;
            ImmutableList immutableListT = immutableList.isEmpty() ? ImmutableList.t("") : immutableList;
            int i7 = 0;
            while (true) {
                int size = immutableListT.size();
                iBitCount = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i7 >= size) {
                    iM = 0;
                    i7 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM = DefaultTrackSelector.m(this.f8015d, (String) immutableListT.get(i7), parameters.w);
                    if (iM > 0) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.f8007i = i7;
            this.f8008j = iM;
            int i8 = this.f8015d.f5218f;
            Ordering ordering = DefaultTrackSelector.f7974k;
            int i9 = parameters.u;
            iBitCount = (i8 == 0 || i8 != i9) ? Integer.bitCount(i8 & i9) : iBitCount;
            this.f8009k = iBitCount;
            this.f8011m = (this.f8015d.f5218f & 1088) != 0;
            int iM2 = DefaultTrackSelector.m(this.f8015d, str, DefaultTrackSelector.p(str) == null);
            this.f8010l = iM2;
            boolean z = iM > 0 || (immutableList.isEmpty() && iBitCount > 0) || this.f8005g || (this.f8006h && iM2 > 0);
            if (RendererCapabilities.e(i4, parameters.n0) && z) {
                i5 = 1;
            }
            this.f8003e = i5;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int a() {
            return this.f8003e;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final /* bridge */ /* synthetic */ boolean b(TrackInfo trackInfo) {
            return false;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain comparisonChainC = ComparisonChain.f42583a.d(this.f8004f, textTrackInfo.f8004f).c(Integer.valueOf(this.f8007i), Integer.valueOf(textTrackInfo.f8007i), Ordering.c().g());
            int i2 = this.f8008j;
            ComparisonChain comparisonChainA = comparisonChainC.a(i2, textTrackInfo.f8008j);
            int i3 = this.f8009k;
            ComparisonChain comparisonChainA2 = comparisonChainA.a(i3, textTrackInfo.f8009k).d(this.f8005g, textTrackInfo.f8005g).c(Boolean.valueOf(this.f8006h), Boolean.valueOf(textTrackInfo.f8006h), i2 == 0 ? Ordering.c() : Ordering.c().g()).a(this.f8010l, textTrackInfo.f8010l);
            if (i3 == 0) {
                comparisonChainA2 = comparisonChainA2.e(this.f8011m, textTrackInfo.f8011m);
            }
            return comparisonChainA2.f();
        }
    }

    public static abstract class TrackInfo<T extends TrackInfo<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final int f8012a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackGroup f8013b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8014c;

        /* renamed from: d, reason: collision with root package name */
        public final Format f8015d;

        public interface Factory<T extends TrackInfo<T>> {
            List a(int i2, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i2, TrackGroup trackGroup, int i3) {
            this.f8012a = i2;
            this.f8013b = trackGroup;
            this.f8014c = i3;
            this.f8015d = trackGroup.f5504d[i3];
        }

        public abstract int a();

        public abstract boolean b(TrackInfo trackInfo);
    }

    public static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8016e;

        /* renamed from: f, reason: collision with root package name */
        public final Parameters f8017f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8018g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f8019h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f8020i;

        /* renamed from: j, reason: collision with root package name */
        public final int f8021j;

        /* renamed from: k, reason: collision with root package name */
        public final int f8022k;

        /* renamed from: l, reason: collision with root package name */
        public final int f8023l;

        /* renamed from: m, reason: collision with root package name */
        public final int f8024m;
        public final boolean n;
        public final boolean o;
        public final int p;
        public final boolean q;
        public final boolean r;
        public final int s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public VideoTrackInfo(int r9, androidx.media3.common.TrackGroup r10, int r11, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters r12, int r13, int r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 430
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, androidx.media3.common.TrackGroup, int, androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters, int, int, boolean):void");
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int a() {
            return this.p;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final boolean b(TrackInfo trackInfo) {
            VideoTrackInfo videoTrackInfo = (VideoTrackInfo) trackInfo;
            if (!this.o && !Util.a(this.f8015d.f5225m, videoTrackInfo.f8015d.f5225m)) {
                return false;
            }
            this.f8017f.getClass();
            return this.q == videoTrackInfo.q && this.r == videoTrackInfo.r;
        }
    }

    public DefaultTrackSelector(Context context, AdaptiveTrackSelection.Factory factory) {
        Parameters parameters = Parameters.r0;
        Parameters parameters2 = new Parameters(new Parameters.Builder(context));
        this.f7975d = new Object();
        this.f7976e = context.getApplicationContext();
        this.f7977f = factory;
        this.f7979h = parameters2;
        this.f7981j = AudioAttributes.f5143g;
        boolean zR = Util.R(context);
        this.f7978g = zR;
        if (!zR && Util.f5744a >= 32) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.f7980i = audioManager == null ? null : new SpatializerWrapperV32(audioManager.getSpatializer());
        }
        boolean z = this.f7979h.m0;
    }

    public static void l(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, HashMap map) {
        for (int i2 = 0; i2 < trackGroupArray.f7771a; i2++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) trackSelectionParameters.A.get(trackGroupArray.a(i2));
            if (trackSelectionOverride != null) {
                TrackGroup trackGroup = trackSelectionOverride.f5508a;
                TrackSelectionOverride trackSelectionOverride2 = (TrackSelectionOverride) map.get(Integer.valueOf(trackGroup.f5503c));
                if (trackSelectionOverride2 == null || (trackSelectionOverride2.f5509b.isEmpty() && !trackSelectionOverride.f5509b.isEmpty())) {
                    map.put(Integer.valueOf(trackGroup.f5503c), trackSelectionOverride);
                }
            }
        }
    }

    public static int m(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f5216d)) {
            return 4;
        }
        String strP = p(str);
        String strP2 = p(format.f5216d);
        if (strP2 == null || strP == null) {
            return (z && strP2 == null) ? 1 : 0;
        }
        if (strP2.startsWith(strP) || strP.startsWith(strP2)) {
            return 3;
        }
        int i2 = Util.f5744a;
        return strP2.split("-", 2)[0].equals(strP.split("-", 2)[0]) ? 2 : 0;
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean q(Parameters parameters, int i2, Format format) {
        if ((i2 & 3584) == 0) {
            return false;
        }
        TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences = parameters.s;
        if (audioOffloadPreferences.f5529c && (i2 & 2048) == 0) {
            return false;
        }
        if (audioOffloadPreferences.f5528b) {
            boolean z = (format.D == 0 && format.E == 0) ? false : true;
            boolean z2 = (i2 & 1024) != 0;
            if (z && !z2) {
                return false;
            }
        }
        return true;
    }

    public static Pair r(int i2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory factory, Comparator comparator) {
        RandomAccess randomAccessT;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < mappedTrackInfo2.f8028a) {
            if (i2 == mappedTrackInfo2.f8029b[i3]) {
                TrackGroupArray trackGroupArray = mappedTrackInfo2.f8030c[i3];
                for (int i4 = 0; i4 < trackGroupArray.f7771a; i4++) {
                    TrackGroup trackGroupA = trackGroupArray.a(i4);
                    List listA = factory.a(i3, trackGroupA, iArr[i3][i4]);
                    int i5 = trackGroupA.f5501a;
                    boolean[] zArr = new boolean[i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        TrackInfo trackInfo = (TrackInfo) listA.get(i6);
                        int iA = trackInfo.a();
                        if (!zArr[i6] && iA != 0) {
                            boolean z = true;
                            if (iA == 1) {
                                randomAccessT = ImmutableList.t(trackInfo);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i7 = i6 + 1;
                                while (i7 < i5) {
                                    boolean z2 = z;
                                    TrackInfo trackInfo2 = (TrackInfo) listA.get(i7);
                                    if (trackInfo2.a() == 2 && trackInfo.b(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i7] = z2;
                                    }
                                    i7++;
                                    z = z2;
                                }
                                randomAccessT = arrayList2;
                            }
                            arrayList.add(randomAccessT);
                        }
                    }
                }
            }
            i3++;
            mappedTrackInfo2 = mappedTrackInfo;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((TrackInfo) list.get(i8)).f8014c;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.f8013b, iArr2), Integer.valueOf(trackInfo3.f8012a));
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities.Listener
    public final void a(Renderer renderer) {
        synchronized (this.f7975d) {
            this.f7979h.getClass();
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final RendererCapabilities.Listener c() {
        return this;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final void e() {
        SpatializerWrapperV32 spatializerWrapperV32;
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        synchronized (this.f7975d) {
            try {
                if (Util.f5744a >= 32 && (spatializerWrapperV32 = this.f7980i) != null && (spatializer$OnSpatializerStateChangedListener = spatializerWrapperV32.f8001d) != null && spatializerWrapperV32.f8000c != null) {
                    spatializerWrapperV32.f7998a.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
                    spatializerWrapperV32.f8000c.removeCallbacksAndMessages(null);
                    spatializerWrapperV32.f8000c = null;
                    spatializerWrapperV32.f8001d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.e();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final void g(AudioAttributes audioAttributes) {
        boolean zEquals;
        synchronized (this.f7975d) {
            zEquals = this.f7981j.equals(audioAttributes);
            this.f7981j = audioAttributes;
        }
        if (zEquals) {
            return;
        }
        o();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final void h(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            t((Parameters) trackSelectionParameters);
        }
        Parameters.Builder builder = new Parameters.Builder(b());
        builder.e(trackSelectionParameters);
        t(new Parameters(builder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022f  */
    @Override // androidx.media3.exoplayer.trackselection.MappingTrackSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair j(androidx.media3.exoplayer.trackselection.MappingTrackSelector.MappedTrackInfo r34, int[][][] r35, final int[] r36, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r37, androidx.media3.common.Timeline r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.j(androidx.media3.exoplayer.trackselection.MappingTrackSelector$MappedTrackInfo, int[][][], int[], androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, androidx.media3.common.Timeline):android.util.Pair");
    }

    public final Parameters.Builder k() {
        Parameters parametersB = b();
        parametersB.getClass();
        return new Parameters.Builder(parametersB);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final Parameters b() {
        Parameters parameters;
        synchronized (this.f7975d) {
            parameters = this.f7979h;
        }
        return parameters;
    }

    public final void o() {
        boolean z;
        TrackSelector.InvalidationListener invalidationListener;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f7975d) {
            try {
                z = this.f7979h.m0 && !this.f7978g && Util.f5744a >= 32 && (spatializerWrapperV32 = this.f7980i) != null && spatializerWrapperV32.f7999b;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z || (invalidationListener = this.f8037a) == null) {
            return;
        }
        invalidationListener.a();
    }

    public final void s(Parameters.Builder builder) {
        t(new Parameters(builder));
    }

    public final void t(Parameters parameters) {
        boolean zEquals;
        parameters.getClass();
        synchronized (this.f7975d) {
            zEquals = this.f7979h.equals(parameters);
            this.f7979h = parameters;
        }
        if (zEquals) {
            return;
        }
        if (parameters.m0 && this.f7976e == null) {
            Log.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        TrackSelector.InvalidationListener invalidationListener = this.f8037a;
        if (invalidationListener != null) {
            invalidationListener.a();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final String A0;
        public static final String B0;
        public static final String C0;
        public static final String D0;
        public static final String E0;
        public static final String F0;
        public static final String G0;
        public static final String H0;
        public static final String I0;
        public static final String J0;
        public static final String K0;
        public static final Parameters r0 = new Parameters(new Builder());
        public static final String s0;
        public static final String t0;
        public static final String u0;
        public static final String v0;
        public static final String w0;
        public static final String x0;
        public static final String y0;
        public static final String z0;
        public final boolean i0;
        public final boolean j0;
        public final boolean k0;
        public final boolean l0;
        public final boolean m0;
        public final boolean n0;
        public final boolean o0;
        public final SparseArray p0;
        public final SparseBooleanArray q0;

        static {
            int i2 = Util.f5744a;
            s0 = Integer.toString(1000, 36);
            t0 = Integer.toString(DateUtils.SEMI_MONTH, 36);
            u0 = Integer.toString(1002, 36);
            v0 = Integer.toString(1003, 36);
            w0 = Integer.toString(1004, 36);
            x0 = Integer.toString(1005, 36);
            y0 = Integer.toString(1006, 36);
            z0 = Integer.toString(1007, 36);
            A0 = Integer.toString(1008, 36);
            B0 = Integer.toString(1009, 36);
            C0 = Integer.toString(1010, 36);
            D0 = Integer.toString(1011, 36);
            E0 = Integer.toString(1012, 36);
            F0 = Integer.toString(1013, 36);
            G0 = Integer.toString(1014, 36);
            H0 = Integer.toString(1015, 36);
            I0 = Integer.toString(1016, 36);
            J0 = Integer.toString(1017, 36);
            K0 = Integer.toString(1018, 36);
        }

        public Parameters(Builder builder) {
            super(builder);
            this.i0 = builder.C;
            this.j0 = builder.D;
            this.k0 = builder.E;
            this.l0 = builder.F;
            this.m0 = builder.G;
            this.n0 = builder.H;
            this.o0 = builder.I;
            this.p0 = builder.J;
            this.q0 = builder.K;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final TrackSelectionParameters.Builder a() {
            return new Builder(this);
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final Bundle c() {
            Bundle bundleC = super.c();
            bundleC.putBoolean(s0, this.i0);
            bundleC.putBoolean(t0, false);
            bundleC.putBoolean(u0, this.j0);
            bundleC.putBoolean(G0, false);
            bundleC.putBoolean(v0, this.k0);
            bundleC.putBoolean(w0, false);
            bundleC.putBoolean(x0, false);
            bundleC.putBoolean(y0, false);
            bundleC.putBoolean(H0, false);
            bundleC.putBoolean(K0, this.l0);
            bundleC.putBoolean(I0, this.m0);
            bundleC.putBoolean(z0, this.n0);
            bundleC.putBoolean(A0, false);
            bundleC.putBoolean(B0, this.o0);
            bundleC.putBoolean(J0, false);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            int i2 = 0;
            while (true) {
                SparseArray sparseArray2 = this.p0;
                if (i2 >= sparseArray2.size()) {
                    break;
                }
                int iKeyAt = sparseArray2.keyAt(i2);
                for (Map.Entry entry : ((Map) sparseArray2.valueAt(i2)).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundleC.putIntArray(C0, Ints.g(arrayList));
                bundleC.putParcelableArrayList(D0, BundleCollectionUtil.b(arrayList2, new f()));
                SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>(sparseArray.size());
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int iKeyAt2 = sparseArray.keyAt(i3);
                    ((SelectionOverride) sparseArray.valueAt(i3)).getClass();
                    Bundle bundle = new Bundle();
                    bundle.putInt(SelectionOverride.f7995a, 0);
                    bundle.putIntArray(SelectionOverride.f7996b, null);
                    bundle.putInt(SelectionOverride.f7997c, 0);
                    sparseArray3.put(iKeyAt2, bundle);
                }
                bundleC.putSparseParcelableArray(E0, sparseArray3);
                i2++;
            }
            SparseBooleanArray sparseBooleanArray = this.q0;
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i4 = 0; i4 < sparseBooleanArray.size(); i4++) {
                iArr[i4] = sparseBooleanArray.keyAt(i4);
            }
            bundleC.putIntArray(F0, iArr);
            return bundleC;
        }

        public final Builder d() {
            return new Builder(this);
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Parameters.class == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (super.equals(parameters) && this.i0 == parameters.i0 && this.j0 == parameters.j0 && this.k0 == parameters.k0 && this.l0 == parameters.l0 && this.m0 == parameters.m0 && this.n0 == parameters.n0 && this.o0 == parameters.o0) {
                    SparseBooleanArray sparseBooleanArray = this.q0;
                    int size = sparseBooleanArray.size();
                    SparseBooleanArray sparseBooleanArray2 = parameters.q0;
                    if (sparseBooleanArray2.size() == size) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                SparseArray sparseArray = this.p0;
                                int size2 = sparseArray.size();
                                SparseArray sparseArray2 = parameters.p0;
                                if (sparseArray2.size() == size2) {
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                                        if (iIndexOfKey >= 0) {
                                            Map map = (Map) sparseArray.valueAt(i3);
                                            Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                            if (map2.size() == map.size()) {
                                                for (Map.Entry entry : map.entrySet()) {
                                                    TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                                                    if (!map2.containsKey(trackGroupArray) || !Util.a(entry.getValue(), map2.get(trackGroupArray))) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return true;
                                }
                            } else {
                                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final int hashCode() {
            return (((((((((((((((super.hashCode() + 31) * 31) + (this.i0 ? 1 : 0)) * 961) + (this.j0 ? 1 : 0)) * 961) + (this.k0 ? 1 : 0)) * 28629151) + (this.l0 ? 1 : 0)) * 31) + (this.m0 ? 1 : 0)) * 31) + (this.n0 ? 1 : 0)) * 961) + (this.o0 ? 1 : 0)) * 31;
        }

        public static final class Builder extends TrackSelectionParameters.Builder {
            public boolean C;
            public boolean D;
            public boolean E;
            public boolean F;
            public boolean G;
            public boolean H;
            public boolean I;
            public final SparseArray J;
            public final SparseBooleanArray K;

            /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public Builder(android.content.Context r9) throws java.lang.NumberFormatException {
                /*
                    Method dump skipped, instructions count: 284
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters.Builder.<init>(android.content.Context):void");
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final void a(TrackSelectionOverride trackSelectionOverride) {
                this.A.put(trackSelectionOverride.f5508a, trackSelectionOverride);
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters b() {
                return new Parameters(this);
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder c() {
                super.c();
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder d(int i2) {
                super.d(i2);
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder g() {
                this.v = -3;
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder h(TrackSelectionOverride trackSelectionOverride) {
                super.h(trackSelectionOverride);
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder i(int i2) {
                super.i(i2);
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder j(int i2, int i3) {
                super.j(i2, i3);
                return this;
            }

            public final void k(TrackSelectionOverride trackSelectionOverride) {
                this.A.put(trackSelectionOverride.f5508a, trackSelectionOverride);
            }

            public final Parameters l() {
                return new Parameters(this);
            }

            public final void m() {
                super.c();
            }

            public final void n(int i2) {
                super.d(i2);
            }

            public final void o() {
                this.C = true;
                this.D = true;
                this.E = true;
                this.F = true;
                this.G = true;
                this.H = true;
                this.I = true;
            }

            public final void p() {
                this.E = true;
            }

            public final void q() {
                this.H = true;
            }

            public final void r() {
                this.C = true;
            }

            public final void s(int i2) {
                this.f5536d = i2;
            }

            public final void t(TrackSelectionOverride trackSelectionOverride) {
                super.h(trackSelectionOverride);
            }

            public final void u(int i2, boolean z) {
                SparseBooleanArray sparseBooleanArray = this.K;
                if (sparseBooleanArray.get(i2) == z) {
                    return;
                }
                if (z) {
                    sparseBooleanArray.put(i2, true);
                } else {
                    sparseBooleanArray.delete(i2);
                }
            }

            public final void v(int i2) {
                super.i(i2);
            }

            public Builder(Parameters parameters) {
                e(parameters);
                this.C = parameters.i0;
                this.D = parameters.j0;
                this.E = parameters.k0;
                this.F = parameters.l0;
                this.G = parameters.m0;
                this.H = parameters.n0;
                this.I = parameters.o0;
                SparseArray sparseArray = new SparseArray();
                int i2 = 0;
                while (true) {
                    SparseArray sparseArray2 = parameters.p0;
                    if (i2 < sparseArray2.size()) {
                        sparseArray.put(sparseArray2.keyAt(i2), new HashMap((Map) sparseArray2.valueAt(i2)));
                        i2++;
                    } else {
                        this.J = sparseArray;
                        this.K = parameters.q0.clone();
                        return;
                    }
                }
            }

            @Deprecated
            public Builder() {
                this.J = new SparseArray();
                this.K = new SparseBooleanArray();
                o();
            }
        }
    }
}
