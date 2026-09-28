package e;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.dataobject.AbstractDataObject;
import f.c;
import f.f;
import f.k;
import f.l;
import j$.util.DesugarTimeZone;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class b extends AbstractDataObject {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f48314j = {"Id", "AppId", "UserCode", "DeviceCode", "VerificationUri", "Interval", "CreationTime", "ExpirationTime", "Scopes"};

    /* renamed from: b, reason: collision with root package name */
    public final String f48315b;

    /* renamed from: c, reason: collision with root package name */
    public final String f48316c;

    /* renamed from: d, reason: collision with root package name */
    public final URI f48317d;

    /* renamed from: e, reason: collision with root package name */
    public final int f48318e;

    /* renamed from: f, reason: collision with root package name */
    public final Date f48319f;

    /* renamed from: g, reason: collision with root package name */
    public final Date f48320g;

    /* renamed from: h, reason: collision with root package name */
    public final String f48321h;

    /* renamed from: i, reason: collision with root package name */
    public final String[] f48322i;

    public b(String str, String str2, String str3, URI uri, int i2, Date date, Date date2, String[] strArr) {
        this.f48321h = str;
        this.f48315b = str2;
        this.f48316c = str3;
        this.f48317d = uri;
        this.f48318e = i2;
        this.f48319f = k.b(date);
        this.f48320g = k.b(date2);
        this.f48322i = strArr;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final c c(Context context) {
        f fVar;
        synchronized (f.class) {
            try {
                if (f.f48359b == null) {
                    f.f48359b = new f(k.b.b(context));
                    f.f48360c = new f.a(context, "CodePairDataSource");
                }
                f.f48360c.a(f.f48359b);
                fVar = f.f48359b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final ContentValues d(Context context) throws l {
        f.b bVar;
        ContentValues contentValues = new ContentValues();
        int i2 = k.f48364b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String[] strArr = f48314j;
        contentValues.put(strArr[1], this.f48321h);
        contentValues.put(strArr[2], this.f48315b);
        String str = strArr[3];
        String strB = this.f48316c;
        int i3 = f.a.f48351d;
        if (context != null) {
            try {
                synchronized (f.b.class) {
                    try {
                        if (f.b.f48353b == null) {
                            f.b.f48353b = new f.b(context);
                        }
                        bVar = f.b.f48353b;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                strB = bVar.b(strB);
            } catch (Exception e2) {
                throw new l(e2);
            }
        }
        contentValues.put(str, strB);
        contentValues.put(strArr[4], this.f48317d.toString());
        contentValues.put(strArr[5], Integer.valueOf(this.f48318e));
        contentValues.put(strArr[6], simpleDateFormat.format(this.f48319f));
        contentValues.put(strArr[7], simpleDateFormat.format(this.f48320g));
        String[] strArr2 = this.f48322i;
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < strArr2.length; i4++) {
            sb.append(strArr2[i4]);
            if (i4 < strArr2.length - 1) {
                sb.append(",");
            }
        }
        contentValues.put(f48314j[8], sb.toString());
        return contentValues;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.Serializable, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Serializable, java.lang.String[]] */
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (TextUtils.equals(this.f48321h, bVar.f48321h) && TextUtils.equals(this.f48315b, bVar.f48315b) && TextUtils.equals(this.f48316c, bVar.f48316c) && AbstractDataObject.b(this.f48317d, bVar.f48317d) && Integer.valueOf(this.f48318e).equals(Integer.valueOf(bVar.f48318e)) && AbstractDataObject.b(this.f48319f, bVar.f48319f) && AbstractDataObject.b(this.f48320g, bVar.f48320g) && AbstractDataObject.b(this.f48322i, bVar.f48322i)) {
                return true;
            }
        }
        return false;
    }
}
