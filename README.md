## Building

For building instruction take a look at docker folder README.md

## Templates to tests

#### API Documentation

1. Change pom version
2. Run deploy-and-push.sh
3. Run push.sh
4. Update Portainer

#### Relationship

Using NoSQL database, we can use save the collection we all information is need from that collection or use an
annotation `@DBRef` to refer to one other collection.

These API use both of them. 

#### Cache

The API is using Cache to improve the performance when consume some data.
The resources configured to manage the cache are:

1. `@CachePut("furnas")` - `POST /api/v1/vision-to-vision` - When save new data, the cache will be updated
2. `@Cacheable("furnas")` - `GET /api/v1/vision/name/{name}/all` - When request a vision by name, the data will be cached

Based in: `https://www.baeldung.com/spring-boot-evict-cache`
