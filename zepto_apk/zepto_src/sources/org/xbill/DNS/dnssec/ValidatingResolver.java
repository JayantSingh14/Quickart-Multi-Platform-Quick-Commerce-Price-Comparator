package org.xbill.DNS.dnssec;

import j$.time.Clock;
import j$.time.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.DClass;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.EDNSOption;
import org.xbill.DNS.ExtendedErrorCodeOption;
import org.xbill.DNS.Header;
import org.xbill.DNS.Master;
import org.xbill.DNS.Message;
import org.xbill.DNS.NSECRecord;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.Type;
import org.xbill.DNS.dnssec.ValUtils;

/* loaded from: classes5.dex */
public final class ValidatingResolver implements Resolver {
    private static final long DEFAULT_TA_BAD_KEY_TTL = 60;
    public static final String TRUST_ANCHOR_FILE_PROPERTY = "dnsjava.dnssec.trust_anchor_file";
    public static final int VALIDATION_REASON_QCLASS = 65280;

    @Generated
    private static final Logger log = LoggerFactory.b(ValidatingResolver.class);
    private final Clock clock;
    private final Resolver headResolver;
    private boolean isAddReasonToAdditional;
    private final KeyCache keyCache;
    private final NSEC3ValUtils n3valUtils;
    private final TrustAnchorStore trustAnchors;
    private final ValUtils valUtils;

    /* renamed from: org.xbill.DNS.dnssec.ValidatingResolver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification;
        static final /* synthetic */ int[] $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus;

        static {
            int[] iArr = new int[SecurityStatus.values().length];
            $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus = iArr;
            try {
                iArr[SecurityStatus.SECURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[SecurityStatus.INSECURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[SecurityStatus.BOGUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[SecurityStatus.INDETERMINATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[SecurityStatus.UNCHECKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ResponseClassification.values().length];
            $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification = iArr2;
            try {
                iArr2[ResponseClassification.POSITIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.CNAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.NODATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.NAMEERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.ANY.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.CNAME_NODATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[ResponseClassification.CNAME_NAMEERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public ValidatingResolver(Resolver resolver) {
        this(resolver, Clock.systemUTC());
    }

    private void addValidationReasonTxtRecord(Message message, String str) {
        int length = (str.length() / 255) + 1;
        String[] strArr = new String[length];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            strArr[i2] = str.substring(i2 * 255, Math.min(i3 * 255, str.length()));
            i2 = i3;
        }
        message.addRecord(new TXTRecord(Name.root, VALIDATION_REASON_QCLASS, 0L, (List<String>) Arrays.asList(strArr)), 3);
    }

    private void applyEdeToOpt(SMessage sMessage, Message message) {
        OPTRecord oPTRecord;
        if (sMessage.getEdeReason() <= -1) {
            return;
        }
        OPTRecord opt = message.getOPT();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtendedErrorCodeOption(sMessage.getEdeReason(), sMessage.getBogusReason()));
        if (opt != null) {
            arrayList.addAll((Collection) opt.getOptions().stream().filter(new org.xbill.DNS.config.a(1)).collect(Collectors.toList()));
            oPTRecord = new OPTRecord(opt.getPayloadSize(), opt.getExtendedRcode(), opt.getVersion(), opt.getFlags(), arrayList);
            message.removeRecord(message.getOPT(), 3);
        } else {
            oPTRecord = new OPTRecord(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 0, 0, 0, arrayList);
        }
        message.addRecord(oPTRecord, 3);
    }

    private KeyEntry dsResponseToKE(SMessage sMessage, Message message, KeyEntry keyEntry) {
        Name name = message.getQuestion().getName();
        int dClass = message.getQuestion().getDClass();
        ResponseClassification responseClassificationClassifyResponse = ValUtils.classifyResponse(message, sMessage);
        KeyEntry keyEntryNewBadKeyEntry = KeyEntry.newBadKeyEntry(name, dClass, DEFAULT_TA_BAD_KEY_TTL);
        int i2 = AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[responseClassificationClassifyResponse.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return dsResponseToKeForNodata(sMessage, message, keyEntry);
                }
                keyEntryNewBadKeyEntry.setBadReason(6, R.get("failed.ds.notype", responseClassificationClassifyResponse));
                return keyEntryNewBadKeyEntry;
            }
            if (this.valUtils.verifySRRset(sMessage.findAnswerRRset(name, 5, dClass), keyEntry, this.clock.instant()).status == SecurityStatus.SECURE) {
                return null;
            }
            keyEntryNewBadKeyEntry.setBadReason(6, R.get("failed.ds.cname", new Object[0]));
            return keyEntryNewBadKeyEntry;
        }
        SRRset sRRsetFindAnswerRRset = sMessage.findAnswerRRset(name, 43, dClass);
        JustifiedSecStatus justifiedSecStatusVerifySRRset = this.valUtils.verifySRRset(sRRsetFindAnswerRRset, keyEntry, this.clock.instant());
        if (justifiedSecStatusVerifySRRset.status != SecurityStatus.SECURE) {
            keyEntryNewBadKeyEntry.setBadReason(justifiedSecStatusVerifySRRset.edeReason, justifiedSecStatusVerifySRRset.reason);
            return keyEntryNewBadKeyEntry;
        }
        if (this.valUtils.atLeastOneSupportedAlgorithm(sRRsetFindAnswerRRset)) {
            log.r("DS RRset was good");
            return KeyEntry.newKeyEntry(sRRsetFindAnswerRRset);
        }
        KeyEntry keyEntryNewNullKeyEntry = KeyEntry.newNullKeyEntry(name, dClass, sRRsetFindAnswerRRset.getTTL());
        keyEntryNewNullKeyEntry.setBadReason(1, R.get("insecure.ds.noalgorithms", name));
        return keyEntryNewNullKeyEntry;
    }

    private KeyEntry dsResponseToKeForNodata(SMessage sMessage, Message message, KeyEntry keyEntry) {
        Name name = message.getQuestion().getName();
        int dClass = message.getQuestion().getDClass();
        KeyEntry keyEntryNewBadKeyEntry = KeyEntry.newBadKeyEntry(name, dClass, DEFAULT_TA_BAD_KEY_TTL);
        if (!this.valUtils.hasSignedNsecs(sMessage)) {
            keyEntryNewBadKeyEntry.setBadReason(10, R.get("failed.ds.nonsec", name));
            return keyEntryNewBadKeyEntry;
        }
        JustifiedSecStatus justifiedSecStatusNsecProvesNodataDsReply = this.valUtils.nsecProvesNodataDsReply(message, sMessage, keyEntry, this.clock.instant());
        int i2 = AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[justifiedSecStatusNsecProvesNodataDsReply.status.ordinal()];
        if (i2 == 1) {
            KeyEntry keyEntryNewNullKeyEntry = KeyEntry.newNullKeyEntry(name, dClass, DEFAULT_TA_BAD_KEY_TTL);
            keyEntryNewNullKeyEntry.setBadReason(-1, R.get("insecure.ds.nsec", new Object[0]));
            return keyEntryNewNullKeyEntry;
        }
        if (i2 == 2) {
            return null;
        }
        if (i2 == 3) {
            keyEntryNewBadKeyEntry.setBadReason(justifiedSecStatusNsecProvesNodataDsReply.edeReason, justifiedSecStatusNsecProvesNodataDsReply.reason);
            return keyEntryNewBadKeyEntry;
        }
        List<SRRset> sectionRRsets = sMessage.getSectionRRsets(2, 50);
        ArrayList arrayList = new ArrayList(0);
        if (sectionRRsets.isEmpty()) {
            keyEntryNewBadKeyEntry.setBadReason(6, R.get("failed.ds.unknown", new Object[0]));
            return keyEntryNewBadKeyEntry;
        }
        long ttl = -1;
        Name signerName = null;
        for (SRRset sRRset : sectionRRsets) {
            if (this.valUtils.verifySRRset(sRRset, keyEntry, this.clock.instant()).status != SecurityStatus.SECURE) {
                log.o("Skipping bad NSEC3");
            } else {
                signerName = sRRset.getSignerName();
                if (ttl < 0 || sRRset.getTTL() < ttl) {
                    ttl = sRRset.getTTL();
                }
                arrayList.add(sRRset);
            }
        }
        int i3 = AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[this.n3valUtils.proveNoDS(arrayList, name, signerName, new Nsec3ValidationState()).ordinal()];
        if (i3 == 1 || i3 == 2) {
            KeyEntry keyEntryNewNullKeyEntry2 = KeyEntry.newNullKeyEntry(name, dClass, ttl);
            keyEntryNewNullKeyEntry2.setBadReason(-1, R.get("insecure.ds.nsec3", new Object[0]));
            return keyEntryNewNullKeyEntry2;
        }
        if (i3 == 3) {
            keyEntryNewBadKeyEntry.setBadReason(6, R.get("failed.ds.nsec3", new Object[0]));
            return keyEntryNewBadKeyEntry;
        }
        if (i3 != 4) {
            keyEntryNewBadKeyEntry.setBadReason(6, R.get("unknown.ds.nsec3", new Object[0]));
            return keyEntryNewBadKeyEntry;
        }
        log.o("NSEC3s for the referral proved no delegation");
        return null;
    }

    private static SMessage errorMessage(Message message, int i2) {
        SMessage sMessage = new SMessage(message.getHeader().getID(), message.getQuestion());
        Header header = sMessage.getHeader();
        header.setRcode(i2);
        header.setFlag(0);
        return sMessage;
    }

    private <T> CompletionStage<T> failedFuture(Throwable th) {
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.completeExceptionally(th);
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$applyEdeToOpt$19(EDNSOption eDNSOption) {
        return eDNSOption.getCode() != 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyEntry lambda$prepareFindKey$11(FindKeyState findKeyState, Void r1) {
        return findKeyState.keyEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$processValidate$14(SMessage sMessage, Message message, Nsec3ValidationState nsec3ValidationState, Executor executor, Void r6) {
        if (sMessage.getStatus() == SecurityStatus.INSECURE) {
            return CompletableFuture.completedFuture(null);
        }
        sMessage.setStatus(SecurityStatus.UNCHECKED, -1);
        return validateNodataResponse(message, sMessage, nsec3ValidationState, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$processValidate$15(SMessage sMessage, Message message, Nsec3ValidationState nsec3ValidationState, Executor executor, Void r6) {
        if (sMessage.getStatus() == SecurityStatus.INSECURE) {
            return CompletableFuture.completedFuture(null);
        }
        sMessage.setStatus(SecurityStatus.UNCHECKED, -1);
        return validateNameErrorResponse(message, sMessage, nsec3ValidationState, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SMessage lambda$processValidate$16(Message message, SMessage sMessage, Void r3) {
        return processFinishedState(message, sMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Message lambda$sendAsync$17(SMessage sMessage) {
        Message message = sMessage.getMessage();
        String bogusReason = sMessage.getBogusReason();
        if (bogusReason != null) {
            applyEdeToOpt(sMessage, message);
            if (this.isAddReasonToAdditional) {
                addValidationReasonTxtRecord(message, bogusReason);
            }
        }
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync$18(Message message, Executor executor, SMessage sMessage) {
        sMessage.getHeader().unsetFlag(10);
        if (message.getHeader().getFlag(11)) {
            return CompletableFuture.completedFuture(sMessage.getMessage());
        }
        Message message2 = sMessage.getMessage();
        if (message.getQuestion().getType() != 46 || message2.getHeader().getRcode() != 0 || message2.getSectionRRsets(1).isEmpty()) {
            return processValidate(message, sMessage, executor).thenApply(new f(this, 1));
        }
        message2.getHeader().unsetFlag(10);
        return CompletableFuture.completedFuture(message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SMessage lambda$sendRequest$10(Message message, Message message2) {
        return new SMessage(message2.normalize(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validateAnswerAndGetWildcardsRecursive$3(SRRset sRRset, SMessage sMessage, Map map, int i2, AtomicInteger atomicInteger, List list, Executor executor, KeyEntry keyEntry) {
        JustifiedSecStatus justifiedSecStatusValidateKeyFor = keyEntry.validateKeyFor(sRRset);
        if (justifiedSecStatusValidateKeyFor != null) {
            justifiedSecStatusValidateKeyFor.applyToResponse(sMessage);
            return CompletableFuture.completedFuture(Boolean.FALSE);
        }
        SecurityStatus securityStatus = this.valUtils.verifySRRset(sRRset, keyEntry, this.clock.instant()).status;
        SecurityStatus securityStatus2 = SecurityStatus.SECURE;
        if (securityStatus != securityStatus2) {
            sMessage.setBogus(R.get("failed.answer.positive", sRRset));
            return CompletableFuture.completedFuture(Boolean.FALSE);
        }
        try {
            Name nameRrsetWildcard = ValUtils.rrsetWildcard(sRRset);
            if (nameRrsetWildcard != null) {
                if (sRRset.getType() == 39) {
                    sMessage.setBogus(R.get("failed.dname.wildcard", sRRset.getName()));
                    return CompletableFuture.completedFuture(Boolean.FALSE);
                }
                map.put(sRRset.getName(), nameRrsetWildcard);
            }
            if (i2 != 39 && sRRset.getType() == 39) {
                DNAMERecord dNAMERecord = (DNAMERecord) sRRset.first();
                if (atomicInteger.getAndIncrement() < list.size()) {
                    SRRset sRRset2 = (SRRset) list.get(atomicInteger.get());
                    if (sRRset2.getType() == 5 && dNAMERecord != null) {
                        if (sRRset2.size() > 1) {
                            sMessage.setBogus(R.get("failed.synthesize.multiple", new Object[0]));
                            return CompletableFuture.completedFuture(Boolean.FALSE);
                        }
                        CNAMERecord cNAMERecord = (CNAMERecord) sRRset2.first();
                        try {
                            Name nameConcatenate = Name.concatenate(cNAMERecord.getName().relativize(dNAMERecord.getName()), dNAMERecord.getTarget());
                            if (!nameConcatenate.equals(cNAMERecord.getTarget())) {
                                sMessage.setBogus(R.get("failed.synthesize.nomatch", cNAMERecord.getTarget(), nameConcatenate));
                                return CompletableFuture.completedFuture(Boolean.FALSE);
                            }
                            sRRset2.setSecurityStatus(securityStatus2);
                        } catch (NameTooLongException unused) {
                            sMessage.setBogus(R.get("failed.synthesize.toolong", new Object[0]));
                            return CompletableFuture.completedFuture(Boolean.FALSE);
                        }
                    }
                }
            }
            atomicInteger.getAndIncrement();
            return validateAnswerAndGetWildcardsRecursive(sMessage, i2, map, atomicInteger, executor);
        } catch (RuntimeException e2) {
            sMessage.setBogus(R.get(e2.getMessage(), sRRset.getName()));
            return CompletableFuture.completedFuture(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$validateNameErrorResponse$6(SMessage sMessage, boolean z) {
        if (sMessage.getStatus() == SecurityStatus.SECURE) {
            sMessage.getHeader().setRcode(0);
        } else if (z) {
            sMessage.setBogus(R.get("failed.nxdomain.haswildcard", new Object[0]));
        } else {
            sMessage.setBogus(R.get("failed.nxdomain.exists", sMessage.getQuestion().getName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validateNameErrorResponse$7(final SMessage sMessage, Name name, Nsec3ValidationState nsec3ValidationState, Message message, Executor executor, Void r22) {
        ArrayList arrayList = new ArrayList(0);
        final boolean z = false;
        boolean zNsecProvesNoWC = false;
        int i2 = 0;
        Name signerName = null;
        for (SRRset sRRset : sMessage.getSectionRRsets(2)) {
            if (sRRset.getType() == 47) {
                NSECRecord nSECRecord = (NSECRecord) sRRset.first();
                if (ValUtils.nsecProvesNameError(sRRset, nSECRecord, name)) {
                    z = true;
                }
                int iLabels = ValUtils.closestEncloser(name, sRRset.getName(), nSECRecord.getNext()).labels();
                if (iLabels > i2 || (iLabels == i2 && !zNsecProvesNoWC)) {
                    zNsecProvesNoWC = ValUtils.nsecProvesNoWC(sRRset, nSECRecord, name);
                }
                i2 = iLabels;
            }
            if (sRRset.getType() == 50) {
                arrayList.add(sRRset);
                signerName = sRRset.getSignerName();
            }
        }
        this.n3valUtils.stripUnknownAlgNSEC3s(arrayList);
        if ((!z || !zNsecProvesNoWC) && !arrayList.isEmpty()) {
            log.o("Validating nxdomain: using NSEC3 records");
            if (this.n3valUtils.allNSEC3sIgnorable(arrayList, this.keyCache)) {
                sMessage.setStatus(SecurityStatus.INSECURE, -1, R.get("failed.nsec3_ignored", new Object[0]));
                return CompletableFuture.completedFuture(null);
            }
            SecurityStatus securityStatusProveNameError = this.n3valUtils.proveNameError(arrayList, name, signerName, nsec3ValidationState);
            if (securityStatusProveNameError != SecurityStatus.SECURE) {
                if (securityStatusProveNameError == SecurityStatus.INSECURE) {
                    sMessage.setStatus(securityStatusProveNameError, -1, R.get("failed.nxdomain.nsec3_insecure", new Object[0]));
                } else {
                    sMessage.setStatus(securityStatusProveNameError, 6, R.get("failed.nxdomain.nsec3_bogus", new Object[0]));
                }
                return CompletableFuture.completedFuture(null);
            }
            z = true;
            zNsecProvesNoWC = true;
        }
        if (!z || !zNsecProvesNoWC) {
            return validateNodataResponse(message, sMessage, nsec3ValidationState, executor).thenRun(new Runnable() { // from class: org.xbill.DNS.dnssec.g
                @Override // java.lang.Runnable
                public final void run() {
                    ValidatingResolver.lambda$validateNameErrorResponse$6(sMessage, z);
                }
            });
        }
        log.r("Successfully validated NAME ERROR response");
        sMessage.setStatus(SecurityStatus.SECURE, -1);
        return CompletableFuture.completedFuture(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$validateNameErrorResponse$8(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validateNameErrorResponseRecursive$9(SRRset sRRset, SMessage sMessage, AtomicInteger atomicInteger, Executor executor, KeyEntry keyEntry) {
        JustifiedSecStatus justifiedSecStatusValidateKeyFor = keyEntry.validateKeyFor(sRRset);
        if (justifiedSecStatusValidateKeyFor != null) {
            justifiedSecStatusValidateKeyFor.applyToResponse(sMessage);
            return failedFuture(new Exception(justifiedSecStatusValidateKeyFor.reason));
        }
        if (this.valUtils.verifySRRset(sRRset, keyEntry, this.clock.instant()).status == SecurityStatus.SECURE) {
            return validateNameErrorResponseRecursive(sMessage, atomicInteger, executor);
        }
        sMessage.setBogus(R.get("failed.nxdomain.authority", sRRset));
        return failedFuture(new Exception("failed.nxdomain.authority"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$validateNodataResponse$4(SMessage sMessage, Name name, int i2, Nsec3ValidationState nsec3ValidationState, Void r21, Throwable th) {
        Void r8 = null;
        if (th != null) {
            return null;
        }
        ValUtils.NsecProvesNodataResponse nsecProvesNodataResponse = new ValUtils.NsecProvesNodataResponse();
        ArrayList arrayList = new ArrayList(0);
        Iterator<SRRset> it = sMessage.getSectionRRsets(2).iterator();
        int i3 = 12;
        Name nameClosestEncloser = null;
        Name signerName = null;
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SRRset next = it.next();
            Void r212 = r8;
            if (next.getType() == 47) {
                NSECRecord nSECRecord = (NSECRecord) next.first();
                ValUtils.NsecProvesNodataResponse nsecProvesNodataResponseNsecProvesNodata = ValUtils.nsecProvesNodata(next, nSECRecord, name, i2);
                if (nsecProvesNodataResponseNsecProvesNodata.result) {
                    z = true;
                } else {
                    i3 = 6;
                }
                if (ValUtils.nsecProvesNameError(next, nSECRecord, name)) {
                    nameClosestEncloser = ValUtils.closestEncloser(name, next.getName(), nSECRecord.getNext());
                }
                nsecProvesNodataResponse = nsecProvesNodataResponseNsecProvesNodata;
            }
            if (next.getType() == 50) {
                arrayList.add(next);
                signerName = next.getSignerName();
            }
            r8 = r212;
        }
        Void r213 = r8;
        Name name2 = nsecProvesNodataResponse.wc;
        if (name2 != null && (nameClosestEncloser == null || (!nameClosestEncloser.equals(name2) && !name.equals(nameClosestEncloser)))) {
            z = false;
            i3 = 6;
        }
        this.n3valUtils.stripUnknownAlgNSEC3s(arrayList);
        if (!z && !arrayList.isEmpty()) {
            log.o("Using NSEC3 records");
            if (this.n3valUtils.allNSEC3sIgnorable(arrayList, this.keyCache)) {
                sMessage.setBogus(R.get("failed.nsec3_ignored", new Object[0]));
                return r213;
            }
            JustifiedSecStatus justifiedSecStatusProveNodata = this.n3valUtils.proveNodata(arrayList, name, i2, signerName, nsec3ValidationState);
            i3 = justifiedSecStatusProveNodata.edeReason;
            SecurityStatus securityStatus = justifiedSecStatusProveNodata.status;
            SecurityStatus securityStatus2 = SecurityStatus.INSECURE;
            if (securityStatus == securityStatus2) {
                sMessage.setStatus(securityStatus2, -1);
                return r213;
            }
            z = securityStatus == SecurityStatus.SECURE;
        }
        if (z) {
            log.r("Successfully validated NODATA response");
            sMessage.setStatus(SecurityStatus.SECURE, -1);
            return r213;
        }
        sMessage.setBogus(R.get("failed.nodata", new Object[0]), i3);
        log.m(name, "Failed NODATA for {}");
        return r213;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validateNodataResponseRecursive$5(SRRset sRRset, SMessage sMessage, AtomicInteger atomicInteger, Nsec3ValidationState nsec3ValidationState, Executor executor, KeyEntry keyEntry) {
        JustifiedSecStatus justifiedSecStatusValidateKeyFor = keyEntry.validateKeyFor(sRRset);
        if (justifiedSecStatusValidateKeyFor != null) {
            justifiedSecStatusValidateKeyFor.applyToResponse(sMessage);
            return failedFuture(new Exception(justifiedSecStatusValidateKeyFor.reason));
        }
        if (this.valUtils.verifySRRset(sRRset, keyEntry, this.clock.instant()).status == SecurityStatus.SECURE) {
            return validateNodataResponseRecursive(sMessage, atomicInteger, nsec3ValidationState, executor);
        }
        sMessage.setBogus(R.get("failed.authority.nodata", sRRset));
        return failedFuture(new Exception("failed.authority.nodata"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validatePositiveResponse$0(Message message, SMessage sMessage, Map map, List list, List list2, Executor executor, Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            return validatePositiveResponseRecursive(sMessage, map, list, list2, message.getQuestion().getType() == 255 ? new int[]{1, 2} : new int[]{2}, new AtomicInteger(0), new AtomicInteger(0), executor);
        }
        return CompletableFuture.completedFuture(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$validatePositiveResponse$1(java.util.Map r13, java.util.List r14, java.util.List r15, org.xbill.DNS.dnssec.SMessage r16, org.xbill.DNS.dnssec.Nsec3ValidationState r17, java.lang.Boolean r18) {
        /*
            r12 = this;
            r1 = r15
            r6 = r16
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r2 = r18
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto Le
            return
        Le:
            boolean r0 = r13.isEmpty()
            r7 = -1
            if (r0 != 0) goto Ld6
            java.util.Set r0 = r13.entrySet()
            java.util.Iterator r8 = r0.iterator()
        L1d:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto Ld6
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Iterator r2 = r14.iterator()
        L2d:
            boolean r3 = r2.hasNext()
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L73
            java.lang.Object r3 = r2.next()
            org.xbill.DNS.dnssec.SRRset r3 = (org.xbill.DNS.dnssec.SRRset) r3
            org.xbill.DNS.Record r4 = r3.first()
            org.xbill.DNS.NSECRecord r4 = (org.xbill.DNS.NSECRecord) r4
            java.lang.Object r5 = r0.getKey()
            org.xbill.DNS.Name r5 = (org.xbill.DNS.Name) r5
            boolean r5 = org.xbill.DNS.dnssec.ValUtils.nsecProvesNameError(r3, r4, r5)
            if (r5 == 0) goto L2d
            java.lang.Object r5 = r0.getKey()     // Catch: org.xbill.DNS.NameTooLongException -> L65
            org.xbill.DNS.Name r5 = (org.xbill.DNS.Name) r5     // Catch: org.xbill.DNS.NameTooLongException -> L65
            org.xbill.DNS.Name r3 = org.xbill.DNS.dnssec.ValUtils.nsecWildcard(r5, r3, r4)     // Catch: org.xbill.DNS.NameTooLongException -> L65
            java.lang.Object r4 = r0.getValue()     // Catch: org.xbill.DNS.NameTooLongException -> L65
            org.xbill.DNS.Name r4 = (org.xbill.DNS.Name) r4     // Catch: org.xbill.DNS.NameTooLongException -> L65
            boolean r3 = r4.equals(r3)     // Catch: org.xbill.DNS.NameTooLongException -> L65
            if (r3 == 0) goto L2d
            r11 = r9
            goto L74
        L65:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "failed.positive.wildcardgeneration"
            java.lang.Object[] r2 = new java.lang.Object[r10]
            java.lang.String r1 = org.xbill.DNS.dnssec.R.get(r1, r2)
            r0.<init>(r1)
            throw r0
        L73:
            r11 = r10
        L74:
            if (r11 != 0) goto Lc4
            boolean r2 = r15.isEmpty()
            if (r2 != 0) goto Lc4
            org.xbill.DNS.dnssec.NSEC3ValUtils r2 = r12.n3valUtils
            org.xbill.DNS.dnssec.KeyCache r3 = r12.keyCache
            boolean r2 = r2.allNSEC3sIgnorable(r15, r3)
            if (r2 == 0) goto L94
            org.xbill.DNS.dnssec.SecurityStatus r0 = org.xbill.DNS.dnssec.SecurityStatus.INSECURE
            java.lang.String r1 = "failed.nsec3_ignored"
            java.lang.Object[] r2 = new java.lang.Object[r10]
            java.lang.String r1 = org.xbill.DNS.dnssec.R.get(r1, r2)
            r6.setStatus(r0, r7, r1)
            return
        L94:
            r2 = r0
            org.xbill.DNS.dnssec.NSEC3ValUtils r0 = r12.n3valUtils
            java.lang.Object r3 = r2.getKey()
            org.xbill.DNS.Name r3 = (org.xbill.DNS.Name) r3
            java.lang.Object r4 = r15.get(r10)
            org.xbill.DNS.dnssec.SRRset r4 = (org.xbill.DNS.dnssec.SRRset) r4
            org.xbill.DNS.Name r4 = r4.getSignerName()
            java.lang.Object r2 = r2.getValue()
            org.xbill.DNS.Name r2 = (org.xbill.DNS.Name) r2
            r5 = r4
            r4 = r2
            r2 = r3
            r3 = r5
            r5 = r17
            org.xbill.DNS.dnssec.SecurityStatus r0 = r0.proveWildcard(r1, r2, r3, r4, r5)
            org.xbill.DNS.dnssec.SecurityStatus r1 = org.xbill.DNS.dnssec.SecurityStatus.INSECURE
            if (r0 != r1) goto Lbf
            r6.setStatus(r0, r7)
            return
        Lbf:
            org.xbill.DNS.dnssec.SecurityStatus r1 = org.xbill.DNS.dnssec.SecurityStatus.SECURE
            if (r0 != r1) goto Lc4
            goto Lc5
        Lc4:
            r9 = r11
        Lc5:
            if (r9 != 0) goto Ld3
            java.lang.String r0 = "failed.positive.wildcard_too_broad"
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r0 = org.xbill.DNS.dnssec.R.get(r0, r1)
            r6.setBogus(r0)
            return
        Ld3:
            r1 = r15
            goto L1d
        Ld6:
            org.xbill.DNS.dnssec.SecurityStatus r0 = org.xbill.DNS.dnssec.SecurityStatus.SECURE
            r6.setStatus(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.dnssec.ValidatingResolver.lambda$validatePositiveResponse$1(java.util.Map, java.util.List, java.util.List, org.xbill.DNS.dnssec.SMessage, org.xbill.DNS.dnssec.Nsec3ValidationState, java.lang.Boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$validatePositiveResponseRecursive$2(SRRset sRRset, SMessage sMessage, Map map, List list, List list2, int[] iArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, Executor executor, KeyEntry keyEntry) {
        JustifiedSecStatus justifiedSecStatusValidateKeyFor = keyEntry.validateKeyFor(sRRset);
        if (justifiedSecStatusValidateKeyFor != null) {
            justifiedSecStatusValidateKeyFor.applyToResponse(sMessage);
            return CompletableFuture.completedFuture(Boolean.FALSE);
        }
        if (this.valUtils.verifySRRset(sRRset, keyEntry, this.clock.instant()).status != SecurityStatus.SECURE) {
            sMessage.setBogus(R.get("failed.authority.positive", sRRset));
            return CompletableFuture.completedFuture(Boolean.FALSE);
        }
        if (!map.isEmpty()) {
            if (sRRset.getType() == 47) {
                list.add(sRRset);
            } else if (sRRset.getType() == 50) {
                list2.add(sRRset);
            }
        }
        return validatePositiveResponseRecursive(sMessage, map, list2, list, iArr, atomicInteger, atomicInteger2, executor);
    }

    private CompletionStage<KeyEntry> prepareFindKey(SRRset sRRset, Executor executor) {
        FindKeyState findKeyState = new FindKeyState();
        findKeyState.signerName = sRRset.getSignerName();
        findKeyState.qclass = sRRset.getDClass();
        if (findKeyState.signerName == null) {
            findKeyState.signerName = sRRset.getName();
        }
        RRset rRsetFind = this.trustAnchors.find(findKeyState.signerName, sRRset.getDClass());
        if (rRsetFind == null) {
            return CompletableFuture.completedFuture(KeyEntry.newNullKeyEntry(findKeyState.signerName, sRRset.getDClass(), DEFAULT_TA_BAD_KEY_TTL));
        }
        SRRset sRRset2 = new SRRset(rRsetFind);
        SecurityStatus securityStatus = SecurityStatus.SECURE;
        sRRset2.setSecurityStatus(securityStatus);
        KeyEntry keyEntryFind = this.keyCache.find(findKeyState.signerName, sRRset.getDClass());
        findKeyState.keyEntry = keyEntryFind;
        if (keyEntryFind == null || (!keyEntryFind.getName().equals(findKeyState.signerName) && findKeyState.keyEntry.isGood())) {
            if (sRRset2.getType() == 43) {
                findKeyState.dsRRset = sRRset2;
                findKeyState.keyEntry = null;
                findKeyState.currentDSKeyName = new Name(rRsetFind.getName(), 1);
                return processFindKey(findKeyState, executor).thenApply(new f(findKeyState, 0));
            }
            KeyEntry keyEntryNewKeyEntry = KeyEntry.newKeyEntry(sRRset2);
            findKeyState.keyEntry = keyEntryNewKeyEntry;
            keyEntryNewKeyEntry.setSecurityStatus(securityStatus);
            this.keyCache.store(findKeyState.keyEntry);
        }
        return CompletableFuture.completedFuture(findKeyState.keyEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processDNSKEYResponse, reason: merged with bridge method [inline-methods] */
    public CompletionStage<Void> lambda$processFindKey$13(Message message, SMessage sMessage, FindKeyState findKeyState, Executor executor) {
        Name name = message.getQuestion().getName();
        int dClass = message.getQuestion().getDClass();
        SRRset sRRsetFindAnswerRRset = sMessage.findAnswerRRset(name, 48, dClass);
        if (sRRsetFindAnswerRRset == null) {
            KeyEntry keyEntryNewBadKeyEntry = KeyEntry.newBadKeyEntry(name, dClass, DEFAULT_TA_BAD_KEY_TTL);
            findKeyState.keyEntry = keyEntryNewBadKeyEntry;
            keyEntryNewBadKeyEntry.setBadReason(9, R.get("dnskey.no_rrset", name));
            return CompletableFuture.completedFuture(null);
        }
        KeyEntry keyEntryVerifyNewDNSKEYs = this.valUtils.verifyNewDNSKEYs(sRRsetFindAnswerRRset, findKeyState.dsRRset, DEFAULT_TA_BAD_KEY_TTL, this.clock.instant());
        findKeyState.keyEntry = keyEntryVerifyNewDNSKEYs;
        if (!keyEntryVerifyNewDNSKEYs.isGood()) {
            return CompletableFuture.completedFuture(null);
        }
        this.keyCache.store(findKeyState.keyEntry);
        return processFindKey(findKeyState, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processDSResponse, reason: merged with bridge method [inline-methods] */
    public CompletionStage<Void> lambda$processFindKey$12(Message message, SMessage sMessage, FindKeyState findKeyState, Executor executor) {
        Name name = message.getQuestion().getName();
        findKeyState.emptyDSName = null;
        findKeyState.dsRRset = null;
        KeyEntry keyEntryDsResponseToKE = dsResponseToKE(sMessage, message, findKeyState.keyEntry);
        if (keyEntryDsResponseToKE == null) {
            findKeyState.emptyDSName = name;
        } else {
            if (!keyEntryDsResponseToKE.isGood()) {
                findKeyState.keyEntry = keyEntryDsResponseToKE;
                if (keyEntryDsResponseToKE.isNull()) {
                    this.keyCache.store(keyEntryDsResponseToKE);
                }
                return CompletableFuture.completedFuture(null);
            }
            findKeyState.dsRRset = keyEntryDsResponseToKE;
            findKeyState.currentDSKeyName = new Name(keyEntryDsResponseToKE.getName(), 1);
        }
        return processFindKey(findKeyState, executor);
    }

    private CompletionStage<Void> processFindKey(final FindKeyState findKeyState, final Executor executor) {
        int i2 = findKeyState.qclass;
        Name name = findKeyState.signerName;
        Name name2 = Name.empty;
        KeyEntry keyEntry = findKeyState.keyEntry;
        if (keyEntry != null) {
            name2 = keyEntry.getName();
        }
        Name name3 = findKeyState.currentDSKeyName;
        if (name3 != null) {
            findKeyState.currentDSKeyName = null;
            name2 = name3;
        }
        if (name2.equals(name)) {
            return CompletableFuture.completedFuture(null);
        }
        Name name4 = findKeyState.emptyDSName;
        if (name4 != null) {
            name2 = name4;
        }
        int iLabels = (name.labels() - name2.labels()) - 1;
        if (iLabels < 0) {
            return CompletableFuture.completedFuture(null);
        }
        Name name5 = new Name(name, iLabels);
        log.i("Key search: targetKeyName = {}, currentKeyName = {}, nextKeyName = {}", name, name2, name5);
        SRRset sRRset = findKeyState.dsRRset;
        if (sRRset == null || !sRRset.getName().equals(name5)) {
            final Message messageNewQuery = Message.newQuery(Record.newRecord(name5, 43, i2));
            final int i3 = 0;
            return sendRequest(messageNewQuery, executor).thenComposeAsync(new Function(this) { // from class: org.xbill.DNS.dnssec.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ValidatingResolver f57948b;

                {
                    this.f57948b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    SMessage sMessage = (SMessage) obj;
                    switch (i3) {
                        case 0:
                            return this.f57948b.lambda$processFindKey$12(messageNewQuery, findKeyState, executor, sMessage);
                        default:
                            return this.f57948b.lambda$processFindKey$13(messageNewQuery, findKeyState, executor, sMessage);
                    }
                }
            });
        }
        final Message messageNewQuery2 = Message.newQuery(Record.newRecord(findKeyState.dsRRset.getName(), 48, i2));
        final int i4 = 1;
        return sendRequest(messageNewQuery2, executor).thenComposeAsync(new Function(this) { // from class: org.xbill.DNS.dnssec.e

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ValidatingResolver f57948b;

            {
                this.f57948b = this;
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                SMessage sMessage = (SMessage) obj;
                switch (i4) {
                    case 0:
                        return this.f57948b.lambda$processFindKey$12(messageNewQuery2, findKeyState, executor, sMessage);
                    default:
                        return this.f57948b.lambda$processFindKey$13(messageNewQuery2, findKeyState, executor, sMessage);
                }
            }
        });
    }

    private SMessage processFinishedState(Message message, SMessage sMessage) {
        SecurityStatus status = sMessage.getStatus();
        String bogusReason = sMessage.getBogusReason();
        int edeReason = sMessage.getEdeReason();
        int i2 = AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[status.ordinal()];
        if (i2 != 1) {
            int i3 = 2;
            if (i2 != 2) {
                if (i2 == 3) {
                    int rcode = sMessage.getHeader().getRcode();
                    if (rcode != 0 && rcode != 3) {
                        i3 = rcode;
                    }
                    sMessage = errorMessage(message, i3);
                } else if (i2 != 5) {
                    throw new IllegalArgumentException("unexpected security status");
                }
            }
        } else {
            sMessage.getHeader().setFlag(10);
        }
        sMessage.setStatus(status, edeReason, bogusReason);
        return sMessage;
    }

    private CompletionStage<SMessage> processValidate(Message message, SMessage sMessage, Executor executor) {
        Message message2;
        SMessage sMessage2;
        CompletionStage<Void> completionStageValidatePositiveResponse;
        ResponseClassification responseClassificationClassifyResponse = ValUtils.classifyResponse(message, sMessage);
        if (responseClassificationClassifyResponse != ResponseClassification.REFERRAL) {
            removeSpuriousAuthority(sMessage);
        }
        Nsec3ValidationState nsec3ValidationState = new Nsec3ValidationState();
        switch (AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$ResponseClassification[responseClassificationClassifyResponse.ordinal()]) {
            case 1:
            case 2:
            case 5:
                message2 = message;
                sMessage2 = sMessage;
                log.r("Validating a positive response");
                completionStageValidatePositiveResponse = validatePositiveResponse(message2, sMessage2, nsec3ValidationState, executor);
                break;
            case 3:
                message2 = message;
                sMessage2 = sMessage;
                log.r("Validating a nodata response");
                completionStageValidatePositiveResponse = validateNodataResponse(message2, sMessage2, nsec3ValidationState, executor);
                break;
            case 4:
                message2 = message;
                sMessage2 = sMessage;
                log.r("Validating a nxdomain response");
                completionStageValidatePositiveResponse = validateNameErrorResponse(message2, sMessage2, nsec3ValidationState, executor);
                break;
            case 6:
                message2 = message;
                sMessage2 = sMessage;
                log.r("Validating a CNAME_NODATA response");
                completionStageValidatePositiveResponse = validatePositiveResponse(message2, sMessage2, nsec3ValidationState, executor).thenCompose(new c(this, sMessage2, message2, nsec3ValidationState, executor, 0));
                break;
            case 7:
                log.r("Validating a cname_nxdomain response");
                message2 = message;
                sMessage2 = sMessage;
                completionStageValidatePositiveResponse = validatePositiveResponse(message, sMessage, nsec3ValidationState, executor).thenCompose(new c(this, sMessage2, message2, nsec3ValidationState, executor, 1));
                break;
            default:
                sMessage.setBogus(R.get("validate.response.unknown", responseClassificationClassifyResponse));
                completionStageValidatePositiveResponse = CompletableFuture.completedFuture(null);
                message2 = message;
                sMessage2 = sMessage;
                break;
        }
        return completionStageValidatePositiveResponse.thenApply(new d(this, message2, sMessage2, 0));
    }

    private void removeSpuriousAuthority(SMessage sMessage) {
        if (sMessage.getSectionRRsets(1).isEmpty() && sMessage.getSectionRRsets(2).size() == 1) {
            return;
        }
        Iterator<SRRset> it = sMessage.getSectionRRsets(2).iterator();
        while (it.hasNext()) {
            SRRset next = it.next();
            if (next.getType() == 2 && next.sigs().isEmpty()) {
                log.i("Removing spurious unsigned NS record (likely inserted by forwarder) {}/{}/{}", next.getName(), Type.string(next.getType()), DClass.string(next.getDClass()));
                it.remove();
            }
        }
    }

    private CompletionStage<SMessage> sendRequest(Message message, Executor executor) {
        Record question = message.getQuestion();
        log.i("Sending request: <{}/{}/{}>", question.getName(), Type.string(question.getType()), DClass.string(question.getDClass()));
        Message messageClone = message.clone();
        messageClone.getHeader().setFlag(11);
        return this.headResolver.sendAsync(messageClone, executor).thenApply(new f(messageClone, 2));
    }

    private CompletionStage<Boolean> validateAnswerAndGetWildcards(SMessage sMessage, int i2, Map<Name, Name> map, Executor executor) {
        return validateAnswerAndGetWildcardsRecursive(sMessage, i2, map, new AtomicInteger(0), executor);
    }

    private CompletionStage<Boolean> validateAnswerAndGetWildcardsRecursive(final SMessage sMessage, final int i2, final Map<Name, Name> map, final AtomicInteger atomicInteger, final Executor executor) {
        final List<SRRset> sectionRRsets = sMessage.getSectionRRsets(1);
        if (atomicInteger.get() >= sectionRRsets.size()) {
            return CompletableFuture.completedFuture(Boolean.TRUE);
        }
        final SRRset sRRset = sectionRRsets.get(atomicInteger.get());
        return prepareFindKey(sRRset, executor).thenCompose(new Function() { // from class: org.xbill.DNS.dnssec.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ValidatingResolver validatingResolver = this.f57957a;
                SMessage sMessage2 = sMessage;
                AtomicInteger atomicInteger2 = atomicInteger;
                List list = sectionRRsets;
                return validatingResolver.lambda$validateAnswerAndGetWildcardsRecursive$3(sRRset, sMessage2, map, i2, atomicInteger2, list, executor, (KeyEntry) obj);
            }
        });
    }

    private CompletionStage<Void> validateNameErrorResponse(Message message, SMessage sMessage, Nsec3ValidationState nsec3ValidationState, Executor executor) {
        SRRset next;
        Name name = message.getQuestion().getName();
        Iterator<SRRset> it = sMessage.getSectionRRsets(1).iterator();
        while (true) {
            Name name2 = name;
            while (it.hasNext()) {
                next = it.next();
                if (next.getSecurityStatus() != SecurityStatus.SECURE) {
                    sMessage.setBogus(R.get("failed.nxdomain.cname_nxdomain", next));
                    return CompletableFuture.completedFuture(null);
                }
                if (next.getType() == 5) {
                    break;
                }
            }
            return validateNameErrorResponseRecursive(sMessage, new AtomicInteger(0), executor).thenComposeAsync(new b(this, sMessage, name2, nsec3ValidationState, message, executor)).exceptionally(new h(0));
            name = ((CNAMERecord) next.first()).getTarget();
        }
    }

    private CompletionStage<Void> validateNameErrorResponseRecursive(SMessage sMessage, AtomicInteger atomicInteger, Executor executor) {
        if (atomicInteger.get() >= sMessage.getSectionRRsets(2).size()) {
            return CompletableFuture.completedFuture(null);
        }
        SRRset sRRset = sMessage.getSectionRRsets(2).get(atomicInteger.getAndIncrement());
        return prepareFindKey(sRRset, executor).thenCompose(new c(this, sRRset, sMessage, atomicInteger, executor));
    }

    private CompletionStage<Void> validateNodataResponse(Message message, final SMessage sMessage, final Nsec3ValidationState nsec3ValidationState, Executor executor) {
        SRRset next;
        Name name = message.getQuestion().getName();
        final int type = message.getQuestion().getType();
        Iterator<SRRset> it = sMessage.getSectionRRsets(1).iterator();
        while (true) {
            final Name name2 = name;
            while (it.hasNext()) {
                next = it.next();
                if (next.getSecurityStatus() != SecurityStatus.SECURE) {
                    sMessage.setBogus(R.get("failed.answer.cname_nodata", next.getName()));
                    return CompletableFuture.completedFuture(null);
                }
                if (next.getType() == 5) {
                    break;
                }
            }
            return validateNodataResponseRecursive(sMessage, new AtomicInteger(0), nsec3ValidationState, executor).handleAsync(new BiFunction() { // from class: org.xbill.DNS.dnssec.k
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    ValidatingResolver validatingResolver = this.f57975a;
                    SMessage sMessage2 = sMessage;
                    int i2 = type;
                    Nsec3ValidationState nsec3ValidationState2 = nsec3ValidationState;
                    return validatingResolver.lambda$validateNodataResponse$4(sMessage2, name2, i2, nsec3ValidationState2, (Void) obj, (Throwable) obj2);
                }
            });
            name = ((CNAMERecord) next.first()).getTarget();
        }
    }

    private CompletionStage<Void> validateNodataResponseRecursive(SMessage sMessage, AtomicInteger atomicInteger, Nsec3ValidationState nsec3ValidationState, Executor executor) {
        if (atomicInteger.get() >= sMessage.getSectionRRsets(2).size()) {
            return CompletableFuture.completedFuture(null);
        }
        SRRset sRRset = sMessage.getSectionRRsets(2).get(atomicInteger.getAndIncrement());
        return prepareFindKey(sRRset, executor).thenComposeAsync(new b(this, sRRset, sMessage, atomicInteger, nsec3ValidationState, executor));
    }

    private CompletionStage<Void> validatePositiveResponse(final Message message, final SMessage sMessage, final Nsec3ValidationState nsec3ValidationState, final Executor executor) {
        final HashMap map = new HashMap(1);
        final ArrayList arrayList = new ArrayList(0);
        final ArrayList arrayList2 = new ArrayList(0);
        return validateAnswerAndGetWildcards(sMessage, message.getQuestion().getType(), map, executor).thenCompose(new Function() { // from class: org.xbill.DNS.dnssec.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ValidatingResolver validatingResolver = this.f57980a;
                Message message2 = message;
                HashMap map2 = map;
                ArrayList arrayList3 = arrayList;
                ArrayList arrayList4 = arrayList2;
                return validatingResolver.lambda$validatePositiveResponse$0(message2, sMessage, map2, arrayList3, arrayList4, executor, (Boolean) obj);
            }
        }).thenAccept(new Consumer() { // from class: org.xbill.DNS.dnssec.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f57987a.lambda$validatePositiveResponse$1(map, arrayList2, arrayList, sMessage, nsec3ValidationState, (Boolean) obj);
            }
        });
    }

    private CompletionStage<Boolean> validatePositiveResponseRecursive(final SMessage sMessage, final Map<Name, Name> map, final List<SRRset> list, final List<SRRset> list2, final int[] iArr, final AtomicInteger atomicInteger, final AtomicInteger atomicInteger2, final Executor executor) {
        if (atomicInteger.get() >= iArr.length) {
            return CompletableFuture.completedFuture(Boolean.TRUE);
        }
        List<SRRset> sectionRRsets = sMessage.getSectionRRsets(iArr[atomicInteger.get()]);
        if (atomicInteger2.get() < sectionRRsets.size()) {
            final SRRset sRRset = sectionRRsets.get(atomicInteger2.getAndIncrement());
            return prepareFindKey(sRRset, executor).thenCompose(new Function() { // from class: org.xbill.DNS.dnssec.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    ValidatingResolver validatingResolver = this.f57965a;
                    SMessage sMessage2 = sMessage;
                    int[] iArr2 = iArr;
                    AtomicInteger atomicInteger3 = atomicInteger;
                    AtomicInteger atomicInteger4 = atomicInteger2;
                    return validatingResolver.lambda$validatePositiveResponseRecursive$2(sRRset, sMessage2, map, list2, list, iArr2, atomicInteger3, atomicInteger4, executor, (KeyEntry) obj);
                }
            });
        }
        atomicInteger.getAndIncrement();
        atomicInteger2.set(0);
        return validatePositiveResponseRecursive(sMessage, map, list, list2, iArr, atomicInteger, atomicInteger2, executor);
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.headResolver.getTimeout();
    }

    public TrustAnchorStore getTrustAnchors() {
        return this.trustAnchors;
    }

    public void init(Properties properties) throws IOException {
        this.keyCache.init(properties);
        this.n3valUtils.init(properties);
        this.valUtils.init(properties);
        String property = properties.getProperty(TRUST_ANCHOR_FILE_PROPERTY);
        if (property != null) {
            log.s(property, "Reading trust anchor file: {}");
            loadTrustAnchors(new FileInputStream(property));
        }
    }

    @Generated
    public boolean isAddReasonToAdditional() {
        return this.isAddReasonToAdditional;
    }

    public void loadTrustAnchors(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        Master master = new Master(inputStream, Name.root, 0L);
        while (true) {
            try {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord == null) {
                    break;
                } else {
                    arrayList.add(recordNextRecord);
                }
            } catch (Throwable th) {
                try {
                    master.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        master.close();
        Collections.sort(arrayList);
        SRRset sRRset = new SRRset();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Record record = (Record) it.next();
            if (record.getType() == 48 || record.getType() == 43) {
                if (sRRset.size() == 0) {
                    sRRset.addRR(record);
                } else if (sRRset.getName().equals(record.getName()) && sRRset.getType() == record.getType() && sRRset.getDClass() == record.getDClass()) {
                    sRRset.addRR(record);
                } else {
                    this.trustAnchors.store(sRRset);
                    sRRset = new SRRset();
                    sRRset.addRR(record);
                }
            }
        }
        if (sRRset.size() > 0) {
            this.trustAnchors.store(sRRset);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return sendRequest(message, executor).thenCompose(new d(this, message, executor, 1));
    }

    @Generated
    public void setAddReasonToAdditional(boolean z) {
        this.isAddReasonToAdditional = z;
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i2, int i3, int i4, List<EDNSOption> list) {
        if (i2 == -1) {
            throw new IllegalArgumentException("EDNS cannot be disabled");
        }
        this.headResolver.setEDNS(i2, i3, i4 | 32768, list);
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i2) {
        this.headResolver.setPort(i2);
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        this.headResolver.setTCP(z);
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.headResolver.setTSIGKey(tsig);
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.headResolver.setTimeout(duration);
    }

    public ValidatingResolver(Resolver resolver, Clock clock) {
        this.isAddReasonToAdditional = true;
        this.headResolver = resolver;
        this.clock = clock;
        resolver.setEDNS(0, 0, 32768, new EDNSOption[0]);
        resolver.setIgnoreTruncation(false);
        this.keyCache = new KeyCache();
        this.valUtils = new ValUtils();
        this.n3valUtils = new NSEC3ValUtils();
        this.trustAnchors = new DefaultTrustAnchorStore();
        try {
            init(System.getProperties());
        } catch (IOException e2) {
            log.j("Could not initialize from system properties", e2);
        }
    }
}
