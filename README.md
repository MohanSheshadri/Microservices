First step under fault tolerance and Resilence	

-------------------------------------------------------------
//In order to have a timeout at service level if threads are piled up and its hampering the service performanec // brutfull source not recomended
	@Bean
	@LoadBalanced
	public RestTemplate getResttemplate() {
		HttpComponentsClientHttpRequestFactory httpRequest = 
				new HttpComponentsClientHttpRequestFactory();
		httpRequest.setConnectTimeout(3000);
		return new RestTemplate(httpRequest);
	}
-------------------------------------------------------------

--Hystrix is depreated:

Here we can have mutiple properties which can decide fallback scenario or call fallBackmethod, i.e..
failurePercentage: 50 is default:
how many calls has to be considered
after how many seconds does we have to check back



Fault Tolerance and Resilence using resilence4j with spring boot :

maven repositories:


		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
			<version>3.2.4</version>
		</dependency>
		<!--
		https://mvnrepository.com/artifact/io.github.resilience4j/resilience4j-spring-boot2 -->
		<dependency>
			<groupId>io.github.resilience4j</groupId>
			<artifactId>resilience4j-spring-boot3</artifactId>
			<version>2.2.0</version>
		</dependency>

-------------------------------------------------------------
configuration in application.yml with default resilnec properties:

spring:
  application.name: movie-catalog-service
  jackson.serialization.indent_output: true

management:
  endpoints.web.exposure.include:
    - '*'
  endpoint.health.show-details: always
  health.circuitbreakers.enabled: true

resilience4j.circuitbreaker:
  configs:
    default:
      registerHealthIndicator: true
      slidingWindowSize: 10
      minimumNumberOfCalls: 5
      permittedNumberOfCallsInHalfOpenState: 3
      automaticTransitionFromOpenToHalfOpenEnabled: true
      waitDurationInOpenState: 5s
      failureRateThreshold: 50
      eventConsumerBufferSize: 10


-------------------------------------------------------------


Annotations
@CircuitBreaker -- at the method level of calling microservice

create a fallBackMethod with Throwable parameter to send any pre user defined message to show when service is down 

------------------------------------------------------------

BulkHead  config to specify the thread counts and configurations to seperate out the service calls and handle idividual failure by chnaging thread pool size:
		BulkheadConfig config = BulkheadConfig.custom()
				  .maxConcurrentCalls(2)
				  .maxWaitDuration(Duration.ofSeconds(0))
				  .build();

------------------------------------------------------------	

http://<CircuitBreaker configured path>/actuator/health -- to check the health and failure status, state of circut breaker : UP or HALF_OPEN or CLOSED
------------------------------------------------------------