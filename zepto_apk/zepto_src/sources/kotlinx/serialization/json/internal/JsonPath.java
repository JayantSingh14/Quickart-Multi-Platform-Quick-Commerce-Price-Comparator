package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class JsonPath {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f56048a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    public int[] f56049b;

    /* renamed from: c, reason: collision with root package name */
    public int f56050c;

    @Metadata
    public static final class Tombstone {

        /* renamed from: a, reason: collision with root package name */
        public static final Tombstone f56051a = new Tombstone();
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = -1;
        }
        this.f56049b = iArr;
        this.f56050c = -1;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("$");
        int i2 = this.f56050c + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = this.f56048a[i3];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.b(serialDescriptor.d(), StructureKind.LIST.f55766a)) {
                    int i4 = this.f56049b[i3];
                    if (i4 >= 0) {
                        sb.append(CLConstants.DOT_SALT_DELIMETER);
                        sb.append(serialDescriptor.f(i4));
                    }
                } else if (this.f56049b[i3] != -1) {
                    sb.append("[");
                    sb.append(this.f56049b[i3]);
                    sb.append("]");
                }
            } else if (obj != Tombstone.f56051a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String toString() {
        return a();
    }
}
