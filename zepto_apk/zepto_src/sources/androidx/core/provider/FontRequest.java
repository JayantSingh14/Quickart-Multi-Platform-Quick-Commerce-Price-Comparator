package androidx.core.provider;

import android.util.Base64;
import java.util.List;

/* loaded from: classes3.dex */
public final class FontRequest {

    /* renamed from: a, reason: collision with root package name */
    public final String f2900a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2901b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2902c;

    /* renamed from: d, reason: collision with root package name */
    public final List f2903d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2904e;

    public FontRequest(String str, String str2, String str3, List list) {
        str.getClass();
        this.f2900a = str;
        str2.getClass();
        this.f2901b = str2;
        this.f2902c = str3;
        list.getClass();
        this.f2903d = list;
        this.f2904e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2900a + ", mProviderPackage: " + this.f2901b + ", mQuery: " + this.f2902c + ", mCertificates:");
        int i2 = 0;
        while (true) {
            List list = this.f2903d;
            if (i2 >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i2);
            for (int i3 = 0; i3 < list2.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i2++;
        }
    }
}
