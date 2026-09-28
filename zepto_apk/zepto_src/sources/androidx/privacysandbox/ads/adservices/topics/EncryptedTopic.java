package androidx.privacysandbox.ads.adservices.topics;

import android.support.v4.media.b;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@ExperimentalFeatures.Ext11OptIn
@Metadata
/* loaded from: classes3.dex */
public final class EncryptedTopic {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11272a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11273b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f11274c;

    public EncryptedTopic(byte[] encryptedTopic, String keyIdentifier, byte[] encapsulatedKey) {
        Intrinsics.checkNotNullParameter(encryptedTopic, "encryptedTopic");
        Intrinsics.checkNotNullParameter(keyIdentifier, "keyIdentifier");
        Intrinsics.checkNotNullParameter(encapsulatedKey, "encapsulatedKey");
        this.f11272a = encryptedTopic;
        this.f11273b = keyIdentifier;
        this.f11274c = encapsulatedKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) obj;
        return Arrays.equals(this.f11272a, encryptedTopic.f11272a) && this.f11273b.contentEquals(encryptedTopic.f11273b) && Arrays.equals(this.f11274c, encryptedTopic.f11274c);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.f11272a)), this.f11273b, Integer.valueOf(Arrays.hashCode(this.f11274c)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EncryptedTopic=");
        byte[] bArr = this.f11272a;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Charset charset = Charsets.UTF_8;
        sb.append(new String(bArr, charset));
        sb.append(", KeyIdentifier=");
        sb.append(this.f11273b);
        sb.append(", EncapsulatedKey=");
        byte[] bArr2 = this.f11274c;
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        sb.append(new String(bArr2, charset));
        sb.append(" }");
        return b.C("EncryptedTopic { ", sb.toString());
    }
}
