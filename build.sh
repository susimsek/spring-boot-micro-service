mvn clean install
cd account-service
mvn dockerfile:build
cd ../
cd ticket-service
sleep 10
mvn dockerfile:build
cd ../
cd notification-service
sleep 10
mvn dockerfile:build
cd ../
cd config-server
sleep 10
mvn dockerfile:build
cd ../
cd eureka-server
sleep 10
mvn dockerfile:build
cd ../
cd gateway-server
sleep 10
mvn dockerfile:build
cd ../
cd hystrix-dashboard
sleep 10
mvn dockerfile:build
cd ../
cd admin-server
sleep 10
mvn dockerfile:build
cd ../