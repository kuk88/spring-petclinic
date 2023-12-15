FROM mysql:8.0.35
LABEL authors="coca1805"

USER root
#might be that `mysql` user ID in `percona` and `mysql` container has different ID, thus change its ID in mysql container and in percona aswell
RUN usermod -u 1024 mysql
RUN groupmod -g 1024 mysql

RUN chown -R :1024 /var/lib/mysql
RUN chmod -R 755 /var/lib/mysql
RUN chmod -R g+s /var/lib/mysql

ENV MYSQL_ROOT_PASSWORD="develop"
ENV MYSQL_DATABASE="petclinic"
ENV MYSQL_USER="petclinic"
ENV MYSQL_PASSWORD="petclinic"
ADD schema.sql /docker-entrypoint-initdb.d/1.sql
ADD data.sql /docker-entrypoint-initdb.d/2.sql

#volume to be used by percona container
VOLUME /var/lib/mysql

USER mysql

EXPOSE 3306
