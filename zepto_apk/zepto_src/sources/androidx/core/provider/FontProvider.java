package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
class FontProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final LruCache f2894a = new LruCache(2);

    /* renamed from: b, reason: collision with root package name */
    public static final a f2895b = new a();

    public interface ContentQueryWrapper {
    }

    public static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
    }

    @RequiresApi
    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f2896a;

        public ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.f2896a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }
    }

    public static class ProviderCacheKey {

        /* renamed from: a, reason: collision with root package name */
        public String f2897a;

        /* renamed from: b, reason: collision with root package name */
        public String f2898b;

        /* renamed from: c, reason: collision with root package name */
        public List f2899c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProviderCacheKey)) {
                return false;
            }
            ProviderCacheKey providerCacheKey = (ProviderCacheKey) obj;
            return Objects.equals(this.f2897a, providerCacheKey.f2897a) && Objects.equals(this.f2898b, providerCacheKey.f2898b) && Objects.equals(this.f2899c, providerCacheKey.f2899c);
        }

        public final int hashCode() {
            return Objects.hash(this.f2897a, this.f2898b, this.f2899c);
        }
    }

    public static FontsContractCompat.FontFamilyResult a(Context context, List list) {
        Trace.beginSection(androidx.tracing.Trace.g("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                FontRequest fontRequest = (FontRequest) list.get(i2);
                ProviderInfo providerInfoB = b(context.getPackageManager(), fontRequest, context.getResources());
                if (providerInfoB == null) {
                    return new FontsContractCompat.FontFamilyResult();
                }
                arrayList.add(c(context, fontRequest, providerInfoB.authority));
            }
            return new FontsContractCompat.FontFamilyResult(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        Trace.beginSection(androidx.tracing.Trace.g("FontProvider.getProvider"));
        try {
            List listB = fontRequest.f2903d;
            String str = fontRequest.f2900a;
            String str2 = fontRequest.f2901b;
            if (listB == null) {
                listB = FontResourcesParserCompat.b(resources, 0);
            }
            ProviderCacheKey providerCacheKey = new ProviderCacheKey();
            providerCacheKey.f2897a = str;
            providerCacheKey.f2898b = str2;
            providerCacheKey.f2899c = listB;
            LruCache lruCache = f2894a;
            ProviderInfo providerInfo = (ProviderInfo) lruCache.c(providerCacheKey);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            a aVar = f2895b;
            Collections.sort(arrayList, aVar);
            for (int i2 = 0; i2 < listB.size(); i2++) {
                ArrayList arrayList2 = new ArrayList((Collection) listB.get(i2));
                Collections.sort(arrayList2, aVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                            break;
                        }
                    }
                    lruCache.d(providerCacheKey, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static FontsContractCompat.FontInfo[] c(Context context, FontRequest fontRequest, String str) {
        Trace.beginSection(androidx.tracing.Trace.g("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath(UtilsKt.SCHEME_FILE).build();
            ContentProviderClient contentProviderClient = new ContentQueryWrapperApi24Impl(context, uriBuild).f2896a;
            Cursor cursorQuery = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(androidx.tracing.Trace.g("ContentQueryWrapper.query"));
                try {
                    String[] strArr2 = {fontRequest.f2902c};
                    if (contentProviderClient != null) {
                        try {
                            cursorQuery = contentProviderClient.query(uriBuild, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e2) {
                            Log.w("FontsProvider", "Unable to query the content provider", e2);
                        }
                    }
                    Trace.endSection();
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorQuery.getColumnIndex("_id");
                        int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                        int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                        int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                        while (cursorQuery.moveToNext()) {
                            int i2 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList2.add(new FontsContractCompat.FontInfo(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i2));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                    return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                throw th;
            }
        } finally {
        }
    }
}
