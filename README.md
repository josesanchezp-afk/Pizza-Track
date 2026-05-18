# 🍕 PIZZA-TRACK - Sistema de Gestión de Pedidos

Sistema interactivo de gestión de pedidos de pizzas con operaciones **Undo/Redo** utilizando estructuras de datos de pilas (stacks).

![Java](https://img.shields.io/badge/Java-8+-blue)
![Version](https://img.shields.io/badge/Version-1.0-green)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)

---

## 📋 Tabla de Contenidos

- [Descripción General](#descripción-general)
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Guía de Uso](#guía-de-uso)
- [Documentación de Clases](#documentación-de-clases)
- [Arquitectura](#arquitectura)
- [Ejemplos](#ejemplos)
- [Troubleshooting](#troubleshooting)

---

## 🎯 Descripción General

**Pizza-Track** es una aplicación de consola desarrollada en **Java** que implementa un sistema completo de gestión de pedidos de pizzas. Utiliza **estructuras de datos de pilas (stacks)** para proporcionar funcionalidades de **Undo (Deshacer)** y **Redo (Rehacer)**, permitiendo a los usuarios registrar, deshacer y rehacer operaciones de forma intuitiva.

### Información del Proyecto
- **Versión:** 1.0
- **Equipo:** Pizza-Track Team
- **Lenguaje:** Java
- **Tipo:** Aplicación de Consola
- **Patrón:** MVC (Modelo-Vista-Controlador)

---

## ✨ Características

✅ **Registro de Pedidos** - Crear nuevos pedidos con nombre e ingredientes
✅ **Operación Deshacer (Undo)** - Cancelar la última acción registrada
✅ **Operación Rehacer (Redo)** - Restaurar una acción deshecha
✅ **Visualización** - Ver detalles del pedido actual en producción
✅ **Validación** - Validación automática de entrada del usuario
✅ **Interfaz Interactiva** - Menú de navegación fácil de usar
✅ **Estructura de Datos Personalizada** - Implementación manual de pilas con listas enlazadas

---

## 📦 Requisitos

- **Java 8** o superior
- **Compilador javac**
- **Terminal o Línea de Comandos**

### Verificar Instalación de Java
```bash
java -version
javac -version
```

---

## 🔧 Instalación

### Paso 1: Clonar o Descargar el Repositorio
```bash
git clone https://github.com/josesanchezp-afk/Pizza-Track.git
cd Pizza-Track
```

### Paso 2: Compilar los Archivos
```bash
javac Pizza.java
javac Pila.java
javac GestionPedidos.java
```

### Paso 3: Ejecutar la Aplicación
```bash
java GestionPedidos
```

---

## 📖 Guía de Uso

### Inicio del Sistema

Cuando ejecutas el programa, aparecerá este menú interactivo:

```
=== PIZZA-TRACK: Gestión de Pedidos ===
1. Registrar Nombre del cliente, para su pedido DE PIZZA
2. Deshacer (Undo)
3. Rehacer (Redo)
4. Mostrar Pedido Actual
0. Salir
Seleccione una opción: _
```

### 1️⃣ Registrar Nuevo Pedido

**Pasos:**
1. Ingresa `1` en el menú principal
2. Sistema solicita: "Ingrese el nombre de la pizza:"
   - Ejemplo: `Pepperoni`
3. Sistema solicita: "Ingrese exactamente 3 ingredientes:"
   - Ingrediente 1: `Tomate`
   - Ingrediente 2: `Queso`
   - Ingrediente 3: `Pepperoni`
4. Confirmación: `¡Pedido registrado exitosamente!`

**Características:**
- El nombre de la pizza no puede estar vacío
- Exactamente 3 ingredientes obligatorios
- Al registrar un nuevo pedido, el historial de "Rehacer" se limpia

---

### 2️⃣ Deshacer (Undo)

**Pasos:**
1. Ingresa `2` en el menú
2. El último pedido se mueve a la lista de espera
3. Mensaje: `Acción Deshecha. Se movió a espera: [nombre]`

**Comportamiento:**
- ✅ Si hay pedidos: Se mueve el tope de la pila principal a la secundaria
- ❌ Si no hay: Se muestra mensaje: `No hay pedidos en la pila principal para deshacer`

---

### 3️⃣ Rehacer (Redo)

**Pasos:**
1. Ingresa `3` en el menú
2. El pedido deshechado se recupera automáticamente
3. Mensaje: `Acción Rehecha. Se recuperó: [nombre]`

**Comportamiento:**
- ✅ Si hay pedidos deshechados: Se recupera desde la pila secundaria
- ❌ Si no hay: Se muestra mensaje: `No hay pedidos en la pila secundaria para rehacer`

---

### 4️⃣ Mostrar Pedido Actual

**Pasos:**
1. Ingresa `4` en el menú
2. Se visualiza el pedido en producción (tope de la pila principal)

**Salida Típica:**
```
--- PEDIDO ACTUAL EN PRODUCCIÓN ---
Nombre de la pizza: Pepperoni
Ingredientes:
  1. Tomate
  2. Queso
  3. Pepperoni
-----------------------------------
```

---

### 0️⃣ Salir

**Pasos:**
1. Ingresa `0` en el menú
2. Mensaje: `Cerrando el sistema Pizza-Track... ¡Hasta pronto!`
3. Aplicación termina correctamente

---

## 📚 Documentación de Clases

### Clase 1: GestionPedidos.java

**Propósito:** Controlador principal - Punto de entrada del sistema

**Tipo:** Clase Controladora

```java
public static void main(String[] args)
```

**Responsabilidades:**
- Inicializar el sistema
- Presentar menú interactivo
- Gestionar dos pilas (principal y secundaria)
- Procesar opciones del usuario
- Validar entrada de datos

**Atributos Locales:**
- `Scanner scanner` - Lectura de entrada del usuario
- `Pila pilaPrincipal` - Almacena pedidos activos
- `Pila pilaSecundaria` - Almacena pedidos deshechados
- `int opcion` - Opción seleccionada

**Comportamiento Especial:**
⚠️ **Al registrar una nueva acción, `pilaSecundaria` se limpia automáticamente**

---

### Clase 2: Pila.java

**Propósito:** Estructura de datos LIFO (Last In, First Out)

**Tipo:** Estructura de Datos - Lista Enlazada

**Métodos Públicos:**

| Método | Parámetros | Retorna | O(n) | Descripción |
|--------|-----------|---------|------|-------------|
| `Pila()` | - | - | O(1) | Constructor - Inicializa pila vacía |
| `push(Pizza pizza)` | Pizza | void | O(1) | Agrega elemento al tope |
| `pop()` | - | Pizza | O(1) | Remueve y retorna elemento del tope |
| `peek()` | - | Pizza | O(1) | Retorna elemento sin remover |
| `isEmpty()` | - | boolean | O(1) | Verifica si está vacía |

**Excepciones:**
- `IllegalStateException` en `pop()` si está vacía
- `IllegalStateException` en `peek()` si está vacía

**Estructura Interna:**
```java
private class Nodo {
    Pizza pizza;
    Nodo siguiente;
}

private Nodo tope;  // Referencia al elemento superior
```

**Características:**
- Implementación manual sin usar colecciones de Java
- Lista enlazada simple
- Todas las operaciones son O(1)
- Dinámico (crece según necesidad)

---

### Clase 3: Pizza.java

**Propósito:** Modelo de datos - Representa una pizza

**Tipo:** Clase POJO (Plain Old Java Object)

**Atributos Privados:**
```java
private String nombre;           // Nombre de la pizza
private String[] ingredientes;   // Arreglo de exactamente 3 ingredientes
```

**Métodos Públicos:**

| Método | Parámetros | Retorna | Descripción |
|--------|-----------|---------|-------------|
| `Pizza(String nombre, String[] ingredientes)` | nombre, ingredientes[] | - | Constructor |
| `getNombre()` | - | String | Obtiene el nombre de la pizza |
| `getIngredientes()` | - | String[] | Obtiene el arreglo de ingredientes |
| `mostrarDetalles()` | - | void | Imprime detalles formateados |

**Ejemplo de Creación:**
```java
String[] ingredientes = {"Tomate", "Queso", "Pepperoni"};
Pizza pizza = new Pizza("Pepperoni", ingredientes);
```

**Ejemplos de Pizzas:**
- `new Pizza("Pepperoni", {"Tomate", "Queso", "Pepperoni"})`
- `new Pizza("Hawaiana", {"Piña", "Jamón", "Queso"})`
- `new Pizza("Vegetariana", {"Champiñones", "Pimiento", "Cebolla"})`

---

## 🏗️ Arquitectura

### Diagrama de Componentes

```
┌─────────────────────────────────────────┐
│      GestionPedidos (Controlador)       │◄─── Interfaz de Usuario
│   - main()                              │
│   - Menú interactivo                    │
│   - Validación de entrada               │
└────────────┬────────────────────────────┘
             │
    ┌────────┴────────┐
    │                 │
    ▼                 ▼
┌─────────┐      ┌──────────────┐
│  Pila   │      │    Pizza     │
│(Stack)  │      │  (Modelo)    │
└─────────┘      └──────────────┘
```

### Capas del Sistema

1. **Capa de Presentación:** `GestionPedidos`
   - Interfaz con el usuario
   - Menú interactivo
   - Validación de entrada

2. **Capa de Datos:** `Pizza`
   - Modelo de datos
   - Encapsulación de información
   - Métodos de acceso (getters)

3. **Capa de Estructura:** `Pila`
   - Estructura de datos LIFO
   - Operaciones básicas (push, pop, peek)
   - Gestión de nodos enlazados

---

## 💡 Ejemplos

### Ejemplo Completo: Sesión Típica

```bash
$ java GestionPedidos

=== PIZZA-TRACK: Gestión de Pedidos ===
1. Registrar Nombre del cliente, para su pedido DE PIZZA
2. Deshacer (Undo)
3. Rehacer (Redo)
4. Mostrar Pedido Actual
0. Salir
Seleccione una opción: 1

Ingrese el nombre de la pizza: Pepperoni
Ingrese exactamente 3 ingredientes:
Ingrediente 1: Tomate
Ingrediente 2: Queso
Ingrediente 3: Pepperoni
-> ¡Pedido registrado exitosamente!

=== PIZZA-TRACK: Gestión de Pedidos ===
Seleccione una opción: 1

Ingrese el nombre de la pizza: Hawaiana
Ingrese exactamente 3 ingredientes:
Ingrediente 1: Piña
Ingrediente 2: Jamón
Ingrediente 3: Queso
-> ¡Pedido registrado exitosamente!

=== PIZZA-TRACK: Gestión de Pedidos ===
Seleccione una opción: 4

--- PEDIDO ACTUAL EN PRODUCCIÓN ---
Nombre de la pizza: Hawaiana
Ingredientes:
  1. Piña
  2. Jamón
  3. Queso
-----------------------------------

=== PIZZA-TRACK: Gestión de Pedidos ===
Seleccione una opción: 0
Cerrando el sistema Pizza-Track... ¡Hasta pronto!
```

### Flujo de Undo/Redo

```
Estado Inicial:
  pilaPrincipal = []
  pilaSecundaria = []

Registrar "Pepperoni":
  pilaPrincipal = [Pepperoni]
  pilaSecundaria = []

Registrar "Hawaiana":
  pilaPrincipal = [Hawaiana, Pepperoni]
  pilaSecundaria = []

UNDO:
  pilaPrincipal = [Pepperoni]
  pilaSecundaria = [Hawaiana]

REDO:
  pilaPrincipal = [Hawaiana, Pepperoni]
  pilaSecundaria = []

Registrar "Vegetariana" (limpia secundaria):
  pilaPrincipal = [Vegetariana, Hawaiana, Pepperoni]
  pilaSecundaria = [] ◄─── LIMPIADA
```

---

## 🐛 Troubleshooting

### ❌ Problema: "¡Por favor, ingrese un número válido!"

**Causa:** Ingresó texto o carácter especial en lugar de número

**Solución:**
- Ingrese solo números: `1`, `2`, `3`, `4` o `0`
- Intente de nuevo

---

### ❌ Problema: "No hay pedidos en la pila principal para deshacer"

**Causa:** Intenta deshacer sin haber registrado pedidos

**Solución:**
1. Primero registre un pedido (opción `1`)
2. Luego use deshacer (opción `2`)

---

### ❌ Problema: "No hay pedidos en la pila secundaria para rehacer"

**Causa:** Intenta rehacer sin haber deshecho ninguna acción

**Solución:**
1. Primero deshaga un pedido (opción `2`)
2. Luego use rehacer (opción `3`)

---

### ❌ Problema: "La pila de pedidos activos está vacía"

**Causa:** No hay pedidos registrados para mostrar

**Solución:**
- Registre un nuevo pedido (opción `1`)
- Intente mostrar nuevamente (opción `4`)

---

### ❌ Error de Compilación: "cannot find symbol"

**Causa:** Falta compilar una de las clases

**Solución:**
```bash
javac Pizza.java
javac Pila.java
javac GestionPedidos.java
```

---

## 📖 Glosario de Términos

| Término | Significado |
|---------|----------|
| **PILA (Stack)** | Estructura de datos LIFO donde el último elemento insertado es el primero en salir |
| **LIFO** | Last In, First Out - Último en Entrar, Primero en Salir |
| **PUSH** | Operación de agregar un elemento al tope de la pila |
| **POP** | Operación de remover y obtener el elemento del tope |
| **PEEK** | Operación de obtener el elemento del tope sin removerlo |
| **UNDO** | Deshacer - Revierte la última acción realizada |
| **REDO** | Rehacer - Restaura una acción que fue deshecha |
| **TOPE** | El elemento que se encuentra en la posición superior |
| **NODO** | Estructura que contiene un dato y un enlace al siguiente |
| **LISTA ENLAZADA** | Estructura donde cada elemento está enlazado con el siguiente |
| **O(1)** | Complejidad temporal constante |

---

## 🎓 Conceptos Educativos

Este proyecto enseña:

✅ **Estructuras de Datos**
   - Pilas (Stacks)
   - Listas Enlazadas
   - Estructura LIFO

✅ **Patrones de Diseño**
   - Patrón Command (Undo/Redo)
   - MVC (Modelo-Vista-Controlador)

✅ **Programación Orientada a Objetos**
   - Encapsulación
   - Abstracción
   - Separación de responsabilidades

✅ **Entrada/Salida en Consola**
   - Scanner para lectura
   - System.out para salida

---

## 📁 Estructura del Proyecto

```
Pizza-Track/
├── Pizza.java                      # Modelo de datos
├── Pila.java                       # Estructura de datos
├── GestionPedidos.java             # Controlador principal
├── README.md                       # Este archivo
├── DOCUMENTACION.md                # Documentación completa
├── GestionPedidos_DOCUMENTACION.txt    # Doc específica
├── Pila_DOCUMENTACION.txt              # Doc específica
├── Pizza_DOCUMENTACION.txt             # Doc específica
└── DOCUMENTACION_COMPLETA.txt      # Doc unificada
```

---

## 🚀 Mejoras Futuras

Posibles extensiones del proyecto:

- [ ] Agregar persistencia en base de datos
- [ ] Agregar sistema de precios por pizza
- [ ] Agregar tamaños de pizza (pequeña, mediana, grande)
- [ ] Crear interfaz gráfica (GUI)
- [ ] Agregar validación de ingredientes únicos
- [ ] Implementar historial persistente
- [ ] Agregar estadísticas de pedidos
- [ ] Multi-usuario con perfiles

---

## 📞 Contacto e Información

- **Equipo:** Pizza-Track Team
- **Versión:** 1.0
- **Estado:** Activo y Mantenido
- **Última Actualización:** 2025
- **Lenguaje:** Java 8+

---

## 📄 Licencia

Este proyecto es de código abierto y disponible para fines educativos.

---

## 🙏 Agradecimientos

Gracias por usar **Pizza-Track**. ¡Esperamos que disfrutes gestionando tus pedidos de pizzas! 🍕

---

**¿Preguntas o Sugerencias?** 
Consulta la documentación detallada en `DOCUMENTACION_COMPLETA.txt` o los archivos específicos de cada clase.

**¡Buen provecho! 🍕**