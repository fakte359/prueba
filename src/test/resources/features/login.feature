# language: es

Característica: Login en Aleerp
  Como candidato QA
  Quiero poder iniciar sesión en https://qa.aleerp.com/login

  Escenario: Login con qa.candidate01
    Dado que el actor abre la página de login
    Cuando inicia sesión con usuario "qa.candidate01@sinergia.com" contraseña "Candidato.01" y entidad "Test Zone"
    Entonces debería ver la página principal

  Escenario: Login con qa.candidate02
    Dado que el actor abre la página de login
    Cuando inicia sesión con usuario "qa.candidate02@sinergia.com" contraseña "Candidato.02" y entidad "Test Zone"
    Entonces debería ver la página principal
