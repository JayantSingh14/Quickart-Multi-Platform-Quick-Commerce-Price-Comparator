package androidx.media3.extractor;

import androidx.fragment.app.e;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@UnstableApi
/* loaded from: classes3.dex */
public final class DolbyVisionConfig {

    /* renamed from: a, reason: collision with root package name */
    public final String f8533a;

    public DolbyVisionConfig(String str) {
        this.f8533a = str;
    }

    public static DolbyVisionConfig a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.K(2);
        int iX = parsableByteArray.x();
        int i2 = iX >> 1;
        int iX2 = ((parsableByteArray.x() >> 3) & 31) | ((iX & 1) << 5);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else {
            if (i2 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i2);
        return new DolbyVisionConfig(e.r(sb, iX2, iX2 >= 10 ? CLConstants.DOT_SALT_DELIMETER : ".0"));
    }
}
