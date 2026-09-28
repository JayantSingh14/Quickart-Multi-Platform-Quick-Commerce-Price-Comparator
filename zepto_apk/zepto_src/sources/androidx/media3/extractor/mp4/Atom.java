package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
abstract class Atom {

    /* renamed from: a, reason: collision with root package name */
    public final int f8969a;

    public static final class ContainerAtom extends Atom {

        /* renamed from: b, reason: collision with root package name */
        public final long f8970b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f8971c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f8972d;

        public ContainerAtom(int i2, long j2) {
            super(i2);
            this.f8970b = j2;
            this.f8971c = new ArrayList();
            this.f8972d = new ArrayList();
        }

        public final ContainerAtom c(int i2) {
            ArrayList arrayList = this.f8972d;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ContainerAtom containerAtom = (ContainerAtom) arrayList.get(i3);
                if (containerAtom.f8969a == i2) {
                    return containerAtom;
                }
            }
            return null;
        }

        public final LeafAtom d(int i2) {
            ArrayList arrayList = this.f8971c;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                LeafAtom leafAtom = (LeafAtom) arrayList.get(i3);
                if (leafAtom.f8969a == i2) {
                    return leafAtom;
                }
            }
            return null;
        }

        @Override // androidx.media3.extractor.mp4.Atom
        public final String toString() {
            return Atom.a(this.f8969a) + " leaves: " + Arrays.toString(this.f8971c.toArray()) + " containers: " + Arrays.toString(this.f8972d.toArray());
        }
    }

    public static final class LeafAtom extends Atom {

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f8973b;

        public LeafAtom(int i2, ParsableByteArray parsableByteArray) {
            super(i2);
            this.f8973b = parsableByteArray;
        }
    }

    public Atom(int i2) {
        this.f8969a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public static int b(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return a(this.f8969a);
    }
}
