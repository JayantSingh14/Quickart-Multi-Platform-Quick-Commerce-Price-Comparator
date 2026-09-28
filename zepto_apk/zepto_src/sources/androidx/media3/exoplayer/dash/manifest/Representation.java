package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.DashSegmentIndex;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import com.google.common.collect.ImmutableList;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class Representation {

    /* renamed from: a, reason: collision with root package name */
    public final Format f6835a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f6836b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6837c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6838d;

    /* renamed from: e, reason: collision with root package name */
    public final RangedUri f6839e;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {

        /* renamed from: f, reason: collision with root package name */
        public final SegmentBase.MultiSegmentBase f6840f;

        public MultiSegmentRepresentation(Format format, ImmutableList immutableList, SegmentBase.MultiSegmentBase multiSegmentBase, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            super(format, immutableList, multiSegmentBase, arrayList, arrayList2, arrayList3);
            this.f6840f = multiSegmentBase;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final String a() {
            return null;
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long b(long j2) {
            return this.f6840f.g(j2);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long c(long j2, long j3) {
            return this.f6840f.e(j2, j3);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long d(long j2, long j3) {
            return this.f6840f.c(j2, j3);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long e(long j2, long j3) {
            SegmentBase.MultiSegmentBase multiSegmentBase = this.f6840f;
            if (multiSegmentBase.f6848f != null) {
                return -9223372036854775807L;
            }
            long jB = multiSegmentBase.b(j2, j3) + multiSegmentBase.c(j2, j3);
            return (multiSegmentBase.e(jB, j2) + multiSegmentBase.g(jB)) - multiSegmentBase.f6851i;
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final RangedUri f(long j2) {
            return this.f6840f.h(this, j2);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long g(long j2, long j3) {
            return this.f6840f.f(j2, j3);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long h(long j2) {
            return this.f6840f.d(j2);
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final boolean i() {
            return this.f6840f.i();
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long j() {
            return this.f6840f.f6846d;
        }

        @Override // androidx.media3.exoplayer.dash.DashSegmentIndex
        public final long k(long j2, long j3) {
            return this.f6840f.b(j2, j3);
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final DashSegmentIndex l() {
            return this;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final RangedUri m() {
            return null;
        }
    }

    public static class SingleSegmentRepresentation extends Representation {

        /* renamed from: f, reason: collision with root package name */
        public final RangedUri f6841f;

        /* renamed from: g, reason: collision with root package name */
        public final SingleSegmentIndex f6842g;

        /* JADX WARN: Multi-variable type inference failed */
        public SingleSegmentRepresentation(Format format, ImmutableList immutableList, SegmentBase.SingleSegmentBase singleSegmentBase, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            super(format, immutableList, singleSegmentBase, arrayList, arrayList2, arrayList3);
            Uri.parse(((BaseUrl) immutableList.get(0)).f6785a);
            long j2 = singleSegmentBase.f6859e;
            RangedUri rangedUri = j2 <= 0 ? null : new RangedUri(singleSegmentBase.f6858d, j2, null);
            this.f6841f = rangedUri;
            this.f6842g = rangedUri == null ? new SingleSegmentIndex(new RangedUri(0L, -1L, null)) : null;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final String a() {
            return null;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final DashSegmentIndex l() {
            return this.f6842g;
        }

        @Override // androidx.media3.exoplayer.dash.manifest.Representation
        public final RangedUri m() {
            return this.f6841f;
        }
    }

    public Representation(Format format, ImmutableList immutableList, SegmentBase segmentBase, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        Assertions.a(!immutableList.isEmpty());
        this.f6835a = format;
        this.f6836b = ImmutableList.o(immutableList);
        this.f6838d = arrayList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
        this.f6839e = segmentBase.a(this);
        int i2 = Util.f5744a;
        this.f6837c = Util.b0(segmentBase.f6845c, 1000000L, segmentBase.f6844b, RoundingMode.FLOOR);
    }

    public abstract String a();

    public abstract DashSegmentIndex l();

    public abstract RangedUri m();
}
