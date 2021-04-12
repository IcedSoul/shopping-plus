mvn clean package -DskipTests

docker-compose -f ./deployment/docker-compose/docker-compose.yml build

docker-compose -f ./deployment/docker-compose/docker-compose.yml down

docker-compose -f  ./deployment/docker-compose/docker-compose.yml up -d