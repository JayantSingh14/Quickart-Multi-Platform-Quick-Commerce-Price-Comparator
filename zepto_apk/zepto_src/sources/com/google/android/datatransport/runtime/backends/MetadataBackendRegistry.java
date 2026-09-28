package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
class MetadataBackendRegistry implements BackendRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final BackendFactoryProvider f20790a;

    /* renamed from: b, reason: collision with root package name */
    public final CreationContextFactory f20791b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f20792c;

    public static class BackendFactoryProvider {

        /* renamed from: a, reason: collision with root package name */
        public final Context f20793a;

        /* renamed from: b, reason: collision with root package name */
        public Map f20794b = null;

        public BackendFactoryProvider(Context context) {
            this.f20793a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.google.android.datatransport.runtime.backends.BackendFactory a(java.lang.String r14) throws android.content.pm.PackageManager.NameNotFoundException {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.MetadataBackendRegistry.BackendFactoryProvider.a(java.lang.String):com.google.android.datatransport.runtime.backends.BackendFactory");
        }
    }

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        BackendFactoryProvider backendFactoryProvider = new BackendFactoryProvider(context);
        this.f20792c = new HashMap();
        this.f20790a = backendFactoryProvider;
        this.f20791b = creationContextFactory;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    public final synchronized TransportBackend b(String str) {
        if (this.f20792c.containsKey(str)) {
            return (TransportBackend) this.f20792c.get(str);
        }
        BackendFactory backendFactoryA = this.f20790a.a(str);
        if (backendFactoryA == null) {
            return null;
        }
        CreationContextFactory creationContextFactory = this.f20791b;
        TransportBackend transportBackendCreate = backendFactoryA.create(CreationContext.a(creationContextFactory.f20784a, creationContextFactory.f20785b, creationContextFactory.f20786c, str));
        this.f20792c.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
