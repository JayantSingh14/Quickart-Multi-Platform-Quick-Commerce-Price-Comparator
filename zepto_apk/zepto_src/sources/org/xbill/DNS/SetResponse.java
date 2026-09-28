package org.xbill.DNS;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.xbill.DNS.Cache;

/* loaded from: classes5.dex */
public class SetResponse {
    private static final SetResponse SR_NXDOMAIN;
    private static final SetResponse SR_NXDOMAIN_AUTH;
    private static final SetResponse SR_NXRRSET;
    private static final SetResponse SR_NXRRSET_AUTH;
    private static final SetResponse SR_UNKNOWN;
    private static final SetResponse SR_UNKNOWN_AUTH;
    private List<RRset> data;
    private boolean isAuthenticated;
    private final SetResponseType type;

    /* renamed from: org.xbill.DNS.SetResponse$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$xbill$DNS$SetResponseType;

        static {
            int[] iArr = new int[SetResponseType.values().length];
            $SwitchMap$org$xbill$DNS$SetResponseType = iArr;
            try {
                iArr[SetResponseType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.NXDOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.NXRRSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.DELEGATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.CNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.DNAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$xbill$DNS$SetResponseType[SetResponseType.SUCCESSFUL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        SetResponseType setResponseType = SetResponseType.UNKNOWN;
        SR_UNKNOWN = new SetResponse(setResponseType, null, false);
        SR_UNKNOWN_AUTH = new SetResponse(setResponseType, null, true);
        SetResponseType setResponseType2 = SetResponseType.NXDOMAIN;
        SR_NXDOMAIN = new SetResponse(setResponseType2, null, false);
        SR_NXDOMAIN_AUTH = new SetResponse(setResponseType2, null, true);
        SetResponseType setResponseType3 = SetResponseType.NXRRSET;
        SR_NXRRSET = new SetResponse(setResponseType3, null, false);
        SR_NXRRSET_AUTH = new SetResponse(setResponseType3, null, true);
    }

    private SetResponse(SetResponseType setResponseType, RRset rRset, boolean z) {
        this.type = setResponseType;
        this.isAuthenticated = z;
        if (rRset != null) {
            addRRset(rRset);
        }
    }

    public static SetResponse ofType(SetResponseType setResponseType) {
        return ofType(setResponseType, null, false);
    }

    public void addRRset(RRset rRset) {
        if (this.type.isSealed()) {
            throw new IllegalStateException("Attempted to add RRset to sealed response of type " + this.type);
        }
        if (this.data == null) {
            this.data = new ArrayList();
            if (rRset instanceof Cache.CacheRRset) {
                this.isAuthenticated = ((Cache.CacheRRset) rRset).isAuthenticated();
            }
        } else if ((rRset instanceof Cache.CacheRRset) && this.isAuthenticated) {
            this.isAuthenticated = ((Cache.CacheRRset) rRset).isAuthenticated();
        }
        this.data.add(rRset);
    }

    public List<RRset> answers() {
        if (this.type != SetResponseType.SUCCESSFUL) {
            return null;
        }
        return this.data;
    }

    public CNAMERecord getCNAME() {
        return (CNAMERecord) this.data.get(0).first();
    }

    public DNAMERecord getDNAME() {
        return (DNAMERecord) this.data.get(0).first();
    }

    public RRset getNS() {
        List<RRset> list = this.data;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Generated
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public boolean isCNAME() {
        return this.type == SetResponseType.CNAME;
    }

    public boolean isDNAME() {
        return this.type == SetResponseType.DNAME;
    }

    public boolean isDelegation() {
        return this.type == SetResponseType.DELEGATION;
    }

    public boolean isNXDOMAIN() {
        return this.type == SetResponseType.NXDOMAIN;
    }

    public boolean isNXRRSET() {
        return this.type == SetResponseType.NXRRSET;
    }

    public boolean isSuccessful() {
        return this.type == SetResponseType.SUCCESSFUL;
    }

    public boolean isUnknown() {
        return this.type == SetResponseType.UNKNOWN;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        if (this.type.isPrintRecords()) {
            str = ": " + this.data.get(0);
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static SetResponse ofType(SetResponseType setResponseType, RRset rRset) {
        return ofType(setResponseType, rRset, false);
    }

    public static SetResponse ofType(SetResponseType setResponseType, Cache.CacheRRset cacheRRset) {
        return ofType(setResponseType, cacheRRset, cacheRRset.isAuthenticated());
    }

    public static SetResponse ofType(SetResponseType setResponseType, RRset rRset, boolean z) {
        switch (AnonymousClass1.$SwitchMap$org$xbill$DNS$SetResponseType[setResponseType.ordinal()]) {
            case 1:
                return z ? SR_UNKNOWN_AUTH : SR_UNKNOWN;
            case 2:
                return z ? SR_NXDOMAIN_AUTH : SR_NXDOMAIN;
            case 3:
                return z ? SR_NXRRSET_AUTH : SR_NXRRSET;
            case 4:
            case 5:
            case 6:
            case 7:
                return new SetResponse(setResponseType, rRset, z);
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }
}
