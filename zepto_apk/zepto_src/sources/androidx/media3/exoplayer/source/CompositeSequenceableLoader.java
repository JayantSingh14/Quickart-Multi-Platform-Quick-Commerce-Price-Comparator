package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class CompositeSequenceableLoader implements SequenceableLoader {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f7531a;

    /* renamed from: b, reason: collision with root package name */
    public long f7532b;

    public static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {

        /* renamed from: a, reason: collision with root package name */
        public final SequenceableLoader f7533a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f7534b;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List list) {
            this.f7533a = sequenceableLoader;
            this.f7534b = ImmutableList.o(list);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean b() {
            return this.f7533a.b();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean e(LoadingInfo loadingInfo) {
            return this.f7533a.e(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long f() {
            return this.f7533a.f();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long q() {
            return this.f7533a.q();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final void s(long j2) {
            this.f7533a.s(j2);
        }
    }

    public CompositeSequenceableLoader(List list, List list2) {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        Assertions.a(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            builder.h(new SequenceableLoaderWithTrackTypes((SequenceableLoader) list.get(i2), (List) list2.get(i2)));
        }
        this.f7531a = builder.j();
        this.f7532b = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f7531a;
            if (i2 >= immutableList.size()) {
                return false;
            }
            if (((SequenceableLoaderWithTrackTypes) immutableList.get(i2)).b()) {
                return true;
            }
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        boolean zE;
        boolean z = false;
        do {
            long jF = f();
            if (jF == Long.MIN_VALUE) {
                return z;
            }
            int i2 = 0;
            zE = false;
            while (true) {
                ImmutableList immutableList = this.f7531a;
                if (i2 >= immutableList.size()) {
                    break;
                }
                long jF2 = ((SequenceableLoaderWithTrackTypes) immutableList.get(i2)).f7533a.f();
                boolean z2 = jF2 != Long.MIN_VALUE && jF2 <= loadingInfo.f6261a;
                if (jF2 == jF || z2) {
                    zE |= ((SequenceableLoaderWithTrackTypes) immutableList.get(i2)).f7533a.e(loadingInfo);
                }
                i2++;
            }
            z |= zE;
        } while (zE);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            ImmutableList immutableList = this.f7531a;
            if (i2 >= immutableList.size()) {
                break;
            }
            long jF = ((SequenceableLoaderWithTrackTypes) immutableList.get(i2)).f();
            if (jF != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jF);
            }
            i2++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        int i2 = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            ImmutableList immutableList = this.f7531a;
            if (i2 >= immutableList.size()) {
                break;
            }
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = (SequenceableLoaderWithTrackTypes) immutableList.get(i2);
            long jQ = sequenceableLoaderWithTrackTypes.q();
            ImmutableList immutableList2 = sequenceableLoaderWithTrackTypes.f7534b;
            if ((immutableList2.contains(1) || immutableList2.contains(2) || immutableList2.contains(4)) && jQ != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jQ);
            }
            if (jQ != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jQ);
            }
            i2++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.f7532b = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j2 = this.f7532b;
        return j2 != -9223372036854775807L ? j2 : jMin2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f7531a;
            if (i2 >= immutableList.size()) {
                return;
            }
            ((SequenceableLoaderWithTrackTypes) immutableList.get(i2)).s(j2);
            i2++;
        }
    }
}
