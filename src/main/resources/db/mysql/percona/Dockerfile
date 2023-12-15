FROM percona/percona-xtrabackup:8.0.35-30

ENV host=""
ENV user=""
ENV password=""
ENV backup_file_name="backup.xbstream"

LABEL authors="coca1805"

USER root

#might be that `mysql` user ID in `percona` and `mysql` container has different ID, thus change its ID in mysql container and in percona aswell
RUN usermod -u 1024 mysql
RUN groupmod -g 1024 mysql

# from where to backup, a mounted volume from mysql container with same directory
RUN mkdir /var/lib/mysql

# `/backup` directory already exists and it is mounted as volume
# change rights to be able to backup from `/var/lib/mysql` directory into `/backup`
RUN chown -R 1024:1024 /backup /var/lib/mysql
RUN chmod -R 755 /backup /var/lib/mysql
RUN chmod -R g+s /backup /var/lib/mysql

USER mysql

ENTRYPOINT exec xtrabackup --backup --host $host --user=$user --password=$password --datadir=/var/lib/mysql/ --stream=xbstream --target-dir=/tmp  > /backup/$backup_file_name


