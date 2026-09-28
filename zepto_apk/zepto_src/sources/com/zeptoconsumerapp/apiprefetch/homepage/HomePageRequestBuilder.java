package com.zeptoconsumerapp.apiprefetch.homepage;

import android.support.v4.media.b;
import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class HomePageRequestBuilder {
    public static JSONArray a(MMKV mmkv) throws JSONException {
        String str;
        String str2 = "pricingCampaignId";
        JSONArray jSONArray = new JSONArray();
        try {
            String str3 = null;
            String strDecodeString = mmkv.decodeString("availedCampaigns", null);
            if (strDecodeString != null && strDecodeString.length() != 0) {
                JSONObject jSONObject = new JSONObject(strDecodeString);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
                    if (jSONObjectOptJSONObject != null) {
                        int iOptInt = jSONObjectOptJSONObject.optInt("campaignId", -1);
                        String strOptString = jSONObjectOptJSONObject.optString("storeId", str3);
                        String strOptString2 = jSONObjectOptJSONObject.optString("subOfferId", str3);
                        String strOptString3 = jSONObjectOptJSONObject.optString(str2, str3);
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("productInfo");
                        if (jSONArrayOptJSONArray == null) {
                            jSONArrayOptJSONArray = new JSONArray();
                        }
                        int length = jSONArrayOptJSONArray.length();
                        int i2 = 0;
                        while (i2 < length) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                            if (jSONObjectOptJSONObject2 == null) {
                                str = str2;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject2.toString());
                                if (iOptInt >= 0) {
                                    jSONObject2.put("campaignId", iOptInt);
                                }
                                if (strOptString != null && strOptString.length() != 0) {
                                    jSONObject2.put("storeId", strOptString);
                                }
                                if (strOptString2 != null && strOptString2.length() != 0) {
                                    jSONObject2.put("subOfferId", strOptString2);
                                }
                                if (strOptString3 != null && strOptString3.length() != 0) {
                                    jSONObject2.put(str2, strOptString3);
                                }
                                str = str2;
                                jSONObject2.put("isDiscountApplicable", true);
                                jSONArray.put(jSONObject2);
                            }
                            i2++;
                            str2 = str;
                            str3 = null;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    public static JSONArray b(MMKV mmkv) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        int i2;
        JSONArray jSONArray = new JSONArray();
        try {
            String strDecodeString = mmkv.decodeString("cartInfoMeta", null);
            if (strDecodeString != null && strDecodeString.length() != 0 && (jSONObjectOptJSONObject = new JSONObject(strDecodeString).optJSONObject("CART_PERSISTENCE_STORE_ID")) != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("productIds");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("productInfo");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("productVariantMeta");
                if (jSONObjectOptJSONObject4 == null) {
                    jSONObjectOptJSONObject4 = new JSONObject();
                }
                int length = jSONArrayOptJSONArray.length();
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject(jSONArrayOptJSONArray.optString(i4));
                    if (jSONObjectOptJSONObject5 != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject5.optJSONArray("variantsSelected");
                        if (jSONArrayOptJSONArray2 == null) {
                            jSONArrayOptJSONArray2 = new JSONArray();
                        }
                        int length2 = jSONArrayOptJSONArray2.length();
                        int i5 = i3;
                        while (i5 < length2) {
                            String strOptString = jSONArrayOptJSONArray2.optString(i5);
                            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject(strOptString);
                            if (jSONObjectOptJSONObject6 == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject6.optJSONObject(strOptString)) == null) {
                                i2 = i4;
                            } else {
                                String strOptString2 = jSONObjectOptJSONObject2.optString("storeProductId", "");
                                int iOptInt = jSONObjectOptJSONObject2.optInt("count", i3);
                                i2 = i4;
                                double dOptDouble = jSONObjectOptJSONObject2.optDouble("price", 0.0d);
                                if (iOptInt > 0) {
                                    Intrinsics.c(strOptString2);
                                    if (strOptString2.length() > 0) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("storeProductId", strOptString2);
                                        jSONObject.put("quantity", iOptInt);
                                        jSONObject.put("productVariantId", strOptString);
                                        jSONObject.put("discountedSellingPrice", dOptDouble);
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            i5++;
                            i4 = i2;
                            i3 = 0;
                        }
                    }
                    i4++;
                    i3 = 0;
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c() {
        /*
            java.lang.String r0 = "home"
            java.lang.String r1 = "lms"
            java.lang.String r2 = "config"
            java.lang.String r3 = "imgkitConfig"
            com.tencent.mmkv.MMKV r4 = com.zeptoconsumerapp.modules.base.StorageManager.a()     // Catch: java.lang.Exception -> Lc8
            com.zeptoconsumerapp.modules.base.StorageKeys[] r5 = com.zeptoconsumerapp.modules.base.StorageKeys.f47625b     // Catch: java.lang.Exception -> Lc8
            java.lang.String r5 = "FeaturesConfig"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.getString(r5, r6)     // Catch: java.lang.Exception -> Lc8
            if (r4 == 0) goto Ld7
            int r5 = r4.length()     // Catch: java.lang.Exception -> Lc8
            if (r5 != 0) goto L20
            goto Ld7
        L20:
            com.google.gson.Gson r5 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Exception -> Lc8
            java.lang.Class<com.google.gson.JsonElement> r6 = com.google.gson.JsonElement.class
            java.lang.Object r4 = r5.d(r6, r4)     // Catch: java.lang.Exception -> Lc8
            java.lang.String r5 = "fromJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch: java.lang.Exception -> Lc8
            com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch: java.lang.Exception -> Lc8
            r4.getClass()     // Catch: java.lang.Exception -> Lc8
            boolean r5 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Exception -> Lc8
            if (r5 != 0) goto L3a
            goto Ld7
        L3a:
            com.google.gson.JsonObject r4 = r4.f()     // Catch: java.lang.Exception -> Lc8
            com.google.gson.internal.LinkedTreeMap r5 = r4.f45256a     // Catch: java.lang.Exception -> Lc8
            boolean r5 = r5.containsKey(r3)     // Catch: java.lang.Exception -> Lc8
            r6 = 0
            if (r5 == 0) goto L57
            com.google.gson.JsonElement r5 = r4.k(r3)     // Catch: java.lang.Exception -> Lc8
            r5.getClass()     // Catch: java.lang.Exception -> Lc8
            boolean r5 = r5 instanceof com.google.gson.JsonObject     // Catch: java.lang.Exception -> Lc8
            if (r5 == 0) goto L57
            com.google.gson.JsonObject r3 = r4.m(r3)     // Catch: java.lang.Exception -> Lc8
            goto L58
        L57:
            r3 = r6
        L58:
            if (r3 == 0) goto L72
            com.google.gson.internal.LinkedTreeMap r4 = r3.f45256a     // Catch: java.lang.Exception -> Lc8
            boolean r4 = r4.containsKey(r2)     // Catch: java.lang.Exception -> Lc8
            if (r4 == 0) goto L72
            com.google.gson.JsonElement r4 = r3.k(r2)     // Catch: java.lang.Exception -> Lc8
            r4.getClass()     // Catch: java.lang.Exception -> Lc8
            boolean r4 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Exception -> Lc8
            if (r4 == 0) goto L72
            com.google.gson.JsonObject r2 = r3.m(r2)     // Catch: java.lang.Exception -> Lc8
            goto L73
        L72:
            r2 = r6
        L73:
            if (r2 == 0) goto L8d
            com.google.gson.internal.LinkedTreeMap r3 = r2.f45256a     // Catch: java.lang.Exception -> Lc8
            boolean r3 = r3.containsKey(r1)     // Catch: java.lang.Exception -> Lc8
            if (r3 == 0) goto L8d
            com.google.gson.JsonElement r3 = r2.k(r1)     // Catch: java.lang.Exception -> Lc8
            r3.getClass()     // Catch: java.lang.Exception -> Lc8
            boolean r3 = r3 instanceof com.google.gson.JsonObject     // Catch: java.lang.Exception -> Lc8
            if (r3 == 0) goto L8d
            com.google.gson.JsonObject r1 = r2.m(r1)     // Catch: java.lang.Exception -> Lc8
            goto L8e
        L8d:
            r1 = r6
        L8e:
            if (r1 == 0) goto La8
            com.google.gson.internal.LinkedTreeMap r2 = r1.f45256a     // Catch: java.lang.Exception -> Lc8
            boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Exception -> Lc8
            if (r2 == 0) goto La8
            com.google.gson.JsonElement r2 = r1.k(r0)     // Catch: java.lang.Exception -> Lc8
            r2.getClass()     // Catch: java.lang.Exception -> Lc8
            boolean r2 = r2 instanceof com.google.gson.JsonObject     // Catch: java.lang.Exception -> Lc8
            if (r2 == 0) goto La8
            com.google.gson.JsonObject r0 = r1.m(r0)     // Catch: java.lang.Exception -> Lc8
            goto La9
        La8:
            r0 = r6
        La9:
            if (r0 == 0) goto Lb1
            java.lang.String r1 = "firstPageSize"
            com.google.gson.JsonElement r6 = r0.k(r1)     // Catch: java.lang.Exception -> Lc8
        Lb1:
            if (r6 == 0) goto Ld7
            boolean r0 = r6 instanceof com.google.gson.JsonPrimitive     // Catch: java.lang.Exception -> Lc8
            if (r0 == 0) goto Ld7
            com.google.gson.JsonPrimitive r0 = r6.g()     // Catch: java.lang.Exception -> Lc8
            java.io.Serializable r0 = r0.f45257a     // Catch: java.lang.Exception -> Lc8
            boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Exception -> Lc8
            if (r0 == 0) goto Ld7
            int r0 = r6.d()     // Catch: java.lang.Exception -> Lc8
            if (r0 <= 0) goto Ld7
            return r0
        Lc8:
            r0 = move-exception
            java.lang.String r1 = "PREFETCH"
            timber.log.Timber$Tree r1 = timber.log.Timber.d(r1)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "PREFETCHLOGIC Error reading LMS page size from config"
            r1.e(r0, r3, r2)
        Ld7:
            r0 = 8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.apiprefetch.homepage.HomePageRequestBuilder.c():int");
    }

    public static int d(MMKV mmkv) {
        JSONObject jSONObjectOptJSONObject;
        int iOptInt;
        Random.f53818a.getClass();
        int iF = Random.f53819b.f(2);
        Timber.d("PREFETCH").d(b.f(iF, "Toggle:: generated random state: "), new Object[0]);
        try {
            String strDecodeString = mmkv.decodeString("toggleWidgetStateData", null);
            if (strDecodeString != null && strDecodeString.length() != 0 && (jSONObjectOptJSONObject = new JSONObject(strDecodeString).optJSONObject("TOGGLE_WIDGET_STATE_1")) != null && (iOptInt = jSONObjectOptJSONObject.optInt("evaluatedState", -2)) != -2) {
                Timber.d("PREFETCH").d("Toggle:: evaluated state from mmkv: " + iOptInt, new Object[0]);
                return iOptInt;
            }
        } catch (Exception unused) {
        }
        return iF;
    }
}
