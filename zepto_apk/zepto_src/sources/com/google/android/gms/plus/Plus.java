package com.google.android.gms.plus;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.plus.zze;
import com.google.android.gms.internal.plus.zzi;
import com.google.android.gms.internal.plus.zzj;
import com.google.android.gms.plus.internal.zzh;
import java.util.HashSet;

@Deprecated
/* loaded from: classes4.dex */
public final class Plus {

    /* renamed from: a, reason: collision with root package name */
    public static final Api f39681a = new Api("Plus.API", new zzc(), new Api.ClientKey());

    @Deprecated
    public static final class PlusOptions implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f39682a = new HashSet();

        @Deprecated
        public static final class Builder {
            public Builder() {
                new HashSet();
            }
        }
    }

    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzh> {
    }

    static {
        new Scope(Scopes.PLUS_LOGIN);
        new Scope(Scopes.PLUS_ME);
        new zzj();
        new zze();
        new zzi();
        new com.google.android.gms.internal.plus.zzh();
    }
}
