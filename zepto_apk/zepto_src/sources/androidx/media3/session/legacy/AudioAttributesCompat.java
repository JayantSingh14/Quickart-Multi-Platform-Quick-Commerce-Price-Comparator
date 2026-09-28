package androidx.media3.session.legacy;

import android.media.AudioAttributes;
import android.os.Build;
import android.support.v4.media.b;
import android.util.SparseIntArray;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public class AudioAttributesCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f10420b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final AudioAttributesImpl f10421a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    public interface AudioAttributesImpl {

        public interface Builder {
            Builder a(int i2);

            AudioAttributesImpl build();
        }

        int F();

        int a();

        int b();

        int getContentType();
    }

    @RequiresApi
    public static class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

        @RequiresApi
        public static class Builder extends AudioAttributesImplApi21.Builder {
            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImplApi21.Builder, androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            public final AudioAttributesImpl.Builder a(int i2) {
                this.f10424a.setUsage(i2);
                return this;
            }

            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImplApi21.Builder
            /* renamed from: b */
            public final AudioAttributesImplApi21.Builder a(int i2) {
                this.f10424a.setUsage(i2);
                return this;
            }

            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImplApi21.Builder, androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            public final AudioAttributesImpl build() {
                return new AudioAttributesImplApi26(this.f10424a.build());
            }
        }
    }

    public static class AudioAttributesImplBase implements AudioAttributesImpl {

        /* renamed from: a, reason: collision with root package name */
        public final int f10425a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final int f10426b = 0;

        /* renamed from: c, reason: collision with root package name */
        public final int f10427c = -1;

        public static class Builder implements AudioAttributesImpl.Builder {
            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            public final AudioAttributesImpl.Builder a(int i2) {
                throw null;
            }

            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            public final AudioAttributesImpl build() {
                throw null;
            }
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int F() {
            int iB = b();
            int i2 = this.f10426b;
            if (iB == 6) {
                i2 |= 4;
            } else if (iB == 7) {
                i2 |= 1;
            }
            return i2 & 273;
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int a() {
            return this.f10425a;
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int b() {
            int i2 = this.f10427c;
            return i2 != -1 ? i2 : AudioAttributesCompat.a(this.f10426b, this.f10425a);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AudioAttributesImplBase)) {
                return false;
            }
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            audioAttributesImplBase.getClass();
            return this.f10426b == audioAttributesImplBase.F() && this.f10425a == audioAttributesImplBase.f10425a && this.f10427c == audioAttributesImplBase.f10427c;
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int getContentType() {
            return 0;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{0, Integer.valueOf(this.f10426b), Integer.valueOf(this.f10425a), Integer.valueOf(this.f10427c)});
        }

        public final String toString() {
            String strF;
            StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
            int i2 = this.f10427c;
            if (i2 != -1) {
                sb.append(" stream=");
                sb.append(i2);
                sb.append(" derived");
            }
            sb.append(" usage=");
            int i3 = AudioAttributesCompat.f10420b;
            int i4 = this.f10425a;
            switch (i4) {
                case 0:
                    strF = "USAGE_UNKNOWN";
                    break;
                case 1:
                    strF = "USAGE_MEDIA";
                    break;
                case 2:
                    strF = "USAGE_VOICE_COMMUNICATION";
                    break;
                case 3:
                    strF = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                    break;
                case 4:
                    strF = "USAGE_ALARM";
                    break;
                case 5:
                    strF = "USAGE_NOTIFICATION";
                    break;
                case 6:
                    strF = "USAGE_NOTIFICATION_RINGTONE";
                    break;
                case 7:
                    strF = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                    break;
                case 8:
                    strF = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                    break;
                case 9:
                    strF = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                    break;
                case 10:
                    strF = "USAGE_NOTIFICATION_EVENT";
                    break;
                case 11:
                    strF = "USAGE_ASSISTANCE_ACCESSIBILITY";
                    break;
                case 12:
                    strF = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                    break;
                case 13:
                    strF = "USAGE_ASSISTANCE_SONIFICATION";
                    break;
                case 14:
                    strF = "USAGE_GAME";
                    break;
                case 15:
                default:
                    strF = b.f(i4, "unknown usage ");
                    break;
                case 16:
                    strF = "USAGE_ASSISTANT";
                    break;
            }
            sb.append(strF);
            sb.append(" content=0 flags=0x");
            sb.append(Integer.toHexString(this.f10426b).toUpperCase(Locale.ROOT));
            return sb.toString();
        }
    }

    public static abstract class AudioManagerHidden {
    }

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributesImpl.Builder f10428a;

        public Builder() {
            int i2 = AudioAttributesCompat.f10420b;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f10428a = new AudioAttributesImplApi26.Builder();
            } else {
                this.f10428a = new AudioAttributesImplApi21.Builder();
            }
        }

        public final void a(int i2) {
            ((AudioAttributesImplApi21.Builder) this.f10428a).f10424a.setContentType(i2);
        }

        public final void b(int i2) {
            ((AudioAttributesImplApi21.Builder) this.f10428a).f10424a.setFlags(i2);
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

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f10421a = audioAttributesImpl;
    }

    public static int a(int i2, int i3) {
        if ((i2 & 1) == 1) {
            return 7;
        }
        if ((i2 & 4) == 4) {
            return 6;
        }
        switch (i3) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 12:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public static AudioAttributesCompat b(AudioAttributes audioAttributes) {
        return Build.VERSION.SDK_INT >= 26 ? new AudioAttributesCompat(new AudioAttributesImplApi26(audioAttributes)) : new AudioAttributesCompat(new AudioAttributesImplApi21(audioAttributes));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f10421a;
        return audioAttributesImpl == null ? audioAttributesCompat.f10421a == null : audioAttributesImpl.equals(audioAttributesCompat.f10421a);
    }

    public final int hashCode() {
        return this.f10421a.hashCode();
    }

    public final String toString() {
        return this.f10421a.toString();
    }

    @RequiresApi
    public static class AudioAttributesImplApi21 implements AudioAttributesImpl {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes f10422a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10423b = -1;

        @RequiresApi
        public static class Builder implements AudioAttributesImpl.Builder {

            /* renamed from: a, reason: collision with root package name */
            public final AudioAttributes.Builder f10424a = new AudioAttributes.Builder();

            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder a(int i2) {
                if (i2 == 16) {
                    i2 = 12;
                }
                this.f10424a.setUsage(i2);
                return this;
            }

            @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl.Builder
            public AudioAttributesImpl build() {
                return new AudioAttributesImplApi21(this.f10424a.build());
            }
        }

        public AudioAttributesImplApi21() {
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int F() {
            AudioAttributes audioAttributes = this.f10422a;
            audioAttributes.getClass();
            return audioAttributes.getFlags();
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int a() {
            AudioAttributes audioAttributes = this.f10422a;
            audioAttributes.getClass();
            return audioAttributes.getUsage();
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int b() {
            int i2 = this.f10423b;
            return i2 != -1 ? i2 : AudioAttributesCompat.a(F(), a());
        }

        public final boolean equals(Object obj) {
            if (obj instanceof AudioAttributesImplApi21) {
                return Objects.equals(this.f10422a, ((AudioAttributesImplApi21) obj).f10422a);
            }
            return false;
        }

        @Override // androidx.media3.session.legacy.AudioAttributesCompat.AudioAttributesImpl
        public final int getContentType() {
            AudioAttributes audioAttributes = this.f10422a;
            audioAttributes.getClass();
            return audioAttributes.getContentType();
        }

        public final int hashCode() {
            AudioAttributes audioAttributes = this.f10422a;
            audioAttributes.getClass();
            return audioAttributes.hashCode();
        }

        public final String toString() {
            return "AudioAttributesCompat: audioattributes=" + this.f10422a;
        }

        public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
            this.f10422a = audioAttributes;
        }
    }
}
