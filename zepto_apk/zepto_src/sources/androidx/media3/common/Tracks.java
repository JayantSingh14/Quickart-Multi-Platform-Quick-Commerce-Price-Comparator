package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class Tracks {

    /* renamed from: b, reason: collision with root package name */
    public static final Tracks f5546b = new Tracks(ImmutableList.r());

    /* renamed from: c, reason: collision with root package name */
    public static final String f5547c;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f5548a;

    public static final class Group {

        /* renamed from: f, reason: collision with root package name */
        public static final String f5549f;

        /* renamed from: g, reason: collision with root package name */
        public static final String f5550g;

        /* renamed from: h, reason: collision with root package name */
        public static final String f5551h;

        /* renamed from: i, reason: collision with root package name */
        public static final String f5552i;

        /* renamed from: a, reason: collision with root package name */
        public final int f5553a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackGroup f5554b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5555c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f5556d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean[] f5557e;

        static {
            int i2 = Util.f5744a;
            f5549f = Integer.toString(0, 36);
            f5550g = Integer.toString(1, 36);
            f5551h = Integer.toString(3, 36);
            f5552i = Integer.toString(4, 36);
        }

        public Group(TrackGroup trackGroup, boolean z, int[] iArr, boolean[] zArr) {
            int i2 = trackGroup.f5501a;
            this.f5553a = i2;
            boolean z2 = false;
            Assertions.a(i2 == iArr.length && i2 == zArr.length);
            this.f5554b = trackGroup;
            if (z && i2 > 1) {
                z2 = true;
            }
            this.f5555c = z2;
            this.f5556d = (int[]) iArr.clone();
            this.f5557e = (boolean[]) zArr.clone();
        }

        public final Format a(int i2) {
            return this.f5554b.f5504d[i2];
        }

        public final boolean b(int i2) {
            return this.f5556d[i2] == 4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Group.class == obj.getClass()) {
                Group group = (Group) obj;
                if (this.f5555c == group.f5555c && this.f5554b.equals(group.f5554b) && Arrays.equals(this.f5556d, group.f5556d) && Arrays.equals(this.f5557e, group.f5557e)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f5557e) + ((Arrays.hashCode(this.f5556d) + (((this.f5554b.hashCode() * 31) + (this.f5555c ? 1 : 0)) * 31)) * 31);
        }
    }

    static {
        int i2 = Util.f5744a;
        f5547c = Integer.toString(0, 36);
    }

    public Tracks(List list) {
        this.f5548a = ImmutableList.o(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(int i2) {
        int i3 = 0;
        while (true) {
            ImmutableList immutableList = this.f5548a;
            if (i3 >= immutableList.size()) {
                return false;
            }
            Group group = (Group) immutableList.get(i3);
            boolean[] zArr = group.f5557e;
            int length = zArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (!zArr[i4]) {
                    i4++;
                } else if (group.f5554b.f5503c == i2) {
                    return true;
                }
            }
            i3++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.f5548a.equals(((Tracks) obj).f5548a);
    }

    public final int hashCode() {
        return this.f5548a.hashCode();
    }
}
