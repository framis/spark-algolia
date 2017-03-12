Spark Algolia Test
==================

# Dependencies

docker, docker-compose (v2)

# To start Spark and run the job

```
docker-compose run spark                                   		# To start the spark container

# And from within the spark container

# Launch Spark Shell
spark-shell                                                		# To start spark-shell from within the container
spark-shell --packages "com.algolia:scala-client_2.11:1.0.1-SNAPSHOT" \
--repositories https://oss.sonatype.org/content/repositories/snapshots/

# For Spark submit
sbt assembly                                                    # Rebuilds a fat JAR
spark-submit target/scala-2.11/algolia-test-assembly-1.0.jar    # Runs the job in local mode
```