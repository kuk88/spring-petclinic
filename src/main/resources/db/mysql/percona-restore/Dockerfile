FROM percona/percona-xtrabackup:8.0.35-30

ENV backup_file_name="backup.xbstream"

LABEL authors="coca1805"

USER root

#might be that `mysql` user ID in `percona` and `mysql` container has different ID, thus change its ID in mysql container and in percona aswell
RUN usermod -u 1024 mysql
RUN groupmod -g 1024 mysql

# from where to backup, a mounted volume from mysql container with same directory
RUN mkdir /var/lib/mysql
RUN mkdir /restore
RUN mkdir /scripts
COPY entrypoint.sh /scripts/entrypoint.sh

# `/backup` directory already exists and it is mounted as volume
# change rights to be able to backup from `/var/lib/mysql` directory into `/backup`
RUN chown -R 1024:1024 /backup /var/lib/mysql /restore /scripts/entrypoint.sh
RUN chmod -R 755 /backup /var/lib/mysql /restore
RUN chmod -R g+s /backup /var/lib/mysql /restore
RUN ["chmod", "+x", "/scripts/entrypoint.sh"]

USER mysql

# # unpack uncompressed archive
#$ xbstream -x --directory=/restore < /backup/$backup_file_name

#When the files are uncompressed you can prepare the backup with the --prepare option:
#$ xtrabackup --prepare --target-dir=/restore

# xtrabackup --copy-back --target-dir=/data/backups/
# or
# xtrabackup --move-back --target-dir=/var/lib/mysql/
# mv /restore/* /var/lib/mysql/

ENTRYPOINT ["sh", "-c", "/scripts/entrypoint.sh $backup_file_name"]
