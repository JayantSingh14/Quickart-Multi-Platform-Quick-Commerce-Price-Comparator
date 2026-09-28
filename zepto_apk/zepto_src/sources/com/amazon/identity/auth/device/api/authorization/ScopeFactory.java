package com.amazon.identity.auth.device.api.authorization;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ScopeFactory {

    public static final class a implements Scope {

        /* renamed from: a, reason: collision with root package name */
        public final String f15116a;

        /* renamed from: b, reason: collision with root package name */
        public final JSONObject f15117b;

        public a(String str, JSONObject jSONObject) {
            if (str == null) {
                throw new IllegalArgumentException("Scope must have a name");
            }
            this.f15116a = str;
            this.f15117b = jSONObject;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = aVar.f15116a;
            String str2 = this.f15116a;
            if (str2 == null) {
                if (str != null) {
                    return false;
                }
            } else if (!str2.equals(str)) {
                return false;
            }
            JSONObject jSONObject = aVar.f15117b;
            JSONObject jSONObject2 = this.f15117b;
            if (jSONObject2 == null) {
                if (jSONObject != null) {
                    return false;
                }
            } else if (!jSONObject2.equals(jSONObject)) {
                return false;
            }
            return true;
        }

        @Override // com.amazon.identity.auth.device.api.authorization.Scope
        public final String getName() {
            return this.f15116a;
        }

        @Override // com.amazon.identity.auth.device.api.authorization.Scope
        public final JSONObject getScopeData() {
            return this.f15117b;
        }

        public final int hashCode() {
            String str = this.f15116a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            JSONObject jSONObject = this.f15117b;
            return iHashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
        }
    }

    public static Scope scopeNamed(String str) {
        return new a(str, null);
    }

    public static Scope scopeNamed(String str, JSONObject jSONObject) {
        return new a(str, jSONObject);
    }
}
