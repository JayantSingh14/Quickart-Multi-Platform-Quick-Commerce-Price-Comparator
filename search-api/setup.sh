#!/usr/bin/env bash
# Quickart Search API — GCP VM setup script
# Tested on Ubuntu 22.04 LTS (e2-medium or larger recommended)
#
# Usage:
#   1. SSH into your GCP VM
#   2. Upload this repo (git clone or gcloud scp)
#   3. cd into search-api/
#   4. chmod +x setup.sh && ./setup.sh
#   5. Copy .env.example to .env and fill in values

set -euo pipefail

echo "==> [1/7] Updating system packages..."
sudo apt-get update -qq
sudo apt-get upgrade -y -qq

echo "==> [2/7] Installing Node.js 20..."
curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash - -qq
sudo apt-get install -y nodejs -qq
node -v
npm -v

echo "==> [3/7] Installing Xvfb (virtual display for headed Chromium)..."
sudo apt-get install -y xvfb -qq

echo "==> [4/7] Installing PM2 process manager..."
sudo npm install -g pm2 --quiet

echo "==> [5/7] Installing Node dependencies..."
npm install --omit=dev

echo "==> [6/7] Installing Playwright Chromium browser + OS dependencies..."
npx playwright install chromium --with-deps

echo "==> [7/7] Setting up .env file..."
if [ ! -f .env ]; then
  cp .env.example .env
  echo "    Created .env from .env.example — edit it before starting the server."
else
  echo "    .env already exists, skipping."
fi

echo ""
echo "====================================================="
echo " Setup complete! Start the server with:"
echo ""
echo "   xvfb-run -a pm2 start server.js --name quickart-api"
echo "   pm2 save"
echo "   pm2 startup   # follow the printed command to survive reboots"
echo ""
echo " Useful commands:"
echo "   pm2 logs quickart-api    # live logs"
echo "   pm2 restart quickart-api # restart"
echo "   pm2 stop quickart-api    # stop"
echo "====================================================="
