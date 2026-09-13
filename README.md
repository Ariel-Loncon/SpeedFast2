![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠  Actividad Sumativa 2: Sincronizando procesos en sistemas concurrentes

## 👤 Autor del proyecto
- **Nombre completo:** [Ariel Gustavo Loncon Lefimil]
- **Sección:** [008A]
- **Carrera:** Desarrollo de aplicaciones
- **Sede:** [Online]

---

# Sistema de Gestión de Envíos - SpeedFast (Semana 5)

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II** (Evaluación Formativa / Semana 5). La solución evoluciona la plataforma de SpeedFast al integrar **mecanismos de sincronización de recursos compartidos** y control de concurrencia mediante `Thread`, `Runnable` y secciones críticas sincronizadas.

---

## 📋 Descripción del Proyecto y Nuevos Requerimientos

Durante el despacho paralelo, múltiples repartidores acceden simultáneamente a la **Zona de Carga** para retirar paquetes. Para evitar condiciones de carrera (*race conditions*) y entregas duplicadas, el sistema implementa un modelo de **Monitor / Recurso Compartido** mediante el cual cada paquete es retirado y procesado de forma atómica por un único repartidor a la vez.

---

# ✨ Características y Principios Aplicados

### 1. Concurrencia y Sincronización de Recursos (`ZonaDeCarga`)
* **Acceso Mutuamente Excluyente:** La clase `ZonaDeCarga` actúa como recurso compartido. Sus métodos `agregarPedido()` y `retirarPedido()` hacen uso de la palabra clave `synchronized` para asegurar que solo un hilo acceda a la cola interna en un instante dado.
* **Procesamiento Seguro:** La extracción mediante `Queue.poll()` de forma sincronizada previene el retiro doble de encomiendas por distintos repartidores.

### 2. Tareas en Paralelo (`Repartidor` - `Runnable`)
* **Ejecución Independiente:** Cada objeto `Repartidor` implementa `Runnable` y procesa pedidos de la zona común mientras existan encomiendas disponibles.
* **Simulación de Flujo de Trabajo:** Modifica dinámicamente el estado del pedido de `PENDIENTE` a `EN_REPARTO`, simula los tiempos de traslado (`Thread.sleep()`), y finaliza en `ENTREGADO`.

### 3. Tipado Seguro con Enumeraciones (`EstadoPedido`)
* **Integridad de Datos:** Sustituye el uso de cadenas por la enumeración `EstadoPedido` (`PENDIENTE`, `EN_REPARTO`, `ENTREGADO`), reduciendo fallos por tipeo y mejorando la legibilidad.

### 4. Orquestación y Coordinación de Hilos (`Main`)
* **Sincronización de Cierre:** El hilo principal (`Main`) coordina la ejecución paralela e invoca el método `join()` en cada hilo de repartidor, garantizando que el reporte final de cierre se imprima únicamente al concluir todas las entregas.

---

## 🛠️ Estructura del Proyecto

```text
src/
├── main/
│   └── Main.java            
└── model/
    ├── EstadoPedido.java    
    ├── Pedido.java          
    ├── Repartidor.java      
    └── ZonaDeCarga.java

---

**Fecha de entrega: [14/09/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa 2: Sincronizando procesos en sistemas concurrentes
