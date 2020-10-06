# test-async

Enable all Actuator metrics:
management.endpoints.web.exposure.include=*

Start application:

```sh
mvn spring-boot:run
```

Start Prometheus and Grafana

```sh
sh start_prometheus_and_grafana.sh
```

**Urls:**

Application: http://localhost:8080/test

Prometheus: http://localhost:9090

Grafana: http://localhost:3030

ThreadDump: http://localhost:8080/actuator/threaddump

HeapDump: http://localhost:8080/actuator/heapdump

JVM-Dashboard: https://grafana.com/grafana/dashboards/4701


**Jmeter Test:**

JMeter.jmx

**Important:**
When you run the Grafana 1st time, user and password are **admin**.


