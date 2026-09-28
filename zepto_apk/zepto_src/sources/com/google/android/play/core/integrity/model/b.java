package com.google.android.play.core.integrity.model;

import androidx.fragment.app.e;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f41842a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f41843b;

    static {
        HashMap map = new HashMap();
        f41842a = map;
        HashMap map2 = new HashMap();
        f41843b = map2;
        Integer numJ = e.j(-2, -1, "Standard Integrity API is not available.\nStandard Integrity API is not enabled, or the Play Store version might be old.\nRecommended actions:\n1) Make sure to be allowlisted to use Standard Integrity API.\n2) Make sure that Integrity API is enabled in Google Play Console.\n3) Ask the user to update Play Store.\n", "The Play Store app is either not installed or not the official version.\nAsk the user to install an official and recent version of Play Store.\n", map);
        Integer numJ2 = e.j(-5, -3, "Network error: unable to obtain integrity details.\nAsk the user to check for a connection.\n", "PackageManager could not find this app.\nSomething is wrong (possibly an attack). Non-actionable.\n", map);
        Integer numJ3 = e.j(-7, -6, "Google Play Services is not available or version is too old.\nAsk the user to Install or Update Play Services.\n", "The calling app UID (user id) does not match the one from Package Manager.\nSomething is wrong (possibly an attack). Non-actionable.\n", map);
        Integer numJ4 = e.j(-9, -8, "The calling app is making too many requests to the API and hence is throttled.\nRetry with an exponential backoff.\n", "Binding to the service in the Play Store has failed. This can be due to having an old Play Store version installed on the device.\nAsk the user to update Play Store.\n", map);
        Integer numJ5 = e.j(-14, -12, "Unknown internal Google server error.\nRetry with an exponential backoff. Consider filing a bug if fails consistently.\n", "The Play Store needs to be updated.\nAsk the user to update the Google Play Store.\n", map);
        Integer numJ6 = e.j(-16, -15, "Play Services needs to be updated.\nAsk the user to update Google Play Services.\n", "The provided cloud project number is invalid.\nUse the cloud project number which can be found in Project info in your Google Cloud Console for the cloud project where Play Integrity API is enabled.\n", map);
        Integer numJ7 = e.j(-18, -17, "The provided request hash is too long. The request hash length must be less than 500 bytes.\nRetry with a shorter request hash.", "There is a transient error on the calling device.\nRetry with an exponential backoff.\n", map);
        Integer numJ8 = e.j(-100, -19, "The StandardIntegrityTokenProvider is invalid (e.g. it is outdated).\nRequest a new integrity token provider by calling StandardIntegrityManager#prepareIntegrityToken.", "Unknown error processing integrity request.\nRetry with an exponential backoff. Consider filing a bug if fails consistently.\n", map);
        map2.put(-1, "API_NOT_AVAILABLE");
        map2.put(-3, "NETWORK_ERROR");
        map2.put(numJ, "PLAY_STORE_NOT_FOUND");
        map2.put(numJ5, "PLAY_STORE_VERSION_OUTDATED");
        map2.put(numJ2, "APP_NOT_INSTALLED");
        map2.put(-6, "PLAY_SERVICES_NOT_FOUND");
        map2.put(-15, "PLAY_SERVICES_VERSION_OUTDATED");
        map2.put(numJ3, "APP_UID_MISMATCH");
        map2.put(-8, "TOO_MANY_REQUESTS");
        map2.put(numJ4, "CANNOT_BIND_TO_SERVICE");
        map2.put(numJ6, "CLOUD_PROJECT_NUMBER_IS_INVALID");
        map2.put(-17, "REQUEST_HASH_TOO_LONG");
        map2.put(-12, "GOOGLE_SERVER_UNAVAILABLE");
        map2.put(numJ7, "CLIENT_TRANSIENT_ERROR");
        map2.put(-19, "INTEGRITY_TOKEN_PROVIDER_INVALID");
        map2.put(numJ8, "INTERNAL_ERROR");
    }
}
