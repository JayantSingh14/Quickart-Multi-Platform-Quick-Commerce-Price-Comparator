package androidx.media3.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f10849a;

    public DefaultTrackNameProvider(Resources resources) {
        resources.getClass();
        this.f10849a = resources;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // androidx.media3.ui.TrackNameProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(androidx.media3.common.Format r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTrackNameProvider.a(androidx.media3.common.Format):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(androidx.media3.common.Format r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            java.lang.String r0 = r7.f5216d
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L3d
            java.lang.String r1 = "und"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L13
            goto L3d
        L13:
            int r1 = androidx.media3.common.util.Util.f5744a
            r3 = 21
            if (r1 < r3) goto L1e
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            goto L24
        L1e:
            java.util.Locale r3 = new java.util.Locale
            r3.<init>(r0)
            r0 = r3
        L24:
            r3 = 24
            if (r1 < r3) goto L2f
            java.util.Locale$Category r1 = java.util.Locale.Category.DISPLAY
            java.util.Locale r1 = java.util.Locale.getDefault(r1)
            goto L33
        L2f:
            java.util.Locale r1 = java.util.Locale.getDefault()
        L33:
            java.lang.String r0 = r0.getDisplayName(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L3f
        L3d:
            r0 = r2
            goto L60
        L3f:
            r3 = 1
            r4 = 0
            int r3 = r0.offsetByCodePoints(r4, r3)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> L60
            r5.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> L60
            java.lang.String r4 = r0.substring(r4, r3)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            java.lang.String r1 = r4.toUpperCase(r1)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            r5.append(r1)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            java.lang.String r1 = r0.substring(r3)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            r5.append(r1)     // Catch: java.lang.IndexOutOfBoundsException -> L60
            java.lang.String r0 = r5.toString()     // Catch: java.lang.IndexOutOfBoundsException -> L60
        L60:
            java.lang.String r1 = r6.c(r7)
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.lang.String r0 = r6.d(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L7d
            java.lang.String r7 = r7.f5214b
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L7b
            goto L7c
        L7b:
            r2 = r7
        L7c:
            r0 = r2
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTrackNameProvider.b(androidx.media3.common.Format):java.lang.String");
    }

    public final String c(Format format) throws Resources.NotFoundException {
        int i2 = format.f5218f & 2;
        Resources resources = this.f10849a;
        String string = i2 != 0 ? resources.getString(R.string.exo_track_role_alternate) : "";
        int i3 = format.f5218f;
        if ((i3 & 4) != 0) {
            string = d(string, resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((i3 & 8) != 0) {
            string = d(string, resources.getString(R.string.exo_track_role_commentary));
        }
        return (i3 & 1088) != 0 ? d(string, resources.getString(R.string.exo_track_role_closed_captions)) : string;
    }

    public final String d(String... strArr) throws Resources.NotFoundException {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f10849a.getString(R.string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
