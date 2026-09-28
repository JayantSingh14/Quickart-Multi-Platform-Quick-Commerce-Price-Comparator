# 🛒 Quickart — Multi-Platform Quick-Commerce Price Comparator

**Compare live prices across Zepto, Blinkit, Swiggy Instamart, Flipkart Minutes, Dmart, and JioMart — from one search.**

None of these platforms expose a public "give me prices" API. Quickart solves that problem three different ways — a Chrome extension that piggybacks on your own logged-in session, a headless-browser search API that synthesizes a session from scratch, and an industrial-scale crawler + AI assistant pipeline — and normalizes everything into one comparable shape.

<p align="center">
  <img alt="Manifest V3" src="https://img.shields.io/badge/Chrome%20Extension-Manifest%20V3-4285F4?logo=googlechrome&logoColor=white">
  <img alt="Node.js" src="https://img.shields.io/badge/Node.js-18%2B-339933?logo=node.js&logoColor=white">
  <img alt="React" src="https://img.shields.io/badge/React-19-61DAFB?logo=react&logoColor=black">
  <img alt="Python" src="https://img.shields.io/badge/FastAPI-Python-009688?logo=fastapi&logoColor=white">
  <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white">
  <img alt="MongoDB" src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white">
  <img alt="Playwright" src="https://img.shields.io/badge/Playwright-headless%20Chromium-2EAD33?logo=playwright&logoColor=white">
  <img alt="License" src="https://img.shields.io/badge/license-MIT-blue">
</p>

---

## 📖 Table of Contents

- [The Problem](#-the-problem)
- [Three Systems, One Goal](#-three-systems-one-goal)
- [Architecture](#-architecture)
- [Repository Structure](#-repository-structure)
- [How the Auth Problem Is Solved (3 Ways)](#-how-the-auth-problem-is-solved-3-ways)
- [Key Engineering Highlights](#-key-engineering-highlights)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
- [Known Rough Edges / Roadmap](#-known-rough-edges--roadmap)
- [Disclaimer](#-disclaimer)
- [License](#-license)

---

## 🎯 The Problem

In India, quick-commerce apps (**Zepto, Blinkit, Instamart, Flipkart Minutes, Dmart, JioMart**) all sell the same products at different prices with different delivery ETAs — but none of them offer a public API for price comparison. Every one of them actively resists automated access via cookie-gated sessions, custom auth headers, WAF fingerprinting, or full TLS-encrypted mobile traffic.

**Quickart's goal:** let a user search *"milk"* once and see prices from every platform side-by-side, grouped as "the same product" — despite each platform actively trying to prevent exactly that.

## 🧩 Three Systems, One Goal

This repo contains three independent attempts at the same problem, each solving the "no public API" issue differently as the project scaled up in ambition:

| # | System | Approach | Auth Strategy |
|---|--------|----------|----------------|
| **v1** | **Browser Extension** (`manifest.json`, `popup/`, `content/`, `background/`, `adapters/`) | Runs inside Chrome. Injects scripts into tabs you already have open on Zepto/Blinkit/Instamart, reads live prices, shows a popup comparison. | Piggybacks on your own logged-in browser session (steals cookies + auth headers it observes). |
| **v2** | **Standalone Search API** (`search-api/`, `zepto-fast-api/`) | A Node.js server that synthesizes a fake browsing session from scratch using a headless browser — no extension required, any web app can call it. | Spins up headless Chromium with geolocation spoofing + anti-bot-detection flags, caches expensive tokens to disk. |
| **v3** | **Industrial Crawler + AI Shopping Assistant** (`crawler-service/`, `zepto_apk/`, `web-app/`, `shopgpt-frontend/`, `shopgpt-backend/`) | A full pipeline: Playwright-driven scraper workers run batch jobs, store results in Postgres/MongoDB, an LLM groups/ranks results conversationally, two polished React frontends display it all. | Batch browser automation at scale + reverse-engineered mobile API contracts (APK decompilation + Frida SSL-pinning bypass). |

## 🏗 Architecture

```
                         ┌────────────────────────────────────────────┐
                         │            User's Chrome Browser            │
                         │  ┌──────────┐   ┌──────────┐   ┌─────────┐  │
                         │  │  Popup   │◄──┤ Service  │◄──┤ Content │  │
                         │  │  (UI)    │   │  Worker  │   │ Scripts │  │
                         │  └──────────┘   │ (brain)  │   │(MAIN +  │  │
                         │                 └────┬─────┘   │ISOLATED)│  │
                         │                       │         └────┬────┘  │
                         └───────────────────────┼──────────────┼───────┘
                                                  │  captured sessions   │
                                                  ▼              ▼
                       Zepto / Blinkit / Instamart / Flipkart APIs (direct replay)

┌───────────────┐      ┌───────────────────┐      ┌─────────────────────────┐
│   web-app     │─────▶│    search-api     │─────▶│  Headless Playwright    │
│ (React/Vite)  │      │ (Node, no framework)│    │  browser (spoofed geo,  │
└───────────────┘      └───────────────────┘      │  anti-bot flags)        │
                                                    └─────────────────────────┘

┌──────────────────┐   ┌───────────────┐   ┌───────────────┐   ┌────────────┐
│ shopgpt-frontend  │──▶│ shopgpt-backend│──▶│ crawler-service│──▶│ Postgres / │
│ (chat UI, React)  │   │ (FastAPI +     │   │ (job queue,    │   │ MongoDB /  │
│                   │   │  Ollama/Groq)  │   │  Playwright,   │   │ S3         │
│                   │   │                │   │  checkpoints)  │   │            │
└──────────────────┘   └───────────────┘   └───────────────┘   └────────────┘
```

## 📂 Repository Structure

```
extensionKart/
├── manifest.json, rules.json          # Chrome extension blueprint (Manifest V3)
├── popup/                             # Extension toolbar UI (vanilla JS, state-machine views)
├── background/                       # Service worker — message router, session capture, API replay
├── content/                          # Per-platform content scripts (MAIN + ISOLATED world pairs)
├── adapters/                         # Per-platform data adapters, normalizer, client-side grouper
│
├── search-api/                       # v2: headless-browser search API (session synthesis from scratch)
├── zepto-fast-api/                   # Lightweight Zepto-only fast search API
│
├── crawler-service/                  # v3: batch scraping pipeline (job queue, Playwright, Postgres/Mongo)
│   ├── sku-scraper/                  #   Direct product scraper workers
│   ├── web-interface/                #   Job orchestration server + DB layer
│   ├── dmart-worker/                 #   Cloudflare Worker variant for Dmart
│   └── new-ui/                       #   Instamart product API
│
├── zepto_apk/                        # Reverse-engineering artifacts: decompiled APK + Frida scripts
│                                      # (SSL-pinning bypass, API-contract extraction — see disclaimer)
│
├── web-app/                          # React/Vite frontend — extension-integrated price comparator
├── shopgpt-frontend/                 # React/Vite chat UI for the AI shopping assistant
└── shopgpt-backend/                  # FastAPI backend — LLM chat, deterministic grouping/ranking
```

## 🔐 How the Auth Problem Is Solved (3 Ways)

Every layer of this project answers the same question — *"how do I get a valid, authenticated session against a platform that doesn't want me to?"* — differently:

1. **Extension (`background/service-worker.js`)** — Passively intercepts `fetch`/`XHR` calls made by the page's *own* JavaScript (in a `MAIN`-world content script) to capture session cookies and dynamically-generated auth headers, then relays them through an `ISOLATED`-world "bridge" script to the service worker, which replays them to call each platform's private API directly. When Instamart's WAF fingerprints and blocks service-worker-originated requests, the fix is to run the `fetch` *inside a real, already-open tab* via `chrome.scripting.executeScript` — making the request indistinguishable from organic traffic.
2. **`search-api/`** — Has no real user to piggyback on, so it launches a real headless Chromium instance (Playwright), spoofs `navigator.webdriver` and geolocation, and caches expensive tokens (e.g. a 55-minute WAF token) to disk with a two-tier (memory + file) cache so a server restart doesn't force re-establishing every session from zero.
3. **`crawler-service/` + `zepto_apk/`** — At scale, batch jobs drive real headless browsers with checkpointed, resumable progress across hundreds of SKUs. For the one channel neither browser trick can reach — the **encrypted mobile app** — `zepto_apk/` uses **Frida** (dynamic instrumentation) to defeat Android's certificate/SSL pinning at multiple layers (`X509TrustManager`, OkHttp's `CertificatePinner`, and native `libssl.so` hooks) so the app's own GraphQL API contract can be observed directly from its decrypted traffic.

## ✨ Key Engineering Highlights

- **Manifest V3 dual-world content scripts** — `MAIN`-world scripts intercept page network calls; `ISOLATED`-world "bridge" scripts relay data to the extension via `chrome.runtime` messaging (neither world alone has both capabilities).
- **postMessage-based mini RPC** — a `__requestId` / pending-`Map` correlation pattern (with timeouts) lets any website talk to the extension as if it were calling a normal async function.
- **WAF & bot-detection evasion** — executing intercepted requests inside a live tab, `navigator.webdriver` spoofing, and `--disable-blink-features=AutomationControlled` to make automated traffic indistinguishable from a real user.
- **Request coalescing** for a shared headless-browser singleton, avoiding duplicate browser launches under concurrent load.
- **Async job pattern with checkpointing** — long-running batch scrapes return a `jobId` immediately and persist per-platform progress so a crash resumes instead of restarting from zero.
- **Deterministic, hallucination-free product grouping** — Jaccard token-similarity + regex-based unit normalization (handling `1kg`, `4x250ml`, `Pack of 6 x 200ml`, etc.) groups the same product across platforms **without** an LLM, guaranteeing consistent, reproducible comparisons.
- **Hybrid AI architecture** — the LLM layer (provider-agnostic: local **Ollama** or cloud **Groq**, swappable via one config value) is deliberately scoped to conversation, summaries, and follow-up suggestions via streaming **SSE**, with a custom sentinel-based (`[SEARCH: ...]`) tool-calling protocol — while price-critical grouping/ranking stays 100% algorithmic.
- **Reverse-engineered a native Android API contract** via APK decompilation and a layered Frida SSL-pinning bypass, when browser-based interception wasn't viable.

## 🛠 Tech Stack

| Layer | Technologies |
|---|---|
| Browser Extension | Manifest V3, vanilla JS, `chrome.*` APIs, `declarativeNetRequest` |
| Frontends | React 19, Vite, `react-markdown` |
| Search / Scraping Backends | Node.js, Playwright (headless Chromium), Express |
| AI Backend | Python, FastAPI, Ollama / Groq (LLM), Server-Sent Events |
| Data Layer | PostgreSQL, MongoDB, AWS S3, SQLite |
| Reverse Engineering | Frida (dynamic instrumentation), APK decompilation |
| Infra | Cloudflare Workers (Dmart), EC2 deployment scripts |

## 🚀 Getting Started

Each sub-project is independently runnable. Pick the piece you want to explore:

### 1. Chrome Extension
```bash
# In Chrome: chrome://extensions → Enable Developer Mode → Load Unpacked
# Select the repository root (manifest.json lives here)
```

### 2. Search API
```bash
cd search-api
cp .env.example .env   # fill in required values
npm install
npm start
```

### 3. AI Shopping Assistant (backend + frontend)
```bash
cd shopgpt-backend
pip install -r requirements.txt
cp .env.example .env   # set LLM_PROVIDER=ollama|groq and provider keys
uvicorn main:app --reload

# in a separate terminal
cd shopgpt-frontend
npm install
npm run dev
```

### 4. Web App (extension-integrated comparator)
```bash
cd web-app
npm install
npm run dev
```

### 5. Crawler Service
```bash
cd crawler-service/web-interface
npm install
cp .env.example .env   # Postgres/Mongo/S3 credentials
npm start
```

> ⚠️ None of the `.env` files with real credentials are committed. Copy the corresponding `.env.example` in each folder and fill in your own values.

## 🧭 Known Rough Edges / Roadmap

Documented honestly, as any real project accumulates over multiple build iterations:

- Product-grouping logic is implemented **twice**, independently, in two languages (`adapters/grouper.js` — exact-key matching; `shopgpt-backend/grouper.py` — fuzzy Jaccard matching) and can drift out of sync.
- `window.postMessage(data, '*')` in the web-app bridge uses a wildcard target origin — fine for `localhost` dev, but should be tightened to an explicit origin before any production deployment.
- Database schema evolves via ad-hoc `ALTER TABLE ... ADD COLUMN IF NOT EXISTS` calls on startup rather than versioned migrations.
- Full "add to cart" automation is not implemented — the extension deep-links to a single product page rather than mutating the platform's real cart via API (a consciously scoped v1 limitation).
- A consolidated v2 architecture — one grouping algorithm, one normalized session-auth abstraction, proper migrations — is the natural next step.

## ⚖️ Disclaimer

This project was built for personal learning and non-commercial price-comparison research. Several techniques used here — session/header interception, headless-browser automation, and especially the Android SSL-pinning bypass in `zepto_apk/` — are legitimate, well-documented techniques in security research and unofficial API-client development, but they do bypass platforms' anti-tampering protections and likely conflict with their Terms of Service. Use responsibly, only against your own accounts/devices, and at your own risk.

## 📄 License

[MIT](LICENSE)

---

<p align="center">Built as a deep dive into browser extensions, reverse engineering, distributed scraping, and hybrid AI system design.</p>
