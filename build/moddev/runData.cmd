@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd D:\MCreatorWorkspaces\mobFarms\MobFarms\run
"C:\Program Files\Java\jdk-21\bin\java.exe" @D:\MCreatorWorkspaces\mobFarms\MobFarms\build\moddev\dataRunClasspath.txt @D:\MCreatorWorkspaces\mobFarms\MobFarms\build\moddev\dataRunVmArgs.txt -Dfml.modFolders=mob_farms%%%%D:\MCreatorWorkspaces\mobFarms\MobFarms\build\classes\java\main;mob_farms%%%%D:\MCreatorWorkspaces\mobFarms\MobFarms\build\resources\main net.neoforged.devlaunch.Main @D:\MCreatorWorkspaces\mobFarms\MobFarms\build\moddev\dataRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal