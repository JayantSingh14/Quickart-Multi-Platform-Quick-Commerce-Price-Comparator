package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo
/* loaded from: classes3.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f5031a = versionedParcel.l(audioAttributesImplBase.f5031a, 1);
        audioAttributesImplBase.f5032b = versionedParcel.l(audioAttributesImplBase.f5032b, 2);
        audioAttributesImplBase.f5033c = versionedParcel.l(audioAttributesImplBase.f5033c, 3);
        audioAttributesImplBase.f5034d = versionedParcel.l(audioAttributesImplBase.f5034d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.q(false, false);
        versionedParcel.v(audioAttributesImplBase.f5031a, 1);
        versionedParcel.v(audioAttributesImplBase.f5032b, 2);
        versionedParcel.v(audioAttributesImplBase.f5033c, 3);
        versionedParcel.v(audioAttributesImplBase.f5034d, 4);
    }
}
