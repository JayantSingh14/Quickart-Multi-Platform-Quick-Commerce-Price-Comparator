package androidx.media;

import android.os.Build;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class AudioAttributesCompat implements VersionedParcelable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5025b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f5026a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface AttributeUsage {
    }

    public static abstract class AudioManagerHidden {
    }

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributesImpl.Builder f5027a;

        public Builder() {
            int i2 = AudioAttributesCompat.f5025b;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f5027a = new AudioAttributesImplApi26.Builder();
            } else {
                this.f5027a = new AudioAttributesImplApi21.Builder();
            }
        }

        public final void a(int i2) {
            ((AudioAttributesImplApi21.Builder) this.f5027a).f5030a.setLegacyStreamType(i2);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    @RestrictTo
    public AudioAttributesCompat() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f5026a;
        return audioAttributesImpl == null ? audioAttributesCompat.f5026a == null : audioAttributesImpl.equals(audioAttributesCompat.f5026a);
    }

    public final int hashCode() {
        return this.f5026a.hashCode();
    }

    public final String toString() {
        return this.f5026a.toString();
    }
}
