package com.amazon.apay.hardened.constant;

import com.amazon.identity.auth.device.api.authorization.Region;
import com.amazon.identity.auth.device.api.authorization.Scope;
import com.amazon.identity.auth.device.api.authorization.ScopeFactory;
import com.amazon.identity.auth.device.api.authorization.SubRegion;

/* loaded from: classes3.dex */
public final class AuthConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final Region f14977a = Region.EU;

    /* renamed from: b, reason: collision with root package name */
    public static final SubRegion f14978b = SubRegion.IN;

    /* renamed from: c, reason: collision with root package name */
    public static final Scope[] f14979c;

    /* renamed from: d, reason: collision with root package name */
    public static final Scope[] f14980d;

    static {
        Scope[] scopeArr = {ScopeFactory.scopeNamed("payments::conduct_silentpay"), ScopeFactory.scopeNamed("profile:user_id")};
        f14979c = scopeArr;
        f14980d = new Scope[]{scopeArr[0], scopeArr[1], ScopeFactory.scopeNamed("prime:benefit_status")};
    }
}
