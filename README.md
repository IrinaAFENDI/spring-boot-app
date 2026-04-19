# LashManager

Приложение для мастера по наращиванию ресниц.  
Управление клиентами и записями на процедуру.

## Технологии
- Java 23
- Spring Boot 3
- Spring Data JPA
- Spring Security
- H2 Database
- Maven

## REST API

### Клиенты (`/api/clients`)
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/clients` | Все клиенты |
| GET | `/api/clients/{id}` | Один клиент |
| POST | `/api/clients` | Создать клиента |
| PUT | `/api/clients/{id}` | Обновить клиента |
| DELETE | `/api/clients/{id}` | Удалить клиента |

### Записи (`/api/appointments`)
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/appointments` | Все записи |
| GET | `/api/appointments/{id}` | Одна запись |
| POST | `/api/appointments` | Создать запись |
| PUT | `/api/appointments/{id}` | Обновить запись |
| DELETE | `/api/appointments/{id}` | Удалить запись |

## Запуск

```bash
git clone https://github.com/IrinaAFENDI/spring-boot-app.git
cd spring-boot-app
mvn spring-boot:run
Приложение запустится на http://localhost:8080
