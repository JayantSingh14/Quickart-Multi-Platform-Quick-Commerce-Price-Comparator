package androidx.media;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

@RestrictTo
/* loaded from: classes3.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f5031a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f5032b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f5033c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f5034d = -1;

    public static class Builder implements AudioAttributesImpl.Builder {
        @Override // androidx.media.AudioAttributesImpl.Builder
        public final AudioAttributesImpl.Builder a() {
            throw null;
        }

        @Override // androidx.media.AudioAttributesImpl.Builder
        public final AudioAttributesImpl build() {
            throw null;
        }
    }

    @RestrictTo
    public AudioAttributesImplBase() {
    }

    public final boolean equals(Object obj) {
        int i2;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f5032b == audioAttributesImplBase.f5032b) {
            int i3 = this.f5033c;
            int i4 = audioAttributesImplBase.f5033c;
            int i5 = audioAttributesImplBase.f5034d;
            if (i5 == -1) {
                int i6 = audioAttributesImplBase.f5031a;
                int i7 = AudioAttributesCompat.f5025b;
                if ((i4 & 1) != 1) {
                    if ((i4 & 4) != 4) {
                        switch (i6) {
                            case 2:
                                i2 = 0;
                                break;
                            case 3:
                                i2 = 8;
                                break;
                            case 4:
                                i2 = 4;
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i2 = 5;
                                break;
                            case 6:
                                i2 = 2;
                                break;
                            case 11:
                                i2 = 10;
                                break;
                            case 12:
                            default:
                                i2 = 3;
                                break;
                            case 13:
                                i2 = 1;
                                break;
                        }
                    } else {
                        i2 = 6;
                    }
                } else {
                    i2 = 7;
                }
            } else {
                i2 = i5;
            }
            if (i2 == 6) {
                i4 |= 4;
            } else if (i2 == 7) {
                i4 |= 1;
            }
            if (i3 == (i4 & 273) && this.f5031a == audioAttributesImplBase.f5031a && this.f5034d == i5) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5032b), Integer.valueOf(this.f5033c), Integer.valueOf(this.f5031a), Integer.valueOf(this.f5034d)});
    }

    public final String toString() {
        String strF;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f5034d != -1) {
            sb.append(" stream=");
            sb.append(this.f5034d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i2 = this.f5031a;
        int i3 = AudioAttributesCompat.f5025b;
        switch (i2) {
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
                strF = b.f(i2, "unknown usage ");
                break;
            case 16:
                strF = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strF);
        sb.append(" content=");
        sb.append(this.f5032b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f5033c).toUpperCase());
        return sb.toString();
    }
}
