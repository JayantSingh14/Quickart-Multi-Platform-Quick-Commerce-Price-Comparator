package androidx.media3.extractor.jpeg;

import java.util.List;

/* loaded from: classes3.dex */
final class MotionPhotoDescription {

    /* renamed from: a, reason: collision with root package name */
    public final long f8752a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8753b;

    public static final class ContainerItem {

        /* renamed from: a, reason: collision with root package name */
        public final String f8754a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8755b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8756c;

        public ContainerItem(long j2, long j3, String str) {
            this.f8754a = str;
            this.f8755b = j2;
            this.f8756c = j3;
        }
    }

    public MotionPhotoDescription(long j2, List list) {
        this.f8752a = j2;
        this.f8753b = list;
    }
}
