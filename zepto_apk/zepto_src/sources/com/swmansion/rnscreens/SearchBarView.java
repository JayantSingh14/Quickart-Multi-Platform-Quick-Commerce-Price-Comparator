package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import androidx.media3.exoplayer.analytics.l;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.events.SearchBarChangeTextEvent;
import com.swmansion.rnscreens.events.SearchBarCloseEvent;
import com.swmansion.rnscreens.events.SearchBarOpenEvent;
import com.swmansion.rnscreens.events.SearchBarSearchButtonPressEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.KEYRecord;

@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SearchBarView extends ReactViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public SearchBarInputTypes f47055a;

    /* renamed from: b, reason: collision with root package name */
    public SearchBarAutoCapitalize f47056b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f47057c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f47058d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f47059e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f47060f;

    /* renamed from: g, reason: collision with root package name */
    public String f47061g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f47062h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f47063i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f47064j;

    /* renamed from: k, reason: collision with root package name */
    public SearchViewFormatter f47065k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f47066l;

    /* renamed from: m, reason: collision with root package name */
    public final int f47067m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes4.dex */
    public static final class SearchBarAutoCapitalize {

        /* renamed from: a, reason: collision with root package name */
        public static final SearchBarAutoCapitalize f47068a;

        /* renamed from: b, reason: collision with root package name */
        public static final SearchBarAutoCapitalize f47069b;

        /* renamed from: c, reason: collision with root package name */
        public static final SearchBarAutoCapitalize f47070c;

        /* renamed from: d, reason: collision with root package name */
        public static final SearchBarAutoCapitalize f47071d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ SearchBarAutoCapitalize[] f47072e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47073f;

        static {
            SearchBarAutoCapitalize searchBarAutoCapitalize = new SearchBarAutoCapitalize("NONE", 0);
            f47068a = searchBarAutoCapitalize;
            SearchBarAutoCapitalize searchBarAutoCapitalize2 = new SearchBarAutoCapitalize("WORDS", 1);
            f47069b = searchBarAutoCapitalize2;
            SearchBarAutoCapitalize searchBarAutoCapitalize3 = new SearchBarAutoCapitalize("SENTENCES", 2);
            f47070c = searchBarAutoCapitalize3;
            SearchBarAutoCapitalize searchBarAutoCapitalize4 = new SearchBarAutoCapitalize("CHARACTERS", 3);
            f47071d = searchBarAutoCapitalize4;
            SearchBarAutoCapitalize[] searchBarAutoCapitalizeArr = {searchBarAutoCapitalize, searchBarAutoCapitalize2, searchBarAutoCapitalize3, searchBarAutoCapitalize4};
            f47072e = searchBarAutoCapitalizeArr;
            f47073f = EnumEntriesKt.a(searchBarAutoCapitalizeArr);
        }

        public static SearchBarAutoCapitalize valueOf(String str) {
            return (SearchBarAutoCapitalize) Enum.valueOf(SearchBarAutoCapitalize.class, str);
        }

        public static SearchBarAutoCapitalize[] values() {
            return (SearchBarAutoCapitalize[]) f47072e.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes4.dex */
    public static final class SearchBarInputTypes {

        /* renamed from: a, reason: collision with root package name */
        public static final SearchBarInputTypes f47074a;

        /* renamed from: b, reason: collision with root package name */
        public static final SearchBarInputTypes f47075b;

        /* renamed from: c, reason: collision with root package name */
        public static final SearchBarInputTypes f47076c;

        /* renamed from: d, reason: collision with root package name */
        public static final SearchBarInputTypes f47077d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ SearchBarInputTypes[] f47078e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47079f;

        @Metadata
        public static final class EMAIL extends SearchBarInputTypes {
            public EMAIL() {
                super(CLConstants.CREDTYPE_EMAIL, 3);
            }

            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public final int a(SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 32;
            }
        }

        @Metadata
        public static final class NUMBER extends SearchBarInputTypes {
            public NUMBER() {
                super("NUMBER", 2);
            }

            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public final int a(SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 2;
            }
        }

        @Metadata
        public static final class PHONE extends SearchBarInputTypes {
            public PHONE() {
                super("PHONE", 1);
            }

            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public final int a(SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                return 3;
            }
        }

        @Metadata
        public static final class TEXT extends SearchBarInputTypes {

            @Metadata
            public /* synthetic */ class WhenMappings {
                static {
                    int[] iArr = new int[SearchBarAutoCapitalize.values().length];
                    try {
                        iArr[0] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        SearchBarAutoCapitalize searchBarAutoCapitalize = SearchBarAutoCapitalize.f47068a;
                        iArr[1] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        SearchBarAutoCapitalize searchBarAutoCapitalize2 = SearchBarAutoCapitalize.f47068a;
                        iArr[2] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        SearchBarAutoCapitalize searchBarAutoCapitalize3 = SearchBarAutoCapitalize.f47068a;
                        iArr[3] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                }
            }

            public TEXT() {
                super("TEXT", 0);
            }

            @Override // com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes
            public final int a(SearchBarAutoCapitalize capitalize) {
                Intrinsics.checkNotNullParameter(capitalize, "capitalize");
                int iOrdinal = capitalize.ordinal();
                if (iOrdinal == 0) {
                    return 1;
                }
                if (iOrdinal == 1) {
                    return KEYRecord.Flags.FLAG2;
                }
                if (iOrdinal == 2) {
                    return 16384;
                }
                if (iOrdinal == 3) {
                    return 4096;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        static {
            TEXT text = new TEXT();
            f47074a = text;
            PHONE phone = new PHONE();
            f47075b = phone;
            NUMBER number = new NUMBER();
            f47076c = number;
            EMAIL email = new EMAIL();
            f47077d = email;
            SearchBarInputTypes[] searchBarInputTypesArr = {text, phone, number, email};
            f47078e = searchBarInputTypesArr;
            f47079f = EnumEntriesKt.a(searchBarInputTypesArr);
        }

        public static SearchBarInputTypes valueOf(String str) {
            return (SearchBarInputTypes) Enum.valueOf(SearchBarInputTypes.class, str);
        }

        public static SearchBarInputTypes[] values() {
            return (SearchBarInputTypes[]) f47078e.clone();
        }

        public abstract int a(SearchBarAutoCapitalize searchBarAutoCapitalize);
    }

    public SearchBarView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f47055a = SearchBarInputTypes.f47074a;
        this.f47056b = SearchBarAutoCapitalize.f47068a;
        this.f47061g = "";
        this.f47062h = true;
        this.f47064j = true;
        this.f47067m = UIManagerHelper.e(this);
    }

    private final ScreenStackHeaderConfig getHeaderConfig() {
        ViewParent parent = getParent();
        if (parent instanceof ScreenStackHeaderSubview) {
            return ((ScreenStackHeaderSubview) parent).getConfig();
        }
        return null;
    }

    private final ScreenStackFragment getScreenStackFragment() {
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null) {
            return headerConfig.getScreenFragment();
        }
        return null;
    }

    public static Unit j(SearchBarView searchBarView, CustomSearchView newSearchView) {
        ScreenStackFragment screenStackFragment;
        CustomSearchView customSearchViewF;
        Intrinsics.checkNotNullParameter(newSearchView, "newSearchView");
        if (searchBarView.f47065k == null) {
            searchBarView.f47065k = new SearchViewFormatter(newSearchView);
        }
        searchBarView.r();
        if (searchBarView.f47063i && (screenStackFragment = searchBarView.getScreenStackFragment()) != null && (customSearchViewF = screenStackFragment.F()) != null) {
            customSearchViewF.B();
        }
        return Unit.f53572a;
    }

    public static void k(SearchBarView searchBarView) {
        searchBarView.q(new SearchBarCloseEvent(searchBarView.f47067m, searchBarView.getId()));
        searchBarView.setToolbarElementsVisibility(0);
    }

    public static void l(SearchBarView searchBarView) {
        searchBarView.q(new SearchBarOpenEvent(searchBarView.f47067m, searchBarView.getId()));
        searchBarView.setToolbarElementsVisibility(8);
    }

    private final void setSearchViewListeners(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.swmansion.rnscreens.SearchBarView.setSearchViewListeners.1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public final void onQueryTextChange(String str) {
                SearchBarView searchBarView = SearchBarView.this;
                searchBarView.q(new SearchBarChangeTextEvent(searchBarView.f47067m, searchBarView.getId(), str));
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public final boolean onQueryTextSubmit(String str) {
                SearchBarView searchBarView = SearchBarView.this;
                searchBarView.q(new SearchBarSearchButtonPressEvent(searchBarView.f47067m, searchBarView.getId(), str));
                return true;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new com.google.android.material.datepicker.c(this, 1));
        searchView.setOnCloseListener(new l(this, 20));
        searchView.setOnSearchClickListener(new com.google.android.material.datepicker.d(this, 3));
    }

    private final void setToolbarElementsVisibility(int i2) {
        ScreenStackHeaderSubview screenStackHeaderSubview;
        int i3 = 0;
        int configSubviewsCount = getHeaderConfig() != null ? r0.getConfigSubviewsCount() - 1 : 0;
        if (configSubviewsCount < 0) {
            return;
        }
        while (true) {
            ScreenStackHeaderConfig headerConfig = getHeaderConfig();
            if (headerConfig != null) {
                Object obj = headerConfig.f47026e.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                screenStackHeaderSubview = (ScreenStackHeaderSubview) obj;
            } else {
                screenStackHeaderSubview = null;
            }
            if ((screenStackHeaderSubview != null ? screenStackHeaderSubview.getType() : null) != ScreenStackHeaderSubview.Type.f47042e && screenStackHeaderSubview != null) {
                screenStackHeaderSubview.setVisibility(i2);
            }
            if (i3 == configSubviewsCount) {
                return;
            } else {
                i3++;
            }
        }
    }

    @NotNull
    public final SearchBarAutoCapitalize getAutoCapitalize() {
        return this.f47056b;
    }

    public final boolean getAutoFocus() {
        return this.f47063i;
    }

    @Nullable
    public final Integer getHeaderIconColor() {
        return this.f47059e;
    }

    @Nullable
    public final Integer getHintTextColor() {
        return this.f47060f;
    }

    @NotNull
    public final SearchBarInputTypes getInputType() {
        return this.f47055a;
    }

    @NotNull
    public final String getPlaceholder() {
        return this.f47061g;
    }

    public final boolean getShouldOverrideBackButton() {
        return this.f47062h;
    }

    public final boolean getShouldShowHintSearchIcon() {
        return this.f47064j;
    }

    @Nullable
    public final Integer getTextColor() {
        return this.f47057c;
    }

    @Nullable
    public final Integer getTintColor() {
        return this.f47058d;
    }

    public final void m() {
        CustomSearchView customSearchViewF;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (customSearchViewF = screenStackFragment.F()) == null) {
            return;
        }
        customSearchViewF.clearFocus();
    }

    public final void n() {
        CustomSearchView customSearchViewF;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (customSearchViewF = screenStackFragment.F()) == null) {
            return;
        }
        customSearchViewF.A();
    }

    public final void o() {
        CustomSearchView customSearchViewF;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment == null || (customSearchViewF = screenStackFragment.F()) == null) {
            return;
        }
        customSearchViewF.B();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            screenStackFragment.J(new com.brentvatne.react.c(this, 5));
        }
    }

    public final void p(String str) {
        ScreenStackFragment screenStackFragment;
        CustomSearchView customSearchViewF;
        if (str == null || (screenStackFragment = getScreenStackFragment()) == null || (customSearchViewF = screenStackFragment.F()) == null) {
            return;
        }
        customSearchViewF.setText(str);
    }

    public final void q(Event event) {
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(event);
        }
    }

    public final void r() {
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        CustomSearchView customSearchViewF = screenStackFragment != null ? screenStackFragment.F() : null;
        if (customSearchViewF != null) {
            if (!this.f47066l) {
                setSearchViewListeners(customSearchViewF);
                this.f47066l = true;
            }
            customSearchViewF.setInputType(this.f47055a.a(this.f47056b));
            SearchViewFormatter searchViewFormatter = this.f47065k;
            if (searchViewFormatter != null) {
                searchViewFormatter.e(this.f47057c);
            }
            SearchViewFormatter searchViewFormatter2 = this.f47065k;
            if (searchViewFormatter2 != null) {
                searchViewFormatter2.f(this.f47058d);
            }
            SearchViewFormatter searchViewFormatter3 = this.f47065k;
            if (searchViewFormatter3 != null) {
                searchViewFormatter3.b(this.f47059e);
            }
            SearchViewFormatter searchViewFormatter4 = this.f47065k;
            if (searchViewFormatter4 != null) {
                searchViewFormatter4.c(this.f47060f);
            }
            SearchViewFormatter searchViewFormatter5 = this.f47065k;
            if (searchViewFormatter5 != null) {
                searchViewFormatter5.d(this.f47061g, this.f47064j);
            }
            customSearchViewF.setOverrideBackAction(this.f47062h);
        }
    }

    public final void setAutoCapitalize(@NotNull SearchBarAutoCapitalize searchBarAutoCapitalize) {
        Intrinsics.checkNotNullParameter(searchBarAutoCapitalize, "<set-?>");
        this.f47056b = searchBarAutoCapitalize;
    }

    public final void setAutoFocus(boolean z) {
        this.f47063i = z;
    }

    public final void setHeaderIconColor(@Nullable Integer num) {
        this.f47059e = num;
    }

    public final void setHintTextColor(@Nullable Integer num) {
        this.f47060f = num;
    }

    public final void setInputType(@NotNull SearchBarInputTypes searchBarInputTypes) {
        Intrinsics.checkNotNullParameter(searchBarInputTypes, "<set-?>");
        this.f47055a = searchBarInputTypes;
    }

    public final void setPlaceholder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f47061g = str;
    }

    public final void setShouldOverrideBackButton(boolean z) {
        this.f47062h = z;
    }

    public final void setShouldShowHintSearchIcon(boolean z) {
        this.f47064j = z;
    }

    public final void setTextColor(@Nullable Integer num) {
        this.f47057c = num;
    }

    public final void setTintColor(@Nullable Integer num) {
        this.f47058d = num;
    }
}
