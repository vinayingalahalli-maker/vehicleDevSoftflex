#!/usr/bin/env bash
# =============================================================================
# install-and-run.sh
#
# One-shot script to:
#   1. Install Java 17 + Maven via SDKMAN (if not already present)
#   2. Install the Vehicle Service Collection SDK into the local Maven repo
#   3. Build and run the Spring Boot application
#
# Usage:
#   chmod +x install-and-run.sh
#   ./install-and-run.sh
#
# Optional env vars:
#   VEHICLE_SDK_BASE_URL  – backend URL (default: http://localhost:3000)
#   SERVER_PORT           – app port    (default: 8080)
# =============================================================================

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
SDK_DIR="$REPO_ROOT/postman/sdks/Collections SDKs/Vehicle Service Collection/java"

VEHICLE_SDK_BASE_URL="${VEHICLE_SDK_BASE_URL:-http://localhost:3000}"
SERVER_PORT="${SERVER_PORT:-8080}"

# ── Colour helpers ────────────────────────────────────────────────────────────
GREEN='\033[0;32m'; YELLOW='\033[1;33m'; RED='\033[0;31m'; NC='\033[0m'
info()    { echo -e "${GREEN}[INFO]${NC}  $*"; }
warn()    { echo -e "${YELLOW}[WARN]${NC}  $*"; }
error()   { echo -e "${RED}[ERROR]${NC} $*" >&2; exit 1; }

# ── 1. Ensure SDKMAN + Java 17 + Maven ───────────────────────────────────────
if ! command -v sdk &>/dev/null; then
    info "Installing SDKMAN..."
    curl -s "https://get.sdkman.io" | bash
    # shellcheck disable=SC1090
    source "$HOME/.sdkman/bin/sdkman-init.sh"
fi

# shellcheck disable=SC1090
[[ -f "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"

if ! command -v java &>/dev/null || ! java -version 2>&1 | grep -q "17\|21"; then
    info "Installing Java 17 via SDKMAN..."
    sdk install java 17.0.11-tem || true
    sdk use java 17.0.11-tem
fi

if ! command -v mvn &>/dev/null; then
    info "Installing Maven via SDKMAN..."
    sdk install maven || true
fi

info "Java:  $(java -version 2>&1 | head -1)"
info "Maven: $(mvn -version 2>&1 | head -1)"

# ── 2. Install SDK into local Maven repo ─────────────────────────────────────
info "Installing Vehicle Service Collection SDK into local Maven repo..."
(cd "$SDK_DIR" && mvn install -DskipTests -q)
info "SDK installed ✓"

# ── 3. Build the Spring Boot app ─────────────────────────────────────────────
info "Building vehicle-service-app..."
(cd "$SCRIPT_DIR" && mvn package -DskipTests -q)
info "Build successful ✓"

# ── 4. Run ────────────────────────────────────────────────────────────────────
info "Starting Vehicle Service Application on port $SERVER_PORT"
info "SDK base URL → $VEHICLE_SDK_BASE_URL"
info "Swagger UI   → http://localhost:$SERVER_PORT/swagger-ui.html"
echo ""

(cd "$SCRIPT_DIR" && mvn spring-boot:run \
    -Dspring-boot.run.arguments="--vehicle.sdk.base-url=$VEHICLE_SDK_BASE_URL --server.port=$SERVER_PORT")
