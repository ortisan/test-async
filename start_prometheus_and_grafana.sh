docker stop $(docker ps -a -q)
docker run --network host -d -p 9090:9090 -v $PWD/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
docker run --network host -d -p 3000:3000 grafana/grafana