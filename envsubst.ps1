Write-Host $env:TAG
Write-Host "--- Verificando archivo ---"
Get-Content -Path "./expenses-api-transactions-deployments.yaml"
Write-Host "---------------------------"

# Paso 4: Ejecutar el comando de sustitución
(Get-Content -Path "./expenses-api-transactions-deployments.yaml" -Raw) | ForEach-Object {
    $ExecutionContext.InvokeCommand.ExpandString($_)
} | Set-Content -Path "./expenses-api-transactions-deployments.yaml"

# Paso 5: Mostrar el resultado
Write-Host "El archivo 'expenses-api-transactions-deployments.yaml' ha sido creado. Su contenido es:"
Get-Content -Path "./expenses-api-transactions-deployments.yaml"
