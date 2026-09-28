package androidx.media3.exoplayer.trackselection;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class MappingTrackSelector extends TrackSelector {

    /* renamed from: c, reason: collision with root package name */
    public MappedTrackInfo f8027c;

    public static final class MappedTrackInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f8028a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f8029b;

        /* renamed from: c, reason: collision with root package name */
        public final TrackGroupArray[] f8030c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f8031d;

        /* renamed from: e, reason: collision with root package name */
        public final int[][][] f8032e;

        /* renamed from: f, reason: collision with root package name */
        public final TrackGroupArray f8033f;

        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RendererSupport {
        }

        public MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f8029b = iArr;
            this.f8030c = trackGroupArrayArr;
            this.f8032e = iArr3;
            this.f8031d = iArr2;
            this.f8033f = trackGroupArray;
            this.f8028a = iArr.length;
        }

        public final TrackGroupArray a(int i2) {
            return this.f8030c[i2];
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final void d(MappedTrackInfo mappedTrackInfo) {
        this.f8027c = mappedTrackInfo;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public final TrackSelectorResult f(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        int[][][] iArr;
        int i2;
        boolean z;
        boolean z2;
        Format[] formatArr;
        int i3;
        int[] iArr2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        boolean z3 = true;
        int[] iArr3 = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr4 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = trackGroupArray2.f7771a;
            trackGroupArr[i4] = new TrackGroup[i5];
            iArr4[i4] = new int[i5][];
        }
        int length2 = rendererCapabilitiesArr.length;
        int[] iArr5 = new int[length2];
        for (int i6 = 0; i6 < length2; i6++) {
            iArr5[i6] = rendererCapabilitiesArr[i6].y();
        }
        int i7 = 0;
        while (i7 < trackGroupArray2.f7771a) {
            TrackGroup trackGroupA = trackGroupArray2.a(i7);
            boolean z4 = trackGroupA.f5503c == 5 ? z3 : false;
            int length3 = rendererCapabilitiesArr.length;
            boolean z5 = z3;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int length4 = rendererCapabilitiesArr.length;
                z2 = z3;
                formatArr = trackGroupA.f5504d;
                i3 = trackGroupA.f5501a;
                if (i8 >= length4) {
                    break;
                }
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i8];
                int[] iArr6 = iArr3;
                int i10 = 0;
                int iMax = 0;
                while (i10 < i3) {
                    int i11 = i10;
                    iMax = Math.max(iMax, rendererCapabilities.b(formatArr[i11]) & 7);
                    i10 = i11 + 1;
                }
                boolean z6 = iArr6[i8] == 0 ? z2 : false;
                if (iMax > i9 || (iMax == i9 && z4 && !z5 && z6)) {
                    z5 = z6;
                    i9 = iMax;
                    length3 = i8;
                }
                i8++;
                z3 = z2;
                iArr3 = iArr6;
            }
            int[] iArr7 = iArr3;
            if (length3 == rendererCapabilitiesArr.length) {
                iArr2 = new int[i3];
            } else {
                RendererCapabilities rendererCapabilities2 = rendererCapabilitiesArr[length3];
                int[] iArr8 = new int[i3];
                for (int i12 = 0; i12 < i3; i12++) {
                    iArr8[i12] = rendererCapabilities2.b(formatArr[i12]);
                }
                iArr2 = iArr8;
            }
            int i13 = iArr7[length3];
            trackGroupArr[length3][i13] = trackGroupA;
            iArr4[length3][i13] = iArr2;
            iArr7[length3] = i13 + 1;
            i7++;
            trackGroupArray2 = trackGroupArray;
            z3 = z2;
            iArr3 = iArr7;
        }
        int[] iArr9 = iArr3;
        boolean z7 = z3;
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr10 = new int[rendererCapabilitiesArr.length];
        for (int i14 = 0; i14 < rendererCapabilitiesArr.length; i14++) {
            int i15 = iArr9[i14];
            trackGroupArrayArr[i14] = new TrackGroupArray((TrackGroup[]) Util.V(i15, trackGroupArr[i14]));
            iArr4[i14] = (int[][]) Util.V(i15, iArr4[i14]);
            strArr[i14] = rendererCapabilitiesArr[i14].getName();
            iArr10[i14] = rendererCapabilitiesArr[i14].g();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr10, trackGroupArrayArr, iArr5, iArr4, new TrackGroupArray((TrackGroup[]) Util.V(iArr9[rendererCapabilitiesArr.length], trackGroupArr[rendererCapabilitiesArr.length])));
        Pair pairJ = j(mappedTrackInfo, iArr4, iArr5, mediaPeriodId, timeline);
        TrackSelection[] trackSelectionArr = (TrackSelection[]) pairJ.second;
        List[] listArr = new List[trackSelectionArr.length];
        for (int i16 = 0; i16 < trackSelectionArr.length; i16++) {
            TrackSelection trackSelection = trackSelectionArr[i16];
            listArr[i16] = trackSelection != null ? ImmutableList.t(trackSelection) : ImmutableList.r();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i17 = 0;
        while (i17 < mappedTrackInfo.f8028a) {
            TrackGroupArray[] trackGroupArrayArr2 = mappedTrackInfo.f8030c;
            TrackGroupArray trackGroupArray3 = trackGroupArrayArr2[i17];
            List list = listArr[i17];
            int i18 = 0;
            while (i18 < trackGroupArray3.f7771a) {
                TrackGroup trackGroupA2 = trackGroupArray3.a(i18);
                int i19 = trackGroupArrayArr2[i17].a(i18).f5501a;
                int[] iArr11 = new int[i19];
                int i20 = 0;
                int i21 = 0;
                while (true) {
                    iArr = mappedTrackInfo.f8032e;
                    if (i20 >= i19) {
                        break;
                    }
                    if ((iArr[i17][i18][i20] & 7) == 4) {
                        iArr11[i21] = i20;
                        i21++;
                    }
                    i20++;
                }
                int[] iArrCopyOf = Arrays.copyOf(iArr11, i21);
                int iMin = 16;
                String str = null;
                List[] listArr2 = listArr;
                int i22 = 0;
                boolean z8 = false;
                int i23 = 0;
                while (i22 < iArrCopyOf.length) {
                    String str2 = trackGroupArrayArr2[i17].a(i18).f5504d[iArrCopyOf[i22]].f5225m;
                    int i24 = i23 + 1;
                    if (i23 == 0) {
                        str = str2;
                    } else {
                        z8 |= !Util.a(str, str2);
                    }
                    iMin = Math.min(iMin, iArr[i17][i18][i22] & 24);
                    i22++;
                    i23 = i24;
                }
                if (z8) {
                    iMin = Math.min(iMin, mappedTrackInfo.f8031d[i17]);
                }
                boolean z9 = iMin != 0 ? z7 : false;
                int i25 = trackGroupA2.f5501a;
                int[] iArr12 = new int[i25];
                boolean[] zArr = new boolean[i25];
                int i26 = 0;
                while (i26 < trackGroupA2.f5501a) {
                    iArr12[i26] = iArr[i17][i18][i26] & 7;
                    int i27 = 0;
                    while (true) {
                        if (i27 >= list.size()) {
                            i2 = i17;
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection2 = (TrackSelection) list.get(i27);
                        i2 = i17;
                        if (trackSelection2.m().equals(trackGroupA2) && trackSelection2.l(i26) != -1) {
                            z = z7;
                            break;
                        }
                        i27++;
                        i17 = i2;
                    }
                    zArr[i26] = z;
                    i26++;
                    i17 = i2;
                }
                builder.h(new Tracks.Group(trackGroupA2, z9, iArr12, zArr));
                i18++;
                i17 = i17;
                listArr = listArr2;
            }
            i17++;
        }
        int i28 = 0;
        while (true) {
            TrackGroupArray trackGroupArray4 = mappedTrackInfo.f8033f;
            if (i28 >= trackGroupArray4.f7771a) {
                return new TrackSelectorResult((RendererConfiguration[]) pairJ.first, (ExoTrackSelection[]) pairJ.second, new Tracks(builder.j()), mappedTrackInfo);
            }
            TrackGroup trackGroupA3 = trackGroupArray4.a(i28);
            int[] iArr13 = new int[trackGroupA3.f5501a];
            Arrays.fill(iArr13, 0);
            builder.h(new Tracks.Group(trackGroupA3, false, iArr13, new boolean[trackGroupA3.f5501a]));
            i28++;
        }
    }

    public final MappedTrackInfo i() {
        return this.f8027c;
    }

    public abstract Pair j(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
}
