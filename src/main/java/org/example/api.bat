@echo off
set a=0
:loop
for /f %%p in ('wmic cpu get loadpercentage') do set /A a=%%p


curl -H "Content-type: application/json" -d {\"cpu":\"%a%"} localhost:8080/v1/save
 timeout /t 1
 goto loop