@echo off
echo ====================================
echo ENICarthage Staff Manager Backend
echo ====================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERREUR] Java n'est pas installe ou n'est pas dans le PATH
    echo Telechargez Java 17 depuis: https://adoptium.net/
    pause
    exit /b 1
)

echo [OK] Java detecte
echo.

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERREUR] Maven n'est pas installe ou n'est pas dans le PATH
    echo Telechargez Maven depuis: https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo [OK] Maven detecte
echo.

echo Compilation et demarrage du backend...
echo.

mvn spring-boot:run

pause
