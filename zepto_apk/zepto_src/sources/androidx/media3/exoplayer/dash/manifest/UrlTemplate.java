package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class UrlTemplate {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6866a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6867b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f6868c;

    public UrlTemplate(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f6866a = arrayList;
        this.f6867b = arrayList2;
        this.f6868c = arrayList3;
    }

    public final String a(int i2, String str, long j2, long j3) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f6867b;
            int size = arrayList.size();
            ArrayList arrayList2 = this.f6866a;
            if (i3 >= size) {
                sb.append((String) arrayList2.get(arrayList.size()));
                return sb.toString();
            }
            sb.append((String) arrayList2.get(i3));
            if (((Integer) arrayList.get(i3)).intValue() == 1) {
                sb.append(str);
            } else {
                int iIntValue = ((Integer) arrayList.get(i3)).intValue();
                ArrayList arrayList3 = this.f6868c;
                if (iIntValue == 2) {
                    sb.append(String.format(Locale.US, (String) arrayList3.get(i3), Long.valueOf(j2)));
                } else if (((Integer) arrayList.get(i3)).intValue() == 3) {
                    sb.append(String.format(Locale.US, (String) arrayList3.get(i3), Integer.valueOf(i2)));
                } else if (((Integer) arrayList.get(i3)).intValue() == 4) {
                    sb.append(String.format(Locale.US, (String) arrayList3.get(i3), Long.valueOf(j3)));
                }
            }
            i3++;
        }
    }
}
