#!/bin/bash

# ========================================================
# Script to Install Docker and Run SQL Server on Linux
# Author: Assistant
# Description: Sets up SQL Server 2022 in Docker
# ========================================================

set -e  # Exit on any error

# Configuration
CONTAINER_NAME="sql1"
SQL_PASSWORD='springboot_MVC1234!'  # Change this to a strong password
PORT=1433
ACCEPT_EULA='Y'

echo "🚀 Starting SQL Server setup with Docker... "

# 1. Install Docker if not installed
if ! command -v docker &> /dev/null; then
    echo "🐳 Docker not found. Installing Docker..."

    # Detect OS
    if [[ -f /etc/os-release ]]; then
        . /etc/os-release
        OS=$NAME
    else
        echo "❌ Could not detect OS."
        exit 1
    fi

    case "$OS" in
        "Ubuntu"|"Debian GNU/Linux")
            apt-get update
            apt-get install -y ca-certificates curl gnupg lsb-release
            mkdir -p /etc/apt/keyrings
            curl -fsSL https://download.docker.com/linux/$(lsb_release -is | tr '[:upper:]' '[:lower:]')/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg
            echo \
              "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/$(lsb_release -is | tr '[:upper:]' '[:lower:]') \
              $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
            apt-get update
            apt-get install -y docker-ce docker-ce-cli containerd.io
            ;;
        "CentOS Linux"|"Red Hat Enterprise Linux"|"Rocky Linux")
            yum install -y yum-utils
            yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
            yum install -y docker-ce docker-ce-cli containerd.io
            systemctl start docker
            systemctl enable docker
            ;;
        *)
            echo "❌ Unsupported OS: $OS"
            echo "Please install Docker manually and re-run the script."
            exit 1
            ;;
    esac

    echo "✅ Docker installed successfully."
else
    echo "🐳 Docker is already installed."
fi

# 2. Pull and Run SQL Server Container
echo "🔁 Pulling and running SQL Server 2022 container..."

docker run -d \
  --name $CONTAINER_NAME \
  -e "ACCEPT_EULA=$ACCEPT_EULA" \
  -e "SA_PASSWORD=$SQL_PASSWORD" \
  -p $PORT:1433 \
  -d mcr.microsoft.com/mssql/server:2022-latest

echo "⏳ Waiting for SQL Server to start (this may take 1-2 minutes)..."

# 3. Tail logs to monitor startup
sleep 10
docker logs -f $CONTAINER_NAME --tail 50 &

# Wait for SQL Server to be ready
echo "🔍 Monitoring logs for successful startup..."
while true; do
    if docker logs $CONTAINER_NAME 2>&1 | grep -i "SQL Server is now ready for client connections"; then
        echo "🎉 SQL Server is up and running!"
        break
    fi
    sleep 5
done

# Stop following logs after confirmation
pkill -f "docker logs" || true

# 4. Show connection info
echo "✅ Container '$CONTAINER_NAME' is running."
echo ""
echo "💡 Connect using:"
echo "   Server: localhost,1433"
echo "   Username: sa"
echo "   Password: $SQL_PASSWORD"
echo ""
echo "📋 Test connection with sqlcmd (install mssql-tools if needed):"
echo "   docker exec -it $CONTAINER_NAME /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P '$SQL_PASSWORD'"
echo ""

echo "✅ Setup complete!"