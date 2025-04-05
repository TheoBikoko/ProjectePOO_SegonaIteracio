# Documentació del Projecte: Sistema de Gestió d'Estades

**Theo Kandi Bikoko Pineda**

## Breu Descripció del Projecte
Aquest projecte consisteix en un sistema de gestió d'estades en empresa per a estudiants. Permet:
- Gestionar estudiants i supervisors
- Assignar estades nacionals o internacionals (Erasmus)
- Validar els requisits dels estudiants
- Consultar informació de les estades

## Nou Disseny de l'Aplicació

### Estructura de Paquets
```
src/
├── domain/
│   ├── model/       # Entitats del domini
│   └── enums/       # Enumeracions
├── manager/         # Lògica de negoci
├── ui/              # Interfície d'usuari
└── database/        # Persistència (futura implementació)
```

### Diagrama de Components
```
[UI] → [Manager] → [Service] → [Domain Model]
```

## Millores de Disseny

### Respecte a la Iteració Anterior
1. **Separació clara de responsabilitats (SRP)**
   - Cada classe té una única responsabilitat

2. **Inversió de dependències (DIP)**
   - El `Manager` depèn d'interfícies (`InternshipService`)
   - Permet canviar implementacions sense modificar el codi.

3. **Obert/Closed (OCP)**
   - El sistema és obert per extensió (noves estades)
   - Tancat per modificació (no cal tocar codi existent)

**Beneficis**:
- **Manteniment**: Canvis facils de localitzar, menys probabilitat d'errors
- **Extensibilitat**: Afegir nova funcionalitat sense modificar codi existent
- **Testabilitat**: Components aïllats, més fàcil de testejar

## Millores Funcionals

1. **Validació millorada**:
   - Sistema verifica automàticament requisits estudiants
   - Missatges d'error més descriptius

2. **Gestió d'estades**:
   - Suport per a múltiples tipus d'estada
   - Càlcul automàtic d'hores segons tipus

3. **Interfície més intuïtiva**:
   - Menús estructurats
   - Validació d'entrades

## Futures Millores (Iteració 3)

1. **Persistència de dades**:
   - Implementar un package `database` amb interifices i classes que gestionin la persistencia de dades
   - Guardar dades entre execucions

2. **Informes**:
   - Generar PDFs amb detalls d'estades
   - Estadístiques d'assignació

3. **Notificacions**:
   - Enviar emails a estudiants/supervisors
   - Recordatoris de terminis

## Conclusions

El nou disseny:
- Millora la mantenibilitat gràcies a la separació de delegacions
- Facilita l'extensió amb noves funcionalitats
- Desacobla components (més flexibilitat)
- Permet un desenvolupament més ràpid i segur

El sistema ara està millor preparat per:
- Incorporar noves característiques
- Adaptar-se a canvis en requisits
- Escalar en nombre d'usuaris

**Lliçons apreses**:
- La inversió en un bon disseny inicial estalvia temps a llarg termini
- Els principis SOLID són essencials per a sistemes mantenibles i extensibles a mes de millorar la legibilitat
```