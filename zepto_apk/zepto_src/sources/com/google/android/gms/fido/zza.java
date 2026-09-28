package com.google.android.gms.fido;

import com.google.android.gms.common.Feature;

/* loaded from: classes4.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public static final Feature f22531a;

    /* renamed from: b, reason: collision with root package name */
    public static final Feature f22532b;

    /* renamed from: c, reason: collision with root package name */
    public static final Feature f22533c;

    static {
        new Feature("cancel_target_direct_transfer", 1L);
        new Feature("delete_credential", 1L);
        new Feature("delete_device_public_key", 1L);
        new Feature("get_or_generate_device_public_key", 1L);
        new Feature("get_passkeys", 1L);
        new Feature("update_passkey", 1L);
        f22531a = new Feature("is_user_verifying_platform_authenticator_available_for_credential", 1L);
        f22532b = new Feature("is_user_verifying_platform_authenticator_available", 1L);
        f22533c = new Feature("privileged_api_list_credentials", 2L);
        new Feature("start_target_direct_transfer", 1L);
        new Feature("zero_party_api_register", 3L);
        new Feature("zero_party_api_sign", 3L);
        new Feature("zero_party_api_list_discoverable_credentials", 2L);
        new Feature("zero_party_api_authenticate_passkey", 1L);
        new Feature("zero_party_api_register_passkey", 1L);
        new Feature("zero_party_api_get_hybrid_client_registration_pending_intent", 1L);
        new Feature("zero_party_api_get_hybrid_client_sign_pending_intent", 1L);
        new Feature("get_browser_hybrid_client_sign_pending_intent", 1L);
        new Feature("get_browser_hybrid_client_registration_pending_intent", 1L);
    }
}
