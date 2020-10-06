# test-async

## How to

1. Enable all Actuator metrics:
    ```sh
    management.endpoints.web.exposure.include=*
    ```

1. Start application:

    ```sh
    mvn spring-boot:run
    ```

1. Start Prometheus and Grafana

    ```sh
    sh start_prometheus_and_grafana.sh
    ```

1. Run the Jmeter test

1. Take snapshots of threaddump
    ```sh
    sh generate_threaddump.sh
    ```

**Urls:**

Application: http://localhost:8080/test

Prometheus: http://localhost:9090

Grafana: http://localhost:3000

ThreadDump: http://localhost:8080/actuator/threaddump

HeapDump: http://localhost:8080/actuator/heapdump

JVM-Dashboard: https://grafana.com/grafana/dashboards/4701


**Jmeter Test:**

JMeter.jmx

**Important:**
When you run the Grafana 1st time, user and password are **admin**.


