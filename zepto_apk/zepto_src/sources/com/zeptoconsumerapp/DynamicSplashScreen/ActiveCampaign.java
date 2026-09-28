package com.zeptoconsumerapp.DynamicSplashScreen;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class ActiveCampaign {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f47412a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class AssetPositions {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AssetPositions[] f47413a = {new AssetPositions("BACKGROUND_IMAGE", 0), new AssetPositions("CENTER_IMAGE", 1), new AssetPositions("TOP_IMAGE", 2), new AssetPositions("BOTTOM_IMAGE", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        AssetPositions EF5;

        public static AssetPositions valueOf(String str) {
            return (AssetPositions) Enum.valueOf(AssetPositions.class, str);
        }

        public static AssetPositions[] values() {
            return (AssetPositions[]) f47413a.clone();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        r1 = r2.a().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        if (r1.hasNext() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
    
        r4 = new java.io.File(((com.zeptoconsumerapp.models.SplashScreenAssetModel) r1.next()).b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
    
        if (r4.exists() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        if (r4.isDirectory() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a4, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.zeptoconsumerapp.models.CampaignDataModel a() {
        /*
            r9 = this;
            r0 = 0
            android.content.SharedPreferences r1 = r9.f47412a     // Catch: java.lang.Exception -> Le
            if (r1 != 0) goto L7
        L5:
            r1 = r0
            goto L13
        L7:
            java.lang.String r2 = "splashScreenCampaigns"
            java.lang.String r1 = r1.getString(r2, r0)     // Catch: java.lang.Exception -> Le
            goto L13
        Le:
            r1 = move-exception
            com.zeptoconsumerapp.Utils.i(r1)     // Catch: java.lang.Exception -> La2
            goto L5
        L13:
            if (r1 != 0) goto L17
            goto La5
        L17:
            com.google.gson.Gson r2 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Exception -> L29
            com.zeptoconsumerapp.DynamicSplashScreen.ActiveCampaign$1 r3 = new com.zeptoconsumerapp.DynamicSplashScreen.ActiveCampaign$1     // Catch: java.lang.Exception -> L29
            r3.<init>()     // Catch: java.lang.Exception -> L29
            java.lang.reflect.Type r3 = r3.f45460b     // Catch: java.lang.Exception -> L29
            java.lang.Object r1 = r2.e(r1, r3)     // Catch: java.lang.Exception -> L29
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L29
            goto L32
        L29:
            r1 = move-exception
            com.zeptoconsumerapp.Utils.i(r1)     // Catch: java.lang.Exception -> La2
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> La2
            r1.<init>()     // Catch: java.lang.Exception -> La2
        L32:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> La2
        L36:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> La2
            if (r2 == 0) goto La5
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> La2
            com.zeptoconsumerapp.models.CampaignDataModel r2 = (com.zeptoconsumerapp.models.CampaignDataModel) r2     // Catch: java.lang.Exception -> La2
            if (r2 != 0) goto L45
            goto L36
        L45:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L64
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            long r5 = r2.f()     // Catch: java.lang.Exception -> L64
            long r7 = r2.d()     // Catch: java.lang.Exception -> L64
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L5e
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 > 0) goto L5e
            r3 = 1
            goto L5f
        L5e:
            r3 = 0
        L5f:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Exception -> L64
            goto L66
        L64:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> La2
        L66:
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Exception -> La2
            if (r3 != 0) goto L6d
            goto L36
        L6d:
            java.util.List r1 = r2.a()     // Catch: java.lang.Exception -> La2
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> La2
        L75:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> La2
            if (r3 == 0) goto La4
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> La2
            com.zeptoconsumerapp.models.SplashScreenAssetModel r3 = (com.zeptoconsumerapp.models.SplashScreenAssetModel) r3     // Catch: java.lang.Exception -> La2
            java.lang.String r3 = r3.b()     // Catch: java.lang.Exception -> La2
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L97
            r4.<init>(r3)     // Catch: java.lang.Exception -> L97
            boolean r3 = r4.exists()     // Catch: java.lang.Exception -> L97
            if (r3 == 0) goto L97
            boolean r3 = r4.isDirectory()     // Catch: java.lang.Exception -> L97
            if (r3 != 0) goto L97
            goto L75
        L97:
            java.lang.Exception r1 = new java.lang.Exception     // Catch: java.lang.Exception -> La2
            java.lang.String r2 = "SplashScreenV2: after caching file is not available"
            r1.<init>(r2)     // Catch: java.lang.Exception -> La2
            com.zeptoconsumerapp.Utils.i(r1)     // Catch: java.lang.Exception -> La2
            goto La5
        La2:
            r1 = move-exception
            goto La6
        La4:
            return r2
        La5:
            return r0
        La6:
            com.zeptoconsumerapp.Utils.i(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.DynamicSplashScreen.ActiveCampaign.a():com.zeptoconsumerapp.models.CampaignDataModel");
    }
}
